package com.text.springboot.bean;

public class Armsinfo {
    private String zbid;

    private String zbname;

    private String zbspec;

    private String zbkind;

    private String zbunit;

    public String getZbid() {
        return zbid;
    }

    public void setZbid(String zbid) {
        this.zbid = zbid;
    }

    public String getZbname() {
        return zbname;
    }

    public void setZbname(String zbname) {
        this.zbname = zbname;
    }

    public String getZbspec() {
        return zbspec;
    }

    public void setZbspec(String zbspec) {
        this.zbspec = zbspec;
    }

    public String getZbkind() {
        return zbkind;
    }

    public void setZbkind(String zbkind) {
        this.zbkind = zbkind;
    }

    public String getZbunit() {
        return zbunit;
    }

    public void setZbunit(String zbunit) {
        this.zbunit = zbunit;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", zbid=").append(zbid);
        sb.append(", zbname=").append(zbname);
        sb.append(", zbspec=").append(zbspec);
        sb.append(", zbkind=").append(zbkind);
        sb.append(", zbunit=").append(zbunit);
        sb.append("]");
        return sb.toString();
    }
}