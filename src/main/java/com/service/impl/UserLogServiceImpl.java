package com.service.impl;

import com.dao.UserLogDao;
import com.entry.UserLog;
import com.service.UserLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GUO
 * @Classname UserLogServiceImpl
 * @Description TODO
 * @Date 2020/6/10 22:22
 */
@Service
public class UserLogServiceImpl implements UserLogService {
    @Autowired
    private UserLogDao userLogDao;


    @Override
    public boolean insert(UserLog userLog) {
        return userLogDao.insert(userLog);
    }

    @Override
    public List<UserLog> findAll() {
        return userLogDao.findAll();
    }

    @Override
    public List<UserLog> findByUsername(String username) {
        return userLogDao.findByUsername(username);
    }

    @Override
    public List<UserLog> findByCity(String city) {
        return userLogDao.findByCity(city);
    }

    @Override
    public boolean delete(Integer id) {
        boolean b = userLogDao.delete(id);
        return b;
    }
}
