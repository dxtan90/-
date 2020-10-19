package com.text.springboot.money.service;

import com.text.springboot.bean.*;
import com.text.springboot.utils.AddToInfo;

import java.util.List;

public interface LayAction {

    //所有
    List<LayInfo> findAllInfo();

    //只查看出账
    List<LayInfo> onlyLayOut();

    //只查看入账
    List<LayInfo> onlyLayIn();

    //所有经办人姓名
    List<String> allRyName();

    //条件查询获取信息
    PageInfo selectInfo(SelectVo vo);

    //获取最大页数
    Integer allPages();

    //入账最大页数
    Integer inPages();

    //出帐最大页数
    Integer outPages();

    //添加入账信息
    void addLayIn(Outlayin in);

    //添加出账信息
    void addLayOut(Outlaycost out);

    //通过id查询信息
    LayInfo findLayInById(Integer id);

    LayInfo findLatOutById(Integer id);

    //更新信息
    void updateInInfo(AddInfo addInfo);
    void updateOutInfo(AddInfo addInfo);

    //删除信息
    void deleteInInfo(Integer id);
    void deleteOutInfo(Integer id);
}
