package com.example.domain;

import java.util.Date;

/**
 * Created by tom on 2016/5/19.
 */
public class Log extends IdEntity {
    private Long userid;//管理员id
    private Date createdate;//日期
    private String content;//日志内容
    private String operation;//操作(主要是"添加"、"修改"、"删除")

    public Log(Long userid, Date createdate, String content, String operation) {
        this.userid = userid;
        this.createdate = createdate;
        this.content = content;
        this.operation = operation;
    }

    public Log() {

    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
