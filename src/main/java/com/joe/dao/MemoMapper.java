package com.joe.dao;

import com.joe.entity.Memo;
import com.joe.entity.MemoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemoMapper {
    long countByExample(MemoExample example);

    int deleteByExample(MemoExample example);

    int deleteByPrimaryKey(String memoId);

    int insert(Memo record);

    int insertSelective(Memo record);

    List<Memo> selectByExample(MemoExample example);

    Memo selectByPrimaryKey(String memoId);

    int updateByExampleSelective(@Param("record") Memo record, @Param("example") MemoExample example);

    int updateByExample(@Param("record") Memo record, @Param("example") MemoExample example);

    int updateByPrimaryKeySelective(Memo record);

    int updateByPrimaryKey(Memo record);
}