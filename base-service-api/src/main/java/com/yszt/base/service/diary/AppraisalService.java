package com.yszt.base.service.diary;

import java.util.Map;

import com.yszt.base.BaseService;
import com.yszt.base.model.generator.Appraisal;

/**
 * 用户评测service层接口.
 * @author qiaolin
 *
 */
public interface AppraisalService extends BaseService<Appraisal>{
	
	Map<String,Object> ranKing(Float score);
	
	int findByLastIndex();
}
