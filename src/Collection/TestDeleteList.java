package Collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin.Z on 2018/1/23.
 */
public class TestDeleteList {
    public static void main(String[] args) {
        testNullSize();
    }

    void testRemove(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals("2")) {
                list.remove(i);
                i--;
            }
        }
        for(String l:list){
            System.err.println(l);
        }
    }

    static void testNullSize(){
        List<Integer> list = new ArrayList<>();
        for(int x:list){
            if(x == 0)
                System.err.println("hey!");
        }
    }
}
