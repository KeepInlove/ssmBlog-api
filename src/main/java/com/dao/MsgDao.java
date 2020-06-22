package com.dao;

import com.entry.Msg;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author GUO
 * @Classname MsgDao
 * @Description TODO
 * @Date 2020/6/22 12:58
 */
@Repository
public interface MsgDao {
    @Insert("insert into msg (name,email,content,time) values (#{name},#{email},#{content},#{time})")
    boolean addMsg(Msg msg);
    @Select("select * from msg")
    List<Msg>findAllMsg();
    @Delete("delete from msg where id=#{id} ")
    boolean deleteMsg(Integer id);
}
