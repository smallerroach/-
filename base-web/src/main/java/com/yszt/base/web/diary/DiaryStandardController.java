package com.yszt.base.web.diary;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.yszt.base.BaseController;
import com.yszt.base.man.diary.DiaryStandardManage;
import com.yszt.base.model.generator.DiaryStandard;
import com.yszt.base.util.Request2ModelUtil;
import com.yszt.base.util.WebUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 部门管理控制类
 * 
 */
@RestController
@Api(value = "标准细节日记", description = "标准细节日记管理")
@RequestMapping(value = "diaryStandard", method = RequestMethod.POST)
public class DiaryStandardController extends BaseController {
	@Autowired
	private DiaryStandardManage diaryStandardManage;

	// 查询部门
	@ApiOperation(value = "查询细节日志")
	@ModelAttribute
	@RequestMapping(value = "/read/list")
	public Object get(HttpServletRequest request,String account, ModelMap modelMap) {
		/*
		 * response.setCharacterEncoding("utf-8");
		 * response.setContentType("multipart/form-data");
		 * response.setHeader("Content-Disposition",
		 * "attachment;fileName="+file.getName()); String path =
		 * request.getSession().getServletContext().getRealPath
		 * ("WEB-INF/upload")+File.separator;
		 */
		Map<String, Object> params = WebUtil.getParameterMap(request);
		params.put("account", account);
		PageInfo<DiaryStandard> list = diaryStandardManage.query(params);
		/*
		 * InputStream in = null; OutputStream out = null; DiaryStandard ds =
		 * list.getList().get(0); File file = new File(ds.getAudioLocation());
		 * try { in = new FileInputStream("upload"+file.getName()); out =
		 * response.getOutputStream();
		 *  byte[] bff = new byte[2048]; int len;
		 * while((len = in.read(bff))>0){ out.write(bff, 0, len); } out.close();
		 * in.close(); } catch (FileNotFoundException e) { e.printStackTrace();
		 * } catch (IOException e) { e.printStackTrace(); } return null;
		 */
		return setSuccessModelMap(modelMap, list);
	}

	// 新增部门
	@ApiOperation(value = "添加细节日志")
	@ModelAttribute
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Object add(HttpServletRequest request,String startTime1,String diaryDate1,String endTime1, MultipartFile file, ModelMap modelMap ) throws ParseException {
		DiaryStandard record = Request2ModelUtil.covert(DiaryStandard.class, request);
		Date startTime = new SimpleDateFormat("yyyy年MM月dd日").parse(startTime1);
		Date diaryDate = new SimpleDateFormat("yyyy年MM月dd日HH时mm分").parse(startTime1+diaryDate1);
		Date endTime = new SimpleDateFormat("yyyy年MM月dd日HH时mm分").parse(startTime1+endTime1);
		record.setId(null);   
		record.setStartTime(startTime);
		record.setDiaryDate(diaryDate);
		record.setEndTime(endTime);
		// 如果文件为空就不上传
		if(file!=null){
			String path = request.getSession().getServletContext().getRealPath("WEB-INF/upload/");
			String fileName = file.getOriginalFilename();
			String newfileName = getRandomChar() + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+
					getRandomChar() + new SimpleDateFormat("MMssHHmmddyyyy").format(new Date())+ getRandomChar() +
					fileName.substring(fileName.lastIndexOf("."),fileName.length());
			File newFile = new File(path, newfileName);
			record.setAudioLocation("upload/"+newfileName);
			// 创建文件所有的父目录
			if (!newFile.exists()) {
				newFile.mkdirs();
			}
			// 上传文件
			try {
				file.transferTo(newFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		diaryStandardManage.add(record);
		return setSuccessModelMap(modelMap);
	}

	@ApiOperation("查询时间段标准细节日志纪录")
	@RequestMapping(value = "hictory")
	public Object hictory(HttpServletRequest request,String account,ModelMap modelMap ){
		DiaryStandard record = Request2ModelUtil.covert(DiaryStandard.class, request);
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("startTime", record.getStartTime());
		params.put("account", account);
		params.put("orderBy", "diary_date asc");
		PageInfo<DiaryStandard> list = diaryStandardManage.query(params);
		
		return setSuccessModelMap(modelMap,list.getList());
	}
	
	@ApiOperation("Pc端查询时间段标准细节日志纪录")
	@RequestMapping(value = "historyPc")
	public Object historyPc(HttpServletRequest request,ModelMap modelMap){
		Map<String,Object> params = WebUtil.getParameterMap(request);
		Integer pageSize = Integer.parseInt((String) params.get("pageSize"));
		params.put("orderBy", "diary_date asc");
		PageInfo<DiaryStandard> list = diaryStandardManage.query(params);
		Integer count = diaryStandardManage.count(params);
		params = new HashMap<String,Object>();
		params.put("object", list);
		
		params.put("count", count/pageSize+(count%pageSize==0?0:1));
		return setSuccessModelMap(modelMap,params);
	}
	
	@ApiOperation(value="根据标准细节日记主键删除日记")
	@ModelAttribute
	@RequestMapping(value= "/delete")
	public Object delete(HttpServletRequest request,Integer id,ModelMap modelMap){
		try {
			diaryStandardManage.delete(id);
		} catch (Exception e) {
			return setSuccessModelMap(modelMap,"error");
		}
		return setSuccessModelMap(modelMap,"success");
	}
	
	
	
	public String getRandomChar(){
		StringBuffer sb = new StringBuffer();
		int len = new Random().nextInt(10);
		for (int i = 0; i < len; i++) {
			sb.append((char)(int)(Math.random()*26+97));
		}
		return sb.toString();
	}
	
	
	/*// 文件上传
	@ApiOperation(value = "文件上传")
	@RequestMapping(value = "/upload")
	public Object upload(HttpServletRequest request, MultipartFile file, Integer id, ModelMap model) {
		DiaryStandard record = diaryStandardManage.queryById(id);
		String path = request.getSession().getServletContext().getRealPath("WEB-INF/upload");
		System.err.println("得到" + path);
		String fileName = file.getOriginalFilename();
		File newFile = new File(fileName);
		record.setAudioLocation(newFile.getPath());
		// 创建文件所有的父目录
		if (!newFile.exists()) {
			newFile.mkdirs();
		}
		// 上传文件
		try {
			file.transferTo(newFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		String path1 = request.getContextPath() + "/upload/" + fileName;
		diaryStandardManage.update(record);
		return setSuccessModelMap(model, path1);
	}*/

	
	/*@ApiOperation("Test")
	@RequestMapping(value = "test")
	public ModelAndView test(HttpServletRequest request){
		PageInfo<DiaryStandard> record = diaryStandardManage.query(new HashMap<String,Object>());
		ModelAndView mv = new ModelAndView("sns/Test");
		mv.addObject("list", record.getList());
		return mv;
	}*/
	
	
}
