package write;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;

/**
 * @description: TODO
 * @date: 2020/5/26 11:35
 * @author: ShangKun
 * @version: 2.0.0
 */
public class WriteExcel07 {

    private static  String PATH = "G:\\excel\\";

    public static void main(String[] args) {


        /*创建一个工作部*/
        Workbook workbook = new XSSFWorkbook();
        /*创建一个工作表*/
        Sheet sheet = workbook.createSheet("第一个工作表");

        /*创建一行*/
        Row row1 = sheet.createRow(0);

        /*创建一个单元格*/
        Cell cell11 = row1.createCell(0);

        cell11.setCellValue("第1个要被赋予的值");

        Cell cell12 = row1.createCell(1);

        cell12.setCellValue("第2个要被赋予的值");


        /*创建一行*/
        Row row2 = sheet.createRow(1);

        Cell cell21 = row2.createCell(0);

        cell21.setCellValue("第3个要被赋予的值");

        Cell cell22 = row2.createCell(1);

        String date = new DateTime().toString("yyyy-mm-dd HH:mm:ss");
        cell22.setCellValue(date);

        try {
            FileOutputStream f = new FileOutputStream(PATH+"07版本要以xlsx结尾.xlsx");
            workbook.write(f);
            f.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
