package com.github.jgzl.framework.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用数据返回对象
 * @param <T>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class R<T> {
    /**
     * 返回code
     * @since 1.0
     */
    private Integer code;
    /**
     * 返回信息
     * @since 1.0
     */
    private String message;
    /**
     * 返回数据
     * @since 1.0
     */
    private T data;

    public <T> R<T> of(Integer code,String message,T data){
        return new R(code,message,data);
    }
}
