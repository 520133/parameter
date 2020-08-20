package com.parameter.exception;

import com.ej.common.exception.BaseException;

/**
 * 设备空异常
 */
public class DeviceBlankException extends BaseException {
    private static final long serialVersionUID = 1L;

    public DeviceBlankException(Throwable ex) {
        super(ex);
    }

    public DeviceBlankException() {
        this("设备id为空");
    }

    public DeviceBlankException(String message) {

        super(message);
    }

    public DeviceBlankException(String message, Throwable ex) {
        super(message, ex);
    }

    @Override
    public int getErrorCode() {
        return ErrorCodeCons.DeviceBlankException;
    }

}
