package com.github.jgzl.framework.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 测试VO
 * @author lihaifeng
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "DemoVo")
public class DemoVo {
    /**
     * 用户名称
     * @required
     * @mock 李海峰
     * @since 1.0
     */
    @NotBlank(message = "username不允许为空")
    @ApiModelProperty(value = "用户名称")
    public String username;
    /**
     * 年龄
     * @required
     * @mock 20
     * @since 1.0
     */
    @NotNull(message = "age不允许为空")
    @ApiModelProperty(value = "年龄")
    public Integer age;
    /**
     * 备注
     * @mock 测试备注
     * @since 1.0
     */
    @ApiModelProperty(value = "备注")
    public String comments;
}
