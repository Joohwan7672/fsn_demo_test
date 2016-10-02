package com.fsn.twitter.dao.user;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

import com.fsn.twitter.dao.user.UserMapper;
import com.fsn.twitter.dao.user.UserVo;
import com.fsn.twitter.common.*;


@Repository
public class UserDao {
	@Resource(name = "userMapper")
    private UserMapper userMapper;

    public List<UserVo> getSelect() {
        return this.userMapper.select();
    }

    public int user_insert(UserVo userVo) {
        return this.userMapper.user_insert(userVo);
    }
    public String get_user_dup_check(String user_id) {
        return this.userMapper.get_user_dup_check(user_id);
   }
}
