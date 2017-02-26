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
 * @version 2017-02-13 20:27:14
 * @see org.base.online.entity.TestPaperInfo
 */
@Table(name = "o_test_paper_info")
public class TestPaperInfo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	// alias
	/*
	 * public static final String TABLE_ALIAS = "TestPaperInfo"; public static
	 * final String ALIAS_ID = "试卷详情表"; public static final String
	 * ALIAS_PAPER_ID = "试卷ID"; public static final String ALIAS_TOPIC_TYPE =
	 * "题目类型"; public static final String ALIAS_SCORE = "分值"; public static
	 * final String ALIAS_PROBLEM_DESCRIPTION = "题目描述"; public static final
	 * String ALIAS_REFERENCE_DESCRIPTION = "参考说明"; public static final String
	 * ALIAS_OPTION = "选项"; public static final String ALIAS_RIGHT_ANSWER =
	 * "正确答案"; public static final String ALIAS_CREATE_TIME = "创建日期"; public
	 * static final String ALIAS_UPDATE_TIME = "修改日期"; public static final
	 * String ALIAS_IMGURL = "图片路径"; public static final String ALIAS_ISIMG =
	 * "是否为图片类型题目（0：否，1：是）";
	 */
	// date formats
	// public static final String FORMAT_CREATE_TIME =
	// DateUtils.DATETIME_FORMAT;
	// public static final String FORMAT_UPDATE_TIME =
	// DateUtils.DATETIME_FORMAT;

	// columns START
	/**
	 * 试卷详情表
	 */
	private java.lang.Integer id;
	/**
	 * 试卷ID
	 */
	private java.lang.Integer paper_id;
	/**
	 * 瞬时字段：试卷详情
	 */
	private List<PaperOptions> paperOptions;
	private TestRecordInfo recordInfo;
	/**
	 * 瞬时字段：试卷名称
	 */
	private java.lang.String paperName;
	/**
	 * 瞬时字段：试卷
	 */
	private TestPaper testPaper;
	/**
	 * 题目类型
	 */
	private java.lang.Integer topic_type;
	/**
	 * 瞬时字段：题目类型名称
	 */
	private java.lang.String topicTypeName;
	/**
	 * 分值
	 */
	private java.lang.Integer score;
	/**
	 * 题目描述
	 */
	private java.lang.String problem_description;
	/**
	 * 参考说明
	 */
	private java.lang.String reference_description;
	/**
	 * 选项
	 */
	private java.lang.String options;
	/**
	 * 正确答案
	 */
	private java.lang.String right_answer;
	/**
	 * 创建日期
	 */
	private java.util.Date create_time;
	/**
	 * 修改日期
	 */
	private java.util.Date update_time;
	/**
	 * 图片路径
	 */
	private java.lang.String imgURL;
	/**
	 * 是否为图片类型题目（0：否，1：是）
	 */
	private java.lang.Integer isIMG;

	// columns END 数据库字段结束

	// concstructor

	public TestPaperInfo() {
	}

	public TestPaperInfo(java.lang.Integer id) {
		this.id = id;
	}

	// get and set
	public void setId(java.lang.Integer value) {
		this.id = value;
	}

	@Id
	@WhereSQL(sql = "id=:TestPaperInfo_id")
	public java.lang.Integer getId() {
		return this.id;
	}

	public void setPaper_id(java.lang.Integer value) {
		this.paper_id = value;
	}

	@WhereSQL(sql = "paper_id=:TestPaperInfo_paper_id")
	public java.lang.Integer getPaper_id() {
		return this.paper_id;
	}

	@Transient
	public java.lang.String getPaperName() {
		return paperName;
	}

	@Transient
	public List<PaperOptions> getPaperOptions() {
		return paperOptions;
	}

	public void setPaperOptions(List<PaperOptions> paperOptions) {
		this.paperOptions = paperOptions;
	}

	public void setPaperName(java.lang.String paperName) {
		this.paperName = paperName;
	}

	@Transient
	public TestPaper getTestPaper() {
		return testPaper;
	}

	public void setTestPaper(TestPaper testPaper) {
		this.testPaper = testPaper;
	}

	public void setTopic_type(java.lang.Integer value) {
		this.topic_type = value;
	}

	@WhereSQL(sql = "topic_type=:TestPaperInfo_topic_type")
	public java.lang.Integer getTopic_type() {
		return this.topic_type;
	}

	@Transient
	public java.lang.String getTopicTypeName() {
		return topicTypeName;
	}

	public void setTopicTypeName(java.lang.String topicTypeName) {
		this.topicTypeName = topicTypeName;
	}

	public void setScore(java.lang.Integer value) {
		this.score = value;
	}

	@WhereSQL(sql = "score=:TestPaperInfo_score")
	public java.lang.Integer getScore() {
		return this.score;
	}

	public void setProblem_description(java.lang.String value) {
		if (StringUtils.isNotBlank(value)) {
			value = value.trim();
		}
		this.problem_description = value;
	}

	@WhereSQL(sql = "problem_description=:TestPaperInfo_problem_description")
	public java.lang.String getProblem_description() {
		return this.problem_description;
	}

	public void setReference_description(java.lang.String value) {
		if (StringUtils.isNotBlank(value)) {
			value = value.trim();
		}
		this.reference_description = value;
	}

	@WhereSQL(sql = "reference_description=:TestPaperInfo_reference_description")
	public java.lang.String getReference_description() {
		return this.reference_description;
	}

	public void setOptions(java.lang.String value) {
		if (StringUtils.isNotBlank(value)) {
			value = value.trim();
		}
		this.options = value;
	}

	@WhereSQL(sql = "options=:TestPaperInfo_options")
	public java.lang.String getOptions() {
		return this.options;
	}

	public void setRight_answer(java.lang.String value) {
		if (StringUtils.isNotBlank(value)) {
			value = value.trim();
		}
		this.right_answer = value;
	}

	@WhereSQL(sql = "right_answer=:TestPaperInfo_right_answer")
	public java.lang.String getRight_answer() {
		return this.right_answer;
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

	@WhereSQL(sql = "create_time=:TestPaperInfo_create_time")
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

	@WhereSQL(sql = "update_time=:TestPaperInfo_update_time")
	public java.util.Date getUpdate_time() {
		return this.update_time;
	}

	public void setImgURL(java.lang.String value) {
		if (StringUtils.isNotBlank(value)) {
			value = value.trim();
		}
		this.imgURL = value;
	}

	@WhereSQL(sql = "imgURL=:TestPaperInfo_imgURL")
	public java.lang.String getImgURL() {
		return this.imgURL;
	}

	public void setIsIMG(java.lang.Integer value) {
		this.isIMG = value;
	}

	@WhereSQL(sql = "isIMG=:TestPaperInfo_isIMG")
	public java.lang.Integer getIsIMG() {
		return this.isIMG;
	}

	public String toString() {
		return new StringBuffer().append("试卷详情表[").append(getId()).append("],")
				.append("试卷ID[").append(getPaper_id()).append("],")
				.append("题目类型[").append(getTopic_type()).append("],")
				.append("分值[").append(getScore()).append("],").append("题目描述[")
				.append(getProblem_description()).append("],").append("参考说明[")
				.append(getReference_description()).append("],").append("选项[")
				.append(getOptions()).append("],").append("正确答案[")
				.append(getRight_answer()).append("],").append("创建日期[")
				.append(getCreate_time()).append("],").append("修改日期[")
				.append(getUpdate_time()).append("],").append("图片路径[")
				.append(getImgURL()).append("],").append("试卷名称[")
				.append(getPaperName()).append("],").append("题目类型名称[")
				.append(getTopicTypeName()).append("],")
				.append("是否为图片类型题目（0：否，1：是）[").append(getIsIMG()).append("],")
				.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof TestPaperInfo == false)
			return false;
		if (this == obj)
			return true;
		TestPaperInfo other = (TestPaperInfo) obj;
		return new EqualsBuilder().append(getId(), other.getId()).isEquals();
	}

	@Transient
	public TestRecordInfo getRecordInfo() {
		return recordInfo;
	}

	public void setRecordInfo(TestRecordInfo recordInfo) {
		this.recordInfo = recordInfo;
	}
}
