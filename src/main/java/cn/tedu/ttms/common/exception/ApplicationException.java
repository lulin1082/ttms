package cn.tedu.ttms.common.exception;

/**
 * @Author: lulin
 * @Date: 3/27/2019 11:02 PM
 * @Version 1.0
 */
public class ApplicationException extends RuntimeException {

    public ApplicationException() {
        super();
    }

    public ApplicationException(Throwable e) {
        super(e);
    }


    public ApplicationException(String message) {
        super(message);
    }
}

