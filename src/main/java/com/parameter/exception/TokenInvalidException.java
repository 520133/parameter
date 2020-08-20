package com.parameter.exception;

import com.ej.common.exception.BaseException;

/**
 * 项目名称：xyydLive 	<br><br>
 * <p>
 * 类名称：TokenInvalidException 		<br><br>
 * <p>
 * 创建人：eeok@163.com 	<br><br>
 * <p>
 * 创建时间：2016-11-1 下午2:16:41 	<br><br>
 * <p>
 * 版本：1.0					<br><br>
 * <p>
 * 功能描述：token无效异常
 */
public class TokenInvalidException extends BaseException {
    private static final long serialVersionUID = 1L;

    public TokenInvalidException(Throwable ex) {
        super(ex);
    }

    public TokenInvalidException(String message) {
        super(message);
    }

    public TokenInvalidException(String message, Throwable ex) {
        super(message, ex);
    }

    @Override
    public int getErrorCode() {
        return ErrorCodeCons.TokenInvalidException;
    }

}
