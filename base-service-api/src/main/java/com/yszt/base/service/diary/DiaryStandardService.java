package com.yszt.base.service.diary;

import java.util.Map;

import com.yszt.base.BaseService;
import com.yszt.base.model.generator.DiaryStandard;

public interface DiaryStandardService extends BaseService<DiaryStandard> {
	
	Integer count(Map<String,Object> params);
}
