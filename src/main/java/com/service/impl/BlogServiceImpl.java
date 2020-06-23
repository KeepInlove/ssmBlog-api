package com.service.impl;

import com.dao.BlogDao;
import com.dao.LabDao;
import com.entry.Blog;

import com.entry.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
        Blog blog = blogDao.selectBlogById(id);
//        String returnHtml = HtmlUtils.htmlUnescape( blog.getHtml());
//        blog.setHtml(returnHtml);
        return blog;
    }

    @Override
    public List<Blog> selectBlogByLabName(String name) {
        Integer labId = labDao.selectLabByName(name).getLabId();
        if (labId!=null&&labId>0){
            List<Blog> blogList = blogDao.selectBlogByLabId(labId);
            if (blogList!=null&&blogList.size()>0){
                return blogList;
            }else {
                return null;
            }
        }else {
            return null;
        }
    }

    @Override
    public List<Blog> selectByData(String data) {
        return blogDao.selectByData(data);
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
        List<Blog> blogList = blogDao.selectByTitle(blog.getTitle());
        if (blogList!=null&&blogList.size()>0){
            return false;
        }else {
//            String html = HtmlUtils.htmlEscapeHex(blog.getHtml());
//            blog.setHtml(html);
            return blogDao.addBlog(blog);
        }
    }

    @Override
    public boolean updateBlog(Blog blog) {
        return blogDao.updateBlog(blog);
    }

    @Override
    public boolean delete(Integer id) {
        return blogDao.delete(id);
    }

//    @Override
//    public boolean updateStatus(Integer id) {
//        Blog blog = blogDao.selectBlogById(id);
//        if (blog!=null){
//            Integer status = blog.getStatus();
//            Integer i=1;
//            Integer o=0;
//           if(i.equals(status)) {
//               blog.setStatus(o);
//           }else {
//               blog.setStatus(i);
//           }
////            boolean status = blog.isStatus();
//            System.out.println("修改前状态:"+status);
////            blog.setStatus(!status);
////            System.out.println(blog);
//            return blogDao.updateStatus(blog);
//        }else {
//            return false;
//        }
//    }

    @Override
    public boolean updateMg_state(Integer id) {
        Blog blog = blogDao.selectBlogById(id);
        if (blog!=null){
            Boolean mg_state = blog.getMg_state();
            if (mg_state==true){
                blog.setMg_state(false);
            }else {
                blog.setMg_state(true);
            }
            return blogDao.updateMg_state(blog);
        }
        else {
            return false;
        }
    }

    @Override
    public int total() {
        return blogDao.total();
    }

//    分页查询
    @Override
    public PageInfo<Blog> findAllBlogByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        // 调用数据层 , 查询所有的产品!
        List<Blog> blogList = blogDao.findAllBlog();
//        Collections.reverse(blogList);//倒叙list集合
//        System.out.println(blogList);
        // 参数传递查询到的产品集合 , 放到PageInfo对象中.
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
        return pageInfo;
    }
}
