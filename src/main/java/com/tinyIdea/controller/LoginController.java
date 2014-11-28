package com.tinyIdea.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tinyIdea.DAO.UserDAO;
import com.tinyIdea.util.AjaxReturn;
import com.tinyIdea.util.UserInfo;

@Controller
@RequestMapping("/login")
public class LoginController {
    private Logger log = Logger.getLogger(this.getClass());
    
    @Autowired
    private UserDAO userDAO = null;
    
    @RequestMapping(params = "method=login")
    public ModelAndView login(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("login/login");
        String pics = "dota2_1.jpg,dota2_2.jpg,dota2_3.jpg,dota2_4.jpg,diablo3_1.jpg,diablo3_2.jpg,diablo3_3.jpg,halo4_1.jpg,halo4_2.jpg,starcraft2_1.jpg,starcraft2_2.jpg,starcraft2_3.jpg";
        mv.addObject("pics", pics);
        mv.addObject("pic_l", pics.split(",").length);
        return mv;
    }
    
    @RequestMapping(params = "method=sign")
    public ModelAndView sign(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("login/signin");
        return mv;
    }
    
    @RequestMapping(params = "action=login", method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String r = request.getParameter("remember");
        
        boolean remember = false;
        if(r != null && r.equals("true")){
            remember = true;
        }
        
        AjaxReturn result;
        if(null == username || null == password){
            result = new AjaxReturn("ERROR", "The username or password is null", null);
            response.getWriter().write(JSONObject.fromObject(result).toString());
            return;
        }
        
        try{
            UserInfo userInfo = new UserInfo();
            userInfo.setUsername(username);
            UserInfo user = userDAO.getUserId(userInfo);
            if(null == user){
                result = new AjaxReturn("ERROR", "The username does not already exist!", null);
                response.getWriter().write(JSONObject.fromObject(result).toString());
                return;
            }
            
            userInfo.setPassword(password);
            user = userDAO.getUserId(userInfo);
            if(null == user){
                result = new AjaxReturn("ERROR", "The username or password is not correct!", null);
                response.getWriter().write(JSONObject.fromObject(result).toString());
                return;
            }
            
            result = new AjaxReturn(user);
            response.getWriter().write(JSONObject.fromObject(result).toString());
            
            setSession(user, request);
            if(remember){
                addCookie(user, response, remember);
            }
        } catch(Exception e){
            log.error(e.getMessage(), e);
            e.printStackTrace();
            result = new AjaxReturn("ERROR", "The login process has an exception.", null);
            response.getWriter().write(JSONObject.fromObject(result).toString());
        }
    }
    
    @RequestMapping(params = "action=sign", method = RequestMethod.POST)
    public void signIn(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AjaxReturn result;
        if(null == username || null == password){
            result = new AjaxReturn("ERROR", "The username or password is null", null);
            response.getWriter().write(JSONObject.fromObject(result).toString());
            return;
        }
        
        try{
            UserInfo userInfo = new UserInfo();
            userInfo.setUsername(username);
            UserInfo user = userDAO.getUserId(userInfo);
            if(null != user){
                result = new AjaxReturn("ERROR", "The username is already existing.", null);
                response.getWriter().write(JSONObject.fromObject(result).toString());
                return;
            }
            
            userInfo.setPassword(password);
            long userId = userDAO.insert(userInfo);
            userInfo.setId(userId);
            
            result = new AjaxReturn(userInfo);
            response.getWriter().write(JSONObject.fromObject(result).toString());
            
            setSession(userInfo, request);
        } catch(Exception e){
            log.error(e.getMessage(), e);
            e.printStackTrace();
            result = new AjaxReturn("ERROR", "The sign process has an exception.", null);
            response.getWriter().write(JSONObject.fromObject(result).toString());
        }
    }
    
    private void setSession(UserInfo user, HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("userId", user.getId());
        session.setAttribute("username", user.getUsername());
    }
    
    private void addCookie(UserInfo user, HttpServletResponse response, boolean remember){
        Cookie userIdCookie = new Cookie("userId", String.valueOf(user.getId()));
        userIdCookie.setMaxAge(30 * 24 * 60 * 60);
        response.addCookie(userIdCookie);
        
        Cookie usernameCookie = new Cookie("username", user.getUsername());
        usernameCookie.setMaxAge(30 * 24 * 60 * 60);
        response.addCookie(usernameCookie);
    }
}
