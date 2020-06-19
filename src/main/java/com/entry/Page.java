package com.entry;

/**
 * @author GUO
 * @Classname Page
 * @Description TODO
 * @Date 2020/6/19 21:22
 */
public class Page {
    // 当前页数,默认为第一页
    private Integer page = 1;

    // 要查询的记录数，默认一次查询10条记录
    private Integer size = 10;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Page{" +
                "page=" + page +
                ", size=" + size +
                '}';
    }
}

