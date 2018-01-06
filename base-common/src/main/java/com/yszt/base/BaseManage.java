package com.yszt.base;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.Assert;

import com.github.pagehelper.PageInfo;

/**
 */
public abstract class BaseManage<P extends BaseService<T>, T extends BaseModel> {
	protected Logger logger = LogManager.getLogger();
	protected P service;
	

	/** 修改 */
	public void update(T record) {
		Assert.notNull(record.getId(), "ID");
		service.update(record);
	}

	/** 新增 */
	public void add(T record) {
		service.update(record);
	}

	/** 删除 */
	public void delete(Integer id) {
		Assert.notNull(id, "ID");
		service.delete(id, 1);
	}

	/** 根据Id查询 */
	@SuppressWarnings("unchecked")
	public T queryById(Integer id) {
		Assert.notNull(id, "ID");
		T record = service.queryById(id);
		return record;
	}

	/** 条件查询 */
	public PageInfo<T> query(Map<String, Object> params) {
		return service.query(params);
	} 
	

}
