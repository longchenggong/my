package com.ello.juc;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author longchenggong
 * @Description:
 * @date 2021/4/215:29
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
//        线程间的竞争();
//         synchronized_关键字();
//        atomicInteger_原子类();
//        reentrantLock_重入锁();
//        reentrantReadWriteLock_读写锁();

        LockSupport_线程间通信(Thread.currentThread());
        LockSupport.park("main");
        System.out.println(count);
        System.out.println("main,run end");

    }



    static int count=0;
    public static void 线程间的竞争() throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        });

        thread1.start();
        thread2.start();
        /*等待线程执行结束*/
        Thread.sleep(1000);
        System.out.println(count);
    }


    public static void synchronized_关键字() throws InterruptedException {
        Object o = new Object();

        Thread thread = new Thread(() -> {
            synchronized (o){
                for (int i = 0; i < 10000; i++) {
                    count++;
                }
            }
        });

        Thread thread1 = new Thread(() -> {
            synchronized (o){
                for (int i = 0; i < 10000; i++) {
                    count++;
                }
            }
        });

        thread.start();
        thread1.start();
        Thread.sleep(1000);
        System.out.println(count);
    }

    public static void atomicInteger_原子类() throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();

        Thread thread = new Thread(() -> {
            atomicInteger.addAndGet(1);
        });

        Thread thread1 = new Thread(() -> {
            atomicInteger.addAndGet(1);
        });

        thread.start();
        thread1.start();

        Thread.sleep(1000);
        System.out.println(atomicInteger.get());
    }

    public static void reentrantLock_重入锁() throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock(true);

        Thread thread = new Thread(() -> {
            reentrantLock.lock();
            for (int i = 0; i < 1000; i++) {
                count++;
            }
            reentrantLock.unlock();
        });

        Thread thread1 = new Thread(() -> {
            reentrantLock.lock();
            for (int i = 0; i < 1000; i++) {
                count++;
            }
            reentrantLock.unlock();
        });

        thread.start();
        thread1.start();
        Thread.sleep(1000);
        System.out.println(count);
    }

    public static void reentrantReadWriteLock_读写锁() throws InterruptedException {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        Thread thread = new Thread(() -> {
            reentrantReadWriteLock.readLock().lock();
            System.out.println("t1 read lock");
            for (int i = 0; i < 10000; i++) {
                count++;
            }
            reentrantReadWriteLock.readLock().unlock();
            System.out.println("t1 read unlock");
        });

        Thread thread1 = new Thread(() -> {
            reentrantReadWriteLock.writeLock().lock();
            System.out.println("t2 write lock");
            for (int i = 0; i < 10000; i++) {
                count++;
            }
            reentrantReadWriteLock.writeLock().unlock();
            System.out.println("t2 write unlock");
        });

        Thread thread2 = new Thread(() -> {
            reentrantReadWriteLock.readLock().lock();
            System.out.println("t3 read lock");
            for (int i = 0; i < 10000; i++) {
                count++;
            }
            reentrantReadWriteLock.readLock().unlock();
            System.out.println("t3 read unlock");
        });


        thread.start();
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
        System.out.println(count);
    }

    /*线程间通信*/
    public static void LockSupport_线程间通信(Thread thread) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("t1,run");
            LockSupport.park("t1");
            for (int i = 0; i < 10000; i++) {
                count++;
            }
            System.out.println("t1 park "+LockSupport.getBlocker(thread).toString());
            LockSupport.unpark(thread);
            System.out.println("t1,run,end");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("t2,run");
            LockSupport.park("t2");
            for (int i = 0; i < 10000; i++) {
                count++;
            }
            System.out.println("t2 park "+LockSupport.getBlocker(t1).toString());
            LockSupport.unpark(t1);
            System.out.println("t2,run end");
        });


        Thread t3 = new Thread(() -> {
            System.out.println("t3,run");
            for (int i = 0; i < 10000; i++) {
                count++;
            }
            System.out.println("t3 park " + LockSupport.getBlocker(t2).toString());
            LockSupport.unpark(t2);
            System.out.println("t3,run end");
        });

        t1.start();
        t2.start();
        t3.start();

    }
}
