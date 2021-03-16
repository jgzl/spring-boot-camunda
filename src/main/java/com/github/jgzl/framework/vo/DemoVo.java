package com.github.jgzl.framework.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@ApiModel(value = "DemoVo")
public class DemoVo {
    @NotBlank(message = "username不允许为空")
    @ApiModelProperty(value = "用户名称")
    public String username;
    @NotNull(message = "age不允许为空")
    @ApiModelProperty(value = "年龄")
    public Integer age;
    @ApiModelProperty(value = "备注")
    public String comments;
}
