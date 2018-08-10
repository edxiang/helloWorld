import Field.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin.Z on 2017/8/4.
 */
public class TestObject {
    public static void main(String[] args) {
        new TestObject().test();
    }

    public void test() {
        List<Person> list = new ArrayList<>();
        Person p = new Person();
        p.setName("zeng");
        list.add(p);

        obj(list);
        Person p2 = new Person();
        p2.setName("xiang");
        list.add(p2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
        }
    }

    public void obj(List list) {
        Person p = new Person();
        p.setName("xiao");
        list.add(p);
    }
}
