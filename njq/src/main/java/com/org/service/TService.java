package com.org.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.org.dao.TestMapper;
import com.org.entity.test.Test;

@Service("tService")
@Transactional
public class TService {
    public static final Logger logger = LoggerFactory.getLogger(TService.class);

    @Autowired
    private TestMapper testMapper;

    public Map<String, Object> getData(String name, int pageNum, int pageSize) {
        logger.info("getData");
        //分页控件
        PageHelper.startPage(pageNum, pageSize);
        //获取列表数据
        List<Test> testList = this.testMapper.selectAllByName(name);
        Map<String, Object> result = new HashMap<>();
        result.put("total", ((Page<Test>) testList).getTotal());
        result.put("list", testList);
        return result;
    }

    public void setData(String name, String sex) {
        logger.info("setData");
        Test t = new Test();
        t.setName(name);
        t.setSex(sex);
        this.testMapper.insert(t);
    }
}
