package TestObjectParameter;

import Domain.Person;
import TestTrip.ConfigDomain;

/**
 * Created by Kevin.Z on 2017/9/27.
 */
public class Main {
    public static void main(String[] args) {
        new Main().t1();
    }

    public void t1(){
        Person p = new Person();
        p.setName("123");
        p.setSex("boy");

        t2(p);
        System.out.println(p.getName());
    }


    public void t2(Person c1){
        c1.setName("xiaoxiang");
    }
}
