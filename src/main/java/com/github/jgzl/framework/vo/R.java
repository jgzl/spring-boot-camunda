package com.github.jgzl.framework.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class R<T> {
    private Integer code;
    private String message;
    private T data;

    public <T> R<T> of(Integer code,String message,T data){
        return new R(code,message,data);
    }
}
