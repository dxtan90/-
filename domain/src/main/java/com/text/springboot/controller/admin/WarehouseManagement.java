package com.text.springboot.controller.admin;

import com.text.springboot.bean.*;
import com.text.springboot.entities.Page;
import com.text.springboot.entities.SurAll;
import com.text.springboot.entities.Syslog;
import com.text.springboot.entities.User;
import com.text.springboot.service.SyslogServiceimp1;
import com.text.springboot.service.impl.ArmsRepairServiceImpl;
import com.text.springboot.service.impl.ArmsSurplusServiceImpl;
import com.text.springboot.service.impl.StorehouseServiceImpl;
import com.text.springboot.service.impl.StoreinAndTakeoutServiceImpl;
import com.text.springboot.utils.ToArmssurplus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/Admin/warehouseManagement")
public class WarehouseManagement {

    @Autowired
    private ArmsRepairServiceImpl armsRepairService;
    @Autowired
    private StorehouseServiceImpl storehouseService;
    @Autowired
    private SyslogServiceimp1 syslogService;
    @Autowired
    private ArmsSurplusServiceImpl surplusService;
    @Autowired
    private StoreinAndTakeoutServiceImpl storeinAndTakeoutService;

    //跳转到装备仓库管理界面
    @GetMapping("")
    public String toRepository(@RequestParam(value="page",required = false,defaultValue = "1") Integer page, Model model){
        Page<Storehouse> data = storehouseService.findStorehouseList(page);
        model.addAttribute("data",data);
        return "Admin/WarehouseManagement/equipmentWarehouse";
    }
    //跳转到添加信息界面
    @GetMapping("/RepAdd")
    public String toRepAdd(){
        return "Admin/WarehouseManagement/WarehouseReset";
    }

    //提交添加请求
    @PostMapping("/RepAdd")
    public String toRepAddPost(HttpSession session,Storehouse storehouse){
        storehouseService.insertStorehouse(storehouse);

        //日志信息
        User user = (User)session.getAttribute("user");
        String body = user.getUsersname()+" 添加了一条仓库信息信息，仓库名称："+storehouse.getSname();
        Syslog log = new Syslog(2,"信息添加",body,user.getUsersname());
        syslogService.addSyslog(log);

        return "redirect:/Admin/warehouseManagement";
    }

    //跳转到更新信息界面
    @GetMapping("/RepUpdate")
    public String toRepUpdate(@RequestParam("id") Integer id,Model model){
        Storehouse data = storehouseService.findStorehouseById(id);
        System.out.println(data);
        model.addAttribute("data",data);
        return "Admin/WarehouseManagement/WarehouseReset";
    }

    //提交更新请求
    @PostMapping("/RepUpdate")
    public String toRepUpdatePost(HttpSession session,Storehouse storehouse){
        storehouseService.updateStorehouseById(storehouse);

        //日志信息
        User user = (User)session.getAttribute("user");
        String body = user.getUsersname()+" 更新了一条仓库信息信息，仓库id："+storehouse.getSid();
        Syslog log = new Syslog(2,"信息更新",body,user.getUsersname());
        syslogService.addSyslog(log);

        return "redirect:/Admin/warehouseManagement";
    }

    //删除仓库信息
    @GetMapping("/RepDel")
    public String toReDel(@RequestParam("id")  Integer id,HttpSession session){
        storehouseService.deleteStorehouseById(id);

        //日志信息
        User user = (User)session.getAttribute("user");
        String body = user.getUsersname()+" 删除了一条仓库信息信息，仓库Id："+id;
        Syslog log = new Syslog(2,"信息删除",body,user.getUsersname());
        syslogService.addSyslog(log);

        return "redirect:/Admin/warehouseManagement";
    }
    //跳转到装备维修界面
    @GetMapping("/equipmentRepaired")
    public String equipRepaired(@RequestParam(value = "page",required = false,defaultValue = "1") Integer page, Model model){
        Page<Armsrepair> data = armsRepairService.findAllArmsrepair(page);
        model.addAttribute("data",data);
        return "Admin/WarehouseManagement/equipmentRepaired";
    }
    //跳转到查询的详情界面
    @GetMapping("/find")
    public String findInfo(@RequestParam("id") Integer id,Model model){
        Armsrepair data = armsRepairService.findArmsrepairById(id);
        model.addAttribute("data",data);
        return "Admin/WarehouseManagement/ArmsRepairInfoView";
    }
    //跳转到添加信息界面
    @GetMapping("/add")
    public String AddInfo(){
        return "Admin/WarehouseManagement/ArmsRepairInfoAdd";
    }

    //提交添加信息
    @PostMapping("/add")
    public String postAddInfo(Armsrepair repair, HttpSession session){
        armsRepairService.addArmsrepair(repair);

        //日志信息
        User root = (User)session.getAttribute("user");
        String body = root.getUsersname()+" 添加了一条装备维修信息，维修军备编号："+repair.getZbid();
        Syslog log = new Syslog(2,"信息添加",body,root.getUsersname());
        syslogService.addSyslog(log);

        return "redirect:/Admin/warehouseManagement/equipmentRepaired";
    }

    //删除信息请求
    @GetMapping("/delete")
    public String deleteInfo(@RequestParam("id") Integer RepId, HttpSession session){
        armsRepairService.deleteArmsrepair(RepId);

        //日志信息
        User root = (User)session.getAttribute("user");
        String body = root.getUsersname()+" 删除了一条装备维修信息，维修编号："+RepId;
        Syslog log = new Syslog(2,"信息删除",body,root.getUsersname());
        syslogService.addSyslog(log);

        return "redirect:Admin/warehouseManagement/equipmentRepaired";
    }
    //跳转到更新界面
    @GetMapping("/update")
    public String updateInfo(@RequestParam("id") Integer id,Model model){
        Armsrepair data = armsRepairService.findArmsrepairById(id);
        model.addAttribute("data",data);
        return "Admin/WarehouseManagement/ArmsRepairInfoAdd";
    }

    //提交更新信息
    @PostMapping("/update")
    public String postUpdateInfo(Armsrepair repair,HttpSession session){
        armsRepairService.updateArmsrepair(repair);

        //日志信息
        User root = (User)session.getAttribute("user");
        String body = root.getUsersname()+" 更新了一条装备维修信息，维修编号："+repair.getRepid();
        Syslog log = new Syslog(2,"信息更新",body,root.getUsersname());
        syslogService.addSyslog(log);

        return "redirect:/Admin/warehouseManagement/equipmentRepaired";
    }


    //进入对应的仓库
    @GetMapping("/warehouseInventory")
    public String toHouse(@RequestParam("sid") Integer sid,@RequestParam(value = "page",required = false,defaultValue = "1") Integer page ,Model model){
        Page<SurAll> data = surplusService.findArmssurplusBySid(sid, page);
        model.addAttribute("data",data);
        model.addAttribute("sid",sid);
        return "Admin/WarehouseManagement/warehouseInventory";
    }

    //进入装备入库界面
    @GetMapping("/storeIn")
    public String inStoreIn(@RequestParam("sid") Integer sid,Model model){
        model.addAttribute("dir","in");
        model.addAttribute("sid",sid);
        return "Admin/WarehouseManagement/equipmentStoreIn";
    }

    //提交装备入库请求
    @PostMapping("/storeIn")
    public String postStoreIn(Storein storein,HttpSession session){
        storeinAndTakeoutService.addStorein(storein);

        //更新库存信息
        Armssurplus arms = surplusService.isExist(storein.getZbid(), storein.getSid());
        if(null==arms){
            surplusService.insertArmssurplus(new ToArmssurplus().inToArmssurplus(storein));
        }else{
            arms.setZbnum(arms.getZbnum()+storein.getZbnum());
            surplusService.updateArmssurplusById(arms);
        }

        //日志信息
        User root = (User)session.getAttribute("user");
        String body = root.getUsersname()+" 添加了一条装备入库信息，入库装备："+storein.getZbid();
        Syslog log = new Syslog(2,"信息添加",body,root.getUsersname());
        syslogService.addSyslog(log);

        return "redirect:/Admin/warehouseManagement/warehouseInventory?sid="+storein.getSid();
    }

    //进入装备调拨界面
    @GetMapping("/takeOut")
    public String inStoreOut(@RequestParam("sid") Integer sid, Model model){
        model.addAttribute("dir","out");
        model.addAttribute("sid",sid);
        return "Admin/WarehouseManagement/equipmentStoreIn";
    }

    //提交装备调拨请求
    @PostMapping("/takeOut")
    public String postStoreOut(Takeout out, HttpSession session){
        storeinAndTakeoutService.addTakeout(out);


        //更新库存信息
        Armssurplus arms = surplusService.isExist(out.getZbid(), out.getSid());
        arms.setZbnum(arms.getZbnum()-out.getZbnum());
        surplusService.updateArmssurplusById(arms);


        //日志信息
        User root = (User)session.getAttribute("user");
        String body = root.getUsersname()+" 添加了一条装备调拨信息，入库装备："+out.getZbid();
        Syslog log = new Syslog(2,"信息添加",body,root.getUsersname());
        syslogService.addSyslog(log);

        return "redirect:/Admin/warehouseManagement/warehouseInventory?sid="+out.getSid();
    }
}
