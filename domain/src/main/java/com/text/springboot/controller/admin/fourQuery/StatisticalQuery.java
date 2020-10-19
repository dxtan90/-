package com.text.springboot.controller.admin.fourQuery;

import com.text.springboot.bean.Storein;
import com.text.springboot.bean.Takeout;
import com.text.springboot.entities.Page;
import com.text.springboot.service.impl.StoreinAndTakeoutServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StatisticalQuery {
    @Autowired
    private StoreinAndTakeoutServiceImpl storeinAndTakeoutService;

    @GetMapping("/Admin/FourQuery/equipmentCollect")
    public String store(@RequestParam(value = "page",required = false,defaultValue = "1") Integer page, Model model){

        Page<Storein> datain = storeinAndTakeoutService.findAllStorein(page);
        Page<Takeout> dataout = storeinAndTakeoutService.findAllTakeout(page);

        model.addAttribute("in",datain);
        model.addAttribute("out",dataout);
        return "Admin/FourQuery/equipmentCollect";
    }
}
