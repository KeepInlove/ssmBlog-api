package com;

import com.entry.Lab;
import com.service.LabService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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
    @Test
    public void select(){
//        Lab lab = labService.selectLab();
//        System.out.println(lab);
    }
    @Test
    public void findAll(){
        List<Lab> labList = labService.findAll();
        System.out.println(labList);
    }
}
