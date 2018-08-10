/**
 * Created by Administrator on 2017/5/15.
 */
public class helloWorld {

    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
        helloWorld hw = new helloWorld();
        byte2char();
    }

    public String getS(){
        return "hello world";
    }

    private static void byte2int() {
        byte[] bs = {127, 1, 0, 0};
        int value = 0;
        for (int i = 0; i < bs.length; i++) {
            int n = (bs[i] < 0 ? (int) bs[i] + 256 : (int) bs[i]) << (8 * i);
            value += n;
        }
    }

    private static void byte2char() {
        byte[] bs = {48, 56, 78, 98};
        for (int i = 0; i < bs.length; i++) {
            System.out.println((char) bs[i]);
        }
        System.out.println(bs[1]);
    }
}
