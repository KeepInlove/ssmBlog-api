package com.controller;

import com.entry.Admin;
import com.entry.UserLog;
import com.service.AdminService;
import com.service.UserLogService;
import com.utils.IPUstils;
import com.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Autowired
    private UserLogService userLogService;
    @PostMapping(value="/login", produces = {"application/json;charset=UTF-8"})
    public ResponseMessage login(@RequestParam String username,
                                 @RequestParam String password,
                                 HttpSession session, HttpServletRequest request) {
        Admin user = adminService.findUser(username, password);
        // 记录登录用户
        Map map=new HashMap();
        if (user!=null) {
            session.setAttribute("loginUser", user);
            String token=new Date()+user.getUsername();
//            登录日志记录
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String time = df.format(new Date());
            UserLog userLog = new UserLog();
            userLog.setUsername(user.getUsername());
            String ipAddress = IPUstils.getIpAddress(request);
//            System.out.println(ipAddress);
            userLog.setIp(ipAddress);
            userLog.setTime(time);
            userLog.setCity("中国-南京");
            boolean b = userLogService.insert(userLog);
//        System.out.println("登录记录"+b);
            map.put("loginUser",user);
            map.put("token",token);
            return  ResponseMessage.success().addObject("_data",map);
        } else {
            map.put("msg","密码或账号错误！");
            return ResponseMessage.error().addObject("_data",map);
        }
    }
}
