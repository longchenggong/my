package com.ello.base.gc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author longchenggong
 * @Description:
 * @date 2021/3/89:05
 */
public class gcTest {

    public static void main(String[] args) throws InterruptedException {
//        Thread.sleep(30000);
//        while (true){
//            loadData();
//        }

        loadData2();
    }
    private static void loadData() throws InterruptedException {
        byte[] data=null;
        for (int i = 0; i < 4; i++) {
            data=new byte[10*1024*1024];
        }
        data=null;
        byte[] data1=new byte[10*1024*1024];
        byte[] data2=new byte[10*1024*1024];

        byte[] data3=new byte[10*1024*1024];
        data3=new byte[10*1024*1024];

        Thread.sleep(1000);
    }


    private static void loadData2() throws InterruptedException {
        List<Data> dates=new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            dates.add(new Data());
        }
        Thread.sleep(1*60*60*1000);
    }

    static class Data{
    }

}
