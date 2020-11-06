package com.kgc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.dao.CollageMapper;
import com.kgc.dao.MajorMapper;
import com.kgc.entity.Collage;
import com.kgc.entity.Condition;
import com.kgc.entity.Major;
import com.kgc.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorServiceImpl implements MajorService {

    @Autowired
    private MajorMapper majorMapper;
    @Autowired
    private CollageMapper collageMapper;

    public PageInfo findByCondition(Condition condition, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Major> majorList = majorMapper.queryByCondition(condition);
        PageInfo pageInfo = new PageInfo(majorList);
        return pageInfo;
    }

    public List<Collage> findAll() {
        return collageMapper.findCollege();
    }

    public int deleteByPrimaryKey(Integer mid) {
        return majorMapper.deleteByPrimaryKey(mid);
    }

    public int insert(Major record) {
        return majorMapper.insert(record);
    }

    public int updateByPrimaryKeySelective(Major record) {
        return updateByPrimaryKeySelective(record);
    }

    public Major selectByPrimaryKey(Integer mid) {
        return majorMapper.selectByPrimaryKey(mid);
    }

}
