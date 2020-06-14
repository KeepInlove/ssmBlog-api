package com.dao;

import com.entry.Demo;
import com.entry.UserLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author GUO
 * @Classname DemoDao
 * @Description TODO
 * @Date 2020/6/14 18:29
 */
@Repository
public interface DemoDao {
    @Insert("insert into demo (markdown,html) values (#{markdown},#{html})")
    boolean addDemo(Demo demo);
    @Select("select * from demo where id=#{id}")
    Demo select(Integer id);
}
