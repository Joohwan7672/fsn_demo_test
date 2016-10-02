package com.fsn.twitter.dao.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fsn.twitter.dao.user.UserVo;

@Repository(value = "userMapper")
public interface UserMapper {
	List<UserVo> select();
    int user_insert(UserVo userVo);
    String get_user_dup_check(String user_id);
}
