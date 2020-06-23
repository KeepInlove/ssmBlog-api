package com.controller;


import com.entry.UserLog;
import com.github.pagehelper.PageInfo;
import com.service.UserLogService;
import com.utils.ResponseMessage;
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
    @GetMapping("/findAllLogPage")
    public ResponseMessage findAllUserLog(@RequestParam(value = "pageNum" , defaultValue = "1")int pageNum,
                                          @RequestParam("pageSize")int pageSize){
        PageInfo<UserLog> pageInfo = userLogService.findAllLogByPage(pageNum, pageSize);
        return ResponseMessage.success().addObject("pageInfo",pageInfo);
    }
    @GetMapping("/findByUsername/{username}")
    public ResponseMessage findByUsername(@PathVariable String username){
        List<UserLog> userLogs= userLogService.findByUsername(username);
        Map maps=new HashMap();
        maps.put("msg","查询成功");
        maps.put("userLogs",userLogs);
        return ResponseMessage.success().addObject("logList",userLogs);
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
    @RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
    public ResponseMessage deleteUserLogById(@PathVariable Integer id){
        boolean b = userLogService.delete(id);
        return b ?ResponseMessage.success().addObject("msg","删除成功"):ResponseMessage.error().addObject("msg","操作失败");
    }
}
