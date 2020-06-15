package com.entry;

import java.io.Serializable;

/**
 * @author GUO
 * @Classname lab
 * @Description TODO
 * @Date 2020/6/14 19:45
 */
public class Lab implements Serializable {
    private Integer labId;
    private String name;

    public Integer getLabId() {
        return labId;
    }

    public void setLabId(Integer labId) {
        this.labId = labId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Lab{" +
                "labId=" + labId +
                ", name='" + name + '\'' +
                '}';
    }
}
