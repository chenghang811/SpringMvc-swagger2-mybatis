package com.org.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.org.entity.test.Test;

import tk.mybatis.mapper.common.Mapper;

public interface TestMapper extends Mapper<Test> {
    List<Test> selectAllByName(@Param("name") String name);
}