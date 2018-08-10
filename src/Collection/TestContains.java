package Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Kevin.Z on 2017/10/16.
 */
public class TestContains {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println((String)iterator.next());
        }
    }
}
