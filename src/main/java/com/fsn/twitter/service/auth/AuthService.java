package com.fsn.twitter.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fsn.twitter.dao.auth.AuthDao;
import com.fsn.twitter.dao.auth.AuthVo;

@Service
public class AuthService {
	
	@Autowired
	private AuthDao authDao;
	
    public AuthVo login_session(AuthVo authVo) {
    	return authDao.login_session(authVo);
    }

}
