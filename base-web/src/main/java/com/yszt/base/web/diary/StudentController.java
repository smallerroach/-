package com.yszt.base.web.diary;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.yszt.base.BaseController;
import com.yszt.base.man.diary.StudentManage;
import com.yszt.base.model.generator.Student;
import com.yszt.base.util.Request2ModelUtil;
import com.yszt.base.util.WebUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 学生管理控制类
 * 
 */
@RestController
@Api(value = "学生管理", description = "学生管理")
@RequestMapping(value = "student", method = RequestMethod.POST)
public class StudentController extends BaseController {
	@Autowired
	private StudentManage studentManage;
 
	@ApiOperation(value = "添加学生")
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public Object add(HttpServletRequest request, ModelMap modelMap) {
		
		Student record = Request2ModelUtil.covert(Student.class, request);
		studentManage.add(record);
		return setSuccessModelMap(modelMap);
	}

	@ApiOperation(value = "删除学生")
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public Object delete(HttpServletRequest request, ModelMap modelMap) {
		Map<String,Object> record = WebUtil.getParameterMap(request);
		studentManage.delete(Integer.parseInt((String) record.get("id")));
		return setSuccessModelMap(modelMap);
	}

	@ApiOperation(value = "更新学生信息")
	@RequestMapping(value = "update",method = RequestMethod.POST)
	public Object update(HttpServletRequest request, ModelMap modelMap) {
		Student record = Request2ModelUtil.covert(Student.class, request);
		System.err.println(record);
		System.err.println("rquest请求对象编码为:"+request.getCharacterEncoding());
		studentManage.update(record);
		return setSuccessModelMap(modelMap);
	}

	@ApiOperation(value = "根据学生主键查询")
	@RequestMapping(value = "queryById", method = RequestMethod.POST)
	public Object queryById(HttpServletRequest request, ModelMap modelMap) {
		Map<String,Object> record = WebUtil.getParameterMap(request);
		System.err.println("或者Id键值"+record.get("id"));
		Student student = studentManage.queryById(Integer.parseInt((String) record.get("id")));
		return setSuccessModelMap(modelMap, student);
	}

	@ApiOperation(value = "学生列表分页查询")
	@RequestMapping(value = "queryPage",method = RequestMethod.POST)
	public Object queryPage(HttpServletRequest request,ModelMap modelMap){
		Map<String,Object> record = WebUtil.getParameterMap(request);
		System.err.println("获得键值对"+record.size());
		PageInfo<?> stu = studentManage.query(record);
		return setSuccessModelMap(modelMap,stu);
	}
}
