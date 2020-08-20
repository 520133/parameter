package com.parameter.exception;

import com.ej.common.exception.BaseException;

/**
 * 项目名称：xyydLive 	<br><br>
 * <p>
 * 类名称：OrderIdInvalidException 		<br><br>
 * <p>
 * 创建人：eeok@163.com 	<br><br>
 * <p>
 * 创建时间：2016-11-4 下午3:00:26 	<br><br>
 * <p>
 * 版本：1.0					<br><br>
 * <p>
 * 功能描述：订单Id无效
 */
public class OrderIdInvalidException extends BaseException {
    private static final long serialVersionUID = 1L;

    public OrderIdInvalidException(Throwable ex) {
        super(ex);
    }

    public OrderIdInvalidException(String message) {
        super(message);
    }

    public OrderIdInvalidException(String message, Throwable ex) {
        super(message, ex);
    }

    @Override
    public int getErrorCode() {
        return -99;
    }

}
