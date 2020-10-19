package com.text.springboot.utils;

import com.text.springboot.entities.Syslog;

import java.util.List;

public class LogsToText {

    public String logsText(List<Syslog> logs){
        StringBuilder sb = new StringBuilder();
        for(Syslog log:logs){
            String body = "\t"+log.getUserName()+" 在 "+log.getLogDate()+" "+log.getLogTime()+" 进行了 "+ log.getTitle()
                    +"\n详细描述为 "+log.getBody()+"\n\n";
            sb.append(body);
        }
        return sb.toString();
    }
}
