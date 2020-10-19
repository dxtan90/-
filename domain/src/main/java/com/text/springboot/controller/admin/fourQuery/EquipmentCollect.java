package com.text.springboot.controller.admin.fourQuery;

import com.text.springboot.bean.Armssurplus;
import com.text.springboot.entities.Page;
import com.text.springboot.service.impl.ArmsSurplusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EquipmentCollect {
    @Autowired
    private ArmsSurplusServiceImpl surplusService;

    @GetMapping("/Admin/FourQuery/repertoryCount")
    public String AllRepInfo(@RequestParam(value = "page",required = false,defaultValue = "1")  Integer page, Model model){

        Page<Armssurplus> data = surplusService.findArmssurplusList(page);
        model.addAttribute("data",data);
        return "Admin/FourQuery/repertoryCount";
    }
}
