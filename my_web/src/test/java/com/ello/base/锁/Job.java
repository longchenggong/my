package com.ello.base.锁;

/**
 * @author longchenggong
 * @Description:
 * @date 2021/3/1816:02
 */
public class Job implements Runnable {
    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.println("任务开始："+Thread.currentThread().getName());
        printQueue.printJob();
        System.out.println("任务结束："+Thread.currentThread().getName());
    }


    public static void main(String[] args) {
        PrintQueue printQueue=new PrintQueue();

        Thread[] threads=new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i]=new Thread(new Job(printQueue),"Thread "+i);
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
            try {
                //为了执行顺序
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
