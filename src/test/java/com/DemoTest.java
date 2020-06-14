package com;

import com.entry.Demo;
import com.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author GUO
 * @Classname DemoTest
 * @Description TODO
 * @Date 2020/6/14 18:35
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DemoTest {
    @Autowired
    private DemoService demoService;
    @Test
    public void addDemo(){
        Demo demo=new Demo();
        demo.setMarkdown("::: hljs-center\n" +
                "\n" +
                "# Vue的使用\n" +
                "\n" +
                ":::\n" +
                "\n" +
                "1. markdown富文本编辑器\n" +
                "2. 组件的注册\n" +
                "3. svg图片的使用");
        demo.setHtml("<div class=\"hljs-center\">\n" +
                "<h1><a id=\"Vue_2\"></a>Vue的使用</h1>\n" +
                "</div>\n" +
                "<ol>\n" +
                "<li>markdown富文本编辑器</li>\n" +
                "<li>组件的注册</li>\n" +
                "<li>svg图片的使用</li>\n" +
                "</ol>");
        boolean b = demoService.addDemo(demo);
    }
    @Test
    public void selectDemo(){

    }
}
