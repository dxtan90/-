package com.text.springboot.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class LayInfo implements Serializable {
    //出入账编号
    private Integer id;
    //来源
    private String source;
    //项目编号
    private Integer itemid;
    //数目
    private Float sum;
    //经办人
    private String ryname;
    //日期
    private String indate;
    //备注
    private String memo;

    private String SSum;

    private boolean isIn;

    private  String rynamel;

    public String getRynamel() {
        return rynamel;
    }

    public void setRynamel(String rynamel) {
        this.rynamel = rynamel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        BigDecimal big = new BigDecimal(sum);
        String s = big.toPlainString();
        this.SSum = isIn?"+"+s:"-"+s;
    }

    public String getRyname() {
        return ryname;
    }

    public void setRyname(String ryname) {
        this.ryname = ryname;
    }

    public String getIndate() {
        return indate;
    }

    public void setIndate(String indate) {
        this.indate = indate;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getSSum() {
        return SSum;
    }

    public void setSSum(String SSum) {
        this.SSum = SSum;
    }

    public boolean isIn() {
        return isIn;
    }

    public void setIn(boolean in) {
        isIn = in;
    }
}
