package com.github.jgzl.framework.controller;

import com.github.jgzl.framework.vo.DemoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "演示控制器")
@RestController
public class DemoController {

    @ApiOperation(value = "演示Validator校验")
    @RequestMapping(value = "/demo",method = {RequestMethod.POST})
    public DemoVo demo(@RequestBody @Validated DemoVo demoVo){
        return demoVo;
    }
}
