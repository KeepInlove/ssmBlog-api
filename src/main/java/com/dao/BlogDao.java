package com.dao;

import com.entry.Blog;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author GUO
 * @Classname BlogDao
 * @Description TODO
 * @Date 2020/6/14 23:33
 */
@Repository
public interface BlogDao {
    /*一对一查询
    * 根据id查询博客的详情
    * */
    @Select("select * from blog where id=#{id}")
    @Results(@Result(property = "lab", column = "lab_id",
             one = @One(select = "com.dao.LabDao.selectLab")))
    Blog selectBlogById(Integer id);

    @Select("select * from blog where lab_id=#{lab_id}")
   List <Blog> selectBlogByLabId(Integer lab_id);
}
