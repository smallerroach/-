package com.yszt.base.dao.diary;

import java.util.List;
import java.util.Map;

import com.yszt.base.BaseExpandMapper;
import com.yszt.base.model.generator.DiaryStandardDoctor;

public interface DiaryStandardDoctorExpandMapper extends BaseExpandMapper{

	/**
	 * 只查名字和身份证号
	 * @param params
	 * @return
	 */
	List<DiaryStandardDoctor> sympleQuery(Map<String,Object> params);
}
