package LeetCode;

/**
 * Created by Kevin.Z on 2018/6/27.
 * 一次过……有点意外之外
 */
public class ComplexNumberMultiplication {
    public static void main(String[] args) {
        System.out.println(new ComplexNumberMultiplication().solution("1+-1i","1+-1i"));
    }

    public String solution(String a, String b){
        String m = a.substring(0,a.indexOf("+"));
        String n = a.substring(a.indexOf("+") + 1, a.length()-1);
        String x = b.substring(0,b.indexOf("+"));
        String y = b.substring(b.indexOf("+") + 1,b.length()-1);

        int mm = 1;
        int nm = 1;
        int xm = 1;
        int ym = 1;
        if(m.contains("-")){
            m = m.substring(1,m.length());
            mm = -1;
        }
        if(n.contains("-")){
            n = n.substring(1,n.length());
            nm = -1;
        }
        if(x.contains("-")){
            x = x.substring(1,x.length());
            xm = -1;
        }
        if(y.contains("-")){
            y = y.substring(1,y.length());
            ym = -1;
        }
        int mx = Integer.parseInt(m) * Integer.parseInt(x) * mm * xm;
        int ny = Integer.parseInt(n) * Integer.parseInt(y) * nm * ym;
        int my = Integer.parseInt(m) * Integer.parseInt(y) * mm * ym;
        int nx = Integer.parseInt(n) * Integer.parseInt(x) * nm * xm;
        int first = mx - ny;
        int second = my + nx;
        return first + "+" + second + "i";
    }
}
