package String;

import Domain.Person;

/**
 * Created by edxiao.zeng on 2017/6/22.
 */
public class LastIndexOf {
    public static void main(String[] args){
        String s = "hell\\o.World.D\\VD";
        int i = s.lastIndexOf(46);
        int n = s.lastIndexOf(92);
        String x = s.substring(i+1);

        String s1 = "123";
        int index = Integer.parseInt(s1);

        int index1 = s.lastIndexOf("\\");
        System.out.println(s.substring(index1+1));

    }

    public void testNull(){
        Person p = new Person();
        if(p == null){
            System.out.println("null");
        }else{
            System.out.println("not null");
        }
    }

    public int testFinally(){
        try{
            int i = 10/0;

            return i;
        }catch (Exception e){
            System.out.println("can't be zero");
        }finally {
            System.out.println("hello");
        }
        return -1;
    }

    public void testIndexOf(){
        String s = " 123 456 789";
        int i = s.indexOf(" ",1);
        System.out.print(i);
    }

    public void testParse(){
        String s = "005";
        int i = Integer.parseInt(s);
        System.out.print(i);
    }

    public void testContains(){
        String s = "asd@123@";
        if(s.contains("@")){
            s = s.split("!")[0];
        }
        System.out.print(s);
    }

    public void test(String s){
        if(s != ""){
            System.out.println("none");
        }else{
            System.out.println("get");
        }
    }


}
