package String;

import java.util.List;

/**
 * Created by Kevin.Z on 2017/9/11.
 */
public class ChangeType {
    String[] officeType = {"DOC","DOCX","PPT","PPTX","XLS","XLSX","TXT","PDF","XML"};
    public static void main(String[] args) {
        String name = "helloWorld.doc";
        int index = name.lastIndexOf(".");
        if(index > 0){
            String ext = name.substring(index+1).toUpperCase();
            System.out.println(new ChangeType().testExtension(ext));
        }else{
            System.out.println("got wrong");
        }
    }

    public boolean testExtension(String ext){
        System.out.println(ext);
        for(String type:officeType){
            if(ext.equals(type))
                return true;
        }
        return false;
    }
}
