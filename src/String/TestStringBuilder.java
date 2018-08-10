package String;

import java.io.Console;

/**
 * Created by Kevin.Z on 2017/7/31.
 */
public class TestStringBuilder {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        s.append("12");
        if(s.toString().equals("")){
            System.out.println("yes");
        }
    }

    public void testBuilder(){
        StringBuilder sb = new StringBuilder();
        sb = sb.append("hello world");
    }
}
