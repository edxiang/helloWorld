package Collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin.Z on 2018/3/30.
 */
public class TestDelete {
    public static void main(String[] args) {
        preNxt();
    }

    public static void preNxt(){
        List<String> lists = new ArrayList<>();
        lists.add("1");
        lists.add("2");
        lists.add("3");
        lists.add("3");
        lists.add("5");
        System.out.println(lists.indexOf("1"));
    }
}
