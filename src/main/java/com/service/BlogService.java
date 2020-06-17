package com.service;

import com.entry.Blog;
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
    boolean updateBlog(Integer id);
    boolean delete(Integer id);
    boolean updateMg_state(Integer id);
}
