package com.service;


import com.entry.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * @author GUO
 * @Classname adminService
 * @Description TODO
 * @Date 2020/6/9 20:26
 */
public interface AdminService {
    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    public Admin findUser(@Param("username") String username,
                          @Param("password") String password);
}
