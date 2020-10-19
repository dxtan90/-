package com.text.springboot.controller.admin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.text.springboot.bean.*;
import com.text.springboot.entities.Syslog;
import com.text.springboot.entities.User;
import com.text.springboot.money.service.Impl.LayActionImpl;
import com.text.springboot.service.SyslogServiceimp1;
import com.text.springboot.utils.AddToInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/Admin")
public class BudgetInformation {
    @Autowired
    private LayActionImpl lay;
    @Autowired
    private SyslogServiceimp1 syslogService;


    //信息总览
    @GetMapping("/budgetInformation")
    public String info(Model model){
        SelectVo vo = new SelectVo();
        vo.setInout("全部");
        vo.setPerson("全部");
        vo.setTime("全部");
        vo.setPage(1);

        PageInfo infos = lay.selectInfo(vo);
        List<String> rys = lay.allRyName();
        model.addAttribute("infos",infos);
        model.addAttribute("rys",rys);
        return "Admin/BudgetInformation/budgetInformation";
    }

    //条件查询
    @PostMapping("/budgetInformation/selectInfo")
    public @ResponseBody PageInfo selectInfo(@RequestBody String data){

        SelectVo selectVo = JSON.parseObject(data, SelectVo.class);
        System.out.println(selectVo);
        return lay.selectInfo(selectVo);
    }

    //信息添加
    @PostMapping("/budgetInformation/addInfo")
    public String addBudgetInfo(AddInfo addInfo, HttpSession session){
        AddToInfo parse = new AddToInfo();

        User root = (User)session.getAttribute("user");
        String body = null;
        if("入账".equals(addInfo.getType())){
            Outlayin in = parse.addToLayIn(addInfo);
            lay.addLayIn(in);

            body = root.getUsersname()+" 添加了一条经费入账信息，入账类型："+in.getSource();
        }else{
            Outlaycost out = parse.addToOut(addInfo);
            lay.addLayOut(out);

            body = root.getUsersname()+" 添加了一条经费出账信息，出账类型："+out.getCdescribe();
        }
        //日志信息
        Syslog log = new Syslog(2,"信息添加",body,root.getUsersname());
        syslogService.addSyslog(log);

        return "redirect:/Admin/budgetInformation";
    }

    //信息查询
    @PostMapping("/budgetInformation/findInfo")
    public @ResponseBody LayInfo findInfo(@RequestBody String data){
        JSONObject js = JSON.parseObject(data);
        Integer id = js.getInteger("id");
        String type = js.getString("type");
        if("in".equals(type)){
            return lay.findLayInById(id);
        }else{
            return lay.findLatOutById(id);
        }
    }
    //信息更新
    @PostMapping("/budgetInformation/updateInfo")
    public String updateInfo(AddInfo addInfo,HttpSession session){
        User root = (User)session.getAttribute("user");
        String body = null;

        if("入账".equals(addInfo.getType())){
            lay.updateInInfo(addInfo);
            body = root.getUsersname()+" 更新了一条经费入账信息，入账类型："+addInfo.getId();
        }else{
            lay.updateOutInfo(addInfo);
            body = root.getUsersname()+" 更新了一条经费入账信息，出账类型："+addInfo.getId();
        }
        //日志信息
        Syslog log = new Syslog(2,"信息更新",body,root.getUsersname());
        syslogService.addSyslog(log);
        return "redirect:/Admin/budgetInformation";
    }

    @GetMapping("/budgetInformation/deleteInfo")
    public String deleteInfo(@RequestParam(value = "id",required=true) Integer id,@RequestParam("type") String type,HttpSession session){
        User root = (User)session.getAttribute("user");
        String body = null;
        if("入账".equals(type)){
            lay.deleteInInfo(id);
            body = root.getUsersname()+" 删除了一条经费入账信息，入账id："+id;
        }else{
            lay.deleteOutInfo(id);
            body = root.getUsersname()+" 删除了一条经费出账信息，出账id："+id;
        }

        //日志信息
        Syslog log = new Syslog(2,"信息更新",body,root.getUsersname());
        syslogService.addSyslog(log);
        return "redirect:/Admin/budgetInformation";
    }
}
