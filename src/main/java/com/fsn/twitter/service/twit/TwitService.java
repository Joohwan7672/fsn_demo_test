package com.fsn.twitter.service.twit;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsn.twitter.common.CommonFunc;
import com.fsn.twitter.dao.auth.AuthVo;
import com.fsn.twitter.dao.twit.TwitDao;
import com.fsn.twitter.dao.twit.TwitVo;
import com.fsn.twitter.dao.user.UserVo;

@Service
public class TwitService {
	
	@Autowired
	private TwitDao twitDao;
	@Autowired
	private HttpSession session;
	
    public List<TwitVo> getSelect() {
    	AuthVo authVo = (AuthVo)session.getAttribute("tw_session");
    	String friend_list = "";
    	TwitVo friendChk = twitDao.getFriendChk(authVo);
    	
    	if(friendChk != null) {
    		friend_list = authVo.getUser_idx() + "," + friendChk.getFriend_user_idxs().replace("|", ",");
    	} else {
    		friend_list = String.valueOf(authVo.getUser_idx());
    	}
    	authVo.setUser_idxs(friend_list);
    	
        return twitDao.getSelect(authVo);
    }
    
    public List<TwitVo> getUserSelect() {
    	AuthVo authVo = (AuthVo)session.getAttribute("tw_session");
    	String friend_list = "";
    	TwitVo friendChk = twitDao.getFriendChk(authVo);
    	
    	if(friendChk != null) {
    		friend_list = authVo.getUser_idx() + "," + friendChk.getFriend_user_idxs().replace("|", ",");
    	} else {
    		friend_list = String.valueOf(authVo.getUser_idx());
    	}
    	authVo.setUser_idxs(friend_list);
        return twitDao.getUserSelect(authVo);
		// TODO Auto-generated method stub
	}
    
    public String follow_ok(UserVo userVo) {
    	AuthVo authVo = (AuthVo)session.getAttribute("tw_session");
    	String target_user_idx = userVo.getTarget_user_idx();
    	String friend_list = "";
    	TwitVo friendChk = twitDao.getFriendChk(authVo);
    	
    	if(friendChk != null) {
    		friend_list = friendChk.getFriend_user_idxs() + " | " + target_user_idx;
    	} else {
    		friend_list = target_user_idx;
    	}
    	userVo.setUser_idx(authVo.getUser_idx());
    	userVo.setTarget_user_idx(friend_list);
		twitDao.follow_ok(userVo);
		
		return "Y";
	}
    
    public void twit_insert(TwitVo twitVo) {
    	twitVo.setTwit_wr_date(CommonFunc.now_date());
    	twitDao.twit_insert(twitVo);
    }
    
    public void twit_delete(int twit_idx) {
    	twitDao.twit_delete(twit_idx);
    }

}
