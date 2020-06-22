package com.gsk.pojo.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.converters.string.StringImageConverter;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

/**
 * @description: TODO
 * @date: 2020/6/2 16:54
 * @author: ShangKun
 * @version: 2.0.0
 */
@Data
@NoArgsConstructor
public class ImageData {

    private  File file;

    private  InputStream inputStream;

    /*使用转换器*/
    @ExcelProperty(converter = StringImageConverter.class)
    private  String string;

    private byte[] byteArray;

    private URL url;



}
