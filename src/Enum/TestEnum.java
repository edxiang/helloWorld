package Enum;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by edxiao.zeng on 2017/7/18.
 */
public class TestEnum {
    public static void main(String[] args) {
        Color c = Color.BLACK;

        /*switch (c) {
            case RED:
                System.out.print(c.getName());
                break;
            case BLACK:
                System.out.print(c.toString());
                break;
            case WHITE:
                System.out.print(c.getName());
                break;
            case GREEN:
                System.out.print(c.getName());
                break;
            default:
                System.out.print("nothing~");
        }*/



        new TestEnum().testEnumSet();
    }

    public void testEnumSet(){
        EnumSet<Color> colorSet = EnumSet.allOf(Color.class);
        for(Color c:colorSet){
            System.out.println(c.toString());
            //直接 print(c),默认输出的是枚举的字符串。
            //为什么是这样子的？
        }

        EnumMap<Color, String> weekMap = new EnumMap(Color.class);
        weekMap.put(Color.RED,"show red color");
        weekMap.put(Color.BLACK,"show black color");
        Iterator<Map.Entry<Color,String>> iter = weekMap.entrySet().iterator();

        while(iter.hasNext()){
            Map.Entry<Color,String> entry = iter.next();
            System.out.println(entry.getKey().getName()+":"+entry.getValue());
        }
    }


}
