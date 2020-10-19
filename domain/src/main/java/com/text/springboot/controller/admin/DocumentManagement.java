package com.text.springboot.controller.admin;

import com.text.springboot.entities.*;
import com.text.springboot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DocumentManagement {
    @Autowired
    private ArmsDataServiceImp1 armsDataService;
    @Autowired
    private DataLendServiceImp1 dataLend;
    @Autowired
    private DataInServiceImp1 dataIn;
    @Autowired
    private SyslogServiceimp1 syslogService;
    //添加信息请求
    @PostMapping("/Admin/documentManagement/addArmsData")
    public String addArmsData(ArmsData armsData, HttpSession session){
        armsDataService.addArmsData(armsData);
        User user = (User) session.getAttribute("user");
        dataIn.addDataInByRoot(armsData,user.getUsersname());

        //日志信息
        String body = user.getUsersname()+" 添加了一条军备资料信息，资料编号："+armsData.getDataNo();
        Syslog log = new Syslog(1,"资料添加",body,user.getUsersname());
        syslogService.addSyslog(log);

        return "redirect:/Admin/documentManagement";
    }
    //搜索信息请求
    @PostMapping("/SearchArmsData")
    public String SearchArmsData(String DataName, Model model){
        List<ArmsData> SearchArmsData=armsDataService.SearchArmsData(DataName);
        model.addAttribute("userSearchArmsData",SearchArmsData);
        return "";
    }

    //删除信息界面
    @GetMapping("/Admin/documentManagement/deleteArmsData")
    public String deleteArmsData(String DataNo, HttpSession session){
        armsDataService.deleteArmsData(DataNo);

        //日志信息
        User user = (User) session.getAttribute("user");
        String body = user.getUsersname()+" 删除了一条军备资料信息，资料编号："+DataNo;
        Syslog log = new Syslog(1,"资料删除",body,user.getUsersname());
        syslogService.addSyslog(log);

        return "redirect:/Admin/documentManagement";
    }

    //借阅信息主界面
    @GetMapping("/Admin/documentManagement")
    public String AdminfindallArmsData(Model model){
        List<ArmsData> data=armsDataService.findallArmsData();
        model.addAttribute("data",data);
        return "Admin/DocumentManagement/documentManagement";
    }

    //进入查询信息主界面
    @GetMapping("/Admin/documentManagement/findArmsData")
    public String findArmsData(String DataId,Model model){
        ArmsData data=armsDataService.findArmsData(DataId);
        model.addAttribute("data",data);
        return "Admin/DocumentManagement/documentManagement";
    }
    //进入更新界面
    @PostMapping("/Admin/documentManagement/modifyArmsData")
    public String modifyArmsData(ArmsData armsData, HttpSession session){
        armsDataService.modifyArmsData(armsData);

        //日志信息
        User user = (User) session.getAttribute("user");
        String body = user.getUsersname()+" 更新了一条军备资料信息，资料编号："+armsData.getDataNo();
        Syslog log = new Syslog(1,"资料更新",body,user.getUsersname());
        syslogService.addSyslog(log);

        return "redirect:/Admin/documentManagement";
    }
    //进入更新页面
    @GetMapping("/Admin/documentManagement/update")
    public String update(String DataId,Model model){
        ArmsData data = armsDataService.findArmsData(DataId);
        model.addAttribute("data",data);
        return "Admin/DocumentManagement/addEquipInfo";
    }
    //进入审核页面
    @GetMapping("/Admin/documentManagement/judgeInfo")
    public String judgeInfo(Model model){
        List<BorrowInfo> data = dataLend.findDataLendByNeed();
        model.addAttribute("data",data);
        return "Admin/DocumentManagement/DataLendApprove";
    }
    //通过信息
    @GetMapping("/Admin/documentManagement/pass")
    public String passJudge(@RequestParam("id") Integer id,@RequestParam("DataNo") String DataNo, HttpSession session) throws Exception {
        dataLend.updateICount(id,DataNo);

        //日志信息
        User user = (User) session.getAttribute("user");
        String body = user.getUsersname()+" 通过了一条军备资料信息，借阅编号："+id+"，资料编号： "+DataNo;
        Syslog log = new Syslog(1,"资料审核",body,user.getUsersname());
        syslogService.addSyslog(log);

        return "redirect:/Admin/documentManagement/judgeInfo";
    }
    //驳回信息
    @GetMapping("/Admin/documentManagement/refuse")
    public String refuseJudge(@RequestParam("id") Integer id, HttpSession session) {
        dataLend.refuseInfo(id);

        //日志信息
        User user = (User) session.getAttribute("user");
        String body = user.getUsersname()+" 驳回了一条军备资料信息，借阅编号："+id;
        Syslog log = new Syslog(1,"资料审核",body,user.getUsersname());
        syslogService.addSyslog(log);

        return "redirect:/Admin/documentManagement/judgeInfo";
    }
}
