package com.text.springboot.utils;

import com.text.springboot.bean.AddInfo;
import com.text.springboot.bean.Outlaycost;
import com.text.springboot.bean.Outlayin;
//将添加信息整合为入账或出账信息
public class AddToInfo {

    public Outlayin addToLayIn(AddInfo add){
        Outlayin in = new Outlayin();
        in.setSource(add.getSource());
        in.setRyname(add.getRyname());
        in.setMemo(add.getMemo());
        in.setIndate(add.getDate());
        in.setInsum(add.getSum());
        in.setItemid(add.getItemid());
        in.setId(add.getId());
        return in;
    }

    public Outlaycost addToOut(AddInfo add){
        Outlaycost out = new Outlaycost();

        out.setCdate(add.getDate());
        out.setCdescribe(add.getSource());
        out.setCsum(add.getSum());
        out.setItemid(add.getItemid());
        out.setMemo(add.getMemo());
        out.setRyname(add.getRyname());
        out.setRynamel(add.getRynamel());
        out.setId(add.getId());
        return out;
    }
}
