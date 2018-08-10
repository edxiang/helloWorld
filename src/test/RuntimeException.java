package test;

/**
 * Created by Kevin.Z on 2017/7/31.
 */
public class RuntimeException {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                System.out.println("exit on normal");
            }
        });

        new RuntimeException().test0();
    }

    public void test0() {
        for (int i = 0; i < 1000; i++) {
            if (i > 900) {
                System.exit(1);
            }
        }
    }

    public void test1() {

    }
}
