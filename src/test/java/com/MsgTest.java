package com;

import com.entry.Msg;
import com.service.MsgService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author GUO
 * @Classname MsgTest
 * @Description TODO
 * @Date 2020/6/22 13:07
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MsgTest {
    @Autowired
    private MsgService msgService;
    @Test
    public void addMsg(){
        Msg msg=new Msg();
        msg.setName("G");
        msg.setEmail("904004593@qq.com");
        msg.setContent("我来留言了");
        boolean b = msgService.addMsg(msg);
        System.out.println(b);
    }
    @Test
    public void findAll(){
        List<Msg> msgList = msgService.findAllMsg();
        msgList.forEach(msg -> System.out.println(msg));
    }
}
