package com;

import com.entry.Data;
import com.service.DataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author GUO
 * @Classname DataTest
 * @Description TODO
 * @Date 2020/6/11 9:47
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DataTest {
    @Autowired
    DataService dataService;
    @Test
    public void findData(){
        Data data = dataService.findData();
        System.out.println(data);
    }
    @Test
    public void update(){
        Data data = dataService.findData();
        data.setQq("123456789");
        dataService.update(data);
    }
}
