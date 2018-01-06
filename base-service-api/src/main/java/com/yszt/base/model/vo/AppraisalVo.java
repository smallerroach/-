package com.yszt.base.model.vo;
/**
 *  记忆力测评辅助类。
 * @author qiaolin
 *
 */
public class AppraisalVo {
	private String value1; // 正确答案
	private String value2; // 用户输入的答案
	
	public AppraisalVo() { }

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}
	
	
	
}
