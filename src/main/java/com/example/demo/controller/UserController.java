package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class UserController {
    @Autowired(required=true)
    private UserService userService;
    @RequestMapping("/index")
    public ModelAndView ToIndex(Model model)
    {

        List<User> userList = userService.getUserList();
        System.out.println("123123");
        model.addAttribute("list",userList);
        ModelAndView mv=new ModelAndView("index");
        return mv;
    }

    @RequestMapping("/toAdd")
    public ModelAndView toAdd(Model model)
    {
        ModelAndView mv=new ModelAndView("add");
        //add省略jsp后缀
        System.out.println("跳转add页面");
        return mv;
    }

    @RequestMapping("/addUser")
    public void addUser(HttpServletResponse response, User user)
    {
        //JSONObject data=new JSONObject();
        int i = userService.addUser(user);
        System.out.println(i);
        if (i>0){
            JsonUtil.ajaxOutPutJson(response,true);
        }else{
            JsonUtil.ajaxOutPutJson(response,false);
        }
    }
}
