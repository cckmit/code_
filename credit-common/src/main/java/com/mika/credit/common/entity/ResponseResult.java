package com.mika.credit.common.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mika on 2016/7/13.
 */
public class ResponseResult<T> implements Serializable {
    private boolean code = false;//运行结果,默认错误
    private String msg;//运行结果描述
    private T content;//记录集合
    private List<?> result;//返回List集合

    public boolean getCode() {
        return code;
    }

    public void setCode(boolean code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public List<?> getResult() {
        return result;
    }

    public void setResult(List<?> result) {
        this.result = result;
    }
}
