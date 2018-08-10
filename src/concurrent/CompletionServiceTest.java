package concurrent;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Kevin.Z on 2018/5/29.
 */
public class CompletionServiceTest {
    public static void main(String[] args) {
        AtomicInteger index = new AtomicInteger(0);
        ExecutorService exe = Executors.newFixedThreadPool(10);
        CompletionService<Integer> cs = new ExecutorCompletionService(exe);
        for (int i = 0; i < 10; i++) {
            cs.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int last = (int)(System.nanoTime() % 10);
                    System.out.println("thread " + index.incrementAndGet() + " is beginning, and will last for " + last);
                    try {
                        Thread.sleep(last * 1000);
                    } catch(Exception e){
                        e.printStackTrace();
                    }
                    return last;
                }
            });
        }
        exe.shutdown();

        for (int i = 0; i < 10; i++) {
            try {
                Future<Integer> f = cs.take();
                Integer x = f.get();
                System.out.println("not sure which thread is stop, but it just stops in " + x + " seconds");
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
