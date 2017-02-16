package org.base.online.entity;

import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.base.frame.annotation.WhereSQL;
import org.base.frame.entity.BaseEntity;

/**
 * TODO 在此加入类描述
 * 
 * @copyright {@link 9iu.org}
 * @author springrain<Auto generate>
 * @version 2017-02-13 20:26:48
 * @see org.base.online.entity.Student
 */
@Table(name = "o_student")
public class Student extends BaseEntity {

	private static final long serialVersionUID = 1L;

	// alias
	/*
	 * public static final String TABLE_ALIAS = "Student"; public static final
	 * String ALIAS_PHONE = "手机号"; public static final String ALIAS_NAME = "姓名";
	 * public static final String ALIAS_MAJOR = "专业"; public static final String
	 * ALIAS_PASSWORD = "密码"; public static final String ALIAS_CREATE_TIME =
	 * "创建时间"; public static final String ALIAS_UPDATE_TIME = "修改时间"; public
	 * static final String ALIAS_ID = "学生表";
	 */
	// date formats
	// public static final String FORMAT_CREATE_TIME =
	// DateUtils.DATETIME_FORMAT;
	// public static final String FORMAT_UPDATE_TIME =
	// DateUtils.DATETIME_FORMAT;

	// columns START
	/**
	 * 手机号
	 */
	private java.lang.String phone;
	/**
	 * 姓名
	 */
	private java.lang.String name;
	/**
	 * 姓名
	 */
	private java.lang.String sex;
	/**
	 * 专业
	 */
	private java.lang.String major;
	/**
	 * 密码
	 */
	private java.lang.String password;
	/**
	 * 创建时间
	 */
	private java.util.Date create_time;
	/**
	 * 修改时间
	 */
	private java.util.Date update_time;
	/**
	 * 学生表
	 */
	private java.lang.Integer id;

	// columns END 数据库字段结束

	// concstructor

	public Student() {
	}

	public Student(java.lang.Integer id) {
		this.id = id;
	}

	// get and set
	public void setPhone(java.lang.String value) {
		this.phone = value;
	}

	@WhereSQL(sql = "phone=:Student_phone")
	public java.lang.String getPhone() {
		return this.phone;
	}

	public void setName(java.lang.String value) {
		if (StringUtils.isNotBlank(value)) {
			value = value.trim();
		}
		this.name = value;
	}

	@WhereSQL(sql = "name=:Student_name")
	public java.lang.String getName() {
		return this.name;
	}

	public void setSex(java.lang.String value) {
		if (StringUtils.isNotBlank(value)) {
			value = value.trim();
		}
		this.sex = value;
	}

	@WhereSQL(sql = "sex=:Student_sex")
	public java.lang.String getSex() {
		return this.sex;
	}

	public void setMajor(java.lang.String value) {
		if (StringUtils.isNotBlank(value)) {
			value = value.trim();
		}
		this.major = value;
	}

	@WhereSQL(sql = "major=:Student_major")
	public java.lang.String getMajor() {
		return this.major;
	}

	public void setPassword(java.lang.String value) {
		if (StringUtils.isNotBlank(value)) {
			value = value.trim();
		}
		this.password = value;
	}

	@WhereSQL(sql = "password=:Student_password")
	public java.lang.String getPassword() {
		return this.password;
	}

	/*
	 * public String getcreate_timeString() { return
	 * DateUtils.convertDate2String(FORMAT_CREATE_TIME, getcreate_time()); }
	 * public void setcreate_timeString(String value) throws ParseException{
	 * setcreate_time(DateUtils.convertString2Date(FORMAT_CREATE_TIME,value)); }
	 */

	public void setCreate_time(java.util.Date value) {
		this.create_time = value;
	}

	@WhereSQL(sql = "create_time=:Student_create_time")
	public java.util.Date getCreate_time() {
		return this.create_time;
	}

	/*
	 * public String getupdate_timeString() { return
	 * DateUtils.convertDate2String(FORMAT_UPDATE_TIME, getupdate_time()); }
	 * public void setupdate_timeString(String value) throws ParseException{
	 * setupdate_time(DateUtils.convertString2Date(FORMAT_UPDATE_TIME,value)); }
	 */

	public void setUpdate_time(java.util.Date value) {
		this.update_time = value;
	}

	@WhereSQL(sql = "update_time=:Student_update_time")
	public java.util.Date getUpdate_time() {
		return this.update_time;
	}

	public void setId(java.lang.Integer value) {
		this.id = value;
	}

	@Id
	@WhereSQL(sql = "id=:Student_id")
	public java.lang.Integer getId() {
		return this.id;
	}

	public String toString() {
		return new StringBuffer().append("手机号[").append(getPhone())
				.append("],").append("姓名[").append(getName()).append("],")
				.append("专业[").append(getMajor()).append("],").append("性别[")
				.append(getSex()).append("],").append("密码[")
				.append(getPassword()).append("],").append("创建时间[")
				.append(getCreate_time()).append("],").append("修改时间[")
				.append(getUpdate_time()).append("],").append("学生表[")
				.append(getId()).append("],").toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Student == false)
			return false;
		if (this == obj)
			return true;
		Student other = (Student) obj;
		return new EqualsBuilder().append(getId(), other.getId()).isEquals();
	}
}
