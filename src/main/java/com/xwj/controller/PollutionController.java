package com.xwj.controller;


import com.xwj.common.R;
import com.xwj.service.PollutionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "污染物接口")
@RestController //这样默认controller返回的是json对象而不是视图名称
@RequestMapping("/api/pollution/")
@CrossOrigin
public class PollutionController {

    @Autowired
    private PollutionService pollutionService;

    /*
    *  这里后续要拓展为根据 年份进行查询
    * */
    @GetMapping("get_all_province")
    @ApiOperation("获取中国地图各个省的污染平均值")
    public R getAllProvincePollutions(){
        List<Map<String, Object>> pollutions = pollutionService.getAllProvincePollutions();
        return R.ok(pollutions,"查询成功!");
    }

    @GetMapping("get_info_by_year/{year}")
    @ApiOperation("根据年份获取各个省的污染物平均值")
    public R getInfoByYear(@PathVariable String year){
        List<Map<String, Object>> pollutions = pollutionService.getInfoByYear(year);
        return R.ok(pollutions,"查询成功!");
    }

    @GetMapping("get_city_by_province/{year}/{name}")
    @ApiOperation("根据省的名称获取城市污染数据")
    public R getCityInfoByProvince(@PathVariable String year,@PathVariable String name){
        List<Map<String, Object>> cityInfoByProvince = pollutionService.getCityInfoByProvince(year,name);
        return R.ok(cityInfoByProvince);
    }





}
