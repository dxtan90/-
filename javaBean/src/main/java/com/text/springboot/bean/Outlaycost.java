package com.text.springboot.bean;

public class Outlaycost {
    private Integer id;

    private String cdate;

    private Integer itemid;

    private Float csum;

    private String ryname;

    private String rynamel;

    private String cdescribe;

    private String memo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Float getCsum() {
        return csum;
    }

    public void setCsum(Float csum) {
        this.csum = csum;
    }

    public String getRyname() {
        return ryname;
    }

    public void setRyname(String ryname) {
        this.ryname = ryname;
    }

    public String getRynamel() {
        return rynamel;
    }

    public void setRynamel(String rynamel) {
        this.rynamel = rynamel;
    }

    public String getCdescribe() {
        return cdescribe;
    }

    public void setCdescribe(String cdescribe) {
        this.cdescribe = cdescribe;
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
        sb.append(", id=").append(id);
        sb.append(", cdate=").append(cdate);
        sb.append(", itemid=").append(itemid);
        sb.append(", csum=").append(csum);
        sb.append(", ryname=").append(ryname);
        sb.append(", rynamel=").append(rynamel);
        sb.append(", cdescribe=").append(cdescribe);
        sb.append(", memo=").append(memo);
        sb.append("]");
        return sb.toString();
    }
}