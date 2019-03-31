package cn.tedu.ttms.common.enums;

import org.omg.CORBA.UNKNOWN;

import java.security.spec.ECField;

/**
 * @Author: lulin
 * @Date: 3/9/2019 11:08 PM
 * @Version 1.0
 */
public enum ExceptionEnum {
    UNKNOWN_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    NULLExcus(44,"不存在")

    ;


    ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String msg;


    public String getMsg() {

        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


}
