package com.yszt.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.yszt.base.model.generator.DiaryStandardDoctor;
import com.yszt.base.model.vo.AppraisalDoctorVo;

/**
 *
 * @author qiaolin
 * @version 2017年2月17日
 * 
 */
public class TestJSON {
	public static void main(String[] args) throws ParseException {
		List<AppraisalDoctorVo>  aa = new ArrayList<>() ;
		AppraisalDoctorVo as1 = new AppraisalDoctorVo();
		as1.setDate(new Date());
		as1.setStartTime(new Date());
		as1.setContinueTime(new Date());
		as1.setCorrectAnswer("哈哈呵");
		as1.setUserAnswer("呵呵哈");
		as1.setEmotion("晴");
		as1.setIsError(true);
		as1.setIsElide(false);
		as1.setSite("优势智通");
		AppraisalDoctorVo as2 = new AppraisalDoctorVo();
		as2.setDate(new Date());
		as2.setStartTime(new Date());
		as2.setContinueTime(new Date());
		as2.setCorrectAnswer("哈哈呵");
		as2.setUserAnswer("呵呵哈"); 
		as2.setEmotion("晴");
		as2.setIsError(true);
		as2.setIsElide(false);
		as2.setSite("优势智通");
		aa.add(as1);
		aa.add(as2);
		String ss = JSON.toJSONString(aa);
		System.out.println(ss);
		
		/*List<DiaryStandardDoctor> diars = new ArrayList<>();
		DiaryStandardDoctor dsd1 = new DiaryStandardDoctor();
		dsd1.setName("liqiaolin");
		dsd1.setIdentity("430723199402287875");
		dsd1.setBirthday(new Date());
		dsd1.setSex("男");
		dsd1.setStartTime(new Date());
		dsd1.setDiaryDate(new SimpleDateFormat("yyyy-MM-dd").parse("2017-02-20"));
		dsd1.setActionAddr("优势智通");
		dsd1.setActionState("写代码");
		dsd1.setEndTime(new Date());
		dsd1.setWeather("晴");
		dsd1.setEmotion("一般");
		
		DiaryStandardDoctor dsd2 = new DiaryStandardDoctor();
		dsd2.setName("liqiaolin");
		dsd2.setIdentity("430723199402287875");
		dsd2.setBirthday(new Date());
		dsd2.setSex("男");
		dsd2.setStartTime(new Date());
		dsd2.setDiaryDate(new SimpleDateFormat("yyyy-MM-dd").parse("2017-02-20"));
		dsd2.setActionAddr("优势智通");
		dsd2.setActionState("写代码");
		dsd2.setEndTime(new Date());
		dsd2.setWeather("晴");
		dsd2.setEmotion("一般");
		
		diars.add(dsd1);
		diars.add(dsd2);
		String ss = JSON.toJSONString(diars);
		System.out.println(ss);
		
		List<DiaryStandardDoctor> dsds = JSON.parseArray(ss, DiaryStandardDoctor.class);
		
		for (DiaryStandardDoctor diaryStandardDoctor : dsds) {
			System.out.println(diaryStandardDoctor);
		}*/
		
		
		
		
		
		
	}
}
