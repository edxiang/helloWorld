package String;

import java.text.SimpleDateFormat;
import java.util.logging.SimpleFormatter;

/**
 * Created by Kevin.Z on 2017/7/31.
 */
public class typeChangeError {
    public static void main(String[] args) {
        long c = System.currentTimeMillis() + 15768000000L;
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = dateFormatter.format(c);
        System.out.println(dateStr);

    }
}
