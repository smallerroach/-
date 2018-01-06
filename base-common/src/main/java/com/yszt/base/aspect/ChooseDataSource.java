package com.yszt.base.aspect;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 *  连接数据源类。
 */
public class ChooseDataSource extends AbstractRoutingDataSource {
	public static Map<String, List<String>> METHODTYPE = new HashMap<String, List<String>>();

	// 获取数据源名称
	protected Object determineCurrentLookupKey() {
		return HandleDataSource.getDataSource();
	}

	public void setMethodType(Map<String, String> map) {
		
	}
}
