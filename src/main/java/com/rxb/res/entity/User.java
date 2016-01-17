package com.rxb.res.entity;

/**
 * 用户
 * @author ty468
 *
 * 2015年11月30日
 */
public class User {
	private String id;
	private String username;
	private String password;
	private String salt;
	private Boolean locked;

	public User() {
	}

	public User(String username, String password, String salt, Boolean locked) {
		super();
		this.username = username;
		this.password = password;
		this.salt = salt;
		this.locked = locked;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

}
