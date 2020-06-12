package com.controller;


import com.entry.UserLog;
import com.service.UserLogService;
import com.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
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
    public ResponseMessage findByUsername(@PathVariable String username, HttpSession session,
                                          HttpServletResponse response){
        List<UserLog> userLogs= userLogService.findByUsername(username);
        Map maps=new HashMap();
        maps.put("msg","查询成功");
        maps.put("userLogs",userLogs);

//        if (!b){
//            return  ResponseMessage.error().addObject("msg","操作错误");
//        }
        System.out.println(userLogs);
        return ResponseMessage.success().addObject("_data",userLogs);
    }
    @GetMapping("/findByCity/{city}")
    public ResponseMessage findByCity(@PathVariable String city,HttpSession session){
        List<UserLog> userLogCity = userLogService.findByCity(city);
        System.out.println(userLogCity);
        Map maps=new HashMap();
        maps.put("msg","查询成功");
        maps.put("userLogCity",userLogCity);
        return ResponseMessage.success().addObject("_data",maps);
    }
//    JSESSIONID=AAB198AAB0063F941DDB3104093E1F7D
//    JSESSIONID=FD00271B19773691FB65F2C552A9C220
    //删除功能
        @GetMapping("/delete/{id}")
        public ResponseMessage deleteUserLogById(@PathVariable Integer id){
            boolean b = userLogService.delete(id);
            return b ?ResponseMessage.success().addObject("msg","删除成功"):ResponseMessage.error().addObject("msg","操作失败");
        }
}
