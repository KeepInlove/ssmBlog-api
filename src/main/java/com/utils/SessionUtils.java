package com.utils;

import com.entry.Admin;

import javax.servlet.http.HttpSession;

/**
 * @author GUO
 * @Classname SessionUtils
 * @Description TODO
 * @Date 2020/6/10 22:40
 */
public class SessionUtils {
    public static boolean getsSession (HttpSession session){
        Admin user = (Admin) session.getAttribute("loginUser");
        if (user!=null){
            return true;
        }
        return false;
    }
}
