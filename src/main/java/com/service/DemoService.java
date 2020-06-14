package com.service;

import com.entry.Demo;

/**
 * @author GUO
 * @Classname DemoService
 * @Description TODO
 * @Date 2020/6/14 18:32
 */
public interface DemoService {
    boolean addDemo(Demo demo);
    Demo select(Integer id);
}
