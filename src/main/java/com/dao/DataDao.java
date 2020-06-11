package com.dao;

import com.entry.Data;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
/**
 * @author GUO
 * @Classname DataDao
 * @Description TODO
 * @Date 2020/6/11 9:32
 */
@Repository
public interface DataDao {
    @Select("select * from data")
    Data findData();
    @Update("update data set name=#{name},work=#{work},address=#{address},qq=#{qq},wechar=#{wechar},github=#{github},email=#{email}")
    boolean update(Data data);
}
