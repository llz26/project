package com.stylefeng.guns.modular.vocabulary.service;

import com.stylefeng.guns.modular.vocabulary.Domain.HSK;
import com.stylefeng.guns.modular.vocabulary.dao.HSKDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HSKService {
    private HSKDao hskDao;

    @Autowired
    public void setHskDao(HSKDao hskDao) {
        this.hskDao = hskDao;
    }
    public List<HSK> getHskList(int level){return hskDao.getHskList(level);}
}
