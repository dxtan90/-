package com.text.springboot.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Random;

@Component
@ConfigurationProperties(prefix = "upload")//读取配置文件yml,以upload 开头的属性值
public class FileUpload {

    private static String profile;//绝对路径
    private static String relativePath;//相对路径

    public static String getRelativePath() {
        return relativePath;
    }

    public  void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    public static String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }


    //1，文件上传后新命名规则
    public  static String getRandomFileName() {
        // 生成随机文件名：当前年月日时分秒+五位随机数（为了在实际项目中防止文件同名而进行的处理）
        // 获取随机数
        final Random r = new Random();
        int rannum = (int) (r.nextDouble() * (99999 - 10000 + 1)) + 10000;
        // 当前时间
        long currentTimeMillis = System.currentTimeMillis();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String nowTime =format.format(currentTimeMillis);
        return nowTime + rannum;

    }
    //2.存储路径(新放路径是否存在)
    public static File getPath(){
        File file=new File(FileUpload.profile);//这里是直接调用配置文件中的值
        if(!file.exists()){//如果文件夹不存在
            file.mkdirs();//创建文件夹
        }
        return file;
    }

    //3.上传图片动作（并返回相对路径存储在数据库中）
    public static String upload(MultipartFile file){
        String str=file.getOriginalFilename();//原始图片名称
        String lastName=str.substring(str.indexOf("."),str.length());//获取尾缀 如.png .jpg
        String fileName = FileUpload.getRandomFileName();//生成的新文件名
        String filePath=FileUpload.getPath().getPath();//图片存放的硬盘位置
        String relativeAdress=FileUpload.relativePath+ fileName+lastName;//相对路径
        File dest = new File(filePath +'\\'+ fileName+lastName);
        try {
            file.transferTo(dest);//上传图片
            System.out.println("=====文件上传成功！");
        } catch (IOException e) {
            System.out.println("=====上传失败！"+e.toString());
        }
        return relativeAdress;
    }

}