package com.tinyIdea.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {
    
    @RequestMapping(params = "method=login")
    public ModelAndView login(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("login/login");
        
        mv.addObject("authorized", true);
        mv.addObject("username", "xiaoqing.liu");
        return mv;
        
    }
    
    @RequestMapping(params = "method=sign")
    public ModelAndView sign(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("login/signin");
        return mv;
    }
}
