package ConvertToPDF;

import java.io.*;

/**
 * Created by Kevin.Z on 2017/8/3.
 */
public class ToPDF {
    public static void main(String[] args) {
         /*import file must be Word, PowerPoint, Excel, Outlook, Publisher, Visio.
         including txt.
         */
        //new ToPDF().getConvertPDF("OfficeToPDF.exe",changeType(new File("src/xml.xml")));
        //new ToPDF().getConvertPDF("OfficeToPDF.exe",new File("src/index.html"));
    }

    /**
     * this method will ignore the tag, it only write the content of tag into the .pdf file
     *
     * @param pdfConvertURL the .exe program's directory
     * @param fl            file path
     * @return
     */
    public File getConvertPDF(String pdfConvertURL, File fl) {
        if (fl == null || !fl.exists()) {
            return null;
        }

        String baseFile = fl.getName();
        int index = baseFile.lastIndexOf(".");
        String fileExt = baseFile.substring(index);

        if (fileExt.length() > 0) {
            //begin to convert
            //int index = baseFile.indexOf(".");
            String basePath = fl.getPath();
            int indexPath = basePath.lastIndexOf(".");
            String coverFileName = basePath.substring(0, indexPath) + ".pdf";
            //String coveredFile = basePath.substring(0, indexPath) + "\\" + coverFileName;
            Runtime rt = Runtime.getRuntime();
            Process p = null;
            try {
                File coTool = new File(pdfConvertURL);
                System.out.println("begin office to pdf:" + baseFile);
                String rumCommand = coTool.getAbsolutePath() + " \"" + fl.getAbsoluteFile() + "\" \"" + coverFileName + "\"";
                p = rt.exec(rumCommand);
                InputStream fis = p.getInputStream();
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);
                String line = null;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                br.close();
                p.destroy();
                System.out.println("office to pdf success:" + baseFile);
                return new File(coverFileName);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public static File changeType(File original){
        try {
            String name = original.getName();
            if(name.contains(".")){
                int index = name.lastIndexOf(".");
                name = name.substring(0,index);
            }
            OutputStream os = new FileOutputStream(name+".txt");
            InputStream is = new FileInputStream(original);

            int len = -1;
            byte[] b = new byte[1024];
            while((len = is.read(b)) != -1){
                os.write(b,0,len);
            }

            is.close();
            os.close();
            return new File(name+".txt");
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
