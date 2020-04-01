package com.stone.activiti.processvariable;

import java.io.Serializable;
import java.util.Date;

/**
 * Holiday: 请假实体类
 *
 * @author Stone
 * @version V1.0
 * @date 2020/4/1
 **/
public class Holiday implements Serializable {
    private Integer id;
    private String username;
    private String type;
    private Date beginDate;
    private Date endDate;
    private Float num;
    private String reason;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Float getNum() {
        return num;
    }

    public void setNum(Float num) {
        this.num = num;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
