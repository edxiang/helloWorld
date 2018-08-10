package HandleOffice;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;

/**
 * Created by Kevin.Z on 2017/8/4.
 * A class to test that how to handle .xls file(excel) by java program
 * mainly in creating .xls file and getting content from .xls file
 */
public class CreateAndGetEXCEL {
    public static void main(String[] args) {
        //new CreateAndGetEXCEL().create();
        new CreateAndGetEXCEL().get();
    }

    public void create(){
        // HSSFWorkbook is a class to handle the .xls file
        // while the XSSFWorkbook is designed for .xlsx file.
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();

        HSSFCellStyle style = workbook.createCellStyle();
        //style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);

        // create a row
        // the function .setCellValue(type) has many type: boolean, Calendar, Date, double, String.
        // for compatibility, just setCellValue(String) -- I don't know if this is a good habit
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("database");
        row.createCell(1).setCellValue("type");
        row.createCell(2).setCellValue("records");
        row.createCell(3).setCellValue("lastModified");
        row.createCell(4).setCellValue("owner");
        row.createCell(5).setCellValue("description");

        for (int i = 1; i < 3; i++) {
            row = sheet.createRow(i);

            row.createCell(0).setCellValue("ARTICLE");
            row.createCell(1).setCellValue("USER");
            row.createCell(2).setCellValue("38");
            row.createCell(3).setCellValue(new Date().toString());
            row.createCell(4).setCellValue("SYSTEM");
            row.createCell(5).setCellValue("article database");
        }

        try {
            // write the data to .xls file
            FileOutputStream fos = new FileOutputStream("ForTest.xls");
            workbook.write(fos);
            fos.close();
        } catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("done");
    }

    public void get(){
        try {
            InputStream xls = new FileInputStream("ForTest.xls");
            // or : new XSSFWorkbook if the extension is .xlsx;
            Workbook workbook = new HSSFWorkbook(xls);
            Sheet sheet = workbook.getSheetAt(0);

            int lastRow = sheet.getLastRowNum();
            for (int i = 1; i <= lastRow; i++) {
                Row row = sheet.getRow(i);

                int lastCell = row.getLastCellNum();
                for (int j = 0; j < lastCell; j++) {
                    Cell cell = row.getCell(j);

                    System.out.print(cell.getStringCellValue()+"_");
                }
                System.out.println();
            }
        } catch(Exception e){
            e.printStackTrace();
        }

    }
}
