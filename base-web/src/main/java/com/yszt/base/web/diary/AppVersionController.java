package com.yszt.base.web.diary;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yszt.base.BaseController;
import com.yszt.base.man.diary.AppVersionsManage;
import com.yszt.base.model.generator.AppVersions;
import com.yszt.base.util.Request2ModelUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author qiaolin
 * app更新控制器
 */
@RestController
@Api(value = "app更新", description = "app更新管理")
@RequestMapping(value = "appUpdate",method = RequestMethod.POST)
public class AppVersionController extends BaseController{
	
	@Autowired
	private AppVersionsManage appVersionsManage;
	
	@ApiOperation(value = "上传最新版本")
	@RequestMapping(value = "addNewVersion", method = RequestMethod.POST)
	public Object addNewVersion(HttpServletRequest request, MultipartFile file,ModelMap modelMap){
		AppVersions record = Request2ModelUtil.covert(AppVersions.class, request);
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("findNewVersion", "true");
		params.put("appname", record.getAppname());
		params.put("pageSize", 1);
		params.put("orderBy", "version desc");
		List<AppVersions> appVersions = appVersionsManage.query(params).getList();
		record.setVersion(appVersions.size()==0?1:appVersions.get(0).getVersion()+1);
		if(file != null){
			String path = request.getSession().getServletContext().getRealPath("WEB-INF/upload/appVersion");
			String fileName = file.getOriginalFilename();
			String newFileName = getRandomChar() + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+fileName.substring(fileName.lastIndexOf("."), fileName.length());
			File f = new File(path, newFileName);
			// 如果文件夹不存在，则创建所有的父目录
			if(!f.exists()){
				f.mkdirs();
			}
			// 上传文件。
			try {
				file.transferTo(f);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				return setSuccessModelMap(modelMap,"文件上传失败!");
			}
			record.setUploadLocation("upload/appVersion/"+newFileName);
		}
		try {
			appVersionsManage.add(record);
		} catch (Exception e) {
			e.printStackTrace();
			return setSuccessModelMap(modelMap,"文件信息写入数据库失败！");
		}
		return setSuccessModelMap(modelMap,"app新版本上传成功!");
	}	
	
	@ApiOperation(value = "删除app版本")
	@RequestMapping(value = "delete")
	public Object delete(Integer id,ModelMap modelMap){
		try {
			appVersionsManage.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return setSuccessModelMap(modelMap,"刪除app版本失败");
		}
		return setSuccessModelMap(modelMap,"删除app版本成功!");
	}

	@ApiOperation(value = "下载app最新版")
	@RequestMapping(value = "download",method = RequestMethod.POST)
	public Object download(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		String appname = Request2ModelUtil.covert(AppVersions.class, request).getAppname();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("findNewVersion", "true");
		params.put("appname", appname);
		params.put("pageSize", 1);
		params.put("orderBy", "version desc");
		List<AppVersions> appVersions = appVersionsManage.query(params).getList();
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		if (appVersions.size() > 0) {
			AppVersions appVersion = appVersions.get(0);
			String path = request.getSession().getServletContext().getRealPath("WEB-INF/"+appVersion.getUploadLocation());
			System.err.println(appVersion.getAppname());
			response.setHeader("Content-Disposition",
					"attachment;fileName="+ appVersion.getAppname()+"_"+appVersion.getVersionNumber()+appVersion.getUploadLocation().substring(appVersion.getUploadLocation().lastIndexOf("."),appVersion.getUploadLocation().length()));
			File file = new File(path);
			InputStream in = null;
			OutputStream out = null;
			try {
				in = new FileInputStream(file);
				out = response.getOutputStream();
				byte[] buf = new byte[2048];
				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					in.close();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	@ApiOperation(value = "检查app最新版本")
	@RequestMapping(value = "checkNewApp",method= RequestMethod.POST)
	public Object checkNewApp(String appName,ModelMap modelMap){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("findNewVersion", "true");
		params.put("appname", appName);
		params.put("pageSize", 1);
		params.put("orderBy", "version desc");
		AppVersions appVersions = appVersionsManage.query(params).getList().get(0);
		return setSuccessModelMap(modelMap,appVersions);
	}
	
	
	
	
	
	
	
	
	
	/**
	 *  随机产生字符串。
	 * @return
	 */
	private String getRandomChar(){
		StringBuffer sb = new StringBuffer();
		int len = new Random().nextInt(10);
		for (int i = 0; i < len; i++) {
			sb.append((char)(int)(Math.random()*26+97));
		}
		return sb.toString();
	}
	
}
