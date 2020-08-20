package com.parameter.exception;

import com.ej.common.exception.BaseException;

/**
 * 解密异常
 */
public class DecodeException extends BaseException {
    private static final long serialVersionUID = 1L;

    public DecodeException(Throwable ex) {
        super(ex);
    }

    public DecodeException() {
        this("通信解密异常");
    }

    public DecodeException(String message) {

        super(message);
    }

    public DecodeException(String message, Throwable ex) {
        super(message, ex);
    }

    @Override
    public int getErrorCode() {
        return ErrorCodeCons.DecodeException;
    }

}
