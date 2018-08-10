package Field;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by edxiao.zeng on 2017/7/19.
 */
public class GetField {

    public static void main(String[] args){
        new GetField().get();
    }

    public void get(){

        Entity e = new Entity();
        Field[] fields = e.getClass().getDeclaredFields();
        System.out.println(fields.length);
        /*for(Field f : fields){
            String s = f.getName();
            System.out.print(s+"-");
        }*/
        getValue(e);
    }

    public void getValue(Entity e){
        try {
            Field[] fields = e.getClass().getDeclaredFields();
            for(Field f:fields){
                String fieldName = f.getName();
                String fieldType = f.getType().getName();
                System.out.println(fieldName+"-"+fieldType);

                /*String firstLetter = fieldName.substring(0, 1).toUpperCase();

                String setter = "set"+firstLetter+fieldName.substring(1);
                Method methodSet = e.getClass().getMethod(setter,String.class);
                Object o1 = methodSet.invoke(e,"this is for test");

                // 通过这种方式执行 getter 方法，挺奇怪的，但真的能用
                String getter = "get" + firstLetter + fieldName.substring(1);
                Method method = e.getClass().getMethod(getter, new Class[]{});
                Object o = method.invoke(e);
                if (o != null) {
                    System.out.println(fieldName + ":(" + f.getType().getName() + ")  " + o.toString());
                }
                break;*/
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }

    }
}
