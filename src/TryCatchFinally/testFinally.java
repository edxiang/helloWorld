package TryCatchFinally;

/**
 * Created by Kevin.Z on 2017/8/23.
 */
public class testFinally {
    public static void main(String[] args) {
        new testFinally().aVoid();
    }

    public void aVoid(){
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(5000);
                System.out.println(i);
            }
        } catch(Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("abort");
        }
    }
}
