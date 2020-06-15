package com.entry;

import java.io.Serializable;

/**
 * @author GUO
 * @Classname Blog
 * @Description TODO
 * @Date 2020/6/14 23:23
 */
public class Blog implements Serializable {
    private Integer id;
    private String title;
    private Integer lab_id;
    private Lab lab;
    private String markdown;
    private String html;
    private String data;

    public Integer getLab_id() {
        return lab_id;
    }

    public void setLab_id(Integer lab_id) {
        this.lab_id = lab_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMarkdown() {
        return markdown;
    }

    public void setMarkdown(String markdown) {
        this.markdown = markdown;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Lab getLab() {
        return lab;
    }

    public void setLab(Lab lab) {
        this.lab = lab;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", lab=" + lab +
                ", markdown='" + markdown + '\'' +
                ", html='" + html + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
