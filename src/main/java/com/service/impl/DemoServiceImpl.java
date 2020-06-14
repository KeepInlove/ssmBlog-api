package com.service.impl;

import com.dao.DemoDao;
import com.entry.Demo;
import com.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author GUO
 * @Classname DemoServiceImpl
 * @Description TODO
 * @Date 2020/6/14 18:32
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoDao demoDao;
    @Override
    public boolean addDemo(Demo demo) {
        return demoDao.addDemo(demo);
    }

    @Override
    public Demo select(Integer id) {
        return demoDao.select(id);
    }
}
