package com.yszt.base.service.diary;

import java.util.List;
import java.util.Map;

import com.yszt.base.BaseService;
import com.yszt.base.model.generator.DiaryStandardDoctor;

public interface DiaryStandardDoctorService extends BaseService<DiaryStandardDoctor> {
	
	/**
	 * 只查名字和身份证号
	 * @param params
	 * @return
	 */
	List<DiaryStandardDoctor> sympleQuery(Map<String,Object> params);
}
