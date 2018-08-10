package File;

import java.awt.*;
import java.io.File;

/**
 * Created by Kevin.Z on 2017/8/24.
 */
public class OpenLocalFile {
    public static void main(String[] args) {
        try {
            File file = new File("c:\\85.mov");
            Desktop.getDesktop().open(file);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
