package com.example.pfm.Exception;
public class BusinessException extends RuntimeException{

    private String code;

    public BusinessException (String code) {
        super(code);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 不写入堆栈信息，提高性能
     */
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}