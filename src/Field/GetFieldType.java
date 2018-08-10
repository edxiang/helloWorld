package Field;

import Domain.Person;

import java.lang.reflect.Field;

/**
 * Created by Kevin.Z on 2017/12/26.
 */
public class GetFieldType {
    public static void main(String[] args) {

        new GetFieldType().test(new Archive());
        System.out.println("-----------");
        //new GetFieldType().test(new Person());
    }

    void test(Object d){
        Field[] fs = d.getClass().getDeclaredFields();
        for(Field f:fs){
            System.err.println(f.getName());
        }
        System.out.println(fs.length);
    }
}
