package read;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

/**
 * @description: TODO
 * @date: 2020/5/26 14:37
 * @author: ShangKun
 * @version: 2.0.0
 */
public class ReadExcel07 {

    private static  String PATH = "G:\\excel\\";

    @Test
    public  void  read07Excel() throws  Exception{

        FileInputStream fileInputStream = new FileInputStream(PATH+"v2.0一期后端计划.xlsx");

        Workbook workbook = new XSSFWorkbook(fileInputStream);

        Sheet sheet  = workbook.getSheetAt(0);

//        Row title = sheet.getRow(0);
//
//        if (title !=  null ){
//
//            /*获取有多少列*/
//            int numberOfCells = title.getPhysicalNumberOfCells();
//            for (int i = 0; i < numberOfCells; i++) {
//                Cell cell = title.getCell(i);
//                if (cell != null){
//                    /*拿到类型*/
//                    int cellType = cell.getCellType();
//                    String stringCellValue = cell.getStringCellValue();
//                    System.out.print(stringCellValue+"|");
//                }
//            }
//
//        }

        /*获取行数*/
        int rowCount = sheet.getPhysicalNumberOfRows();
        for (int i = 0; i < rowCount; i++) {
            /*遍历行数*/
            Row row = sheet.getRow(i);

            if (row !=  null ){

                /*获取有多少列*/
                int numberOfCells = row.getPhysicalNumberOfCells();
                for (int j = 0; j < numberOfCells; j++) {
                    Cell cell = row.getCell(j);
                    if (cell != null){
                        /*拿到类型*/
                        int cellType = cell.getCellType();
                        String stringCellValue = cell.getStringCellValue();
                        System.out.print(stringCellValue+"|");
                    }
                }

            }
            System.out.println();
            System.out.println("____________________________");
        }

    }
}
