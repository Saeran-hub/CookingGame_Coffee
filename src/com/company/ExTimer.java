package com.company;




public class ExTimer extends Thread {
    private String TAG = "ExTimer";
    private CallBack callBack;
    //任务开始的时间
    public long startTime;
    //延迟多久执行
    public long delay;
    //判断这个线程是否还执行回调
    private boolean stillRun = true;
    private ExTimer newTask;

    public ExTimer() {

    }
    @Override
    public void run() {
        try {
            startTime = System.currentTimeMillis();
            Thread.sleep(delay);
            if (stillRun) {
                callBack.run();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 模仿Timer的使用方法，因为之前用的是Timer
     * @param callBack
     * @param delay
     */
    public void schedule(CallBack callBack, long delay) {
        this.callBack = callBack;
        this.delay = delay;
        start();
    }

    /**
     * 增加延迟时间
     * @param addDelay
     */
    public void addDelay(long addDelay) {

        //计算这个计时器原来已经走了多久
        long cha = System.currentTimeMillis() - startTime;

        //计算这个计时器原来剩下的时间
        long lastDelay = this.delay - cha;

        if (lastDelay > 0) {
            //新的计时器延迟时间，剩下的+新增的
            this.delay = lastDelay + addDelay;
            if (newTask != null) {
                newTask.interrupt();
            }
            newTask = new ExTimer();
            newTask.schedule(callBack, delay);
            startTime = System.currentTimeMillis();
            stillRun = false;
        }
    }

    /**
     * 取消计时器
     */
    public void cancel() {
        if (newTask!=null){
            newTask.interrupt();
            newTask = null;
        }
        stillRun = false;
        interrupt();
    }

    /**
     * 提供个接口回调
     */
    interface CallBack {
        void run();
    }
}
