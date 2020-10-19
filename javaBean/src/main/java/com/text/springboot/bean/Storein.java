package com.text.springboot.bean;

import java.math.BigDecimal;

public class Storein {
    private Integer siid;

    private String sitype;

    private String zbid;

    private String makedate;

    private BigDecimal zbprice;

    private Integer zbnum;

    private Integer sid;

    private String rynamel;

    private String ryname;

    private String optdate;

    private String memo;

    public Integer getSiid() {
        return siid;
    }

    public void setSiid(Integer siid) {
        this.siid = siid;
    }

    public String getSitype() {
        return sitype;
    }

    public void setSitype(String sitype) {
        this.sitype = sitype;
    }

    public String getZbid() {
        return zbid;
    }

    public void setZbid(String zbid) {
        this.zbid = zbid;
    }

    public String getMakedate() {
        return makedate;
    }

    public void setMakedate(String makedate) {
        this.makedate = makedate;
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
        sb.append(", siid=").append(siid);
        sb.append(", sitype=").append(sitype);
        sb.append(", zbid=").append(zbid);
        sb.append(", makedate=").append(makedate);
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