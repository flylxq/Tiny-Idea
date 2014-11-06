package com.tinyIdea.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tinyIdea.DAO.UserDAO;
import com.tinyIdea.util.UserInfo;

@Controller
@RequestMapping("/login")
public class LoginController {
    
    @Autowired
    private UserDAO userDAO = null;
    
    @RequestMapping(params = "method=login")
    public ModelAndView login(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("login/login");
        
        mv.addObject("authorized", false);
        mv.addObject("username", "xiaoqing.liu");
        
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("xiaoqing.liu");
        userInfo.setPassword("fly5201314");
        
        userDAO.insert(userInfo);
        return mv;
        
    }
    
    @RequestMapping(params = "method=sign")
    public ModelAndView sign(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("login/signin");
        return mv;
    }
}
