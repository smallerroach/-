package com.yszt.base.man.diary;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yszt.base.BaseManage;
import com.yszt.base.model.generator.Appraisal;
import com.yszt.base.service.diary.AppraisalService;
/**
 *  
 * @author qiaolin
 *
 */
@Service
public class AppraisalManage extends BaseManage<AppraisalService, Appraisal>{

	@Autowired
	public void setService(AppraisalService appraisalService) {
		this.service = appraisalService;
	}
	
	/**
	 *  打败了多少用户。
	 * @return
	 */
	public float ranKing(Float score){
		Map<String,Object> params = this.service.ranKing(score);
		if(((Long)params.get("min"))==0){
			return 0;
		}else if(((Long)params.get("equal"))==((Long)params.get("max"))){
			return 100;
		}
		double sum = ((((Long)params.get("min")).doubleValue())/((Long)params.get("sum")).doubleValue())*100;
		return (float) sum;
	};
	
	/**
	 *  获取最后插入数据的id
	 */
	public int findByLastIndex(){
		return this.service.findByLastIndex();
	}
	
}
