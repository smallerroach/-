package com.yszt.base.dao.diary;

import java.util.Map;

import com.yszt.base.BaseExpandMapper;

/**
 *  用户记忆力测评持久层扩展接口.
 * @author qiaolin
 *
 */
public interface AppraisalExpandMapper extends BaseExpandMapper{
	
	/**
	 *  打败了多少用户。
	 * @return
	 */
	Map<String,Object> ranKing(Float score);
	
	/**
	 *  获取最后插入数据的id
	 * @return
	 */
	int findByLastIndex();
}
