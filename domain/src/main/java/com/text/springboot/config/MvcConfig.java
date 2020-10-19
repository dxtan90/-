package com.text.springboot.config;

import com.text.springboot.component.LoginHandlerInterceptor;
import com.text.springboot.component.FileUpload;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //进入登录页面
        registry.addViewController("/").setViewName("login");
        //进入管理员主界面
        registry.addViewController("/Admin").setViewName("Admin/adminMain");
        registry.addViewController("/index").setViewName("index");
        //进入查询页面
        registry.addViewController("/Admin/FourQuery").setViewName("Admin/FourQuery/statisticalQuery");
        //进入经费信息管理界面
//        registry.addViewController("/Admin/budgetInformation").setViewName("/Admin/BudgetInformation/budgetInformation");
        //进入装备资料管理界面
//        registry.addViewController("/Admin/documentManagement").setViewName("/Admin/DocumentManagement/documentManagement");
        //进入基本信息管理界面
//        registry.addViewController("/Admin/basicInformation").setViewName("/Admin/BasicInformation/basicInformation");
        //进入仓库管理界面
//        registry.addViewController("/Admin/warehouseManagement").setViewName("/Admin/WarehouseManagement/equipmentWarehouse");

        //进入添加装备信息界面
        registry.addViewController("/Admin/documentManagement/addInfo").setViewName("Admin/DocumentManagement/addEquipInfo");
        //进入用户主界面
        registry.addViewController("/User").setViewName("User/userMain");
        //进入装备借阅界面
//        registry.addViewController("/User/dataOfBorrowing").setViewName("/User/DataOfBorrowing/dataOfBorrowing");

        //进入个人信息界面
//        registry.addViewController("/selfInformation").setViewName("/selfInformation");

        //test 装备统计
//        registry.addViewController("/Admin/FourQuery/equipmentCollect").setViewName("Admin/FourQuery/equipmentCollect");
        //test 经费统计
//        registry.addViewController("/Admin/FourQuery/budgetSummary").setViewName("Admin/FourQuery/budgetSummary");
        //test 个人信息
//        registry.addViewController("/Admin/FourQuery/personalInformation").setViewName("Admin/FourQuery/personalInformation");
        //test 仓库统计
//        registry.addViewController("/Admin/FourQuery/repertoryCount").setViewName("Admin/FourQuery/repertoryCount");

        //test 仓库管理
//        registry.addViewController("/Admin/warehouseManagement/warehouseInventory").setViewName("/Admin/WarehouseManagement/warehouseInventory");
//        registry.addViewController("/Admin/warehouseManagement/equipmentRepaired").setViewName("/Admin/WarehouseManagement/equipmentRepaired");


    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).
                addPathPatterns("/**").
                excludePathPatterns("/","/login.html","/index","/login","/css/**","/js/**","/images/**","/webjars/**","/vendor/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(FileUpload.getRelativePath()+"**").addResourceLocations("file:"+FileUpload.getProfile());

    }
}