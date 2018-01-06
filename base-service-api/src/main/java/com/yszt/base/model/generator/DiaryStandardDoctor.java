package com.yszt.base.model.generator;

import com.yszt.base.BaseModel;
import java.util.Date;

@SuppressWarnings("serial")
public class DiaryStandardDoctor extends BaseModel {
    private String name;
    private Date birthday;
    private String sex;
    private String identity;
    private Date diaryDate;
    private Date startTime;
    private Date endTime;
    private String actionAddr;
    private String actionState;
    private String weather;
    private String emotion;
    private String audioLocation;
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getBirthday() {
        return birthday;
    }
 
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    public Date getDiaryDate() {
        return diaryDate;
    }

    public void setDiaryDate(Date diaryDate) {
        this.diaryDate = diaryDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getActionAddr() {
        return actionAddr;
    }

    public void setActionAddr(String actionAddr) {
        this.actionAddr = actionAddr == null ? null : actionAddr.trim();
    }

    public String getActionState() {
        return actionState;
    }

    public void setActionState(String actionState) {
        this.actionState = actionState == null ? null : actionState.trim();
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather == null ? null : weather.trim();
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion == null ? null : emotion.trim();
    }

    public String getAudioLocation() {
        return audioLocation;
    }

    public void setAudioLocation(String audioLocation) {
        this.audioLocation = audioLocation == null ? null : audioLocation.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", name=").append(name);
        sb.append(", birthday=").append(birthday);
        sb.append(", sex=").append(sex);
        sb.append(", identity=").append(identity);
        sb.append(", diaryDate=").append(diaryDate);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", actionAddr=").append(actionAddr);
        sb.append(", actionState=").append(actionState);
        sb.append(", weather=").append(weather);
        sb.append(", emotion=").append(emotion);
        sb.append(", audioLocation=").append(audioLocation);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        DiaryStandardDoctor other = (DiaryStandardDoctor) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getIdentity() == null ? other.getIdentity() == null : this.getIdentity().equals(other.getIdentity()))
            && (this.getDiaryDate() == null ? other.getDiaryDate() == null : this.getDiaryDate().equals(other.getDiaryDate()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getActionAddr() == null ? other.getActionAddr() == null : this.getActionAddr().equals(other.getActionAddr()))
            && (this.getActionState() == null ? other.getActionState() == null : this.getActionState().equals(other.getActionState()))
            && (this.getWeather() == null ? other.getWeather() == null : this.getWeather().equals(other.getWeather()))
            && (this.getEmotion() == null ? other.getEmotion() == null : this.getEmotion().equals(other.getEmotion()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getEnable() == null ? other.getEnable() == null : this.getEnable().equals(other.getEnable()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getAudioLocation() == null ? other.getAudioLocation() == null : this.getAudioLocation().equals(other.getAudioLocation()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getIdentity() == null) ? 0 : getIdentity().hashCode());
        result = prime * result + ((getDiaryDate() == null) ? 0 : getDiaryDate().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getActionAddr() == null) ? 0 : getActionAddr().hashCode());
        result = prime * result + ((getActionState() == null) ? 0 : getActionState().hashCode());
        result = prime * result + ((getWeather() == null) ? 0 : getWeather().hashCode());
        result = prime * result + ((getEmotion() == null) ? 0 : getEmotion().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getEnable() == null) ? 0 : getEnable().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getAudioLocation() == null) ? 0 : getAudioLocation().hashCode());
        return result;
    }
}