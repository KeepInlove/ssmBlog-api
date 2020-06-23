package com.controller;

import com.entry.Blog;
import com.entry.LB;
import com.entry.Lab;
import com.service.BlogService;
import com.service.LabService;
import com.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @Autowired
    private BlogService blogService;
    @GetMapping("/findLabs")
    public ResponseMessage findLabs(){
        List<Lab> labList = labService.findAll();
        return ResponseMessage.success().addObject("labList",labList);
    }
    @GetMapping("/findAllLab")
    public ResponseMessage findAllLabs(){
        List<LB>lbs=new ArrayList<>();
        List<Lab> labList = labService.findAll();
        labList.forEach(lab -> {
//            System.out.println(lab.getName());
            LB lb=new LB();
            lb.setStu(true);
            List<Blog> list = blogService.selectBlogByLabName(lab.getName());
//            System.out.println(list==null);
            if (list==null){
                lb.setName(lab.getName());
                lb.setCount(0);
                lbs.add(lb);
            }else {
                lb.setName(lab.getName());
                lb.setCount(list.size());
                lbs.add(lb);
            }
        });
        return ResponseMessage.success().addObject("labList",lbs);
    }
    @PostMapping(value = "/addLab",produces = {"application/json;charset=UTF-8"})
    public ResponseMessage addLab(@RequestBody Lab lab){
        boolean b = labService.insertLab(lab);
        return b ? ResponseMessage.success():ResponseMessage.error();
    }
    @RequestMapping(value = "/updateLab",method = RequestMethod.PUT,produces = {"application/json;charset=UTF-8"})
    public ResponseMessage updateLab(@RequestBody Lab lab){
        boolean b = labService.updateLab(lab);
        return b ? ResponseMessage.success():ResponseMessage.error();
    }
    @RequestMapping(value = "/deleteLab/{id}",method = RequestMethod.DELETE)
    public ResponseMessage deleteLab(@PathVariable Integer id){
        boolean b = labService.deleteLab(id);
        return b ? ResponseMessage.success() :ResponseMessage.error();
    }

}
