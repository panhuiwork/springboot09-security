package com.geral.springboot09.security.service.entity;


public class User {
	private Integer id;
	private String username;
	private String userpass;
	private String qx;
	public User() {}
	public User(Integer id, String username, String userpass, String qx) {
		this.id = id;
		this.username = username;
		this.userpass = userpass;
		this.qx = qx;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public String getQx() {
		return qx;
	}
	public void setQx(String qx) {
		this.qx = qx;
	}
	
}
