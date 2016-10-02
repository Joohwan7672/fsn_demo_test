package com.fsn.twitter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fsn.twitter.dao.auth.AuthVo;
import com.fsn.twitter.service.auth.AuthService;

@Controller(value="auth")

public class AuthController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private AuthService authService;
	
	// 로그인  
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String userLoginForm() {
    	logger.info("display login form");
        return "user/login";
    }
    
 // 로그인 체크 
    @RequestMapping(value = "/login_chk", method = RequestMethod.POST)
    public String userLoginCheck(@ModelAttribute("authVo") AuthVo authVo, HttpSession session, HttpServletRequest request) {
    	logger.info("display login check");
    	AuthVo session_chk = authService.login_session(authVo);
    	if (session_chk != null) {
             session.setAttribute("tw_session", session_chk);
             return "redirect:/twit_list";
        }else{
        	 return "redirect:/login";
        }
    }
    
    //로그아웃
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
    	logger.info("display logout complete");
    	session.invalidate();
        return "redirect:/login";
    }
    
}
