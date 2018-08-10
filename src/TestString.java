/**
 * Created by Administrator on 2017/6/2.
 */
public class TestString {
    public static void main(String[] args){
        String s = " xiao xiang         zeng    ";
        String s1 = s.trim();
        /*String[] list = s.trim().split("\\s+");
        System.out.println(list.length);
        for(int i = 0;i < list.length;i++){
            System.out.println(list[i]);
        }*/

        String s0 = "xiao@xiang@zeng";
        String s9 = "xiaoxiangzeng";
        String[] temp = s0.split("@");
        String[] temp9 = s9.split("@");
        System.out.println(temp.length);
        System.out.println(temp9.length);
        if(!"".equals(temp9[0])){
            System.out.println(temp9[0]);
        }
        new TestString().test1();
    }

    public void test1(){
        String s = "   ";
        if(s == null){

        }
        System.out.print("1"+s.trim()+"1");
    }

}
