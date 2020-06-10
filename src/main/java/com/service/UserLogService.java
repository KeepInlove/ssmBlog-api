package com.service;

import com.entry.UserLog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

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
}
