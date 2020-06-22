package com.service;

import com.entry.Msg;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author GUO
 * @Classname MsgService
 * @Description TODO
 * @Date 2020/6/22 13:05
 */
public interface MsgService {
    boolean addMsg(Msg msg);
    List<Msg> findAllMsg();
    boolean deleteMsg(Integer id);
    PageInfo<Msg> findAllMsgByPage(int pageNum, int pageSize);
}
