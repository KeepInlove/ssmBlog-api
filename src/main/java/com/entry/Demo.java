package com.entry;

/**
 * @author GUO
 * @Classname Demo
 * @Description TODO
 * @Date 2020/6/14 18:24
 */
public class Demo  {
    private Integer id;
    private String markdown;
    private String html;

    public String getMarkdown() {
        return markdown;
    }

    public void setMarkdown(String markdown) {
        this.markdown = markdown;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "id=" + id +
                ", markdown='" + markdown + '\'' +
                ", html='" + html + '\'' +
                '}';
    }
}
