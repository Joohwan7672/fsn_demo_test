package com.fsn.twitter.dao.user;

public class UserVo {
	private int user_idx;
	private String user_name;
    private String user_id;
    private String user_password;
    private String user_reg_date;
    private String target_user_idx;
    
	public int getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
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
	public String getUser_reg_date() {
		return user_reg_date;
	}
	public void setUser_reg_date(String user_reg_date) {
		this.user_reg_date = user_reg_date;
	}
	public String getTarget_user_idx() {
		return target_user_idx;
	}
	public void setTarget_user_idx(String target_user_idx) {
		this.target_user_idx = target_user_idx;
	}
	@Override
	public String toString() {
		return "UserVo [user_idx=" + user_idx + ", user_name=" + user_name + ", user_id=" + user_id + ", user_password="
				+ user_password + ", user_reg_date=" + user_reg_date + "]";
	}
}
