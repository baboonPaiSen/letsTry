package com.gsk.pojo.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.*;
import lombok.Data;


import java.util.Date;

/**
 * @description: TODO
 * @date: 2020/6/2 17:22
 * @author: ShangKun
 * @version: 2.0.0
 */
@Data
@ContentRowHeight(30)//内容高度
@HeadRowHeight(40)//标题高度
@ColumnWidth(25)//设置列宽


public class WidthAndHeightData {

//    @HeadStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND,fillBackgroundColor = 14)
    @ExcelProperty("字符串标题")
    private String string;
    @ExcelProperty("日期标题")
    private Date date;

    /*设置列宽 可以设置属性  也可以修饰类*/
    @ColumnWidth(50)
    @ExcelProperty("数字标题")
    private Double doubleDate;
}
