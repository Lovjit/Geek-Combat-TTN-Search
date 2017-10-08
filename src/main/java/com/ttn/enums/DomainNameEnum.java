package com.ttn.enums;

/**
 * The enum Domain name enum.
 */
public enum DomainNameEnum {

	COMPANY("COMPANY", "company"),

	PROJECT("PROJECT", "project"),

	TECHNOLOGY("TECHNOLOGY", "technology"),

	TECHNOLOGY_TYPE("TECHNOLOGYTYPE", ""),

	INDUSTRYTYPE("INDUSTRYTYPE", ""),

	COMPANYTYPE("COMPANYTYPE", ""),

	ENGAGEMENTTYPE("ENGAGEMENTTYPE", ""),

	DOCUMENT("DOCUMENT", "document");

	private String name;

	private String indexName;

	/**
	 * Instantiates a new Domain name enum.
	 *
	 * @param name
	 *            the name
	 * @param indexName
	 *            the index name
	 */
	DomainNameEnum(String name, String indexName) {
		this.name = name;
		this.indexName = indexName;
	}

	/**
	 * Gets name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets index name.
	 *
	 * @return the index name
	 */
	public String getIndexName() {
		return indexName;
	}

	/**
	 * Gets domain name.
	 *
	 * @param name
	 *            the name
	 * @return the domain name
	 */
	public static DomainNameEnum getDomainName(String name) {
		if (name != null) {
			for (DomainNameEnum domain : DomainNameEnum.values()) {
				if (name.equalsIgnoreCase(domain.name)) {
					return domain;
				}
			}
		}
		return null;
	}

	/**
	 * Gets domain index.
	 *
	 * @param name
	 *            the name
	 * @return the domain index
	 */
	public static DomainNameEnum getDomainIndex(String name) {
		if (name != null) {
			for (DomainNameEnum domain : DomainNameEnum.values()) {
				if (name.equalsIgnoreCase(domain.getIndexName())) {
					return domain;
				}
			}
		}
		return null;
	}
}
