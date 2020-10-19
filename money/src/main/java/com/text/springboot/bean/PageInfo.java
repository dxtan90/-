package com.text.springboot.bean;

import java.io.Serializable;
import java.util.List;

public class PageInfo implements Serializable {
    private List<LayInfo> layInfo;
    private Integer pages;


    @Override
    public String toString() {
        return "pageInfo{" +
                "layInfo=" + layInfo +
                ", pages=" + pages +
                '}';
    }

    public List<LayInfo> getLayInfo() {
        return layInfo;
    }

    public void setLayInfo(List<LayInfo> layInfo) {
        this.layInfo = layInfo;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}
