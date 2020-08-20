package com.parameter.util;

import lombok.Getter;

/**
 * @author 杨森霖
 * @author 2020/8/5 0005 下午 17:03
 */
@Getter
public class Result<T> {
    /**
     * 状态码，比如1000代表响应成功
     */
    private int code;
    /**
     * 响应信息，用来说明响应情况
     */
    private String msg;
    /**
     * 响应的具体数据
     */
    private T data;

    public Result(T data) {
        this(ResultCode.SUCCESS,  data);
    }

    public Result(ResultCode resultCode, T data) {
        this.code = code;
        this.data = data;
    }
}