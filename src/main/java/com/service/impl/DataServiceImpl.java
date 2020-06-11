package com.service.impl;

import com.dao.DataDao;
import com.entry.Data;
import com.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author GUO
 * @Classname DataServiceImpl
 * @Description TODO
 * @Date 2020/6/11 9:41
 */
@Service
public class DataServiceImpl implements DataService {
    @Autowired
    private DataDao dataDao;
    @Override
    public Data findData() {
        return  dataDao.findData();
    }
    @Override
    public boolean update(Data data) {
        return dataDao.update(data);
    }
}
