package com.tosit.yulong.web.Utils;

import com.tosit.yulong.web.daoImp.DaoImpl;
import com.tosit.yulong.web.entity.Ticket;

import java.util.List;

/**
 * Created by zx on 2016/9/29.
 */
public class JSUtil {
    public int getTotal(){
        int total =0;
        //计算现有票务总价
        List<Ticket> tickets = new DaoImpl().queryCarts();
        int price =0;
        int number =0;
        for (Ticket tEach:tickets ) {
            price=tEach.getT_price();
            number=tEach.getT_number();
            total +=price*number;
        }
        return  total;
    }
}
