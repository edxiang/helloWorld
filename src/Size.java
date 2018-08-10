import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Kevin.Z on 2018/1/5.
 */
public class Size {

    private final static long GB = 1024 * 1024 * 1024;
    private final static long MB = 1024 * 1024;
    private final ExecutorService maxThread = Executors.newFixedThreadPool(30);


    public static void main(String[] args) {
        new Size().getC();
    }

    private void getC() {
        File[] roots = File.listRoots();
        File f = roots[0];
        System.err.print(f + ":");
        System.err.println(f.getUsableSpace() / GB + " G");

        File[] files = f.listFiles();
        System.err.println(files.length);
        try {
            for (final File d : files) {
                if (d.isDirectory()) {
                    //long size = getSize(maxThread,d);
                    long  size = singleThread(d);
                    System.out.println(d.getName() + ":" + size / MB + " M");
                } else {
                    System.out.println(d.getName() + ":" + d.getTotalSpace() / MB + " M");
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            maxThread.shutdown();
        }
    }

    private long singleThread(File file){
        if(file.isDirectory()){
            File[] files = file.listFiles();
            long totalSize = 0L;
            if(files == null)
                return totalSize;
            for(File f:files){
                totalSize += singleThread(f);
            }
            return totalSize;
        }else{
            return file.length();
        }
    }

    private long getSize(final ExecutorService service, File file) throws Exception {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            long totalSize = 0L;
            if (files == null)
                return totalSize;
            final List<Future<Long>> partialFutures = new ArrayList<>();
            for (final File f : files) {
                partialFutures.add(service.submit(new Callable<Long>() {
                    @Override
                    public Long call() throws Exception {
                        return getSize(service,f);
                    }
                }));
            }
            for(final Future<Long> partialFuture:partialFutures){
                totalSize += partialFuture.get();
            }
            return totalSize;
        } else {
            return file.length();
        }
    }
}
