package com.levelup;

public class Person {
	
	private String id;
	private String ssn;
	private String name;

	public Person(String id, String ssn, String name) {
		super();
		this.id = id;
		this.ssn = ssn;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
