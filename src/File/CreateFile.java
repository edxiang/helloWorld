package File;

import java.io.*;

/**
 * Created by Kevin.Z on 2017/8/31.
 */
public class CreateFile {
    public static void main(String[] args) {
        new CreateFile().create();
    }

    public void create(){
        try {
            File f = new File("c:/hello/world/now/what/hhh.txt");
            if(!f.exists()){
                f.mkdirs();
                f.createNewFile();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
