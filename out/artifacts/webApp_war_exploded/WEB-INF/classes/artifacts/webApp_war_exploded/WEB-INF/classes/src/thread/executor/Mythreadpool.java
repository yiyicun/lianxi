package thread.executor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

//下面举个代码实例来模拟实现线程池复用线程
//        　　生产了两个 线程作为工人
//        　　生产了10个同样的任务，让他们执行
//        　　利用复用让 2个线程完成10个任务


//线程池不允许使用Executors去创建，而是通过ThreadPoolExecutor的方式，
//        这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
//        说明：Executors各个方法的弊端：
//        1）newFixedThreadPool和newSingleThreadExecutor:
//          主要问题是堆积的请求处理队列可能会耗费非常大的内存，甚至OOM。
//        2）newCachedThreadPool和newScheduledThreadPool:
//          主要问题是线程数最大数是Integer.MAX_VALUE，可能会创建数量非常多的线程，甚至OOM。

//使用submit(Runnable task) 的时候，错误的堆栈信息跑出来的时候会被内部捕获到，所以打印不出来具体的信息让我们查看，解决的方法有如下两种：
//使用execute（）代替submit（）；
public class Mythreadpool {
    LinkedList<Task> taskList = new LinkedList<Task>();

    class Task { //任务类
        int id;
        Task(int id){
            this.id=id;
            System.out.println("第"+id+"个任务产生");
        }
        public void run() {//具体的工作
            System.out.println("第"+id+"个任务正在执行");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("第"+id+"个任务执行完毕");
        }
    }

    class Worker extends Thread { //工人实体
        String name;
        Worker(String name) {
            this.name = name;
        }

        public void run() {
            while(true) {
                if(taskList.size() == 0) {
                    try {
                        synchronized (taskList) {
                            System.out.println("Worker " + name+" 没有任务");
                            taskList.wait(); //没得到任务，进入tasklist的等待队列
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                synchronized (taskList) {
                    System.out.print("Worker " + name+" 得到任务");
                    Task task = taskList.removeFirst();
                    System.out.println(task.id);
                    task.run();
                }
            }
        }
    }

    void pool() {  //工人。只生产了两个工人
        ArrayList<Worker> wokerlist=new ArrayList<Worker>();
        for(int i=0;i<2;i++) {
            Worker k = new Worker("第"+(i+1)+"个工人");
            k.start();
            wokerlist.add(k);//
        }
    }

    class Factory extends Thread{ //生产任务的线程，总共会生产10个任务
        public void run() {
            for(int i=0;i<10;i++) {
                synchronized(taskList) {
                    taskList.addLast(new Task(i+1));
                    taskList.notify();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Mythreadpool mythreadpool = new Mythreadpool();
        mythreadpool.pool(); //初始化工人
        Mythreadpool.Factory m= mythreadpool.new Factory();
        m.start();
    }
}