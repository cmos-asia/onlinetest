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
 * @version  2017-02-13 20:27:47
 * @see org.base.online.entity.TestRecordInfo
 */
@Table(name="o_test_record_info")
public class TestRecordInfo  extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	//alias
	/*
	public static final String TABLE_ALIAS = "TestRecordInfo";
	public static final String ALIAS_ID = "考试记录详情表";
	public static final String ALIAS_RECORD_ID = "记录表ID";
	public static final String ALIAS_PAPER_ID = "试题表ID";
	public static final String ALIAS_PAPER_INFO_ID = "试题详情表ID";
	public static final String ALIAS_ANSWER_RESULT = "作答答案";
	public static final String ALIAS_ANSWER_SCORE = "作答得分";
	public static final String ALIAS_ISRIGHT = "是否正确（0：否，1：是）";
    */
	//date formats
	
	//columns START
	/**
	 * 考试记录详情表
	 */
	private java.lang.Integer id;
	/**
	 * 记录表ID
	 */
	private java.lang.Integer record_id;
	/**
	 * 试题表ID
	 */
	private java.lang.Integer paper_id;
	/**
	 * 试题详情表ID
	 */
	private java.lang.Integer paper_info_id;
	/**
	 * 作答答案
	 */
	private java.lang.String answer_result;
	/**
	 * 作答得分
	 */
	private java.lang.Integer answer_score;
	/**
	 * 是否正确（0：否，1：是）
	 */
	private java.lang.Integer isRight;
	//columns END 数据库字段结束
	
	//concstructor

	public TestRecordInfo(){
	}

	public TestRecordInfo(
		java.lang.Integer id
	){
		this.id = id;
	}

	//get and set
	public void setId(java.lang.Integer value) {
		this.id = value;
	}
	
	@Id
     @WhereSQL(sql="id=:TestRecordInfo_id")
	public java.lang.Integer getId() {
		return this.id;
	}
	public void setRecord_id(java.lang.Integer value) {
		this.record_id = value;
	}
	
     @WhereSQL(sql="record_id=:TestRecordInfo_record_id")
	public java.lang.Integer getRecord_id() {
		return this.record_id;
	}
	public void setPaper_id(java.lang.Integer value) {
		this.paper_id = value;
	}
	
     @WhereSQL(sql="paper_id=:TestRecordInfo_paper_id")
	public java.lang.Integer getPaper_id() {
		return this.paper_id;
	}
	public void setPaper_info_id(java.lang.Integer value) {
		this.paper_info_id = value;
	}
	
     @WhereSQL(sql="paper_info_id=:TestRecordInfo_paper_info_id")
	public java.lang.Integer getPaper_info_id() {
		return this.paper_info_id;
	}
	public void setAnswer_result(java.lang.String value) {
		    if(StringUtils.isNotBlank(value)){
			 value=value.trim();
			}
		this.answer_result = value;
	}
	
     @WhereSQL(sql="answer_result=:TestRecordInfo_answer_result")
	public java.lang.String getAnswer_result() {
		return this.answer_result;
	}
	public void setAnswer_score(java.lang.Integer value) {
		this.answer_score = value;
	}
	
     @WhereSQL(sql="answer_score=:TestRecordInfo_answer_score")
	public java.lang.Integer getAnswer_score() {
		return this.answer_score;
	}
	public void setIsRight(java.lang.Integer value) {
		this.isRight = value;
	}
	
     @WhereSQL(sql="isRight=:TestRecordInfo_isRight")
	public java.lang.Integer getIsRight() {
		return this.isRight;
	}
	
	public String toString() {
		return new StringBuffer()
			.append("考试记录详情表[").append(getId()).append("],")
			.append("记录表ID[").append(getRecord_id()).append("],")
			.append("试题表ID[").append(getPaper_id()).append("],")
			.append("试题详情表ID[").append(getPaper_info_id()).append("],")
			.append("作答答案[").append(getAnswer_result()).append("],")
			.append("作答得分[").append(getAnswer_score()).append("],")
			.append("是否正确（0：否，1：是）[").append(getIsRight()).append("],")
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TestRecordInfo == false) return false;
		if(this == obj) return true;
		TestRecordInfo other = (TestRecordInfo)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

	
