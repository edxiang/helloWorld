package Field;

import java.lang.reflect.*;

/**
 * Created by Kevin.Z on 2017/12/7.
 */
public class GetterSetter {
    private Person p = new Person();

    public static void main(String[] args) {
        new GetterSetter().getter();
    }

    private void getter(){
        Field[] fields = p.getClass().getDeclaredFields();
        for(Field f:fields){
            System.out.println(f.getType().getName());
        }
    }
}
