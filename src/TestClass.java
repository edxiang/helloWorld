/**
 * Created by Administrator on 2017/5/19.
 */
public class TestClass {
    public static void main(String[] args){
        new TestClass().test();
    }

    public void test(){
        Person p = new Person("hello");
    }

    class Person{
        public Person(){
            System.out.println("no argument");
        }
        public Person(String name){
            this();
            System.out.println("with argument");
        }
    }

}
