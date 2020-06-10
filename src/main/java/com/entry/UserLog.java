package com.entry;

import java.sql.Timestamp;

/**
 * @author GUO
 * @Classname Userlog
 * @Description TODO
 * @Date 2020/6/10 18:33
 */
public class UserLog {
    private Integer id;
    private String username;
    private Timestamp time;
    private String ip;
    private String city;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    @Override
    public String toString() {
        return "UserLog{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", time=" + time +
                ", ip='" + ip + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
