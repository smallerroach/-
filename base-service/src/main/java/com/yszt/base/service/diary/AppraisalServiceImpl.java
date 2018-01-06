package com.yszt.base.service.diary;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageInfo;
import com.yszt.base.BaseServiceImpl;
import com.yszt.base.dao.diary.AppraisalExpandMapper;
import com.yszt.base.model.generator.Appraisal;
/**
 * 
 * @author qiaolin
 *
 */
@Component(value ="appraisalService")
public class AppraisalServiceImpl extends BaseServiceImpl<Appraisal> implements AppraisalService {

	@Autowired
	AppraisalExpandMapper appraisalExpandMapper;
	
	@Override
	public PageInfo<Appraisal> query(Map<String, Object> params) {
		if(!"no".equals(params.get("startPage"))){
			this.startPage(params);
		}
		return getPage(appraisalExpandMapper.query(params));
	}
	
	
	@Override
	public Map<String,Object> ranKing(Float score) {
		return appraisalExpandMapper.ranKing(score);
	}


	@Override
	public int findByLastIndex() {
		return appraisalExpandMapper.findByLastIndex();
	}

}
