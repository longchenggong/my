package com.ello.base.锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author longchenggong
 * @Description:
 * @date 2021/3/1815:55
 */
public class PrintQueue {

    //    private final Lock lock=new ReentrantLock(false);
    private final Lock lock=new ReentrantLock(false);

    public void printJob(){
        lock.lock();
        try {
            long duration= (long) (Math.random()*10000);
            System.out.println("当前线程执行中："+Thread.currentThread().getName()+" sleep："+duration);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

        lock.lock();
        try{
            Long duration = (long) (Math.random()*10000);
            System.out.printf("%s:Second PrintQueue: Printing a Job during %d seconds\n",
                    Thread.currentThread().getName(), (duration / 1000));
            Thread.sleep(duration);
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
