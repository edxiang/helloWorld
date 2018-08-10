package Field;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin.Z on 2017/12/25.
 */
public class TestObject {
    public static void main(String[] args) {
        Person p = new Person();
        p.setAge(24);
        p.setName("kevin");
        p.setGender("male");
        p.setId(0);
        p.setF(false);
        //test(p.getClass().getDeclaredFields(),p);

        List<Person> personList = new ArrayList<>();
        List<Entity> entityList = new ArrayList<>();
        Person p1 = new Person();
        p1.setName("k");
        Person p2 = new Person();
        p2.setName("e");
        personList.add(p1);
        personList.add(p2);

        Entity e1 = new Entity();
        e1.setName("v");
        Entity e2 = new Entity();
        e2.setName("i");
        Entity e3 = new Entity();
        e3.setName("n");
        entityList.add(e1);
        entityList.add(e2);
        entityList.add(e3);

        test1(personList);
        test1(entityList);
    }

    // work!
    private static void test(Field[] f, Object d){
        try {
            for (int i = 0; i < f.length; i++) {
                System.out.println();
                String fieldName = f[i].getName();
                String firstLetter = fieldName.substring(0,1).toUpperCase();
                String getter = "get" + firstLetter + fieldName.substring(1);
                Method methodGet = d.getClass().getMethod(getter,new Class[]{});
                Object o = methodGet.invoke(d);
                if(o!=null){
                    System.out.println(o.toString());
                }else{
                    System.out.println("null~");
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void test1(List ls){
        try {
            Field[] f = ls.get(0).getClass().getDeclaredFields();
            for(Object d:ls) {
                for (int i = 0; i < f.length; i++) {
                    String fieldName = f[i].getName();
                    String firstLetter = fieldName.substring(0, 1).toUpperCase();
                    String getter = "get" + firstLetter + fieldName.substring(1);
                    Method methodGet = d.getClass().getMethod(getter, new Class[]{});
                    Object o = methodGet.invoke(d);
                    System.out.print("");
                    if (o != null) {
                        System.out.println(o.toString());
                    } else {
                        //System.out.println("null~");
                    }
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
