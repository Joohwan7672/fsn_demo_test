package com.fsn.twitter;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fsn.twitter.dao.twit.TwitVo;
import com.fsn.twitter.dao.user.UserVo;
import com.fsn.twitter.service.twit.TwitService;

@Controller(value="twit")

public class TwitController {
	
	private static final Logger logger = LoggerFactory.getLogger(TwitController.class);
	
	@Autowired
    private TwitService twitService;

    // 게시판 목록 
    @RequestMapping(value = "/twit_list", method = RequestMethod.GET)
    public String twitMainList(Model model) {
        logger.info("display view twit list");
        List<TwitVo> twit_list = twitService.getSelect();
        List<TwitVo> user_list = twitService.getUserSelect();
        model.addAttribute("twit_list", twit_list);
        model.addAttribute("user_list", user_list);

        return "twit/list";
    }
    
 // 팔로우하기 
    @RequestMapping(value = "/follow_ok", method = RequestMethod.POST)
    public @ResponseBody String userFollowSet(@ModelAttribute("userVo") UserVo userVo) {
    	logger.info("display follow ajax");
    	
    	twitService.follow_ok(userVo);
    	
        return "Y";
    }

    @RequestMapping(value = "/twit_save", method = RequestMethod.POST)
    public @ResponseBody String twitSave(@ModelAttribute("twitVo") TwitVo twitVo, RedirectAttributes redirectAttributes) {
		logger.info("display twit_save ajax");
    	
        this.twitService.twit_insert(twitVo);
        
        return "Y";
    }

    @RequestMapping(value = "/twit_delete", method = RequestMethod.POST)
    public @ResponseBody String twitDelete(@RequestParam(value = "twit_idx", required = false) int twit_idx) {
    	logger.info("display twit_delete ajax");
    	
        this.twitService.twit_delete(twit_idx);
        
        return "Y";
    }

}
