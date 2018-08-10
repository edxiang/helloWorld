package concurrent;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by Kevin.Z on 2017/8/31.
 */
public class CyclicBarrierRunnable implements Runnable {
    CyclicBarrier barrier1 = null;
    CyclicBarrier barrier2 = null;

    public CyclicBarrierRunnable(CyclicBarrier cyclicBarrier1, CyclicBarrier cyclicBarrier2){
        this.barrier1 = cyclicBarrier1;
        this.barrier2 = cyclicBarrier2;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+" waiting at barrier 1");
            barrier1.await();

            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+" waiting at barrier 2");
            barrier2.await();

            System.out.println(Thread.currentThread().getName()+" done!");
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
