package com.text.springboot.controller.admin.fourQuery;

import com.alibaba.fastjson.JSON;
import com.text.springboot.bean.PageInfo;
import com.text.springboot.bean.SelectVo;
import com.text.springboot.money.service.Impl.LayActionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Admin/FourQuery")
public class BudgetSummary {
    @Autowired
    private LayActionImpl lay;

    @GetMapping("/budgetSummary")
    public String info(Model model){
        SelectVo vo = new SelectVo();
        vo.setInout("全部");
        vo.setTime("全部");
        vo.setPage(1);

        PageInfo infos = lay.selectInfo(vo);
        List<String> rys = lay.allRyName();
        model.addAttribute("infos",infos);
        model.addAttribute("rys",rys);
        return "Admin/FourQuery/budgetSummary";
    }

    @PostMapping("/selectInfo")
    public @ResponseBody
    PageInfo selectInfo(@RequestBody String data, Model model){

        SelectVo selectVo = JSON.parseObject(data, SelectVo.class);
        System.out.println(selectVo);
        PageInfo infos = lay.selectInfo(selectVo);
        return infos;
    }
}
