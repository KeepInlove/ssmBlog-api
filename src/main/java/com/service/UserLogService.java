package com.service;
import com.entry.UserLog;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author GUO
 * @Classname UserLogService
 * @Description TODO
 * @Date 2020/6/10 22:19
 */
public interface UserLogService {
    boolean insert(UserLog userLog);
    List<UserLog> findAll();
    List<UserLog>findByUsername(String username);
    List<UserLog>findByCity(String city);
    boolean delete(Integer id);
    PageInfo<UserLog> findAllLogByPage(int pageNum, int pageSize);
}
