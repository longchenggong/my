package com.ello.base.锁;

/**
 * @author longchenggong
 * @Description:
 * @date 2021/3/1811:26
 */
public class Test {

    public void sync(){
        synchronized(this){
            int aa=10;
            System.out.println(aa);
        }

    }

    public synchronized void sync1(){
        int aa=10;
        System.out.println(aa);
    }
}
