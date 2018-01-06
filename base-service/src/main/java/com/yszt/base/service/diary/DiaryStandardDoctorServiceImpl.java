package com.yszt.base.service.diary;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.PageInfo;
import com.yszt.base.BaseServiceImpl;
import com.yszt.base.dao.diary.DiaryStandardDoctorExpandMapper;
import com.yszt.base.model.generator.DiaryStandardDoctor;

@Component("diaryStandardDoctorService")
public class DiaryStandardDoctorServiceImpl extends BaseServiceImpl<DiaryStandardDoctor> implements DiaryStandardDoctorService {
	@Autowired
	private DiaryStandardDoctorExpandMapper expandMapper;
	
	public PageInfo<DiaryStandardDoctor> query(Map<String, Object> params) {
		if(!"no".equals(params.get("startPage"))){
			this.startPage(params);
		}
		return getPage(expandMapper.query(params));
	}

	@Override
	public List<DiaryStandardDoctor> sympleQuery(Map<String, Object> params) {
		return expandMapper.sympleQuery(params);
	}
	
}
 