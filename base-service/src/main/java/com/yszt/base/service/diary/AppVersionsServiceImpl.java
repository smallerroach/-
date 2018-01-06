package com.yszt.base.service.diary;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageInfo;
import com.yszt.base.BaseServiceImpl;
import com.yszt.base.dao.diary.AppVersionsExpandMapper;
import com.yszt.base.model.generator.AppVersions;
/**
 *
 * @author qiaolin
 *
 */
@Component(value ="appVersionsService")
public class AppVersionsServiceImpl extends BaseServiceImpl<AppVersions> implements AppVersionsService{
	
	@Autowired
	private AppVersionsExpandMapper appVersionsExpandMapper;

	public PageInfo<AppVersions> query(Map<String, Object> params) {
		this.startPage(params);
		return getPage(appVersionsExpandMapper.query(params));
	}
}
