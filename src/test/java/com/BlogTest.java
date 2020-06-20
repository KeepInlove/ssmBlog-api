package com;

import com.dao.BlogDao;
import com.dao.LabDao;
import com.entry.Blog;
import com.entry.Lab;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.BlogService;
import com.service.LabService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Blog> blogList = blogService.selectByData("2020-06-17");
        System.out.println(blogList.size());
//        System.out.println(blogList);
    }
    @Test
    public void selectBlogByLabName(){
        List<Blog> blogList = blogService.selectBlogByLabName("jav");
        System.out.println(blogList);
    }
    @Test
    public void addBlog(){
        Blog blog=new Blog();
        Lab lab=new Lab();
        Integer lab_id = labDao.selectLabByName("mysql").getLabId();
        blog.setLab_id(lab_id);
        blog.setHtml("<h1>CRUD程序猿的一生<h1>");
        blog.setMarkdown("#CRUD程序猿的一生");
        blog.setTitle("CRUD程序猿的一生");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time = df.format(new Date());
        blog.setData(time);
        boolean b = blogService.addBlog(blog);
        System.out.println(b);
//        List<Blog> blogList = blogService.findAllBlog();
//        System.out.println(blogList);
    }
    @Test
    public void updateBlog(){
        Blog blog = blogService.selectBlogById(1);
        blog.setTitle("Vue中的虚拟Dom");
        System.out.println(blog);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time = df.format(new Date());
        blog.setData(time);
        boolean b = blogService.updateBlog(blog);
        System.out.println(b);
    }
    @Test
    public void updateStatus(){
        Blog blog = blogService.selectBlogById(1);
        boolean status = blog.getMg_state();
        System.out.println(status);
        boolean b = blogService.updateMg_state(1);
        System.out.println(blogService.selectBlogById(1));


    }
    @Test
    public void total(){
        int total = blogService.total();
        System.out.println(total);
    }
    @Test
    public void BlogPage(){
        PageHelper.startPage(1,5);
        List<Blog> blogList = blogService.findAllBlog();
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
        // 4. 查询分页其他的数据.
//        System.out.println("当前页码 :"+pageInfo.getPageNum());
        System.out.println("每页显示条数 :"+pageInfo.getPageSize());   // 获取每页个数
        System.out.println("总条数:"+pageInfo.getTotal());  			 // 获取总条数.
        List<Blog> list = pageInfo.getList();  					 // 获取分页显示的数据.
//        System.out.println(list);
        System.out.println("分页显示的数据的大小: "+list.size());
        System.out.println("总页数: "+pageInfo.getPages());	 	     // 获取总页数.
    }
    @Test
    public void blogPage(){
        PageInfo<Blog>pageInfo=blogService.findAllBlogByPage(1,5);
        System.out.println(pageInfo);
//        List<Blog> blogList = pageInfo.getList();
//        blogList=blogList.stream().filter(Blog->Blog.getMg_state()==true).collect(Collectors.toList());
//        System.out.println(blogList);
    }

}
