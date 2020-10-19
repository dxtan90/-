package com.text.springboot.bean;

import java.math.BigDecimal;

public class Armsrepair {
    private Integer repid;

    private String zbid;

    private String repairdate;

    private String unit;

    private String reason;

    private String status;

    private BigDecimal cost;

    private String result;

    private String ryname;

    private String rynamel;

    private String postdate;

    public Integer getRepid() {
        return repid;
    }

    public void setRepid(Integer repid) {
        this.repid = repid;
    }

    public String getZbid() {
        return zbid;
    }

    public void setZbid(String zbid) {
        this.zbid = zbid;
    }

    public String getRepairdate() {
        return repairdate;
    }

    public void setRepairdate(String repairdate) {
        this.repairdate = repairdate;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    public String getPostdate() {
        return postdate;
    }

    public void setPostdate(String postdate) {
        this.postdate = postdate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", repid=").append(repid);
        sb.append(", zbid=").append(zbid);
        sb.append(", repairdate=").append(repairdate);
        sb.append(", unit=").append(unit);
        sb.append(", reason=").append(reason);
        sb.append(", status=").append(status);
        sb.append(", cost=").append(cost);
        sb.append(", result=").append(result);
        sb.append(", ryname=").append(ryname);
        sb.append(", rynamel=").append(rynamel);
        sb.append(", postdate=").append(postdate);
        sb.append("]");
        return sb.toString();
    }
}