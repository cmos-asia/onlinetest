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
 * @copyright {@link 9iu.org}
 * @author springrain<Auto generate>
 * @version  2017-02-13 20:26:05
 * @see org.base.online.entity.Subjects
 */
@Table(name="o_subjects")
public class Subjects  extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	//alias
	/*
	public static final String TABLE_ALIAS = "Subjects";
	public static final String ALIAS_ID = "科目表";
	public static final String ALIAS_NAME = "name";
	public static final String ALIAS_CREATE_TIME = "create_time";
	public static final String ALIAS_UPDATE_TIME = "update_time";
	public static final String ALIAS_STATUS = "生效状态（0：不可用，1：可用）";
    */
	//date formats
	//public static final String FORMAT_CREATE_TIME = DateUtils.DATETIME_FORMAT;
	//public static final String FORMAT_UPDATE_TIME = DateUtils.DATETIME_FORMAT;
	
	//columns START
	/**
	 * 科目表
	 */
	private java.lang.Integer id;
	/**
	 * name
	 */
	private java.lang.String name;
	/**
	 * create_time
	 */
	private java.util.Date create_time;
	/**
	 * update_time
	 */
	private java.util.Date update_time;
	/**
	 * 生效状态（0：不可用，1：可用）
	 */
	private java.lang.Integer status;
	//columns END 数据库字段结束
	
	//concstructor

	public Subjects(){
	}

	public Subjects(
		java.lang.Integer id
	){
		this.id = id;
	}

	//get and set
	public void setId(java.lang.Integer value) {
		this.id = value;
	}
	
	@Id
     @WhereSQL(sql="id=:Subjects_id")
	public java.lang.Integer getId() {
		return this.id;
	}
	public void setName(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.name = value;
	}
	
     @WhereSQL(sql="name=:Subjects_name")
	public java.lang.String getName() {
		return this.name;
	}
		/*
	public String getcreate_timeString() {
		return DateUtils.convertDate2String(FORMAT_CREATE_TIME, getcreate_time());
	}
	public void setcreate_timeString(String value) throws ParseException{
		setcreate_time(DateUtils.convertString2Date(FORMAT_CREATE_TIME,value));
	}*/
	
	public void setCreate_time(java.util.Date value) {
		this.create_time = value;
	}
	
     @WhereSQL(sql="create_time=:Subjects_create_time")
	public java.util.Date getCreate_time() {
		return this.create_time;
	}
		/*
	public String getupdate_timeString() {
		return DateUtils.convertDate2String(FORMAT_UPDATE_TIME, getupdate_time());
	}
	public void setupdate_timeString(String value) throws ParseException{
		setupdate_time(DateUtils.convertString2Date(FORMAT_UPDATE_TIME,value));
	}*/
	
	public void setUpdate_time(java.util.Date value) {
		this.update_time = value;
	}
	
     @WhereSQL(sql="update_time=:Subjects_update_time")
	public java.util.Date getUpdate_time() {
		return this.update_time;
	}
	public void setStatus(java.lang.Integer value) {
		this.status = value;
	}
	
     @WhereSQL(sql="status=:Subjects_status")
	public java.lang.Integer getStatus() {
		return this.status;
	}
	
	public String toString() {
		return new StringBuffer()
			.append("科目表[").append(getId()).append("],")
			.append("name[").append(getName()).append("],")
			.append("create_time[").append(getCreate_time()).append("],")
			.append("update_time[").append(getUpdate_time()).append("],")
			.append("生效状态（0：不可用，1：可用）[").append(getStatus()).append("],")
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Subjects == false) return false;
		if(this == obj) return true;
		Subjects other = (Subjects)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

	
