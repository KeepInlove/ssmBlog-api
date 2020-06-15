package com;

import com.dao.BlogDao;
import com.dao.LabDao;
import com.entry.Blog;
import com.entry.Lab;
import com.service.BlogService;
import com.service.LabService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author GUO
 * @Classname BlogTest
 * @Description TODO
 * @Date 2020/6/14 23:51
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class BlogTest {
    @Autowired
   private  BlogDao blogDao;
    @Autowired
    private BlogService blogService;
    @Autowired
    LabDao labDao;
    @Test
    public void select(){
        Blog blog = blogDao.selectBlogById(1);
        System.out.println(blog);
    }
    @Test
    public void selectLabId(){
        List<Blog> blogList = blogDao.selectBlogByLabId(1);
        int size = blogList.size();
        System.out.println(size);
        System.out.println("------");
        System.out.println(blogList);
    }
    @Test
    public void selectByData(){
        List<Blog> blogList = blogDao.findAllBlog();
        System.out.println(blogList);
    }
    @Test
    public void selectBlogByLabName(){
        List<Blog> blogList = blogService.selectBlogByLabName("jav");
        System.out.println(blogList);
    }
    @Test
    public void addBlog(){
//        Blog blog=new Blog();
//        Lab lab=new Lab();
//        Integer lab_id = labDao.selectLabByName("mysql").getLabId();
//        blog.setLab_id(lab_id);
//        blog.setHtml("<h1>CRUD程序猿的一生<h1>");
//        blog.setMarkdown("#CRUD程序猿的一生");
//        blog.setTitle("CRUD程序猿的一生");
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        String time = df.format(new Date());
//        blog.setData(time);
//        boolean b = blogService.addBlog(blog);
//        System.out.println(b);
        List<Blog> blogList = blogService.findAllBlog();
        System.out.println(blogList);

    }

}
