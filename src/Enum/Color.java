package Enum;

/**
 * Created by edxiao.zeng on 2017/7/18.
 */
public enum Color {
    RED("red color", 1),
    GREEN("green color", 2),
    BLACK("black color", 3),
    WHITE("white color", 4);
    private String name;
    private int index;

    Color(String name, int index) {
        this.index = index;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String toString() {
        return this.getName() + " - " + this.getIndex();
    }

}
