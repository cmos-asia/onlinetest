package org.base.online.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class PaperAnswer {
	/**
	 * 题目类型表
	 */
	private java.lang.Integer id;
	/**
	 * 
	 */
	private java.lang.Integer optionId;

	// concstructor

	public PaperAnswer() {
	}

	public PaperAnswer(java.lang.Integer id) {
		this.id = id;
	}

	// get and set
	public void setId(java.lang.Integer value) {
		this.id = value;
	}

	public java.lang.Integer getOptionId() {
		return optionId;
	}

	public void setOptionId(java.lang.Integer optionId) {
		this.optionId = optionId;
	}

	public java.lang.Integer getId() {
		return id;
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof PaperAnswer == false)
			return false;
		if (this == obj)
			return true;
		PaperAnswer other = (PaperAnswer) obj;
		return new EqualsBuilder().append(getId(), other.getId()).isEquals();
	}
}
