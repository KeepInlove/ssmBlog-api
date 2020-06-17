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
             one = @One(select = "com.dao.LabDao.selectById")))
    Blog selectBlogById(Integer id);


    @Select("select * from blog")
    @Results(@Result(property = "lab", column = "lab_id",
            one = @One(select = "com.dao.LabDao.selectById")))
    List <Blog> findAllBlog();

    @Select("select * from blog where lab_id=#{lab_id}")
    @Results(@Result(property = "lab", column = "lab_id",
            one = @One(select = "com.dao.LabDao.selectById")))
    List <Blog> selectBlogByLabId(Integer lab_id);

    @Select("select * from blog where data like '%${name}%'")
    @Results(@Result(property = "lab", column = "lab_id",
            one = @One(select = "com.dao.LabDao.selectById")))
    List<Blog>selectByData(String data);

    @Select("select * from blog where title like '%${name}%'")
    @Results(@Result(property = "lab", column = "lab_id",
            one = @One(select = "com.dao.LabDao.selectById")))
    List<Blog>selectByTitle(String title);

    @Insert("insert into blog (title,markdown,html,data,lab_id) values (#{title},#{markdown},#{html},#{data},#{lab_id})")
    boolean addBlog(Blog blog);

    @Update("update blog set title=#{title},markdown=#{markdown},html=#{html},data=#{data},lab_id=#{lab_id} where id=#{id}")
    boolean updateBlog(Blog blog);

    @Update("update blog set mg_state=#{mg_state} where id=#{id}")
    boolean updateMg_state(Blog blog);

    @Delete("delete from blog where id=#{id}")
    boolean delete(Integer id);

}
