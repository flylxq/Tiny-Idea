package com.tinyIdea.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/intro.html")
public class IntroController {
    @RequestMapping()
    public ModelAndView getPage(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new ModelAndView("login/intro");
        HttpSession session = request.getSession();
        Enumeration<String> sessions = session.getAttributeNames();
        while(sessions.hasMoreElements()){
            String key = sessions.nextElement();
            System.out.println(key + ":" + session.getAttribute(key));
        }
        return mv;
    }
}
