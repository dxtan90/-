package com.text.springboot.money.service.Impl;

import com.text.springboot.bean.*;
import com.text.springboot.money.mapper.OutLayIn;
import com.text.springboot.money.mapper.OutLayOut;
import com.text.springboot.money.service.LayAction;
import com.text.springboot.utils.AddToInfo;
import com.text.springboot.utils.InOutToInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LayActionImpl implements LayAction {
    @Autowired
    OutLayIn in;
    @Autowired
    OutLayOut out;

    InOutToInfo util = new InOutToInfo();
    AddToInfo adu = new AddToInfo();
    @Override
    public List<LayInfo> findAllInfo() {
        List<LayInfo> layin = onlyLayIn();
        List<LayInfo> layout = onlyLayOut();
        layin.addAll(layout);
        return layin;
    }

    @Override
    public List<LayInfo> onlyLayOut() {
        List<Outlaycost> layout = out.findAllLayOut();
        return util.outToInfo(layout);
    }

    @Override
    public List<LayInfo> onlyLayIn() {
        List<Outlayin> layin = in.findAllLayIn();
        return util.inToInfo(layin);
    }

    @Override
    public List<String> allRyName() {

        List<String> inName = in.findAllRyName();
        List<String> outName = out.findAllRyName();
        inName.removeAll(outName);
        inName.addAll(outName);
        return inName;
    }

    @Override
    public PageInfo selectInfo(SelectVo vo) {
        String inout = vo.getInout();
        if("只看出账".equals(inout)){
            List<Outlaycost> layout = out.findLayOutByVo(vo);
            Integer pages = outPages();
            List<LayInfo> outs = util.outToInfo(layout);
            return util.combineInfo(outs,pages);
        }else if("只看入账".equals(inout)){
            List<Outlayin> layin = in.findLayInByVo(vo);
            Integer pages = inPages();
            List<LayInfo> ins = util.inToInfo(layin);
            return util.combineInfo(ins,pages);
        }else{
            int orderPage = vo.getPage();
            Integer ip = inPages();
            List<LayInfo> infos;
            if(orderPage<ip){
                List<Outlayin> layin = in.findLayInByVo(vo);
                infos = util.inToInfo(layin);
            }else{
                int inLess = in.findAllCount()%10;
                int startCount = (10-inLess)%10;
                if(orderPage==ip){
                    List<Outlayin> layin = in.findLayInByVo(vo);
                    infos = util.inToInfo(layin);

                    vo.setStartSize(0);
                    vo.setFindCount(startCount);
                    List<Outlaycost> layout = out.findLayOutByVo(vo);
                    infos.addAll(util.outToInfo(layout));
                }else{
                    vo.setStartSize(startCount+(orderPage-1-ip)*10);
                    vo.setFindCount(10);
                    List<Outlaycost> layout = out.findLayOutByVo(vo);
                    infos = util.outToInfo(layout);
                }
            }
            Integer pages = allPages();

            return util.combineInfo(infos,pages);
        }
    }

    @Override
    public Integer allPages() {
        Integer inc = in.findAllCount();
        Integer outc = out.findAllCount();
        return (int)Math.ceil((inc+outc)/10.0);
    }

    @Override
    public Integer inPages() {
        Integer inc = in.findAllCount();
        return (int)Math.ceil(inc/10.0);
    }

    @Override
    public Integer outPages() {
        Integer outc = out.findAllCount();
        return (int)Math.ceil(outc/10.0);

    }

    @Override
    public void addLayIn(Outlayin ins) {
        in.addLayIn(ins);
    }

    @Override
    public void addLayOut(Outlaycost outs) {
        out.addLayOut(outs);
    }

    @Override
    public LayInfo findLayInById(Integer id) {
        Outlayin layin = in.findLayInById(id);
        return util.inToInfo(layin);
    }

    @Override
    public LayInfo findLatOutById(Integer id) {
        Outlaycost layout = out.findLayOutById(id);
        return util.outToInfo(layout);
    }

    @Override
    public void updateInInfo(AddInfo addInfo) {
        Outlayin ins = adu.addToLayIn(addInfo);
        in.updateLayIn(ins);
    }

    @Override
    public void updateOutInfo(AddInfo addInfo) {
        Outlaycost outs = adu.addToOut(addInfo);
        out.updateLayOut(outs);
    }

    @Override
    public void deleteInInfo(Integer id) {
        in.deleteLayIn(id);
    }

    @Override
    public void deleteOutInfo(Integer id) {
        out.deleteLayOut(id);
    }


}
