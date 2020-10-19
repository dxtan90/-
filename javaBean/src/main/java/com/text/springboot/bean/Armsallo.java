package com.text.springboot.bean;

import java.math.BigDecimal;

public class Armsallo {
    private Integer id;

    private String zbid;

    private Integer anum;

    private BigDecimal zbprice;

    private String outdep;

    private String indep;

    private String atype;

    private String person;

    private String usefuldate;

    private String rynamel;

    private String ryname;

    private String adate;

    private String memo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZbid() {
        return zbid;
    }

    public void setZbid(String zbid) {
        this.zbid = zbid;
    }

    public Integer getAnum() {
        return anum;
    }

    public void setAnum(Integer anum) {
        this.anum = anum;
    }

    public BigDecimal getZbprice() {
        return zbprice;
    }

    public void setZbprice(BigDecimal zbprice) {
        this.zbprice = zbprice;
    }

    public String getOutdep() {
        return outdep;
    }

    public void setOutdep(String outdep) {
        this.outdep = outdep;
    }

    public String getIndep() {
        return indep;
    }

    public void setIndep(String indep) {
        this.indep = indep;
    }

    public String getAtype() {
        return atype;
    }

    public void setAtype(String atype) {
        this.atype = atype;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getUsefuldate() {
        return usefuldate;
    }

    public void setUsefuldate(String usefuldate) {
        this.usefuldate = usefuldate;
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

    public String getAdate() {
        return adate;
    }

    public void setAdate(String adate) {
        this.adate = adate;
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
        sb.append(", zbid=").append(zbid);
        sb.append(", anum=").append(anum);
        sb.append(", zbprice=").append(zbprice);
        sb.append(", outdep=").append(outdep);
        sb.append(", indep=").append(indep);
        sb.append(", atype=").append(atype);
        sb.append(", person=").append(person);
        sb.append(", usefuldate=").append(usefuldate);
        sb.append(", rynamel=").append(rynamel);
        sb.append(", ryname=").append(ryname);
        sb.append(", adate=").append(adate);
        sb.append(", memo=").append(memo);
        sb.append("]");
        return sb.toString();
    }
}