package org.bee.webBee.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * bee 线程池
 * @author wangtonghe
 * @date 2017/5/11 08:17
 */
public class BeeThreadPool {


    /**
     * 线程数
     */
    private int threadNum;

    private AtomicInteger taskNum = new AtomicInteger(0);


    private ExecutorService executorService;

    public BeeThreadPool(int threadNum) {
        this.threadNum = threadNum;
        this.executorService = Executors.newFixedThreadPool(threadNum);
    }

    public BeeThreadPool(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public void execute(final Runnable runnable){
        executorService.execute(()-> runnable.run());
    }

    public void shutdown(){
        executorService.shutdown();
    }

    public boolean isShundown(){
        return executorService.isShutdown();
    }

    public int getAliveThreadNum() {
        return ((ThreadPoolExecutor) executorService).getActiveCount();
    }


}
