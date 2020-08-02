package com.ohayou.liteshop.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author liyan
 * @date 2020/7/14 下午9:53
 */
public class WebLog implements Serializable {

    /*
    操作描述
     */
    private String desc;

    /**
     * 操作用户
     */

    private String username;

    /**
     * 操作时间
     */
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime statTime;

    /**
     * 消耗时间
     */
    private String spendTime;

    /*
     * uri
     */
    private String uri;

    /**
     * url
     */
    private String url;

    /**
     * 请求方法
     */
    private String method;

    /**
     * IP地址
     */
    private String ip;

    /**
     * 请求参数
     */
    private Object Parameter;

    /**
     * 返回结果
     */
    private Object result;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getStatTime() {
        return statTime;
    }

    public void setStatTime(LocalDateTime statTime) {
        this.statTime = statTime;
    }

    public String getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(String spendTime) {
        this.spendTime = spendTime;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Object getParameter() {
        return Parameter;
    }

    public void setParameter(Object parameter) {
        Parameter = parameter;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "WebLog{" +
                "desc='" + desc + '\'' +
                ", username='" + username + '\'' +
                ", statTime=" + statTime +
                ", spendTime=" + spendTime +
                ", uri='" + uri + '\'' +
                ", url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", ip='" + ip + '\'' +
                ", Parameter=" + Parameter +
                ", result=" + result +
                '}';
    }
}
