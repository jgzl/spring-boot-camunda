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

    public <T> R<T> success(T data){
        return new R(200,"success",data);
    }
    public <T> R<T> failed(T data){
        return new R(400,"failed",data);
    }
}
