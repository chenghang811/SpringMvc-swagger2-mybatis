package com.org.config.TO;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

public class Msg implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -1438156651704620149L;

    /**
     * serialVersionUID
     */

    public static final String INFO = "info";

    public static final String WARN = "warn";

    public static final String ERROR = "error";

    public static final String FATAL = "fatal";

    private String code;

    private String type;

    private String content;

    public Msg(String type, String content) {
        this.type = type;
        this.content = content;
    }

    public Msg(String type, String content, String code) {
        this.type = type;
        this.content = content;
        this.code = code;
    }

    public static Msg info(String content) {
        return new Msg(INFO, content);
    }

    public static Msg warn(String content) {
        return warn(content, null);
    }

    public static Msg warn(String content, String code) {
        return new Msg(WARN, content, code);
    }

    public static Msg error(String content) {
        return error(content, null);
    }

    public static Msg error(String content, String code) {
        return new Msg(ERROR, content, code);
    }

    public static Msg fatal(String content) {
        return fatal(content, null);
    }

    public static Msg fatal(String content, String code) {
        return new Msg(FATAL, content, code);
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
