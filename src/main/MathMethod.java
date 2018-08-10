package main;

/**
 * Created by Administrator on 2017/6/1.
 */
public class MathMethod {
    private static int result = 0;

    public void add(int s){
        result = result + s;
    }

    public void minus(int s){
        result = result - s;
    }

    public void time(int s){
        for(;;);
    }

    public void divide(int s){
        result = result / s;
    }

    public int getResult(){
        return result;
    }

    public void clear(){
        result = 0;
    }
}
