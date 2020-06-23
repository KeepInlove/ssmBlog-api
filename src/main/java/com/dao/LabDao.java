package com.dao;

import com.entry.Lab;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author GUO
 * @Classname LabDao
 * @Description TODO
 * @Date 2020/6/14 19:46
 */
@Repository
public interface LabDao {
    @Insert("insert into lab (name) value (#{name}) ")
    boolean insertLab(Lab lab);

    @Select("select * from lab where labId=#{labId} ")
    Lab selectById(Integer labId);

    @Select("select * from lab where name like '%${name}%'")
    Lab selectLabByName(String name);

    @Select("select * from lab")
    List<Lab> findAll();

    @Delete("delete from lab where labId=#{labId}")
    boolean deleteLab(Integer labId);

    @Update("update lab set name=#{name} WHERE labId=#{labId}")
    boolean updateLab(Integer labId);
}
