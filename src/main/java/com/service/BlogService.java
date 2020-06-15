package com.service;

import com.dao.LabDao;
import com.entry.Blog;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author GUO
 * @Classname BlogService
 * @Description TODO
 * @Date 2020/6/15 14:58
 */
public interface BlogService {
    Blog selectBlogById(Integer id);
    List<Blog> selectBlogByLabName(String name);
    List<Blog>selectByData(String data);
    List<Blog>selectByTitle(String title);
    List <Blog> findAllBlog();
    boolean addBlog(Blog blog);
    boolean updateBlog(Blog blog);
    boolean delete(Integer id);
}
