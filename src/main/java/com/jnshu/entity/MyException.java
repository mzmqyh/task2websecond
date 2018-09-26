package com.jnshu.entity;

public class MyException {
    private ExceptionEnums exceptionEnums;
    public MyException(ExceptionEnums exceptionEnums){
        this.exceptionEnums = exceptionEnums;
    }
    public ExceptionEnums getExceptionEnums(){
        return exceptionEnums;
    }
}
