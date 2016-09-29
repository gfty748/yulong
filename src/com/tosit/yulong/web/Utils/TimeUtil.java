package com.tosit.yulong.web.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

/**
 * Created by Administrator on 2016/9/30 0030.
 */
public class TimeUtil {
    /**
     * 获取当前的时间
     * @return
     */
    public String getTime(){
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = df.format(date);
        time = time.substring(time.length()-12);
        return time;
    }

}
