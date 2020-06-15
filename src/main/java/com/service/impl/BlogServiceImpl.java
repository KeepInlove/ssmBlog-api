package com.service.impl;

import com.dao.BlogDao;
import com.dao.LabDao;
import com.entry.Blog;

import com.entry.Lab;
import com.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GUO
 * @Classname BlogServiceImpl
 * @Description TODO
 * @Date 2020/6/15 15:00
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogDao blogDao;
    @Autowired
    private LabDao labDao;
    @Override
    public Blog selectBlogById(Integer id) {
        return blogDao.selectBlogById(id);
    }

    @Override
    public List<Blog> selectBlogByLabName(String name) {
        return blogDao.selectBlogByLabId(labDao.selectLabByName(name).getLabId());
    }

    @Override
    public List<Blog> selectByData(String data) {
        return selectByData(data);
    }

    @Override
    public List<Blog> selectByTitle(String title) {
        return blogDao.selectByTitle(title);
    }

    @Override
    public List<Blog> findAllBlog() {
        return blogDao.findAllBlog();
    }

    @Override
    public boolean addBlog(Blog blog) {
        return blogDao.addBlog(blog);
    }

    @Override
    public boolean updateBlog(Blog blog) {
        return blogDao.updateBlog(blog);
    }

    @Override
    public boolean delete(Integer id) {
        return blogDao.delete(id);
    }
}
