package com.text.springboot.bean;

import java.io.Serializable;

public class SelectVo  implements Serializable {

    private String inout;
    private String time;
    private String person;
    private Integer page;
    private Integer startSize;
    private Integer findCount;

    @Override
    public String toString() {
        return "SelectVo{" +
                "inout='" + inout + '\'' +
                ", time='" + time + '\'' +
                ", person='" + person + '\'' +
                ", page=" + page +
                ", startSize=" + startSize +
                ", findCount=" + findCount +
                '}';
    }

    public Integer getFindCount() {
        return findCount;
    }

    public void setFindCount(Integer findCount) {
        this.findCount = findCount;
    }

    public String getInout() {
        return inout;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getStartSize() {
        return startSize;
    }

    public void setStartSize(Integer startSize) {
        this.startSize = startSize;
    }

    public void setPage(Integer page) {
        this.page = page;
        this.startSize = (page-1)*10;
    }

    public void setInout(String inout) {
        this.inout = inout;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
}
