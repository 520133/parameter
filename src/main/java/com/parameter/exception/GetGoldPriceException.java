package com.parameter.exception;

import com.ej.common.exception.BaseException;

/**
 * 黄金价格异常
 */
public class GetGoldPriceException extends BaseException {
    private static final long serialVersionUID = 1L;

    public GetGoldPriceException(Throwable ex) {
        super(ex);
    }

    public GetGoldPriceException(String message) {
        super(message);
    }

    public GetGoldPriceException(String message, Throwable ex) {
        super(message, ex);
    }

    @Override
    public int getErrorCode() {
        return ErrorCodeCons.GetGoldPriceException;
    }

}
