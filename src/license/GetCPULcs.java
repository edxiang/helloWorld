package license;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by edxiao.zeng on 2017/7/20.
 */
public class GetCPULcs {
    public static void main(String[] args) throws IOException {
        /*Process process = Runtime.getRuntime().exec(
                new String[]{"wmic", "cpu", "get", "ProcessorId"});
        process.getOutputStream().close();
        Scanner sc = new Scanner(process.getInputStream());
        String property = sc.next();
        String serial = sc.next();
        System.out.println(property + ": " + serial);*/
        new GetCPULcs().lis();
    }

    public void lis(){
        try{
            Process prc = Runtime.getRuntime().exec(new String[]{"wmic", "cpu", "get", "ProcessorId"});
            while(true){

            }

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("killed");
        }
    }
}
