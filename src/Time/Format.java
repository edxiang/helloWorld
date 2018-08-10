package Time;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Kevin.Z on 2017/11/28.
 */
public class Format {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String dateFormat = format.format(new Date()).trim();
        String d1 = dateFormat.split(" ")[0];
        String d2 = d1.replaceAll("/","");
        System.out.println(d2);
    }
}
