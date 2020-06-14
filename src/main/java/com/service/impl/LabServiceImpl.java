package com.service.impl;

import com.dao.LabDao;
import com.entry.Lab;
import com.service.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GUO
 * @Classname LabServiceImpl
 * @Description TODO
 * @Date 2020/6/14 22:39
 */
@Service
public class LabServiceImpl implements LabService {
    @Autowired
   private LabDao labDao;
    @Override
    public boolean insertLab(Lab lab) {
        return labDao.insertLab(lab);
    }
    @Override
    public Lab selectLab(Integer id) {
        return labDao.selectLab(id);
    }

    @Override
    public List<Lab> findAll() {
        return labDao.findAll();
    }

    @Override
    public boolean deleteLab(Integer id) {
        return labDao.deleteLab(id);
    }

    @Override
    public boolean updateLab(Integer id) {
        return labDao.deleteLab(id);
    }
}
