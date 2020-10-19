package com.text.springboot.controller;

import com.text.springboot.bean.Armsperson;
import com.text.springboot.bean.Armsusers;
import com.text.springboot.entities.Departments;
import com.text.springboot.entities.Syslog;
import com.text.springboot.entities.User;
import com.text.springboot.service.ArmsDataServiceImp1;
import com.text.springboot.service.SyslogServiceimp1;
import com.text.springboot.service.UserServiceImp1;
import com.text.springboot.service.impl.ArmsPersonServiceImpl;
import com.text.springboot.service.impl.DepartmentsServiceImpl;
import com.text.springboot.utils.LogsToText;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserServiceImp1 userService;

    @Autowired
    private ArmsPersonServiceImpl armsPersonService;

    @Autowired
    private DepartmentsServiceImpl departmentsService;

    @Autowired
    private SyslogServiceimp1 syslogService;


    @PostMapping("/login")      //登录
    public String login(@RequestParam(value="username") String Usersname, @RequestParam(value="password")  String Userspwd, Model model, HttpSession session){

        SimpleHash resetPwd = new SimpleHash("md5", Userspwd, null, 2);
        User user=userService.login(Usersname,resetPwd.toString());
        System.out.println(user);
        if(user !=null){
            Armsperson person = armsPersonService.getOneArmsperson(user.getRyId());

            session.setAttribute("user",user);
            session.setAttribute("person",person);


            Syslog log = new Syslog(0,"用户登录",Usersname+"  登录系统",Usersname);
            syslogService.addSyslog(log);

            if("root".equals(user.getUserType())){
                return "redirect:/Admin";
            }else {
                return "redirect:/User";
            }
        }
        else{
            model.addAttribute("msg","密码或用户名错误");
            return "redirect:/";
        }
    }

    @PostMapping("/modifyPwd")      //修改密码
    public String modifyPwd(String Usersname,String oUserspwd,String nUserspwd,String reUserspwd){
        if(nUserspwd.equals(reUserspwd)){
            SimpleHash newPassword = new SimpleHash("md5", nUserspwd,null, 2);
            SimpleHash oldPassword = new SimpleHash("md5", oUserspwd,null, 2);

            userService.modifyPwd(Usersname,oldPassword.toString(),newPassword.toString());
            //加入日志
            Syslog log = new Syslog(0,"密码修改",Usersname+"  修改了密码",Usersname);
            syslogService.addSyslog(log);

            return "redirect:/selfInformation";
        }else{
            return "redirect:/selfInformation";
        }
    }

    @GetMapping("/resetPwd")    //重置密码
    public String resetPwd(Integer Ryid,HttpSession session){
        //设置密码
        String pwd = "111111";
        SimpleHash resetPwd = new SimpleHash("md5", pwd, null, 2);
        userService.resetPwd(Ryid,resetPwd.toString());
        //加入日志
        User user = (User)session.getAttribute("user");
        User ad = userService.findByRyId(Ryid);
        Syslog log = new Syslog(0,"密码重置",ad.getUsersname()+"的密码被重置了,重置密码为: "+pwd,user.getUsersname());
        syslogService.addSyslog(log);

        return "redirect:/Admin/basicInformation";
    }


    @GetMapping("/exit")    //退出系统
    public String exit(HttpSession session){
        User user = (User)session.getAttribute("user");
        //加入日志
        session.removeAttribute("user");
        session.removeAttribute("person");
        Syslog log = new Syslog(0,"用户登出",user.getUsersname()+" 登出系统",user.getUsersname());
        syslogService.addSyslog(log);
        return "redirect:/";
    }

    @GetMapping("/selfInformation")    //查看个人基本信息
    public String findbasicInfo(HttpSession session,Model model){
        User user = (User) session.getAttribute("user");
        List<Syslog> logs = null;

        Armsperson personInfo = armsPersonService.getOneArmsperson(user.getRyId());
        Departments dep = departmentsService.getOneDepartments(personInfo.getDepId());
        if("admin".equals(user.getUserType())){
            logs = syslogService.findPersonalSyslog(user.getUsersname());
        }else{
            logs = syslogService.findallSyslog();
        }
        String logText = new LogsToText().logsText(logs);

        model.addAttribute("data",personInfo);
        model.addAttribute("dep",dep);
        model.addAttribute("logText",logText);
        return "selfInformation";
    }
}



