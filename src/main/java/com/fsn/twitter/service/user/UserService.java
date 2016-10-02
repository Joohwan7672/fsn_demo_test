package com.fsn.twitter.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsn.twitter.common.CommonFunc;
import com.fsn.twitter.dao.user.UserDao;
import com.fsn.twitter.dao.user.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
    public List<UserVo> getSelect() {
        return userDao.getSelect();
    }

    public void user_insert(UserVo userVo) {
    	userVo.setUser_reg_date(CommonFunc.now_date());
    	userDao.user_insert(userVo);
    }

	public String user_id_check(String user_id) {
		String dup_chk = userDao.get_user_dup_check(user_id);
		
		if(dup_chk != null) {
			return "N";
		} else {
			return "Y";
		}
	}
}
