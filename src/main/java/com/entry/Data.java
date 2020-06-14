package com.entry;
import java.io.Serializable;


/**
 * @author GUO
 * @Classname Data
 * @Description TODO
 * @Date 2020/6/11 9:29
 */
public class Data implements Serializable {
    private String name;
    private String work;
    private String address;
    private String qq;
    private String wechar;
    private String github;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechar() {
        return wechar;
    }

    public void setWechar(String wechar) {
        this.wechar = wechar;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                ", work='" + work + '\'' +
                ", address='" + address + '\'' +
                ", qq='" + qq + '\'' +
                ", wechar='" + wechar + '\'' +
                ", github='" + github + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
