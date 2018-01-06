package com.yszt.base.service.diary;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageInfo;
import com.yszt.base.BaseServiceImpl;
import com.yszt.base.dao.diary.DiaryUserExpandMapper;
import com.yszt.base.model.generator.DiaryUser;

/**
 * 标准细节日志用户服务层接口实现类。
 */
@Component(value = "diaryUserService")
public class DiaryUserServiceImpl extends BaseServiceImpl<DiaryUser> implements DiaryUserService {

	@Autowired
	private DiaryUserExpandMapper syDeptExpandMapper;

	public PageInfo<DiaryUser> query(Map<String, Object> params) {
			this.startPage(params);
			return getPage(syDeptExpandMapper.query(params));
	}
	
	
	

}
