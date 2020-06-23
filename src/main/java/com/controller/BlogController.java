package com.controller;

import com.entry.Blog;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.BlogService;
import com.service.LabService;
import com.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author GUO
 * @Classname BlogController
 * @Description TODO
 * @Date 2020/6/15 15:03
 */
@RestController
@RequestMapping("/api")
public class BlogController {
    @Autowired
   private BlogService blogService;
    @Autowired
    private  LabService labService;
//    根据id查询具体的博客内容
    @GetMapping("/selectBlogById/{id}")
    public ResponseMessage selectBlogById(@PathVariable Integer id){
        Blog blog = blogService.selectBlogById(id);
        return ResponseMessage.success().addObject("blog",blog);
    }
    @GetMapping("/selectBlogByLabName/{name}")
    public ResponseMessage selectBlogByLabName(@PathVariable String name){
        List<Blog> blogList = blogService.selectBlogByLabName(name);
        if(blogList==null){
            return ResponseMessage.error().addObject("tip","此标签暂无文章");
        }else {
        blogList=blogList.stream().filter(Blog->Blog.getMg_state()==true).collect(Collectors.toList());
        return ResponseMessage.success().addObject("blogList",blogList);
        }
    }
    @GetMapping("/selectByTitle")
    public ResponseMessage selectByTitle(String title){
        List<Blog> blogList = blogService.selectByTitle(title);
        blogList=blogList.stream().filter(Blog->Blog.getMg_state()==true).collect(Collectors.toList());
        return ResponseMessage.success().addObject("blogList",blogList);
    }
    @GetMapping("/selectByData")
    public ResponseMessage selectByData(String data){
        List<Blog> blogList = blogService.selectByData(data);
        blogList=blogList.stream().filter(Blog->Blog.getMg_state()==true).collect(Collectors.toList());
        return ResponseMessage.success().addObject("blogList",blogList);
    }
    @GetMapping("/findStatusPage")
    public ResponseMessage findStatusPage(@RequestParam(value = "pageNum" , defaultValue = "1")int pageNum, @RequestParam("pageSize")int pageSize){
        PageInfo<Blog>pageInfo=blogService.findAllBlogByPage(pageNum,pageSize);
        List<Blog> blogList= pageInfo.getList();
        /*java8根据某一属性条件快速筛选list中的集合*/
        blogList=blogList.stream().filter(Blog->Blog.getMg_state()==true).collect(Collectors.toList());
//        blogList.forEach(Blog -> {
//            System.out.println(Blog.getId());
//        });
        Collections.reverse(blogList);//倒叙list集合
        pageInfo.setList(blogList);
        return ResponseMessage.success().addObject("pageInfo",pageInfo);
    }
    @GetMapping("/findStatus")
    public ResponseMessage findStatus(){
        List<Blog> blogList = blogService.findAllBlog();
        /*java8根据某一属性条件快速筛选list中的集合*/
        blogList=blogList.stream().filter(Blog->Blog.getMg_state()==true).collect(Collectors.toList());
//        blogList.forEach(Blog -> {
//            System.out.println(Blog.getId());
//        });
        Collections.reverse(blogList);//倒叙list集合
        return ResponseMessage.success().addObject("blogList",blogList);
    }
    @GetMapping("/findAllBlog")
    public ResponseMessage findAllBlog(){
        List<Blog> blogList = blogService.findAllBlog();
        return ResponseMessage.success().addObject("blogList",blogList);
    }
    /**
     *   查询所有的信息 , 并进行分页.
     */
    @RequestMapping(value = "/findAllBlogByPage")
    public ResponseMessage findAllBlogByPage(@RequestParam(value = "pageNum" , defaultValue = "1")int pageNum,
                                       @RequestParam("pageSize")int pageSize){
        PageInfo<Blog>pageInfo=blogService.findAllBlogByPage(pageNum,pageSize);
        return ResponseMessage.success().addObject("blogList",pageInfo);
    }
    @PostMapping(value = "/addBlog/{labName}",produces = {"application/json;charset=UTF-8"})
    public ResponseMessage addBlog(@RequestBody Blog blog,@PathVariable  String labName){
        blog.setLab_id(labService.selectLab(labName).getLabId());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String time = df.format(new Date());
        blog.setData(time);
        boolean b = blogService.addBlog(blog);
//        System.out.println(blog);
      return b ? ResponseMessage.success().addObject("tip","添加成功") : ResponseMessage.error().addObject("tip","添加失败");
    }
    @RequestMapping(value = "/updateBlog/{labName}",method = RequestMethod.PUT,produces = {"application/json;charset=UTF-8"})
    public ResponseMessage updateBlog(@RequestBody Blog blog,@PathVariable String labName){
        Blog blog1 = blogService.selectBlogById(blog.getId());
        if (blog1!=null){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String time = df.format(new Date());
        blog1.setLab_id(labService.selectLab(labName).getLabId());
        blog1.setData(time);
        blog1.setTitle(blog.getTitle());
        blog1.setMarkdown(blog.getMarkdown());
        blog1.setHtml(blog.getHtml());
        boolean b = blogService.updateBlog(blog1);
        return  b ? ResponseMessage .success():ResponseMessage.error();
        }
        else {
            return ResponseMessage.error().addObject("msg","未查到该文章");
        }
    }
    @GetMapping("/updateStates/{id}")
    public ResponseMessage updateStates(@PathVariable Integer id){
        boolean b = blogService.updateMg_state(id);
        return b ? ResponseMessage.success():ResponseMessage.error();
    }
    @RequestMapping(value = "/deleteBlog/{id}",method = RequestMethod.DELETE)
    public ResponseMessage deleteBlog(@PathVariable Integer id){
        boolean b = blogService.delete(id);
        return  b ? ResponseMessage .success().addObject("msg","删除成功"):ResponseMessage.error().addObject("msg","删除失败");
    }
}
