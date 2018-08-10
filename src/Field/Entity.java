package Field;

/**
 * Created by edxiao.zeng on 2017/7/19.
 */
public class Entity {
    public String name;
    public String firstName;
    private String gender;
    private int age;
    private double height;
    private double weight;
    private boolean brothers;
    private boolean sisters;

    public Entity(){
        //this.name = "xiaoxiang";
        this.firstName = "zeng";
        this.gender = "male";
        //this.age = 25;
        //this.height = 1.68;
        this.weight = 62.5;
        this.brothers = false;
        //this.sisters = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean getBrothers() {
        return brothers;
    }

    public void setBrothers(boolean brothers) {
        this.brothers = brothers;
    }

    public boolean getSisters() {
        return sisters;
    }

    public void setSisters(boolean sisters) {
        this.sisters = sisters;
    }
}
