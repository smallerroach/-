package com.yszt.base.web.diary;

import static com.yszt.base.util.StringCompare.Similarity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.HashMap;
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
import com.yszt.base.model.generator.Appraisal;
import com.yszt.base.model.vo.AppraisalVo;
import com.yszt.base.util.WebUtil;

/**
 * 记忆力测评控制层。
 * @author qiaolin
 *
 */
@RestController
@RequestMapping(value = "appraisal")
@Api(value = "记忆力测评",description = "记忆力测评管理")
public class AppraisalController extends BaseController{
	
	@Autowired
	private AppraisalManage manage;
	//times保存记忆力测评第一次查询的时间
	private Map<String,Object> times = new HashMap<String, Object>();
	
	/**
	 * 可以根据时间段，姓名，性别，出生年月，身份证查询
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@ApiOperation(value = "多条件查看历史记忆力测试结果")
	@RequestMapping(value = "showAppraisal",method = RequestMethod.POST)
	public Object showAppraisal(HttpServletRequest request,ModelMap modelMap){
		Map<String,Object> params = WebUtil.getParameterMap(request);
		times.clear();
		times.put("startTime", params.get("startTime"));
		times.put("endTime", params.get("endTime"));
		PageInfo<Appraisal> record = manage.query(params);
		return setSuccessModelMap(modelMap, record);
	}
	/**
	 * 根据ID和时间查询
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@ApiOperation(value = "根据ID和时间查询")
	@RequestMapping(value = "queryById",method = RequestMethod.POST)
	public Object queryById(HttpServletRequest request,ModelMap modelMap){
		Map<String,Object> params = WebUtil.getParameterMap(request);
		params.put("startTime", (String) times.get("startTime"));
		params.put("endTime", (String) times.get("endTime"));
		PageInfo<Appraisal> record = manage.query(params);
		return setSuccessModelMap(modelMap,	record);
	}
	/**
	 * 记忆力测评分析
	 * @param request
	 * @param msg
	 * @param modelMap
	 * @return
	 */
	@ApiOperation(value = "记忆力测评")
	@RequestMapping(value = "memory",method = RequestMethod.POST)
	public Object memory(HttpServletRequest request,String msg,ModelMap modelMap){
		List<AppraisalVo> record = JSON.parseArray(msg,AppraisalVo.class);
		int size = record.size();
		float sum = 0;
		for (AppraisalVo appraisalVo : record) {
			sum+=Similarity(appraisalVo.getValue1(), appraisalVo.getValue2());
		}
		float grossScore = sum/size;
		Map<String,Object> params = WebUtil.getParameterMap(request);
		float score = manage.ranKing(grossScore);
		Appraisal instance = new Appraisal();
		 
		instance.setCreateBy(Integer.parseInt((String)params.get("createBy")));
		instance.setScore(grossScore);
		manage.add(instance);
		Map<String,Object> result = new HashMap<>();
		result.put("score", Math.round(score));
		result.put("grossScore", Math.round(grossScore));
		return setSuccessModelMap(modelMap,result);
	}
	
}
