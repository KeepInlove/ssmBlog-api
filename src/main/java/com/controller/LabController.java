package com.controller;

import com.entry.Lab;
import com.service.LabService;
import com.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author GUO
 * @Classname LabController
 * @Description TODO
 * @Date 2020/6/14 22:46
 */
@RestController
@RequestMapping("/api")
public class LabController {
    @Autowired
   private LabService labService;

    @GetMapping("/findLabs")
    public ResponseMessage findLabs(){
        List<Lab> labList = labService.findAll();
        return ResponseMessage.success().addObject("labList",labList);
    }
}
