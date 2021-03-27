package com.ohayou.liteshop.dto;

/**
 * @author liyan
 * @date 2021/3/25 下午10:33
 */
public class ExpressResponseDTO {

    private Integer status;

    private String msg;

    private ExpressResultDTO result;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ExpressResultDTO getResult() {
        return result;
    }

    public void setResult(ExpressResultDTO result) {
        this.result = result;
    }
}
