package com.fsn.twitter.dao.twit;

public class TwitVo {
    private int twit_idx;
    private int twit_wr_user_idx;
    private String twit_content;
    private String twit_wr_date;
    private String twit_del_flag;
    private String user_name;
    private String user_idx;
    private String user_id;
    private String friend_user_idxs;
    
	public int getTwit_idx() {
		return twit_idx;
	}
	public void setTwit_idx(int twit_idx) {
		this.twit_idx = twit_idx;
	}
	public int getTwit_wr_user_idx() {
		return twit_wr_user_idx;
	}
	public void setTwit_wr_user_idx(int twit_wr_user_idx) {
		this.twit_wr_user_idx = twit_wr_user_idx;
	}
	public String getTwit_content() {
		return twit_content;
	}
	public void setTwit_content(String twit_content) {
		this.twit_content = twit_content;
	}
	public String getTwit_wr_date() {
		return twit_wr_date;
	}
	public void setTwit_wr_date(String twit_wr_date) {
		this.twit_wr_date = twit_wr_date;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getFriend_user_idxs() {
		return friend_user_idxs;
	}
	public void setFriend_user_idxs(String friend_user_idxs) {
		this.friend_user_idxs = friend_user_idxs;
	}
	public String getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(String user_idx) {
		this.user_idx = user_idx;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getTwit_del_flag() {
		return twit_del_flag;
	}
	public void setTwit_del_flag(String twit_del_flag) {
		this.twit_del_flag = twit_del_flag;
	}
	
	@Override
	public String toString() {
		return "TwitVo [twit_idx=" + twit_idx + ", twit_wr_user_idx=" + twit_wr_user_idx + ", twit_content="
				+ twit_content + ", twit_wr_date=" + twit_wr_date + ", user_name=" + user_name + ", user_idx="
				+ user_idx + ", user_id=" + user_id + ", friend_user_idxs=" + friend_user_idxs + "]";
	}
	
	
}
