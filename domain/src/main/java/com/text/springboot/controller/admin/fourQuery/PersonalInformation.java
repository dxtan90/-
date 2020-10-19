package com.text.springboot.controller.admin.fourQuery;

import com.text.springboot.bean.Armsperson;
import com.text.springboot.service.impl.ArmsPersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PersonalInformation {

    @Autowired
    private ArmsPersonServiceImpl personService;

    @GetMapping("/Admin/FourQuery/personalInformation")
    public String lookSelfInfo(Model model){
        List<Armsperson> data = personService.getAllArmsperson();
        model.addAttribute("data",data);
        return "Admin/FourQuery/personalInformation";
    }
}
