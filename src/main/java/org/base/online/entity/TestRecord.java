package org.base.online.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

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
 * @version 2017-02-13 20:27:28
 * @see org.base.online.entity.TestRecord
 */
@Table(name = "o_test_record")
public class TestRecord extends BaseEntity {

	private static final long serialVersionUID = 1L;

	// alias
	/*
	 * public static final String TABLE_ALIAS = "TestRecord"; public static
	 * final String ALIAS_ID = "考试记录表"; public static final String
	 * ALIAS_STUDENT_ID = "学生ID"; public static final String ALIAS_PAPER_ID =
	 * "试题表ID"; public static final String ALIAS_PAPER_NAME = "试题名称"; public
	 * static final String ALIAS_USED_TIME = "做题使用时间"; public static final
	 * String ALIAS_RIGHT_SCORE = "得分"; public static final String
	 * ALIAS_ANSWER_START_TIME = "作答开始时间"; public static final String
	 * ALIAS_ANSWER_FINISH_TIME = "作答结束时间"; public static final String
	 * ALIAS_CREATE_TIME = "创建日期"; public static final String ALIAS_UPDATE_TIME
	 * = "修改日期"; public static final String ALIAS_STATUS = "状态（0：未做 1：已做）";
	 * public static final String ALIAS_ISPASS = "是否及格（0：否，1：是）";
	 */
	// date formats
	// public static final String FORMAT_ANSWER_START_TIME =
	// DateUtils.DATETIME_FORMAT;
	// public static final String FORMAT_ANSWER_FINISH_TIME =
	// DateUtils.DATETIME_FORMAT;
	// public static final String FORMAT_CREATE_TIME =
	// DateUtils.DATETIME_FORMAT;
	// public static final String FORMAT_UPDATE_TIME =
	// DateUtils.DATETIME_FORMAT;

	// columns START
	/**
	 * 考试记录表
	 */
	private java.lang.Integer id;
	/**
	 * 学生ID
	 */
	private java.lang.Integer student_id;
	/**
	 * 瞬时字段：学生姓名
	 */
	private java.lang.String student_name;
	/**
	 * 试题表ID
	 */
	private java.lang.Integer paper_id;
	/**
	 * 试题名称
	 */
	private java.lang.String paper_name;
	private TestPaper testPaper;
	/**
	 * 做题使用时间
	 */
	private java.lang.Long used_time;
	/**
	 * 总分
	 */
	private java.lang.Integer total_score;
	/**
	 * 得分
	 */
	private java.lang.Integer right_score;
	/**
	 * 作答开始时间
	 */
	private java.util.Date answer_start_time;
	/**
	 * 作答结束时间
	 */
	private java.util.Date answer_finish_time;
	/**
	 * 创建日期
	 */
	private java.util.Date create_time;
	/**
	 * 修改日期
	 */
	private java.util.Date update_time;
	/**
	 * 状态（0：未做 1：已做）
	 */
	private java.lang.Integer status;
	/**
	 * 是否及格（0：否，1：是）
	 */
	private java.lang.Integer isPass;

	// columns END 数据库字段结束

	// concstructor

	public TestRecord() {
	}

	public TestRecord(java.lang.Integer id) {
		this.id = id;
	}

	// get and set
	public void setId(java.lang.Integer value) {
		this.id = value;
	}

	@Id
	@WhereSQL(sql = "id=:TestRecord_id")
	public java.lang.Integer getId() {
		return this.id;
	}

	public void setStudent_id(java.lang.Integer value) {
		this.student_id = value;
	}

	@WhereSQL(sql = "student_id=:TestRecord_student_id")
	public java.lang.Integer getStudent_id() {
		return this.student_id;
	}

	public void setPaper_id(java.lang.Integer value) {
		this.paper_id = value;
	}

	@WhereSQL(sql = "paper_id=:TestRecord_paper_id")
	public java.lang.Integer getPaper_id() {
		return this.paper_id;
	}

	public void setPaper_name(java.lang.String value) {
		if (StringUtils.isNotBlank(value)) {
			value = value.trim();
		}
		this.paper_name = value;
	}

	@WhereSQL(sql = "paper_name=:TestRecord_paper_name")
	public java.lang.String getPaper_name() {
		return this.paper_name;
	}

	public void setUsed_time(java.lang.Long value) {
		this.used_time = value;
	}

	@WhereSQL(sql = "used_time=:TestRecord_used_time")
	public java.lang.Long getUsed_time() {
		return this.used_time;
	}

	public void setTotal_score(java.lang.Integer value) {
		this.total_score = value;
	}

	@WhereSQL(sql = "total_score=:TestRecord_total_score")
	public java.lang.Integer getTotal_score() {
		return this.total_score;
	}

	public void setRight_score(java.lang.Integer value) {
		this.right_score = value;
	}

	@WhereSQL(sql = "right_score=:TestRecord_right_score")
	public java.lang.Integer getRight_score() {
		return this.right_score;
	}

	/*
	 * public String getanswer_start_timeString() { return
	 * DateUtils.convertDate2String(FORMAT_ANSWER_START_TIME,
	 * getanswer_start_time()); } public void setanswer_start_timeString(String
	 * value) throws ParseException{
	 * setanswer_start_time(DateUtils.convertString2Date
	 * (FORMAT_ANSWER_START_TIME,value)); }
	 */

	public void setAnswer_start_time(java.util.Date value) {
		this.answer_start_time = value;
	}

	@WhereSQL(sql = "answer_start_time=:TestRecord_answer_start_time")
	public java.util.Date getAnswer_start_time() {
		return this.answer_start_time;
	}

	/*
	 * public String getanswer_finish_timeString() { return
	 * DateUtils.convertDate2String(FORMAT_ANSWER_FINISH_TIME,
	 * getanswer_finish_time()); } public void
	 * setanswer_finish_timeString(String value) throws ParseException{
	 * setanswer_finish_time
	 * (DateUtils.convertString2Date(FORMAT_ANSWER_FINISH_TIME,value)); }
	 */

	public void setAnswer_finish_time(java.util.Date value) {
		this.answer_finish_time = value;
	}

	@WhereSQL(sql = "answer_finish_time=:TestRecord_answer_finish_time")
	public java.util.Date getAnswer_finish_time() {
		return this.answer_finish_time;
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

	@WhereSQL(sql = "create_time=:TestRecord_create_time")
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

	@WhereSQL(sql = "update_time=:TestRecord_update_time")
	public java.util.Date getUpdate_time() {
		return this.update_time;
	}

	public void setStatus(java.lang.Integer value) {
		this.status = value;
	}

	@WhereSQL(sql = "status=:TestRecord_status")
	public java.lang.Integer getStatus() {
		return this.status;
	}

	public void setIsPass(java.lang.Integer value) {
		this.isPass = value;
	}

	@WhereSQL(sql = "isPass=:TestRecord_isPass")
	public java.lang.Integer getIsPass() {
		return this.isPass;
	}

	public String toString() {
		return new StringBuffer().append("考试记录表[").append(getId()).append("],")
				.append("学生ID[").append(getStudent_id()).append("],")
				.append("试题表ID[").append(getPaper_id()).append("],")
				.append("试题名称[").append(getPaper_name()).append("],")
				.append("做题使用时间[").append(getUsed_time()).append("],")
				.append("总分[").append(getTotal_score()).append("],")
				.append("得分[").append(getRight_score()).append("],")
				.append("作答开始时间[").append(getAnswer_start_time()).append("],")
				.append("作答结束时间[").append(getAnswer_finish_time()).append("],")
				.append("创建日期[").append(getCreate_time()).append("],")
				.append("修改日期[").append(getUpdate_time()).append("],")
				.append("状态（0：未做 1：已做）[").append(getStatus()).append("],")
				.append("是否及格（0：否，1：是）[").append(getIsPass()).append("],")
				.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof TestRecord == false)
			return false;
		if (this == obj)
			return true;
		TestRecord other = (TestRecord) obj;
		return new EqualsBuilder().append(getId(), other.getId()).isEquals();
	}

	@Transient
	public java.lang.String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(java.lang.String student_name) {
		this.student_name = student_name;
	}

	@Transient
	public TestPaper getTestPaper() {
		return testPaper;
	}

	public void setTestPaper(TestPaper testPaper) {
		this.testPaper = testPaper;
	}
}
