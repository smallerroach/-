package com.yszt.base.model.generator;

import java.util.Date;

import com.yszt.base.BaseModel;

@SuppressWarnings("serial")
public class Appraisal extends BaseModel {

	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column appraisal.score
	 *
	 * @mbggenerated
	 */
	private Float score;
	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column appraisal.name
	 *
	 * @mbggenerated
	 */
	private String name;
	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column appraisal.identity
	 *
	 * @mbggenerated
	 */
	private String identity;
	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column appraisal.birthday
	 *
	 * @mbggenerated
	 */
	private Date birthday;
	/**
	 *
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column appraisal.sex
	 *
	 * @mbggenerated
	 */
	private String sex;

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column appraisal.name
	 *
	 * @return the value of appraisal.name
	 *
	 * @mbggenerated
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column appraisal.name
	 *
	 * @param name
	 *            the value for appraisal.name
	 *
	 * @mbggenerated
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column appraisal.identity
	 *
	 * @return the value of appraisal.identity
	 *
	 * @mbggenerated
	 */
	public String getIdentity() {
		return identity;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column appraisal.identity
	 *
	 * @param identity
	 *            the value for appraisal.identity
	 *
	 * @mbggenerated
	 */
	public void setIdentity(String identity) {
		this.identity = identity;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column appraisal.birthday
	 *
	 * @return the value of appraisal.birthday
	 *
	 * @mbggenerated
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column appraisal.birthday
	 *
	 * @param birthday
	 *            the value for appraisal.birthday
	 *
	 * @mbggenerated
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column appraisal.score
	 *
	 * @return the value of appraisal.score
	 *
	 * @mbggenerated
	 */
	public Float getScore() {
		return score;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column appraisal.score
	 *
	 * @param score
	 *            the value for appraisal.score
	 *
	 * @mbggenerated
	 */
	public void setScore(Float score) {
		this.score = score;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column appraisal.sex
	 *
	 * @return the value of appraisal.sex
	 *
	 * @mbggenerated
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column appraisal.sex
	 *
	 * @param sex
	 *            the value for appraisal.sex
	 *
	 * @mbggenerated
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table appraisal
	 *
	 * @mbggenerated
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", score=").append(score);
		sb.append(", identity=").append(identity);
		sb.append(", name=").append(name);
		sb.append(", birthday=").append(birthday);
		sb.append("]");
		return sb.toString();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table appraisal
	 *
	 * @mbggenerated
	 */
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
		Appraisal other = (Appraisal) that;
		return (this.getId() == null ? other.getId() == null : this.getId()
				.equals(other.getId()))
				&& (this.getCreateTime() == null ? other.getCreateTime() == null
						: this.getCreateTime().equals(other.getCreateTime()))
				&& (this.getCreateBy() == null ? other.getCreateBy() == null
						: this.getCreateBy().equals(other.getCreateBy()))
				&& (this.getUpdateTime() == null ? other.getUpdateTime() == null
						: this.getUpdateTime().equals(other.getUpdateTime()))
				&& (this.getUpdateBy() == null ? other.getUpdateBy() == null
						: this.getUpdateBy().equals(other.getUpdateBy()))
				&& (this.getEnable() == null ? other.getEnable() == null : this
						.getEnable().equals(other.getEnable()))
				&& (this.getRemark() == null ? other.getRemark() == null : this
						.getRemark().equals(other.getRemark()))
				&& (this.getScore() == null ? other.getScore() == null : this
						.getScore().equals(other.getScore()))
				&& (this.getName() == null ? other.getName() == null : this
						.getName().equals(other.getName()))
				&& (this.getBirthday() == null ? other.getBirthday() == null
						: this.getBirthday().equals(other.getBirthday()))
				&& (this.getIdentity() == null ? other.getIdentity() == null
						: this.getIdentity().equals(other.getIdentity()));
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table appraisal
	 *
	 * @mbggenerated
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result
				+ ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
		result = prime * result
				+ ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
		result = prime * result
				+ ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
		result = prime * result
				+ ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
		result = prime * result
				+ ((getEnable() == null) ? 0 : getEnable().hashCode());
		result = prime * result
				+ ((getRemark() == null) ? 0 : getRemark().hashCode());
		result = prime * result
				+ ((getScore() == null) ? 0 : getScore().hashCode());
		result = prime * result
				+ ((getName() == null) ? 0 : getName().hashCode());
		result = prime * result
				+ ((getIdentity() == null) ? 0 : getIdentity().hashCode());
		result = prime * result
				+ ((getBirthday() == null) ? 0 : getBirthday().hashCode());
		return result;
	}
}