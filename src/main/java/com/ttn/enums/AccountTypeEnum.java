package com.ttn.enums;

public enum AccountTypeEnum {

	ENTERPRISE("Enterprise"),
	PRODUCT("Product");

	private AccountTypeEnum(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
