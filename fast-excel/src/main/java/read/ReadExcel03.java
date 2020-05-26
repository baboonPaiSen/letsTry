package read;

import java.io.FileInputStream;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 * @description: TODO
 * @date: 2020/5/26 14:17
 * @author: ShangKun
 * @version: 2.0.0
 */
public class ReadExcel03 {

    private static  String PATH = "G:\\excel\\";

    public static void main(String[] args) {

        try {
            FileInputStream fileInputStream = new FileInputStream(PATH + "03版本要以xls结尾.xls");
            /*使用excel能操作的 他都能操作*/
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);

            /*拿到第一个工作表*/
            Sheet sheet  = hssfWorkbook.getSheetAt(0);
            /*拿到第一行*/
            Row row = sheet.getRow(0);
            /*拿到第一个单元格*/
            Cell cell = row.getCell(0);

            System.out.println(cell.getStringCellValue());
            fileInputStream.close();
        } catch (Exception e) {

        }



    }
}
