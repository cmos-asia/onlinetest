package org.base.online.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class PaperOptions {
	/**
	 * 试题id
	 */
	private java.lang.Integer id;

	/**
	 * 名称
	 */
	private java.lang.String option;

	// concstructor

	public PaperOptions() {
	}

	public PaperOptions(java.lang.Integer id) {
		this.id = id;
	}

	// get and set
	public void setId(java.lang.Integer value) {
		this.id = value;
	}

	public java.lang.String getOption() {
		return option;
	}

	public void setOption(java.lang.String option) {
		this.option = option;
	}

	public java.lang.Integer getId() {
		return id;
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getId()).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof PaperOptions == false)
			return false;
		if (this == obj)
			return true;
		PaperOptions other = (PaperOptions) obj;
		return new EqualsBuilder().append(getId(), other.getId()).isEquals();
	}
}
