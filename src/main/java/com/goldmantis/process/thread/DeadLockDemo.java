package com.goldmantis.process.thread;

/**
 * 死锁场景模拟
 */
public class DeadLockDemo {
    private static String A = "A";
    private static String B = "B";

    private void deadLock() {
        System.out.println("3");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        Thread.currentThread().sleep(2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    synchronized (B){
                        System.out.println("1");
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B){
                    synchronized (A){
                        System.out.println("2");
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }
}
