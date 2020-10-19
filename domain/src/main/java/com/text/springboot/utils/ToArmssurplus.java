package com.text.springboot.utils;

import com.text.springboot.bean.Armssurplus;
import com.text.springboot.bean.Storein;
import com.text.springboot.bean.Takeout;

public class ToArmssurplus {

    public Armssurplus inToArmssurplus(Storein storein){
        Armssurplus a = new Armssurplus();
        a.setMakedate(storein.getMakedate());
        a.setZbid(storein.getZbid());
        a.setMemo(storein.getMemo());
        a.setSid(storein.getSid());
        a.setZbnum(storein.getZbnum());
        a.setZbprice(storein.getZbprice());
        return  a;
    }

}
