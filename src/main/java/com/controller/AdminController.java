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
import java.sql.Timestamp;
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
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time = df.format(new Date());
        UserLog userLog = new UserLog();
        userLog.setUsername(user.getUsername());
        userLog.setIp(IPUstils.getIpAddress(request));
        userLog.setTime(time);
        userLog.setCity("中国-南京");
//        boolean b = userLogService.insert(userLog);
//        System.out.println("登录记录"+b);

        map.put("loginUser",user);
        return  ResponseMessage.success().addObject("_data",map);
    }
}
