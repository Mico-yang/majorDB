package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.Collage;
import com.kgc.entity.Condition;
import com.kgc.entity.Major;

import java.util.List;

public interface MajorService {

    //带条件的分页查询（课程信息）
    PageInfo findByCondition(Condition condition,Integer pageNum,Integer pageSize);

    //查询所有学院
    List<Collage> findAll();

    //删除
    int deleteByPrimaryKey(Integer mid);

    //增加
    int insert(Major record);

    //修改
    int updateByPrimaryKeySelective(Major record);

    //查询一条信息
    Major selectByPrimaryKey(Integer mid);
}
