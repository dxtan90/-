package com.text.springboot.controller.user;

import com.text.springboot.entities.*;
import com.text.springboot.service.ArmsDataServiceImp1;
import com.text.springboot.service.DataLendServiceImp1;
import com.text.springboot.service.SyslogServiceimp1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class DataLendController {
    @Autowired
    private DataLendServiceImp1 dataLendService;
    @Autowired
    private ArmsDataServiceImp1 armsDataService;
    @Autowired
    private SyslogServiceimp1 syslogService;

    //借阅申请
    @PostMapping("/User/dataOfBorrowing/addDataLend")
    public String addDataLend(DataLend dataLend,HttpSession session){

        dataLend.setFlag(0);
        String date = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss").format(new Date());
        dataLend.setLendDate(date);
        dataLendService.addDataLend(dataLend);
        //加入日志
        User user = (User)session.getAttribute("user");
        Syslog log = new Syslog(1,"资料借阅",user.getUsersname()+" 发起资料借阅申请",user.getUsersname());
        syslogService.addSyslog(log);

        return "redirect:/User/dataOfBorrowing";
    }

    //归还申请
    @GetMapping("/User/myEquipment/bookReturn")
    public String bookreturn(int Id, HttpSession session){
        dataLendService.updateDataLend(Id,2);
        User user = (User) session.getAttribute("user");
        Integer ryid = user.getRyId();
        //加入日志
        Syslog log = new Syslog(1,"资料归还",user.getUsersname()+" 发起资料归还申请",user.getUsersname());
        syslogService.addSyslog(log);
        String url = "redirect:/User/myEquipment/lendList?ryid="+ryid;
        return url;
    }


    //跳转我的借阅面板
    @GetMapping("/User/myEquipment/lendLog")
    public String lookMyLog(@RequestParam("ryid") Integer ryid,Model model){
        List<BorrowInfo> data = dataLendService.findDataLendByRyIdByLog(ryid);
        model.addAttribute("data",data);
        return "User/MyEquipment/myBorrowLog";
    }
    //跳转我的借阅面板
    @GetMapping("/User/myEquipment/lendList")
    public String lookMyLend(@RequestParam("ryid") Integer ryid,Model model){
        List<BorrowInfo> data = dataLendService.findDataLendByRyName(ryid);
        model.addAttribute("data",data);
        return "User/MyEquipment/myBorrowList";
    }
    //跳转借阅页面
    @GetMapping("/User/dataOfBorrowing/ArmsLend")
    public String findArmsData(String DataId,Model model){
        ArmsData data=armsDataService.findArmsData(DataId);
        model.addAttribute("data",data);
        return "User/DataOfBorrowing/DataLend";
    }
    //跳转到用户借阅总界面
    @GetMapping("/User/dataOfBorrowing")
    public String UserfindallArmsData(Model model){
        List<ArmsData> data=armsDataService.findallArmsData();
        model.addAttribute("data",data);
        return "User/DataOfBorrowing/dataOfBorrowing";
    }
}
