package com.text.springboot.controller.admin;

import com.text.springboot.bean.Armsinfo;
import com.text.springboot.bean.Armsperson;
import com.text.springboot.entities.Departments;
import com.text.springboot.entities.Syslog;
import com.text.springboot.entities.User;
import com.text.springboot.service.SyslogServiceimp1;
import com.text.springboot.service.UserServiceImp1;
import com.text.springboot.service.impl.ArmsInfoServiceImpl;
import com.text.springboot.service.impl.ArmsPersonServiceImpl;
import com.text.springboot.service.impl.DepartmentsServiceImpl;
import com.text.springboot.component.FileUpload;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class BasicInformation {

    @Autowired
    private ArmsPersonServiceImpl armsPersonService;
    @Autowired
    private DepartmentsServiceImpl departmentsService;
    @Autowired
    private UserServiceImp1 userService;
    @Autowired
    private ArmsInfoServiceImpl armsInfoService;
    @Autowired
    private SyslogServiceimp1 syslogService;

    @GetMapping("/Admin/basicInformation")
    public String basicInfo(Model model){
        List<Departments> data = departmentsService.getAllDepartments();
        List<Armsinfo> eqs = armsInfoService.getAllArmsinfo();
        model.addAttribute("data",data);
        model.addAttribute("eqs",eqs);
        return "Admin/BasicInformation/basicInformation";
    }
    //跳转到添加用户界面
    @GetMapping("/Admin/basicInformation/addUser")
    public String addUser(){
        return "Admin/BasicInformation/addUser";
    }
    //添加用户
    @PostMapping("/Admin/basicInformation/insert")
    public String insertUserPersonInformation(User user, Armsperson person, @RequestParam("file") MultipartFile file, HttpSession session){

        if (!StringUtils.isEmpty(file.getOriginalFilename())) {
            person.setPhoto(FileUpload.upload(file));
        }
        armsPersonService.insertArmsperson(person);
        user.setRyId(person.getRyid());
        SimpleHash resetPwd = new SimpleHash("md5", user.getUserspwd(), null, 2);
        user.setUserspwd(resetPwd.toString());
        userService.addUser(user);


        //日志信息
        User root = (User)session.getAttribute("user");
        String body = root.getUsersname()+" 添加了一条用户信息，添加用户： "+user.getUsersname()+" 初始密码：" +user.getUserspwd()
                        +"用户类型: "+user.getUserType()+"人员姓名： "+person.getRyname();
        Syslog log = new Syslog(0,"用户添加",body,root.getUsersname());
        syslogService.addSyslog(log);

        return "redirect:/Admin/basicInformation";
    }
    //删除用户
    @GetMapping("/Admin/basicInformation/delete")
    public String deleteUserPersonInfo(Integer ryid,HttpSession session){
        User user = userService.findByRyId(ryid);
        armsPersonService.deleteArmsperson(ryid);
        userService.deleteUser(ryid);

        //日志信息
        User root = (User)session.getAttribute("user");
        String body = root.getUsersname()+" 删除了一条用户信息，删除用户： "+user.getUsersname()+"用户类型: "+user.getUserType();
        Syslog log = new Syslog(0,"用户删除",body,root.getUsersname());
        syslogService.addSyslog(log);

        return  "redirect:/Admin/basicInformation";
    }
    //跳转修改界面
    @GetMapping("/Admin/basicInformation/changeZbidInfo")
    public String changeInfoZid(String zbid,Model model){
        Armsinfo data = armsInfoService.getOneArmsinfo(zbid);
        model.addAttribute("data",data);
        return "Admin/BasicInformation/changeInfo";
    }
    //提交修改请求
    @PostMapping("/Admin/basicInformation/changeZbidInfo")
    public String changeInfo(Armsinfo arms,HttpSession session){
        armsInfoService.updateArmsinfo(arms);

        //日志信息
        User root = (User)session.getAttribute("user");
        String body = root.getUsersname()+" 更新了一条军备信息，军备id: "+arms.getZbid();
        Syslog log = new Syslog(2,"信息更新",body,root.getUsersname());
        syslogService.addSyslog(log);

        return "redirect:/Admin/basicInformation";
    }
    //提交删除装备
    @GetMapping("/Admin/basicInformation/deleteZbidInfo")
    public String deleteInfoZid(String zbid,HttpSession session){
        armsInfoService.deleteArmsinfo(zbid);

        //日志信息
        User root = (User)session.getAttribute("user");
        String body = root.getUsersname()+" 删除了一条军备信息，军备id: "+zbid;
        Syslog log = new Syslog(2,"信息删除",body,root.getUsersname());
        syslogService.addSyslog(log);

        return "redirect:/Admin/basicInformation";
    }
    //跳转到新建装备界面
    @GetMapping("/Admin/basicInformation/addEquip")
    public String addEquip(){
        return "Admin/BasicInformation/addEquipInfo";
    }
    //提交添加请求
    @PostMapping("/Admin/basicInformation/addEquip")
    public String postAddEquip(Armsinfo armsinfo,HttpSession session){
        armsInfoService.insertArmsinfo(armsinfo);

        //日志信息
        User root = (User)session.getAttribute("user");
        String body = root.getUsersname()+" 添加了一条军备信息，军备名称："+armsinfo.getZbname();
        Syslog log = new Syslog(2,"信息添加",body,root.getUsersname());
        syslogService.addSyslog(log);

        return "redirect:/Admin/basicInformation";
    }

    //查看个人详细信息
    @GetMapping("/Admin/basicInformation/find")
    public String lookInfo(@RequestParam("ryid") Integer ryid,Model model)
    {
        Armsperson person = armsPersonService.getOneArmsperson(ryid);
        model.addAttribute("person",person);
        return  "Admin/BasicInformation/UserInfoView";
    }
}
