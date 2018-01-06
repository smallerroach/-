package com.yszt.base.web.diary;

import static com.yszt.base.util.StringCompare.Similarity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.yszt.base.BaseController;
import com.yszt.base.man.diary.AppraisalManage;
import com.yszt.base.man.diary.DiaryStandardDoctorManage;
import com.yszt.base.model.generator.Appraisal;
import com.yszt.base.model.generator.DiaryStandardDoctor;
import com.yszt.base.model.vo.AppraisalDoctorVo;
import com.yszt.base.util.Name2py;
import com.yszt.base.util.WebUtil;
/**
 *  标准细节日记(医生专用版) 控制层
 * @author qiaolin
 * @date 2017年2月17日
 *
 */
@RestController
@Api(value = "标准细节日记(医生专用版)",description = "标准细节日记(医生专用版)")
@RequestMapping(value = "doctor")
public class DiaryStandardDoctorController extends BaseController{
	
	@Autowired
	private DiaryStandardDoctorManage manage;
	@Autowired 
	private AppraisalManage appraisalManage;
	 //times保存标准细节日记第一次请求的起始时间
	private Map<String,Object> times = new HashMap<String, Object>();
	@ApiOperation("增加标准细节日记")
	@RequestMapping(value="add",method = RequestMethod.POST)
	public Object add(String text,ModelMap modelMap){
		List<DiaryStandardDoctor> records = JSON.parseArray(text, DiaryStandardDoctor.class);
		for (DiaryStandardDoctor record : records) {
			manage.add(record);
		}
		return setSuccessModelMap(modelMap);
	}
	/**
	 * 可以根据时间段，姓名，性别，出生年月，身份证查询
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@ApiOperation("多条件查找用户标准细节日记")
	@RequestMapping(value = "query",method = RequestMethod.POST)
	public Object query(HttpServletRequest request,ModelMap modelMap){
		Map<String,Object> params = WebUtil.getParameterMap(request);
		times.clear();
		times.put("startTime", params.get("startTime"));
		times.put("endTime", params.get("endTime"));
		PageInfo<DiaryStandardDoctor> record = manage.query(params);
		return setSuccessModelMap(modelMap,	record);
		
	}
	
	/**
	 * 查询个人记录
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@ApiOperation("根据身份证号查找用户标准细节日记")
	@RequestMapping(value = "queryById",method = RequestMethod.POST)
	public Object queryById(HttpServletRequest request,ModelMap modelMap){
		Map<String,Object> params = WebUtil.getParameterMap(request);
		String startTime = (String) times.get("startTime");
		String endTime = (String) times.get("endTime");
		params.put("startTime", startTime);
		params.put("endTime", endTime);
		PageInfo<DiaryStandardDoctor> record = manage.query(params);
		return setSuccessModelMap(modelMap,	record);
	}
	
	@ApiOperation("记忆力测评")
	@RequestMapping(value = "appraisal")
	public Object appraisal(String record,Integer id,ModelMap modelMap,HttpServletRequest request) throws ParseException{
		List<AppraisalDoctorVo> adv = JSON.parseArray(record, AppraisalDoctorVo.class);
		int size = adv.size();
		int errorSum = 0;
		float sum = 0;
		for (AppraisalDoctorVo appraisalDoctorVo : adv) {
			float value = 0;
			if(!appraisalDoctorVo.getIsElide()){
				value = Similarity(appraisalDoctorVo.getCorrectAnswer(), appraisalDoctorVo.getUserAnswer());
			}else{
				value = 100;
				appraisalDoctorVo.setIsError(false);
			}
			if(value<90){
				appraisalDoctorVo.setIsError(true);
				errorSum++;
			}
			sum+=value;
		}
		float grossScore = sum/size;
		float score = appraisalManage.ranKing(grossScore);
		Map<String,Object> result = new HashMap<>(); 
		if(id == null){ 
			Map<String,Object> params = WebUtil.getParameterMap(request);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Appraisal instance = new Appraisal();
			instance.setBirthday("".equals((String)params.get("birthday")) ? null : sdf.parse((String)params.get("birthday")));
			instance.setName((String) params.get("name"));
			instance.setIdentity((String) params.get("identity"));
			instance.setSex((String)params.get("sex"));
			instance.setScore(grossScore);
			appraisalManage.add(instance);
	 		int index = appraisalManage.findByLastIndex();
			result.put("id", index);
		}else{
			Appraisal appraisal = appraisalManage.queryById(id);
			appraisal.setScore(score);
			appraisalManage.update(appraisal);
			result.put("id", id);
		}
		result.put("score", Math.round(score));
		result.put("grossScore", Math.round(grossScore));
		result.put("object", adv);
		result.put("errorSum", errorSum);
		return setSuccessModelMap(modelMap,result);
	}
	/**
	 * 查名字和身份证号(数据量超大的时候用，使用了名字分组)
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@ApiOperation("查名字和身份证号")
	@RequestMapping(value = "simpleQuery", method = RequestMethod.POST)
	@SuppressWarnings({ "static-access", "rawtypes", "unchecked" })
	public Object simpleQuery(HttpServletRequest request,ModelMap modelMap){
		Map<String,Object> params = WebUtil.getParameterMap(request);
		List<DiaryStandardDoctor> doctors = manage.sympleQuery(params);
		Name2py name2py = new Name2py();
		ArrayList lis2 = null;//保存首字母相同的名字集合
		//table以首字母分开存放名字集合
		Hashtable<String, ArrayList> table = new Hashtable<String, ArrayList>();
		int count = doctors.size();
		String chainName;
		String allpy;
		String fir;
		String identity;
		for (int i = 0; i < count; i++) {
			chainName = doctors.get(i).getName();
			identity = doctors.get(i).getIdentity();
			allpy = name2py.cn2py(chainName);
			fir = allpy.substring(0,1); 
			lis2 = table.get(fir);
			if (lis2 == null || lis2.size() == 0){
				lis2 = new ArrayList();
			}	
			lis2.add(chainName+":"+identity);
			table.put(fir, lis2);
		}
		return setSuccessModelMap(modelMap,table);
	}
}
