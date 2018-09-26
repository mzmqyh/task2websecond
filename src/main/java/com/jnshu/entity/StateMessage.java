package com.jnshu.entity;


import java.util.HashMap;
import java.util.Map;

public enum StateMessage implements ExceptionEnums {
    
    FIND_ALL_SUCESS(1, "findAll success"),
    FIND_ALL_failed(-1, "findall failed"),
    UPDATE_SUCCESS(30, "update success"),
    UPDATE_FAIL(-30, "update failed"),
    MISSING_VALUE(31, "至少输入一个字段");

    private int code;
    private String gmessage;
    private Map<Integer,String> map = new HashMap<>();




     StateMessage(int code, String gmessage) {
        this.code = code;
        this.gmessage = gmessage;
    }


    @Override
    public int getCode() {
        return 0;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
