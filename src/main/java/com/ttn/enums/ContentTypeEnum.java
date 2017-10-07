package com.ttn.enums;

import java.util.Objects;

public enum ContentTypeEnum {

	ACCOUNT("Account", "company"),

	PROJECT("Project", "project"),

	CONTENT("Content", "doc_content"),

	PERSON("Person", "person"),

	TECHNOLOGY("Technology", "technology");

	private String index;

	private String name;

	private ContentTypeEnum(String name, String index) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.index = index;
	}

	public static ContentTypeEnum getIndexEnum(String value) {
		if (Objects.nonNull(value) && !value.equals("")) {
			ContentTypeEnum[] arg0 = values();
			int arg1 = arg0.length;
			value = value.trim();

			for (int arg2 = 0; arg2 < arg1; ++arg2) {
				ContentTypeEnum index = arg0[arg2];
				if (value.equalsIgnoreCase(index.getName())) {
					return index;
				}
			}
		}

		return null;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
