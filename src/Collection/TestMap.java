package Collection;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kevin.Z on 2018/1/12.
 */
public class TestMap {
    public static void main(String[] args) {
        list();
    }

    private static void contain(){
        Map<Integer,Integer> m = new HashMap<>();
        m.put(0,1);
        m.put(2,3);
        m.put(4,5);

        if(m.containsKey(2))
            System.out.println(m.get(2));
        System.err.println(m.size());
    }

    static void list(){
        Map<Integer,Integer> m = new HashMap<>();
        m.put(0,1);
        m.put(2,3);
        m.put(4,5);

        for(Integer x : m.keySet()){
            System.out.println(x + " - " + m.get(x));
        }
    }

    static void create(){
        Map<Integer,Integer> m = new HashMap<>();
        m.put(1,2);
    }
}
