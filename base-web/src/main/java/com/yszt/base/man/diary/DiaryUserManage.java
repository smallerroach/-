package com.yszt.base.man.diary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yszt.base.BaseManage;
import com.yszt.base.model.generator.DiaryUser;
import com.yszt.base.service.diary.DiaryUserService;

/**
 *  标准细节日记用户管理类
 * @author qiaolin
 *
 */ 
@Service
public class DiaryUserManage extends BaseManage<DiaryUserService,DiaryUser>{

	@Autowired
	public void setService(DiaryUserService service){
		this.service = service;
	}
}
