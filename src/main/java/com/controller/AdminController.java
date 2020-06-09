package com.controller;

import com.entry.Admin;
import com.service.AdminService;
import com.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author GUO
 * @Classname AdminController
 * @Description TODO
 * @Date 2020/6/9 21:08
 */
@RestController
@RequestMapping("/api")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping(value="/login", produces = {"application/json;charset=UTF-8"})
    @ResponseBody // 序列化--> 类型转换--> jackson --> json
    public ResponseMessage login(@RequestParam String username,
                                 @RequestParam String password,
                                 HttpSession session) {
        Admin user = adminService.findUser(username, password);
        // 记录登录用户
        session.setAttribute("loginUser", user);
        return user!=null? ResponseMessage.success().addObject("msg","登陆成功"+user):ResponseMessage.error();
    }
}
