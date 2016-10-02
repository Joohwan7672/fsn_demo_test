package com.fsn.twitter.dao.auth;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fsn.twitter.dao.auth.AuthMapper;
import com.fsn.twitter.dao.auth.AuthVo;


@Service(value = "authDao")
public class AuthDao {
	@Resource(name = "authMapper")
    private AuthMapper authMapper;

    public AuthVo login_session(AuthVo authVo) {
    	return this.authMapper.login_session(authVo);
    }
}
