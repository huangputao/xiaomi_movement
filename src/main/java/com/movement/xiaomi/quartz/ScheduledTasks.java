package com.movement.xiaomi.quartz;


import com.movement.xiaomi.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class ScheduledTasks {

    @Autowired
    Http http;
    //

    /**
     *   秒 分钟 小时 日期 月份 年
     *   这里设置成每年1月1号00时 执行
     *   0 0 1 1 * ?  每月执行一次
     */
    //@Scheduled(cron = "0 0 16 * * ?")
    @Scheduled(cron = "${schedules.run}")
    public void removeLog(){
        System.out.println("开始执行!");
        http.mainHandler(null,null);
        System.out.println("执行结束");
    }
}
