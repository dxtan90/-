package com.text.springboot;

import com.text.springboot.bean.Outlayin;
import com.text.springboot.bean.SelectVo;
import com.text.springboot.entities.Page;
import com.text.springboot.money.mapper.OutLayIn;
import com.text.springboot.money.service.Impl.LayActionImpl;
import com.text.springboot.service.impl.ArmsRepairServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTests {
    @Autowired
    OutLayIn layAction;
    @Autowired
    ArmsRepairServiceImpl armsRe;
    @Test
    void contextLoads() {
        System.out.println(layAction.findLayInById(20200001));
    }

    @Test
    void testFindAll(){
        List<Outlayin> allLayIn = layAction.findAllLayIn();
        System.out.println(allLayIn);
    }

    @Test
    void testfindByname(){
        List<Outlayin> lay = layAction.findLayInByRyName("%李%");
        System.out.println(lay);
    }

    @Test
    void addLayIn(){
        for(int i=0;i<10;i++){
            Outlayin lay = new Outlayin();
            lay.setSource("国家拨入");
            lay.setItemid(10005);
            lay.setInsum(1001010f);
            lay.setRyname("张三");
            lay.setIndate("2019/6/24");
            lay.setMemo("这是测试样例");

            layAction.addLayIn(lay);
        }


    }


}
