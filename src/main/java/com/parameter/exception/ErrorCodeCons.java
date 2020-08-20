package com.parameter.exception;

/**
 * ErrorCodeCons
 *
 * @author linapex
 */
public class ErrorCodeCons {
    /**
     * 通用异常
     */
    public static final int GENERAL_ERRORCODE = -99;

    /**
     * -110，token无效
     */
    public static final int TokenInvalidException = -110;
    /**
     * -111，设备id签名为空
     */
    public static final int DeviceBlankException = -111;
    /**
     * -112，解密异常
     */
    public static final int DecodeException = -112;
    /**
     * -113，转账异常
     */

    public static final int TransferException = -113;
    /**
     * -114，未知的device
     */
    public static final int UnknownDeviceException = -114;
    /**
     * -99，读取黄金异常
     */
    public static final int GetGoldPriceException = GENERAL_ERRORCODE;

}
