package com.yszt.base.web.diary;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.yszt.base.BaseController;
import com.yszt.base.man.diary.DiaryUserManage;
import com.yszt.base.model.generator.DiaryUser;
import com.yszt.base.support.security.coder.MyMD5Coder;
import com.yszt.base.util.Request2ModelUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 标准细节日志用户控制层。
 * @author qiaolin
 *
 */
@RestController
@Api(value = "标准细节用户", description = "标准细节用户管理")
@RequestMapping(value = "diaryUser",method = RequestMethod.POST)
public class DiaryUserController extends BaseController{
	protected Logger log = LogManager.getLogger();	 
	@Autowired
	DiaryUserManage diaryUserManage;
	
	@ApiOperation(value = "用户注册")
	@ModelAttribute
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Object add(HttpServletRequest request,ModelMap modelMap){
		DiaryUser record = Request2ModelUtil.covert(DiaryUser.class, request);
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("account", record.getAccount());
		PageInfo<DiaryUser> du = diaryUserManage.query(params);
		if(du.getSize()>0){
			return setSuccessModelMap(modelMap,"1");
		}
		record.setPassword(MyMD5Coder.Md5enCode(record.getPassword()));
		diaryUserManage.add(record);
		return setSuccessModelMap(modelMap,"0");
	}
	
	@ApiOperation(value = "用户登录")
	@ModelAttribute
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public Object login(HttpServletRequest request,ModelMap modelMap){
		DiaryUser record = Request2ModelUtil.covert(DiaryUser.class, request);
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("account", record.getAccount());
		params.put("password", record.getPassword());
		PageInfo<DiaryUser> du = diaryUserManage.query(params);
		if(du.getSize()>0){
			request.getSession().setAttribute("user", du.getList().get(0));
			log.info("获得用户信息"+du.getList().get(0));
			return setSuccessModelMap(modelMap,du.getList().get(0));
		}
		return setSuccessModelMap(modelMap,"0");
	}
	
	@ApiOperation("修改用户资料")
	@ModelAttribute
	@RequestMapping(value = "update",method = RequestMethod.POST)
	public Object update(HttpServletRequest request, MultipartFile file,ModelMap modelMap){
		DiaryUser record = Request2ModelUtil.covert(DiaryUser.class,request);
		DiaryUser diaryUser = diaryUserManage.queryById(record.getId());
		diaryUser.setHeight(record.getHeight());
		diaryUser.setSex(record.getSex());
		diaryUser.setBirthdary(record.getBirthdary());
		diaryUser.setWeight(record.getWeight());
		diaryUser.setUserName(record.getUserName());
		if(file!=null){
			String path = request.getSession().getServletContext().getRealPath("WEB-INF/upload/head/");
			String fileName = file.getOriginalFilename();
			String newfileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+
					new SimpleDateFormat("MMssHHmmddyyyy").format(new Date())+
					fileName.substring(fileName.lastIndexOf("."),fileName.length());
			File newFile = new File(path, newfileName);
			diaryUser.setPortrait("upload/head/"+newfileName);
			// 如果目录不存在，创建所有父目录。
			if(!newFile.exists()){
				newFile.mkdirs();
			}
			// 将文件写入指定位置。
			try {
				file.transferTo(newFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		diaryUserManage.update(diaryUser);
		return setSuccessModelMap(modelMap,diaryUser);
	}
	
	
}
