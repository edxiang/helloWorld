package Builder;

/**
 * Created by Kevin.Z on 2017/10/12.
 */
public class Person {
    private final String name;
    private final int gender;
    private final int age;
    private final double height;
    private final double weight;

    public static class Builder{
        private final String name;
        private final int gender;

        private int age = 0;
        private double height = 0.0;
        private double weight = 0.0;

        public Builder(String name, int gender){
            this.name = name;
            this.gender = gender;
        }

        public Builder age(int val){
            age = val;
            return this;
        }
        public Builder height(double val){
            height = val;
            return this;
        }
        public Builder weight(double val){
            weight = val;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }

    private Person(Builder builder){
        name = builder.name;
        gender = builder.gender;
        age = builder.age;
        height = builder.height;
        weight = builder.weight;
    }
}
