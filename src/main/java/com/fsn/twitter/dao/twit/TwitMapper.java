package com.fsn.twitter.dao.twit;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.fsn.twitter.dao.auth.AuthVo;
import com.fsn.twitter.dao.user.UserVo;

@Repository(value = "twitMapper")
public interface TwitMapper {
    List<TwitVo> select(AuthVo vo);
    TwitVo selectFriendChk(AuthVo vo);
    List<TwitVo> getUserSelect(AuthVo vo);
    void follow_ok(UserVo vo);
    void twit_insert(TwitVo twitVo);
    void twit_delete(int twit_idx);
    
}