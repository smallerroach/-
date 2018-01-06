package com.yszt.base.man.diary;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yszt.base.BaseManage;
import com.yszt.base.model.generator.DiaryStandard;
import com.yszt.base.service.diary.DiaryStandardService;


/** 
 */
@Service
public class DiaryStandardManage extends BaseManage<DiaryStandardService, DiaryStandard> {
	@Autowired
	public void setService(DiaryStandardService service) {
		this.service = service;
	}
	
	public Integer count(Map<String,Object> params){
		return this.service.count(params);
	}
}
