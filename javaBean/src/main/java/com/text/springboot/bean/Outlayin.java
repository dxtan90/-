package com.text.springboot.bean;

public class Outlayin {
    private Integer id;

    private String source;

    private Integer itemid;

    private Float insum;

    private String ryname;

    private String indate;

    private String memo;

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

    public Float getInsum() {
        return insum;
    }

    public void setInsum(Float insum) {
        this.insum = insum;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", source=").append(source);
        sb.append(", itemid=").append(itemid);
        sb.append(", insum=").append(insum);
        sb.append(", ryname=").append(ryname);
        sb.append(", indate=").append(indate);
        sb.append(", memo=").append(memo);
        sb.append("]");
        return sb.toString();
    }
}