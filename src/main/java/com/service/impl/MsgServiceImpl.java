package com.service.impl;

import com.dao.MsgDao;
import com.entry.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GUO
 * @Classname MsgServiceImpl
 * @Description TODO
 * @Date 2020/6/22 13:06
 */
@Service
public class MsgServiceImpl implements MsgService{
    @Autowired
    private MsgDao msgDao;
    @Override
    public boolean addMsg(Msg msg) {
        return msgDao.addMsg(msg);
    }

    @Override
    public List<Msg> findAllMsg() {
        return msgDao.findAllMsg();
    }

    @Override
    public boolean deleteMsg(Integer id) {
        return msgDao.deleteMsg(id);
    }

    @Override
    public PageInfo<Msg> findAllMsgByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Msg>msgList=msgDao.findAllMsg();
        PageInfo<Msg>pageInfo=new PageInfo<>(msgList);
        return pageInfo;
    }
}
