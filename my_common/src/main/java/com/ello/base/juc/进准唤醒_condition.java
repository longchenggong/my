package com.ello.base.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 进准唤醒_condition {
    public static void main(String[] args) {
        printMsg printMsg = new printMsg();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
            printMsg.printA();
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                printMsg.printB();
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                printMsg.printC();
            }
        },"C").start();
    }
}

class printMsg {

    /*等待，业务，通知*/
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    private Integer number = 1;


    public void printA() {
        lock.lock();
        try {
            while (number != 1) {
                condition1.await();
            }
            number=2;
            System.out.println(Thread.currentThread().getName() + "=>AAAAA");
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            while (number != 2) {
                condition2.await();
            }
            number=0;
            System.out.println(Thread.currentThread().getName() + "=>BBB");
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            while (number!=0){
                condition3.await();
            }
            number=1;
            System.out.println(Thread.currentThread().getName() + "=>CCC");
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
