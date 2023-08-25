package org.example.botrunningsystem.service.impl.util;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zzx
 * @date 2023/8/25 2:25
 */
public class BotPool extends Thread{
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private Queue<Bot> bots = new LinkedList<>();

    public void addBot(Integer userId,String botCode,String input){
        lock.lock();
        try {
            bots.add(new Bot(userId,botCode,input));
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    private void consume(Bot bot){
        //joor动态编译java代码
        Consumer consumer = new Consumer();
        consumer.startTimeout(2000,bot);

    }
    @Override
    public void run() {
         while (true){
             lock.lock();
             if (bots.isEmpty()){
                 try {
                     condition.await();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                     lock.unlock();
                     break;
                 }
             }
             else {
                 Bot bot = bots.remove();//返回并删除队头
                 lock.unlock();
                 consume(bot);//比较耗时 所以放在解锁之前
             }
         }
    }
}
