package com.controller;

import com.entry.UserLog;
import com.service.UserLogService;
import com.sun.javafx.collections.MappingChange;
import com.utils.ResponseMessage;
import com.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GUO
 * @Classname UserLogController
 * @Description TODO
 * @Date 2020/6/10 22:24
 */
@RestController
@RequestMapping("/api")
public class UserLogController {
    @Autowired
    private UserLogService userLogService;
    @GetMapping("/findAllUserLog")
    public ResponseMessage findAllUserLog(){
        Map map=new HashMap();
        List<UserLog> userLogList = userLogService.findAll();
        if (userLogList==null){
            map.put("msg","小二正在维护路上");
            return ResponseMessage.error().addObject("_data",map);
        }
        return ResponseMessage.success().addObject("userLogList",userLogList);
    }
    @GetMapping("/findByUsername/{username}")
    public ResponseMessage findByUsername(@PathVariable String username,HttpSession session){
        List<UserLog> userLogs = userLogService.findByUsername(username);
        System.out.println(userLogs);
        Map maps=new HashMap();
        maps.put("msg","查询成功");
        maps.put("userLogs",userLogs);
        boolean b = SessionUtils.getsSession(session);
        if (!b){
            return  ResponseMessage.error().addObject("msg","操作错误");
        }
        return ResponseMessage.success().addObject("_data",maps);
    }
    @GetMapping("/findByUsername/{city}")
    public ResponseMessage findByCity(@PathVariable String city,HttpSession session){
        List<UserLog> userLogs = userLogService.findByCity(city);
        System.out.println(userLogs);
        Map maps=new HashMap();
        maps.put("msg","查询成功");
        maps.put("userLogs",userLogs);
        boolean b = SessionUtils.getsSession(session);
        if (!b){
            return  ResponseMessage.error().addObject("msg","操作错误");
        }
        return ResponseMessage.success().addObject("_data",maps);
    }
}
