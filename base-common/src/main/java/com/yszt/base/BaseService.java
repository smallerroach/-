package com.yszt.base;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;

/**
 */
public interface BaseService<T extends BaseModel> {
	// 更新数据
	@Transactional
	public T update(T record);
	// 根据
	@Transactional
	public void delete(Integer id, Integer userId);

	public T queryById(Integer id);

	public void init();

	public PageInfo<T> query(Map<String, Object> params);
}
