package com.parameter.exception;

import com.ej.common.exception.BaseException;

/**
 * 未知的Device
 */
public class UnknownDeviceException extends BaseException {
    private static final long serialVersionUID = 1L;

    public UnknownDeviceException(Throwable ex) {
        super(ex);
    }

    public UnknownDeviceException(String message) {
        super(message);
    }

    public UnknownDeviceException(String message, Throwable ex) {
        super(message, ex);
    }

    @Override
    public int getErrorCode() {
        return ErrorCodeCons.UnknownDeviceException;
    }

}
