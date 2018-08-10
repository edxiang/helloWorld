package String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin.Z on 2017/12/5.
 */
public class ListRemove {
    public static void main(String[] args) {
        List<String> ss = new ArrayList<>();
        ss.add("a1");
        ss.add("a2");
        ss.add("a3");
        ss.add("a4");
        ss.add("s1");
        ss.add("a6");
        ss.add("a7");

        for (int i = 0; i < ss.size(); i++) {
            if(!ss.get(i).contains("a")) {
                ss.remove(i);
                i--;
            }
        }
        for(String s:ss){
            System.out.println(s);
        }
        testContains();
    }

    public static void testContains(){
        List<String> ss = new ArrayList<>();
        ss.add("DOC");
        ss.add("DOCX");
        ss.add("PPT");
        ss.add("XLS");
        String[] officeType = {"DOC","DOCX","PPT","PPTX","XLS","XLSX","TXT","PDF","XML"};
        String target = "DOC";
        System.out.println(ss.contains(target));
    }
}
