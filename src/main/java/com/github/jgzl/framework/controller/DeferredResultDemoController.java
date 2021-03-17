package com.github.jgzl.framework.controller;

import com.github.jgzl.framework.exception.CustomException;
import com.github.jgzl.framework.vo.DemoVo;
import com.github.jgzl.framework.vo.R;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Map;
import java.util.Optional;

/**
 * @author lihaifeng
 * @version 1.0
 * @since 1.0
 */
@Api(tags = "演示控制器")
@RestController
@AllArgsConstructor
public class DeferredResultDemoController {

    private Map<String, DeferredResult<R<DemoVo>>> cacheMap = Maps.newConcurrentMap();

    @ApiOperation(value = "演示Validator校验")
    @RequestMapping(value = "/demo",method = {RequestMethod.POST})
    public DemoVo demo(@RequestBody @Validated DemoVo demoVo){
        return demoVo;
    }

    /**
     * 演示DeferredResult请求数据
     * </p><h2>{@code http://127.0.0.1:8080/fetch?requestId=1&timeout=9000}</h2>
     * @param requestId
     * @param timeout
     * @return
     */
    @ApiOperation(value = "演示DeferredResult请求数据")
    @RequestMapping(value = "/fetch",method = {RequestMethod.GET})
    public DeferredResult fetch(@RequestParam String requestId, @RequestParam Long timeout){
        Optional.ofNullable(cacheMap).filter(cache->!cache.containsKey(requestId)).orElseThrow(()->new IllegalArgumentException(String.format("requestId=%s is existing!!!",requestId)));
        DeferredResult result = new DeferredResult(timeout!=null?timeout:3000,new R<>().of(400,"超过设定的超时时间",null));
        cacheMap.put(requestId,result);
        return result;
    }

    /**
     * 演示DeferredResult填写数据，模拟异步请求
     * </p><h2>{@code http://127.0.0.1:8080/input?requestId=1&comments=测试}</h2>
     * @param requestId
     * @param comments
     * @return
     */
    @ApiOperation(value = "演示DeferredResult填写数据，模拟异步请求")
    @RequestMapping(value = "/input",method = {RequestMethod.GET})
    public String deferredResult(@RequestParam String requestId, @RequestParam String comments){
        DeferredResult<R<DemoVo>> result = Optional.ofNullable(cacheMap).filter(cache->cache.containsKey(requestId)).orElseThrow(()->new CustomException(401,String.format("requestId=%s is not existing!!!",requestId))).get(requestId);
        result.setResult(new R<>(200,"请求成功",new DemoVo("用户"+requestId,20,comments)));
        cacheMap.remove(requestId);
        return "Done";
    }
}
