package com.service.impl;
import com.dao.AdminDao;
import com.entry.Admin;
import com.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author GUO
 * @Classname AdminServiceImpl
 * @Description TODO
 * @Date 2020/6/9 20:27
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Override
    public Admin findUser(String username, String password) {
        return adminDao.findUser(username,password);
    }
}
