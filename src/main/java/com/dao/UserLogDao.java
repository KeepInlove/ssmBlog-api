package com.dao;

import com.entry.UserLog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author GUO
 * @Classname UserLogDao
 * @Description TODO
 * @Date 2020/6/10 22:11
 */
@Repository
public interface UserLogDao {
    @Insert("insert into userlog (username,time,ip,city)values(#{username},#{time},#{ip},#{city})")
    boolean insert(UserLog userLog);
    @Select("select * from userlog ")
    List<UserLog>findAll();
    @Select("select * from userlog where username=#{username} ")
    List<UserLog>findByUsername(String username);
    @Select("select * from userlog where city like '%${name}%'")
    List<UserLog>findByCity(String city);
    @Delete("delete from userlog where id=#{id}")
    boolean delete(Integer id);
}
