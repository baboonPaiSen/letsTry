package pojo;

import java.util.Date;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class DemoData {

    //index影响在excel中的排序结果
    @ExcelProperty(value = "字符串标题",index = 0)
    private String string;
    @ExcelProperty(value = "日期标题",index = 1)
    private Date date;
    @ExcelProperty(value = "数字标题",index = 2)
    private Double doubleData;
    /**
     * 忽略这个字段
     */
    @ExcelIgnore
    private String ignore;
}