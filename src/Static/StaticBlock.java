package Static;

/**
 * Created by Kevin.Z on 2017/8/23.
 */
public class StaticBlock {
    private static int x;
    static{
        x = 101;
    }

    public static void show(int y){
        System.out.println(y);
        System.out.println(x);
    }
}
