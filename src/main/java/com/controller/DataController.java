package com.controller;

import com.entry.Data;
import com.service.DataService;
import com.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GUO
 * @Classname DataController
 * @Description TODO
 * @Date 2020/6/11 9:44
 */
@RestController
@RequestMapping("/api")
public class DataController {
    @Autowired
   private DataService dataService;
    @GetMapping("/findData")
   public ResponseMessage findData(){
        Map map=new HashMap();
        Data data = dataService.findData();
        map.put("data",data);
        return ResponseMessage.success().addObject("data",map);
    }
    @GetMapping("/updateData")
    public ResponseMessage updateData(Data data){
        boolean b = dataService.update(data);
        return b ? ResponseMessage.success().addObject("msg","操作成功"):ResponseMessage.error().addObject("msg","操失败");
    }
}
