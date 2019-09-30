package com.taosha;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread());
        thread.start();
    }

    static class MyThread implements Runnable{

        public void run() {
            System.out.println(new Date());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(new Date());
        }
    }

}

