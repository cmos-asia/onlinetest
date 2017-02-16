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
 * @version 2017-02-13 20:27:59
 * @see org.base.online.entity.TopicType
 */
@Table(name = "o_topic_type")
public class TopicType extends BaseEntity {

	private static final long serialVersionUID = 1L;

	// alias
	/*
	 * public static final String TABLE_ALIAS = "TopicType"; public static final
	 * String ALIAS_ID = "题目类型表"; public static final String ALIAS_NAME = "名称";
	 * public static final String ALIAS_CREATE_TIME = "创建日期"; public static
	 * final String ALIAS_UPDATE_TIME = "修改日期";
	 */
	// date formats
	// public static final String FORMAT_CREATE_TIME =
	// DateUtils.DATETIME_FORMAT;
	// public static final String FORMAT_UPDATE_TIME =
	// DateUtils.DATETIME_FORMAT;

	// columns START
	/**
	 * 题目类型表
	 */
	private java.lang.Integer id;
	/**
	 * 名称
	 */
	private java.lang.String name;
	/**
	 * 创建日期
	 */
	private java.util.Date create_time;
	/**
	 * 修改日期
	 */
	private java.util.Date update_time;
	/**
	 * 生效状态（0：不可用，1：可用）
	 */
	private java.lang.Integer status;

	// columns END 数据库字段结束

	// concstructor

	public TopicType() {
	}

	public TopicType(java.lang.Integer id) {
		this.id = id;
	}

	// get and set
	public void setId(java.lang.Integer value) {
		this.id = value;
	}

	@Id
	@WhereSQL(sql = "id=:TopicType_id")
	public java.lang.Integer getId() {
		return this.id;
	}

	public void setName(java.lang.String value) {
		if (StringUtils.isNotBlank(value)) {
			value = value.trim();
		}
		this.name = value;
	}

	@WhereSQL(sql = "name=:TopicType_name")
	public java.lang.String getName() {
		return this.name;
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

	@WhereSQL(sql = "create_time=:TopicType_create_time")
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

	@WhereSQL(sql = "update_time=:TopicType_update_time")
	public java.util.Date getUpdate_time() {
		return this.update_time;
	}

	public void setStatus(java.lang.Integer value) {
		this.status = value;
	}

	@WhereSQL(sql = "status=:TopicType_status")
	public java.lang.Integer getStatus() {
		return this.status;
	}

	public String toString() {
		return new StringBuffer().append("题目类型表[").append(getId()).append("],")
				.append("名称[").append(getName()).append("],").append("创建日期[")
				.append(getCreate_time()).append("],").append("修改日期[")
				.append(getUpdate_time()).append("],")
				.append("生效状态（0：不可用，1：可用）[").append(getStatus()).append("],")
				.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof TopicType == false)
			return false;
		if (this == obj)
			return true;
		TopicType other = (TopicType) obj;
		return new EqualsBuilder().append(getId(), other.getId()).isEquals();
	}
}
