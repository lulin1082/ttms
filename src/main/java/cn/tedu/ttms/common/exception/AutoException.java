package cn.tedu.ttms.common.exception;

import cn.tedu.ttms.common.enums.ExceptionEnum;

/**
 * @Author: lulin
 * @Date: 3/27/2019 10:54 PM
 * @Version 1.0
 */
public class AutoException extends RuntimeException{
    private Integer code;

    public AutoException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public AutoException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code=exceptionEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

