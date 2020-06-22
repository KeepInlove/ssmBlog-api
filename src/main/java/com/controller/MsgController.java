package com.controller;

import com.entry.Blog;
import com.entry.Msg;
import com.github.pagehelper.PageInfo;
import com.service.MsgService;
import com.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author GUO
 * @Classname MsgController
 * @Description TODO
 * @Date 2020/6/22 13:21
 */
@RestController
@RequestMapping("/api")
public class MsgController {
    @Autowired
    private MsgService msgService;
    @PostMapping(value = "/addMsg",produces = {"application/json;charset=UTF-8"})
    public ResponseMessage addMsg(@RequestBody Msg msg){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time = df.format(new Date());
        msg.setTime(time);
        boolean b = msgService.addMsg(msg);
        return b ? ResponseMessage.success().addObject("tip","留言成功") : ResponseMessage.error().addObject("tip","留言失败");
    }
    @RequestMapping(value = "/findAllMsgByPage")
    public ResponseMessage findAllMsgByPage(@RequestParam(value = "pageNum" , defaultValue = "1")int pageNum,
                                             @RequestParam("pageSize")int pageSize){

        PageInfo<Msg> pageInfo=msgService.findAllMsgByPage(pageNum,pageSize);
        return ResponseMessage.success().addObject("msgList",pageInfo);
    }
    @RequestMapping(value = "/deleteMsg/{id}",method = RequestMethod.DELETE)
    public ResponseMessage deleteMsg(@PathVariable Integer id){
        boolean b = msgService.deleteMsg(id);
        return b? ResponseMessage.success():ResponseMessage.error();
    }
}
