package com.yszt.base.dao.diary;

import java.util.Map;

import com.yszt.base.BaseExpandMapper;

public interface DiaryStandardExpandMapper extends BaseExpandMapper {

	Integer count(Map<String,Object>params);
	
}