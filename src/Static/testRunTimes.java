package Static;

/**
 * Created by edxiao.zeng on 2017/7/21.
 */
public class testRunTimes {
    public static void main(String[] args){
        int sum = 0;
        for(int i = 0;i < 9;i++){
            sum += getNum();
        }
        System.out.print(sum);
    }

    public static int getNum(){
        int index = 10;
        System.out.println(index+"- static~~~");
        return index;
    }
}
