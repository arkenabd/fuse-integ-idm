package com.json.netty.util;

public class FixLengthMessageIn {
	public String fieldName;
	public String indexStart;
	public String indexEnd;
	public String value;

	public FixLengthMessageIn() {
	}

	public FixLengthMessageIn(String fieldName, String indexStart, String indexEnd, String value) {
		this.fieldName = fieldName;
		this.indexStart = indexStart;
		this.indexEnd = indexEnd;
		this.value = value;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getIndexStart() {
		return indexStart;
	}

	public void setIndexStart(String indexStart) {
		this.indexStart = indexStart;
	}

	public String getIndexEnd() {
		return indexEnd;
	}

	public void setIndexEnd(String indexEnd) {
		this.indexEnd = indexEnd;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
