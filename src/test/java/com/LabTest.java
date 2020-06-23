package com;

import com.entry.Blog;
import com.entry.LB;
import com.entry.Lab;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.service.BlogService;
import com.service.LabService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GUO
 * @Classname LabTest
 * @Description TODO
 * @Date 2020/6/14 22:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class LabTest {
    @Autowired
   private LabService labService;
    @Autowired
    private BlogService blogService;
    @Test
    public void insert(){
        Lab lab=new Lab();
        lab.setName("Redis");
        boolean b = labService.insertLab(lab);
        System.out.println(b);
    }
    @Test
    public void findAll(){
        List<Lab> labList = labService.findAll();
        System.out.println(labList);
    }
    @Test
    public void findLabAndBlog(){
        List<LB>lbs=new ArrayList<>();
        List<Lab> labList = labService.findAll();
        labList.forEach(lab -> {
            System.out.println(lab.getName());
            LB lb=new LB();
            List<Blog> list = blogService.selectBlogByLabName(lab.getName());
            System.out.println(list==null);
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
        System.out.println(lbs);
    }
}
