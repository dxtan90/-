package com.text.springboot.utils;

import com.text.springboot.bean.LayInfo;
import com.text.springboot.bean.Outlaycost;
import com.text.springboot.bean.Outlayin;
import com.text.springboot.bean.PageInfo;

import java.util.ArrayList;
import java.util.List;
//将入账或出账信息统一整合为经费信息。
public class InOutToInfo {


    public LayInfo inToInfo(Outlayin lay){
        LayInfo layInfo = new LayInfo();
        layInfo.setIn(true);
        layInfo.setId(lay.getId());
        layInfo.setIndate(lay.getIndate());
        layInfo.setRyname(lay.getRyname());
        layInfo.setItemid(lay.getItemid());
        layInfo.setSource(lay.getSource());
        layInfo.setMemo(lay.getMemo());
        layInfo.setSum(lay.getInsum());
        return layInfo;
    }

    public LayInfo outToInfo(Outlaycost lay){
        LayInfo layInfo = new LayInfo();
        layInfo.setIn(false);
        layInfo.setId(lay.getId());
        layInfo.setIndate(lay.getCdate());
        layInfo.setRyname(lay.getRyname());
        layInfo.setItemid(lay.getItemid());
        layInfo.setSource(lay.getCdescribe());
        layInfo.setMemo(lay.getMemo());
        layInfo.setSum(lay.getCsum());
        layInfo.setRynamel(lay.getRynamel());
        return layInfo;
    }

    public List<LayInfo> outToInfo(List<Outlaycost> outs){
        List<LayInfo> infos = new ArrayList<>();
        for(Outlaycost lay:outs){
            LayInfo layInfo = outToInfo(lay);
            infos.add(layInfo);
        }
        return infos;
    }

    public List<LayInfo> inToInfo(List<Outlayin> ins){
        List<LayInfo> infos = new ArrayList<>();
        for(Outlayin lay:ins){
            LayInfo layInfo = inToInfo(lay);
            infos.add(layInfo);
        }
        return infos;
    }

    public PageInfo combineInfo(List<LayInfo> layInfo,Integer pages){
        PageInfo pageInfo  = new PageInfo();
        pageInfo.setLayInfo(layInfo);
        pageInfo.setPages(pages);
        return pageInfo;
    }
}
