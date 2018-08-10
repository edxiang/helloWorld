package Time;

/**
 * Created by Kevin.Z on 2017/8/29.
 */
public class NanoTime {
    public static void main(String[] args) {
        long a1 = System.nanoTime();
        while (true) {
            try {
                Thread.sleep(1001);
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        long a2 = System.nanoTime();
        System.out.println((a2 - a1) / 1000000000);
    }
}
