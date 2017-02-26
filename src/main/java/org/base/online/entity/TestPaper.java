package org.base.online.entity;

import java.util.List;

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
 * @version 2017-02-13 20:27:02
 * @see org.base.online.entity.TestPaper
 */
@Table(name = "o_test_paper")
public class TestPaper extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	private java.lang.Integer id;
	/**
	 * 试卷名称
	 */
	private java.lang.String name;
	/**
	 * 科目
	 */
	private java.lang.Integer subjects;
	/**
	 * 瞬时字段：所有科目
	 */
	private List<Subjects> subjectsList;
	/**
	 * 瞬时字段：试卷信息
	 */
	private List<TestPaperInfo> testPaperInfoList;
	/**
	 * 瞬时字段：科目名称
	 */
	private java.lang.String subjectsName;
	/**
	 * 瞬时字段：服务当前时间
	 */
	private java.util.Date serverNowDate;
	/**
	 * 瞬时字段：考试结束时间
	 */
	private java.util.Date serverEndTime;
	/**
	 * 生效状态（0：不可用，1：可以，2：已删除）
	 */
	private java.lang.Integer status;
	/**
	 * 作答时间
	 */
	private java.lang.Integer answer_time;
	/**
	 * 总分
	 */
	private java.lang.Integer total_score;
	/**
	 * 及格分数
	 */
	private java.lang.Integer pass_mark;
	/**
	 * 创建日期
	 */
	private java.util.Date create_time;
	/**
	 * 修改日期
	 */
	private java.util.Date update_time;

	// columns END 数据库字段结束

	// concstructor

	public TestPaper() {
	}

	public TestPaper(java.lang.Integer id) {
		this.id = id;
	}

	// get and set
	public void setId(java.lang.Integer value) {
		this.id = value;
	}

	@Id
	@WhereSQL(sql = "id=:TestPaper_id")
	public java.lang.Integer getId() {
		return this.id;
	}

	public void setName(java.lang.String value) {
		if (StringUtils.isNotBlank(value)) {
			value = value.trim();
		}
		this.name = value;
	}

	@WhereSQL(sql = "name=:TestPaper_name")
	public java.lang.String getName() {
		return this.name;
	}

	public void setSubjects(java.lang.Integer value) {
		this.subjects = value;
	}

	@WhereSQL(sql = "subjects=:TestPaper_subjects")
	public java.lang.Integer getSubjects() {
		return this.subjects;
	}

	@Transient
	public java.lang.String getSubjectsName() {
		return subjectsName;
	}

	@Transient
	public java.util.Date getServerNowDate() {
		return serverNowDate;
	}

	@Transient
	public java.util.Date getServerEndTime() {
		return serverEndTime;
	}

	public void setServerEndTime(java.util.Date serverEndTime) {
		this.serverEndTime = serverEndTime;
	}

	public void setServerNowDate(java.util.Date serverNowDate) {
		this.serverNowDate = serverNowDate;
	}

	public void setSubjectsName(java.lang.String subjectsName) {
		this.subjectsName = subjectsName;
	}

	@Transient
	public List<Subjects> getSubjectsList() {
		return subjectsList;
	}

	public void setSubjectsList(List<Subjects> subjectsList) {
		this.subjectsList = subjectsList;
	}

	@Transient
	public List<TestPaperInfo> getTestPaperInfoList() {
		return testPaperInfoList;
	}

	public void setTestPaperInfoList(List<TestPaperInfo> testPaperInfoList) {
		this.testPaperInfoList = testPaperInfoList;
	}

	public void setStatus(java.lang.Integer value) {
		this.status = value;
	}

	@WhereSQL(sql = "status=:TestPaper_status")
	public java.lang.Integer getStatus() {
		return this.status;
	}

	public void setAnswer_time(java.lang.Integer value) {
		this.answer_time = value;
	}

	@WhereSQL(sql = "answer_time=:TestPaper_answer_time")
	public java.lang.Integer getAnswer_time() {
		return this.answer_time;
	}

	public void setTotal_score(java.lang.Integer value) {
		this.total_score = value;
	}

	@WhereSQL(sql = "total_score=:TestPaper_total_score")
	public java.lang.Integer getTotal_score() {
		return this.total_score;
	}

	public void setPass_mark(java.lang.Integer value) {
		this.pass_mark = value;
	}

	@WhereSQL(sql = "pass_mark=:TestPaper_pass_mark")
	public java.lang.Integer getPass_mark() {
		return this.pass_mark;
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

	@WhereSQL(sql = "create_time=:TestPaper_create_time")
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

	@WhereSQL(sql = "update_time=:TestPaper_update_time")
	public java.util.Date getUpdate_time() {
		return this.update_time;
	}

	public String toString() {
		return new StringBuffer().append("id[").append(getId()).append("],")
				.append("试卷名称[").append(getName()).append("],").append("科目[")
				.append(getSubjects()).append("],")
				.append("生效状态（0：不可用，1：可以，2：已删除）[").append(getStatus())
				.append("],").append("作答时间[").append(getAnswer_time())
				.append("],").append("总分[").append(getTotal_score())
				.append("],").append("及格分数[").append(getPass_mark())
				.append("],").append("创建日期[").append(getCreate_time())
				.append("],").append("修改日期[").append(getUpdate_time())
				.append("],").append("科目名称[").append(getSubjectsName())
				.append("],").toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof TestPaper == false)
			return false;
		if (this == obj)
			return true;
		TestPaper other = (TestPaper) obj;
		return new EqualsBuilder().append(getId(), other.getId()).isEquals();
	}
}
