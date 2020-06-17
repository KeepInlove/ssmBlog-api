package com;

import com.entry.Admin;
import com.entry.Blog;
import com.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author GUO
 * @Classname AdminTest
 * @Description TODO
 * @Date 2020/6/9 20:48
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AdminTest {

    @Autowired
    private AdminService adminService;
    @Test
    public void login(){
        Admin user = adminService.findUser("admin", "admin");
        System.out.println(user);
    }
    @Test
    public void list(){
        List<Blog> list=new ArrayList<>();
        Blog blog1=new Blog();
        blog1.setMg_state(true);
        blog1.setId(1);
        System.out.println(blog1);
//        Blog blog2=new Blog();
//        blog2.setId(2);
//        list.add(blog1);
//        list.add(blog2);
//        System.out.println("前:"+list);
//        Collections.reverse(list);
//        System.out.println("后"+list);
    }
}
