package com.service;

import com.entry.Lab;

import java.util.List;

/**
 * @author GUO
 * @Classname LabService
 * @Description TODO
 * @Date 2020/6/14 22:37
 */
public interface LabService {
    boolean insertLab(Lab lab);
    Lab selectLab(String name);
    List<Lab> findAll();
    boolean deleteLab(Integer id);
    boolean updateLab(Integer id);
}
