package com.yszt.base.service.diary;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.github.pagehelper.PageInfo;
import com.yszt.base.BaseServiceImpl;
import com.yszt.base.dao.diary.StudentExpandMapper;
import com.yszt.base.model.generator.Student;

@Component(value="studentService")
public class StudentServicecImpl extends  BaseServiceImpl<Student> implements StudentService{
	
	@Autowired	
	private StudentExpandMapper syDeptExpandMapper;
	
	public PageInfo<Student> query(Map<String, Object> params) {
		this.startPage(params);
		return getPage(syDeptExpandMapper.query(params));
	}
	
	
	
}
