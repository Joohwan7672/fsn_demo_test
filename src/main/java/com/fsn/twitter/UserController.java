package com.fsn.twitter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fsn.twitter.service.user.UserService;
import com.fsn.twitter.dao.user.UserVo;

@Controller(value="user")

public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
    
    // 회원가입 
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String userSignupForm() {
    	logger.info("display signup form");
    	
        return "user/signup";
    }
    
    @RequestMapping(value = "/signup_ok", method = RequestMethod.POST)
    public String userSignupSave(@ModelAttribute("userVo") UserVo userVo) {
    	logger.info("display signup complete");
    	userService.user_insert(userVo);
        
    	return "redirect:/login";
    }
    
 // 아이디중복체크 
    @RequestMapping(value = "/email_chk", method = RequestMethod.POST)
    public @ResponseBody String userEmailCheck(@ModelAttribute("userVo") UserVo userVo) {
    	logger.info("display signup form");
    	
    	String result = "N";
    	result = userService.user_id_check(userVo.getUser_id());

    	return result;
    }

}
