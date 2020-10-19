package com.text.springboot.bean;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class AddInfo implements Serializable {
    //来源
    @NotNull
    private String source;
    //项目编号
    @NotNull
    private Integer itemid;
    //数目
    @NotNull
    private Float sum;
    //经办人
    @NotNull
    private String ryname;
    //日期
    @NotNull
    private String date;
    //批准人
    private String rynamel;
    //备注
    @NotNull
    private String memo;
    //类型
    @NotNull
    private String type;
    //id
    private Integer id;

    @Override
    public String toString() {
        return "AddInfo{" +
                "source='" + source + '\'' +
                ", itemid=" + itemid +
                ", sum=" + sum +
                ", ryname='" + ryname + '\'' +
                ", date='" + date + '\'' +
                ", rynamel='" + rynamel + '\'' +
                ", memo='" + memo + '\'' +
                ", type='" + type + '\'' +
                ", id=" + id +
                '}';
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Float getSum() {
        return sum;
    }

    public void setSum(Float sum) {
        this.sum = sum;
    }

    public String getRyname() {
        return ryname;
    }

    public void setRyname(String ryname) {
        this.ryname = ryname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRynamel() {
        return rynamel;
    }

    public void setRynamel(String rynamel) {
        this.rynamel = rynamel;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
