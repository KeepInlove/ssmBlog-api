package com.controller;

import com.entry.Data;
import com.service.DataService;
import com.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
        Data data = dataService.findData();
        return ResponseMessage.success().addObject("user",data);
    }
    @RequestMapping(value = "/updateData",method = RequestMethod.PUT,produces = {"application/json;charset=UTF-8"})
    public ResponseMessage updateData(@RequestBody Data data){
        boolean b = dataService.update(data);
        return b ? ResponseMessage.success().addObject("msg","操作成功"):ResponseMessage.error().addObject("msg","操失败");
    }
}
