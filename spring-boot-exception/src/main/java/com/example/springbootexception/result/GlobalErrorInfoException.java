package com.example.springbootexception.result;

/**
 * 统一错误码异常
 *
 * Created by tomlxq on 14/03/2017.
 */
public class GlobalErrorInfoException extends Exception {

    private ErrorInfoInterface errorInfo;

    public GlobalErrorInfoException (ErrorInfoInterface errorInfo) {
        this.errorInfo = errorInfo;
    }

    public ErrorInfoInterface getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ErrorInfoInterface errorInfo) {
        this.errorInfo = errorInfo;
    }
}