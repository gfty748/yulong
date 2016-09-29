package com.tosit.yulong.web.Utils;

/**
 * Created by Administrator on 2016/9/30 0030.
 */
public class DDHUtil {
    public String getDDH(String name){
        String ddh  = "YLXS";
        String header = new ChToEnUtil().getPinYinHeadChar(name);
        ddh+=header;
        String time = new TimeUtil().getTime();
        ddh+=time;
        return  ddh;
    }

    public static void main(String[] args) {
        String ddh = new DDHUtil().getDDH("王东东");
        System.out.println(ddh);
    }
}
