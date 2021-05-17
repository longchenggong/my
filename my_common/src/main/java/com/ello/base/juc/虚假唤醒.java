package com.ello.base.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 虚假唤醒 {

    public static void main(String[] args) {
//        Data data = new Data();
        Lock_Data data = new Lock_Data();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.increment();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.decrement();
            }
        }, "B").start();

        /*2个线程以上会存在线程的虚假唤醒，需要把业务代码中的if改为while，【线程唤醒后会从wait地方执行，使用if时不会再判断导致】*/
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.increment();
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.decrement();
            }
        }, "D").start();
    }

}

/*等待，业务，通知*/
class Data {
    private Integer number = 0;

    public synchronized void increment() throws InterruptedException {
//        if (number != 0) { //if存在虚假唤醒
        while (number != 0) {
            //等待
            this.wait();
        }
        //业务
        number++;
        System.out.println(Thread.currentThread().getName() + "=>" + number);
        //唤醒
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
//        if (number == 0) {  //if存在虚假唤醒
        while (number == 0) {
            //等待
            this.wait();
        }
        //业务
        number--;
        System.out.println(Thread.currentThread().getName() + "=>" + number);
        //唤醒
        this.notifyAll();
    }
}


class Lock_Data{
    Lock lock=new ReentrantLock();
    Condition condition = lock.newCondition();

    private Integer number=0;

    public void increment(){

        lock.lock();

        try {
            while (number!=0){
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "=>" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement(){
        lock.lock();
        try {
            while (number==0){
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "=>" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}