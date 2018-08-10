package Domain;

import java.util.Date;

/**
 * Created by edxiao.zeng on 2017/6/22.
 */
public class Person {
    private String name;
    private String sex;
    private Date date;
    private int i;

    public int getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean equals(Object o){
        if(this == o)
            return true;
        if(o == null)
            return false;
        if(getClass() != o.getClass())
            return false;
        Person p = (Person)o;

        if(!name.equals(p.getName()))
            return false;
        if(!sex.equals(p.getSex()))
            return false;
        if(!date.equals(p.getDate()))
            return false;
        return true;
    }
}
