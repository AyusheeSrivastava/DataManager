package com.Bean;

public class UserData {
	private String key;
	private String value;
	private String userId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public UserData(String key, String value,String userId) {
		super();
		this.key = key;
		this.value= value;
		this.userId=userId;
	}
	public UserData() {
		super();
	}

}
