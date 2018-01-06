package com.yszt.base.man.diary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yszt.base.BaseManage;
import com.yszt.base.model.generator.AppVersions;
import com.yszt.base.service.diary.AppVersionsService;
/**
 *  app更新service层
 * @author qiaolin
 *
 */
@Service
public class AppVersionsManage extends BaseManage<AppVersionsService, AppVersions>{

	@Autowired
	public void setService(AppVersionsService service) {
		this.service = service;
	}
}
