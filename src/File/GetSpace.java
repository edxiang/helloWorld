package File;

import java.io.File;

/**
 * Created by Kevin.Z on 2017/9/4.
 */
public class GetSpace {
    private static final long sizeOf = 1024*1024*1024;

    public static void main(String[] args) {
        File[] roots = File.listRoots();
        for(File f:roots){
            System.out.println(f);
            System.out.println("Free space = " + f.getFreeSpace()/sizeOf);
            System.out.println("Usable space = " + f.getUsableSpace()/sizeOf);
            System.out.println("Total space = " + f.getTotalSpace()/sizeOf);
            System.out.println();
        }
    }

    public void t(){
        File discSpace = new File("G:");

        long totalCapacity = discSpace.getTotalSpace();
        long freePartitionSpace = discSpace.getFreeSpace();
        long usablePartitionSpace = discSpace.getUsableSpace();

        System.out.println("total: "+ totalCapacity/(1024*1024*1024));
        System.out.println("free: "+ freePartitionSpace/(1024*1024*1024));
        System.out.println("usable: "+ usablePartitionSpace/(1024*1024*1024));
    }

    public void t1(){
        File f = new File("\\\\192.168.88.105\\C$");
        long totalCapacity = f.getTotalSpace();
        System.out.println("total: "+ totalCapacity/(1024*1024*1024));
    }
}
