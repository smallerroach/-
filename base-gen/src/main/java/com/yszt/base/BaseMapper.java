package com.yszt.base;

import java.util.List;
import java.util.Map;

/**
 * @author 
 * @version 2016年6月3日 下午2:30:14
 */
public interface BaseMapper<T extends BaseModel> {

	List<T> selectAll();

	int deleteByPrimaryKey(Integer id);

	T selectByPrimaryKey(Integer id);

	int insert(T record);

	int updateByPrimaryKey(T record);
	
	// 分页查询
	List<T> queryPage(Map<String,Object> params);
}
