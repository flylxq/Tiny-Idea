package com.tinyIdea.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @RequestMapping("/index")
    public ModelAndView listAllBoard(HttpServletRequest request){
        System.out.println("Query for the index page.");
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("authorized", false);
        mv.addObject("username", "xiaoqing.liu");
        
        return mv;
    }
}
