package com;

import com.entry.UserLog;
import com.service.UserLogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.sql.Timestamp;
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
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        UserLog userLog=new UserLog();
        userLog.setUsername("admin");
        userLog.setTime(timestamp);
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
}
