package com.fsn.twitter.dao.twit;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fsn.twitter.dao.auth.AuthVo;
import com.fsn.twitter.dao.user.UserVo;

@Repository
public class TwitDao {
    @Resource(name = "twitMapper")
    private TwitMapper twitMapper;

    public List<TwitVo> getSelect(AuthVo vo) {
        return this.twitMapper.select(vo);
    }
    
    public TwitVo getFriendChk(AuthVo vo) {
    	return this.twitMapper.selectFriendChk(vo);
    }
    
    public List<TwitVo> getUserSelect(AuthVo vo) {
		return this.twitMapper.getUserSelect(vo);
	}
    
    public void follow_ok(UserVo vo) {
    	this.twitMapper.follow_ok(vo);
	}

    public void twit_delete(int twit_idx) {
        this.twitMapper.twit_delete(twit_idx);
    }
    
    public void twit_insert(TwitVo twitVo) {
        this.twitMapper.twit_insert(twitVo);
    }

}