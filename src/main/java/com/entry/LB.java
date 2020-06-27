package com.entry;

/**
 * @author GUO
 * @Classname LB
 * @Description TODO
 * @Date 2020/6/23 13:41
 */
public class LB {
    private String name;
    private Integer id;
    private Integer value;
    private Boolean stu;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Boolean getStu() {
        return stu;
    }

    public void setStu(Boolean stu) {
        this.stu = stu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "LB{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", value=" + value +
                ", stu=" + stu +
                '}';
    }
}
