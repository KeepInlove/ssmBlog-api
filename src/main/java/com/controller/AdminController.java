package com.controller;

import com.entry.Admin;
import com.service.AdminService;
import com.utils.IPUstils;
import com.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

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
//    @ResponseBody // 序列化--> 类型转换--> jackson --> json
    public ResponseMessage login(@RequestParam String username,
                                 @RequestParam String password,
                                 HttpSession session, HttpServletRequest request) {
        Admin user = adminService.findUser(username, password);
        // 记录登录用户
        session.setAttribute("loginUser", user);
        Map map=new HashMap() ;
        if (user==null){
            map.put("msg","用户名或密码错误");
            return ResponseMessage.error().addObject("_data",map);
        }
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String ipAddress = IPUstils.getIpAddress(request);
        map.put("date",timestamp);
        map.put("ip",ipAddress);
        map.put("loginUser",user);
        System.out.println(ipAddress);
        System.out.println(timestamp);
        System.out.println(user);
        System.out.println("----");
        return  ResponseMessage.success().addObject("_data",map);
    }


}
