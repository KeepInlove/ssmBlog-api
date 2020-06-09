package com;

import com.entry.Admin;
import com.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}
