package com.kgc.dao;

import com.kgc.entity.Condition;
import com.kgc.entity.Major;
import com.kgc.entity.MajorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MajorMapper {
    long countByExample(MajorExample example);

    int deleteByExample(MajorExample example);

    //删除
    int deleteByPrimaryKey(Integer mid);

    //增加
    int insert(Major record);

    int insertSelective(Major record);

    List<Major> selectByExample(MajorExample example);

    //查询一条信息
    Major selectByPrimaryKey(Integer mid);

    int updateByExampleSelective(@Param("record") Major record, @Param("example") MajorExample example);

    int updateByExample(@Param("record") Major record, @Param("example") MajorExample example);

    //修改
    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);

    //动态查询（带查询条件和分页）
    List<Major> queryByCondition(Condition condition);
}