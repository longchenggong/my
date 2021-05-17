package com.ello.base.juc;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 创建线程 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {for (int i = 0; i < 40; i++) ticket.sale();}).start();
        new Thread(() -> {for (int i = 0; i < 40; i++) ticket.sale();}).start();
        new Thread(() -> {for (int i = 0; i < 40; i++)  ticket.sale();}).start();
    }

}

class Ticket {
    private Integer number = 60;
    Lock lock=new ReentrantLock();

    public void sale() {

        if (number > 0) {
            System.out.println("卖出了第" + (number--) + "剩余" + number + "张");

        }
    }
}
