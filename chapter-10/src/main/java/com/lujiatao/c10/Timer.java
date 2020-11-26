package com.lujiatao.c10;

public class Timer {

    public static final Timer TIMER = new Timer();
    private long startTime;

    private Timer() {
    }

    public void setStartTime() {
        this.startTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return System.currentTimeMillis() - startTime;
    }

}
