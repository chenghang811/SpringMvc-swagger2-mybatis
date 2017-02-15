package com.org.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.config.TO.AjaxResult;
import com.org.service.TService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TService tService;

    /**
     * 测试接口
     * @return
     */
    @RequestMapping(value = "/getTest", method = RequestMethod.GET)
    @ApiOperation(value = "测试接口获取数据-分页查询")
    public AjaxResult getTest(@RequestParam(required = false) @ApiParam(value = "姓名", required = false) String name,
            @RequestParam(required = true) @ApiParam(value = "页码", required = true) int pageNum,
            @RequestParam(required = true) @ApiParam(value = "每页显示多少条", required = true) int pageSize) {
        return new AjaxResult<>(this.tService.getData(name, pageNum, pageSize)).success();
    }

    /**
     * 测试接口-获取数据
     * @return
     */
    @RequestMapping(value = "/postTest", method = RequestMethod.POST)
    @ApiOperation(value = "测试接口提交数据")
    public AjaxResult postTest(@RequestParam(required = true) @ApiParam(value = "姓名", required = true) String name,
            @RequestParam(required = false) @ApiParam(value = "性别", required = false) String sex) {
        this.tService.setData(name, sex);
        return new AjaxResult<>().success();
    }
}
