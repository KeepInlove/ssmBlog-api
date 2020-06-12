package com;

import com.entry.UserLog;
import com.service.UserLogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author GUO
 * @Classname UserLogTest
 * @Description TODO
 * @Date 2020/6/10 22:53
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserLogTest {
    @Autowired
   private UserLogService userLogService;
    @Test
    public void insertUserLog(){
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String s = df.format(new Date());
        UserLog userLog=new UserLog();
        userLog.setUsername("admin");
        userLog.setTime(s);
        userLog.setIp("127.0.0.1");
        userLog.setCity("中国-南京");
        boolean b = userLogService.insert(userLog);
        System.out.println(b);
    }
    @Test
    public void findAllUserLog(){
        List<UserLog> userLogList = userLogService.findAll();
        System.out.println(userLogList);
    }
    @Test
    public void DataTest(){
        Date date=new Date(System.currentTimeMillis());
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String s = df.format(new Date());
        System.out.println(s);
        System.out.println("----");
        System.out.println(date);
    }
    @Test
    public void findByUsername(){
        List<UserLog> userLogList= userLogService.findByUsername("admin");
        int size = userLogList.size();
        System.out.println(userLogList);
        System.out.println(size);
    }
    @Test
    public void findByCity(){
        List<UserLog> cityList = userLogService.findByCity("南京");
        int size = cityList.size();
        System.out.println(size);
        System.out.println(cityList);
    }

}
