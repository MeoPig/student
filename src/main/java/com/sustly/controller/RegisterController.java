package com.sustly.controller;

import com.sustly.bean.TeacherInfo;
import com.sustly.service.TeacherService;
import com.sustly.utils.md5.Md5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RegisterController {

    @Resource(name = "teacherService")
    private TeacherService service;
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@RequestParam("id") String id,
                           @RequestParam("password") String password,
                           @RequestParam("rpassword") String rpassword){
        if (password.equals(rpassword)){
            TeacherInfo info = new TeacherInfo();
            info.setId(id);
            String md5Password = Md5Util.MD5Encode(password);
            info.setPassword(md5Password);
            service.save(info);
            //这里是home/login才行,redirect是重定向到Controller
            return "redirect:/home/login";
        }else {
            return "redirect:/register";
        }
    }

    @RequestMapping(value = "/checkId", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> checkId(@RequestBody TeacherInfo param){
        String passWord = service.findPassowrdByid(param.getId());
        Map<String, Object> map = new HashMap<String, Object>();
        if (passWord == null){
            map.put("isSuccess",true);
            map.put("Msg","用户名可以使用！");
        }else {
            map.put("isSuccess",false);
            map.put("Msg","用户名已被注册！");
        }

        return map;
    }
    @RequestMapping(value = "registerUser")
    public String registerUser(){
        return "/register";
    }

}
