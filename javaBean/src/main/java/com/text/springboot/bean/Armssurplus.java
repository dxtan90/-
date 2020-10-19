package com.text.springboot.bean;

import java.math.BigDecimal;

public class Armssurplus {
    private Integer spid;

    private String zbid;

    private BigDecimal zbprice;

    private Integer zbnum;

    private String makedate;

    private Integer sid;

    private String memo;

    public Integer getSpid() {
        return spid;
    }

    public void setSpid(Integer spid) {
        this.spid = spid;
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

    public String getMakedate() {
        return makedate;
    }

    public void setMakedate(String makedate) {
        this.makedate = makedate;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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
        sb.append(", spid=").append(spid);
        sb.append(", zbid=").append(zbid);
        sb.append(", zbprice=").append(zbprice);
        sb.append(", zbnum=").append(zbnum);
        sb.append(", makedate=").append(makedate);
        sb.append(", sid=").append(sid);
        sb.append(", memo=").append(memo);
        sb.append("]");
        return sb.toString();
    }
}