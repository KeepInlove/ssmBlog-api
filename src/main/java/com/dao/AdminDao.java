package com.dao;

import com.entry.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author GUO
 * @Classname admin
 * @Description TODO
 * @Date 2020/6/9 11:22
 */
@Repository
public interface AdminDao {
    /**
     * 通过账户和密码查询用户
     * @param username
     * @param password
     * @return
     */
    @Select("select * from sys_user where username=#{username} and password=#{password}")
    public Admin findUser(@Param("username") String username,
                          @Param("password") String password);
}
