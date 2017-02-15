package com.org.config.TO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

public class AjaxResult<T> implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(AjaxResult.class);

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 6564457566699517560L;

    private T result;

    private List<Msg> msgs = new ArrayList<>();

    private Boolean success;

    private List<String> scripts = new ArrayList<>(8);

    private String cause;

    public AjaxResult() {
        super();
    }

    public AjaxResult(T result) {
        this.result = result;
        this.success = true;
    }

    public AjaxResult(Msg msg, Boolean success) {
        this.msgs.add(msg);
        this.success = success;
    }

    public AjaxResult(Msg msg) {
        this.msgs.add(msg);
    }

    public AjaxResult<T> result(T result) {
        this.result = result;
        return this;
    }

    public AjaxResult<T> success() {
        this.success = true;
        return this;
    }

    public AjaxResult<T> fail() {
        this.success = false;
        return this;
    }

    public AjaxResult<T> msg(Msg msg) {
        return this.addMsg(msg);
    }

    private AjaxResult<T> addMsg(Msg msg) {
        this.msgs.add(msg);
        return this;
    }

    public AjaxResult<T> execute(String script, Object... paras) {
        this.scripts.add(";(function(paras){" + "try{" + script + "}catch(e){}" + "})(" + (paras == null ? null : JSON.toJSONString(paras)) + ");");
        return this;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public List<Msg> getMsgs() {
        return this.msgs;
    }

    public void setMsgs(List<Msg> msgs) {
        this.msgs = msgs;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<String> getScripts() {
        return this.scripts;
    }

    public void setScripts(List<String> scripts) {
        this.scripts = scripts;
    }

    public String getCause() {
        return this.cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
