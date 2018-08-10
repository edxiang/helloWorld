package concurrent;

import java.util.concurrent.*;

/**
 * Created by Kevin.Z on 2017/8/30.
 */
public class ExecutorServiceTest {
    private CountDownLatch latch;

    public static void main(String[] args) {
        //new ExecutorServiceTest().testExecutorService();
        /*Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                new ExecutorServiceTest().testScheduledExecutorService();
            }
        });
        t.start();
        System.out.println("back to main Thread");*/
        new ExecutorServiceTest().testCyclicBarrier();
    }

    public void testExecutorService() {
        try {
            //ExecutorService es1 = Executors.newSingleThreadExecutor();
            //ExecutorService es1 = Executors.newCachedThreadPool();
            ExecutorService es1 = Executors.newFixedThreadPool(1);


            ThreadForTest t1 = new ThreadForTest(1);
            es1.execute(t1);

            Future futureR = es1.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Runnable tasks");
                }
            });
            //System.out.println("futureR.get: " + futureR.get());

            Future futureC = es1.submit(new Callable<Integer>() {
                public Integer call() throws Exception {
                    System.out.println("Callable tasks");
                    return 1;
                }
            });
            //System.out.println("futureC.get: " + futureC.get());

            es1.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testScheduledExecutorService() {
        latch = new CountDownLatch(3);
        try {
            ScheduledExecutorService ses = Executors.newScheduledThreadPool(5);

            ScheduledFuture future1 = ses.schedule(new Callable<String>() {
                public String call() throws Exception {
                    System.out.println("in the Scheduled Executor Service.");
                    return "Called";
                }
            }, 5, TimeUnit.SECONDS);
            // future.get() 会阻塞主线程
            //System.out.println("future1.get:"+future1.get());

            ScheduledFuture future2 = ses.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    System.out.println("whatever you like.");
                    latch.countDown();
                }
            }, 0, 3, TimeUnit.SECONDS);// period: the time between a beginning to the next beginning

            latch.await();

            ses.shutdown();
            latch = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testCyclicBarrier(){
        Runnable barrier1Action = new Runnable() {
            @Override
            public void run() {
                System.out.println("BarrierAction 1 executed");
            }
        };
        Runnable barrier2Action = new Runnable() {
            @Override
            public void run() {
                System.out.println("BarrierAction 2 executed");
            }
        };

        CyclicBarrier barrier1 = new CyclicBarrier(2,barrier1Action);
        CyclicBarrier barrier2 = new CyclicBarrier(2,barrier2Action);

        CyclicBarrierRunnable barrierRunnable1 = new CyclicBarrierRunnable(barrier1,barrier2);
        CyclicBarrierRunnable barrierRunnable2 = new CyclicBarrierRunnable(barrier1,barrier2);

        new Thread(barrierRunnable1).start();
        new Thread(barrierRunnable2).start();
    }
}
