package com.kgc.dao;

import com.kgc.entity.Collage;
import com.kgc.entity.CollageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CollageMapper {
    long countByExample(CollageExample example);

    int deleteByExample(CollageExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(Collage record);

    int insertSelective(Collage record);

    List<Collage> selectByExample(CollageExample example);

    Collage selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") Collage record, @Param("example") CollageExample example);

    int updateByExample(@Param("record") Collage record, @Param("example") CollageExample example);

    int updateByPrimaryKeySelective(Collage record);

    int updateByPrimaryKey(Collage record);


    //查询所有学院
    @Select("select * from collage")
    List<Collage> findCollege();
}