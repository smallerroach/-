package com.yszt.base.man.diary;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yszt.base.BaseManage;
import com.yszt.base.model.generator.DiaryStandardDoctor;
import com.yszt.base.service.diary.DiaryStandardDoctorService;

@Service
public class DiaryStandardDoctorManage extends BaseManage<DiaryStandardDoctorService, DiaryStandardDoctor> {
	
	@Autowired
	public void setService(DiaryStandardDoctorService service) {
		this.service = service;
	}
	public List<DiaryStandardDoctor> sympleQuery(Map<String, Object> params){
		return service.sympleQuery(params);
	}
}
