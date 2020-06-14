package com;

import com.dao.BlogDao;
import com.dao.LabDao;
import com.entry.Blog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}
