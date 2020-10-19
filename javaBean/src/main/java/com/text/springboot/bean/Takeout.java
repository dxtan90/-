package com.text.springboot.bean;

import java.math.BigDecimal;

public class Takeout {
    private Integer toid;

    private String ttype;

    private String zbid;

    private BigDecimal zbprice;

    private Integer zbnum;

    private Integer sid;

    private String rynamel;

    private String ryname;

    private String optdate;

    private String memo;

    public Integer getToid() {
        return toid;
    }

    public void setToid(Integer toid) {
        this.toid = toid;
    }

    public String getTtype() {
        return ttype;
    }

    public void setTtype(String ttype) {
        this.ttype = ttype;
    }

    public String getZbid() {
        return zbid;
    }

    public void setZbid(String zbid) {
        this.zbid = zbid;
    }

    public BigDecimal getZbprice() {
        return zbprice;
    }

    public void setZbprice(BigDecimal zbprice) {
        this.zbprice = zbprice;
    }

    public Integer getZbnum() {
        return zbnum;
    }

    public void setZbnum(Integer zbnum) {
        this.zbnum = zbnum;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getRynamel() {
        return rynamel;
    }

    public void setRynamel(String rynamel) {
        this.rynamel = rynamel;
    }

    public String getRyname() {
        return ryname;
    }

    public void setRyname(String ryname) {
        this.ryname = ryname;
    }

    public String getOptdate() {
        return optdate;
    }

    public void setOptdate(String optdate) {
        this.optdate = optdate;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", toid=").append(toid);
        sb.append(", ttype=").append(ttype);
        sb.append(", zbid=").append(zbid);
        sb.append(", zbprice=").append(zbprice);
        sb.append(", zbnum=").append(zbnum);
        sb.append(", sid=").append(sid);
        sb.append(", rynamel=").append(rynamel);
        sb.append(", ryname=").append(ryname);
        sb.append(", optdate=").append(optdate);
        sb.append(", memo=").append(memo);
        sb.append("]");
        return sb.toString();
    }
}