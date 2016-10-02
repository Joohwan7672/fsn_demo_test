package com.fsn.twitter.dao.auth;

public class AuthVo {
	private int user_idx;
	private String user_name;
    private String user_id;
    private String user_password;
    private String user_reg_date;
    
    private String user_idxs;

	public int getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_reg_date() {
		return user_reg_date;
	}
	public void setUser_reg_date(String user_reg_date) {
		this.user_reg_date = user_reg_date;
	}
	public String getUser_idxs() {
		return user_idxs;
	}
	public void setUser_idxs(String user_idxs) {
		this.user_idxs = user_idxs;
	}
	@Override
	public String toString() {
		return "AuthVo [user_idx=" + user_idx + ", user_name=" + user_name + ", user_id=" + user_id + ", user_password="
				+ user_password + ", user_reg_date=" + user_reg_date + "]";
	}
}
