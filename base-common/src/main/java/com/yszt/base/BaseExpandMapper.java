package com.yszt.base;

import java.util.Map;

import com.github.pagehelper.Page;

/**
 */
public interface BaseExpandMapper {
	/** 条件分页查询 */
	Page<Integer> query(Map<String, Object> params);
	
	
}
