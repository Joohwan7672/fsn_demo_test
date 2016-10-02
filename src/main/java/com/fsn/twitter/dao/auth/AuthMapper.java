package com.fsn.twitter.dao.auth;

import org.springframework.stereotype.Repository;

import com.fsn.twitter.dao.auth.AuthVo;

@Repository(value = "authMapper")
public interface AuthMapper {
	AuthVo login_session(AuthVo authVo);
}
