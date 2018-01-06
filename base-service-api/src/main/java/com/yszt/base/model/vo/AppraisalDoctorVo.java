package com.yszt.base.model.vo;

import java.util.Date;

/**
 * 标准细节日记(医生专用版) 测评辅类
 * @author qiaolin
 * @version 2017年2月17日
 * 
 */
public class AppraisalDoctorVo {
	private Date date; //日期 
	private Date startTime; // 时间
	private String site; // 地点
	private String correctAnswer; // 正确答案
	private String userAnswer; // 用户输入的答案
	private Date continueTime; // 持续时间
	private String emotion; // 心情
	private Boolean isElide;  // 是否忽略答案的正确性
	private Boolean isError; // 是否有错误
	private String weather;  // 天气
	
	public AppraisalDoctorVo() { }

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public String getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}

	public Date getContinueTime() {
		return continueTime;
	}

	public void setContinueTime(Date continueTime) {
		this.continueTime = continueTime;
	}

	public String getEmotion() {
		return emotion;
	}

	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}

	public Boolean getIsElide() {
		return isElide;
	}

	public void setIsElide(Boolean isElide) {
		this.isElide = isElide;
	}

	
	public Boolean getIsError() {
		return isError;
	}

	public void setIsError(Boolean isError) {
		this.isError = isError;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((continueTime == null) ? 0 : continueTime.hashCode());
		result = prime * result + ((correctAnswer == null) ? 0 : correctAnswer.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((emotion == null) ? 0 : emotion.hashCode());
		result = prime * result + ((isElide == null) ? 0 : isElide.hashCode());
		result = prime * result + ((isError == null) ? 0 : isError.hashCode());
		result = prime * result + ((site == null) ? 0 : site.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((userAnswer == null) ? 0 : userAnswer.hashCode());
		result = prime * result + ((weather == null) ? 0 : weather.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppraisalDoctorVo other = (AppraisalDoctorVo) obj;
		if (continueTime == null) {
			if (other.continueTime != null)
				return false;
		} else if (!continueTime.equals(other.continueTime))
			return false;
		if (correctAnswer == null) {
			if (other.correctAnswer != null)
				return false;
		} else if (!correctAnswer.equals(other.correctAnswer))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (emotion == null) {
			if (other.emotion != null)
				return false;
		} else if (!emotion.equals(other.emotion))
			return false;
		if (isElide == null) {
			if (other.isElide != null)
				return false;
		} else if (!isElide.equals(other.isElide))
			return false;
		if (isError == null) {
			if (other.isError != null)
				return false;
		} else if (!isError.equals(other.isError))
			return false;
		if (site == null) {
			if (other.site != null)
				return false;
		} else if (!site.equals(other.site))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (userAnswer == null) {
			if (other.userAnswer != null)
				return false;
		} else if (!userAnswer.equals(other.userAnswer))
			return false;
		if (weather == null) {
			if (other.weather != null)
				return false;
		} else if (!weather.equals(other.weather))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AppraisalDoctorVo [date=" + date + ", startTime=" + startTime + ", site=" + site + ", correctAnswer="
				+ correctAnswer + ", userAnswer=" + userAnswer + ", continueTime=" + continueTime + ", emotion="
				+ emotion + ", isElide=" + isElide + ", isError=" + isError + ", weather=" + weather + "]";
	}
	
	
	
}
