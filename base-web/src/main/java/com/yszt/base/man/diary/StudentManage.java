package com.yszt.base.man.diary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yszt.base.BaseManage;
import com.yszt.base.model.generator.Student;
import com.yszt.base.service.diary.StudentService;

@Service
public class StudentManage extends BaseManage<StudentService, Student> {
    
    @Autowired
	public void setService(StudentService service) {
		this.service = service;
	}  
}