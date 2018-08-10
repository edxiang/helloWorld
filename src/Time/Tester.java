package Time;

import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Kevin.Z on 2018/3/16.
 */
public class Tester {
    public static void main(String[] args) {
        testTimeZone();
    }

    public static  void testTimeZone(){
        TimeZone.setDefault(TimeZone.getTimeZone("GMT-8"));
        Date date = new Date();
        System.out.println(date);
    }
}
