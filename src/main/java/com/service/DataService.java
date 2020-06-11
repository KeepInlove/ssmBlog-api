package com.service;

import com.entry.Data;

/**
 * @author GUO
 * @Classname DataServier
 * @Description TODO
 * @Date 2020/6/11 9:39
 */
public interface DataService {
    Data findData();
    boolean update(Data data);
}
