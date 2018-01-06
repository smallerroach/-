package com.yszt.base.service.diary;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageInfo;
import com.yszt.base.BaseServiceImpl;
import com.yszt.base.dao.diary.DiaryStandardExpandMapper;
import com.yszt.base.model.generator.DiaryStandard;

/**
 */
@Component(value="diaryStandardService")
public class DiaryStandardServiceImpl extends BaseServiceImpl<DiaryStandard> implements DiaryStandardService {
	
	@Autowired
	private DiaryStandardExpandMapper syDeptExpandMapper;
	
	public PageInfo<DiaryStandard> query(Map<String, Object> params) {

		Set<Entry<String,Object>> entry = params.entrySet();
		for (Entry<String, Object> entry2 : entry) {
			System.out.println(entry2.getKey()+" : "+entry2.getValue());
		}
		if(!"no".equals(params.get("startPage"))){
			this.startPage(params);
		}
		return getPage(syDeptExpandMapper.query(params));
	}

	@Override
	public Integer count(Map<String, Object> params) {
		return syDeptExpandMapper.count(params);
	}


}
