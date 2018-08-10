package concurrent;


/**
 * Created by Kevin.Z on 2017/8/30.
 */
public class ThreadForTest extends Thread {
    private int num;

    public ThreadForTest(int num){
        this.num = num;
    }

    @Override
    public void run(){
        try {
            sleep(2000);
            System.out.println("in the testing thread___"+num);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
