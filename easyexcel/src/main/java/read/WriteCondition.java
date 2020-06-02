package read;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.junit.Test;
import pojo.DemoData;

/**
 * @description: TODO
 * @date: 2020/5/29 18:28
 * @author: ShangKun
 * @version: 2.0.0
 */
public class WriteCondition {


    private static  String PATH = "G:\\excel\\";

    private List<DemoData> data() {
        List<DemoData> list = new ArrayList<DemoData>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.5621313122);
            list.add(data);
        }
        return list;
    }

    /**
    * @Author ShangKun
    * @Description //TODO显示某些字段和不显示某些字段
    * @Date 11:36 2020/5/30
    * @Param []
    * @return void
    **/
    @Test
    public void write() {
        // 写法1
        String fileName = PATH + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        List<DemoData> data = this.data();
        /*includeColumnFiledNames里面设置要显示的字段*/
        EasyExcel.write(fileName, DemoData.class).includeColumnFiledNames(null).sheet("模板").doWrite(data);
        /*excludeColumnFiledNames里面设置排除掉的字段*/
        EasyExcel.write(fileName, DemoData.class).excludeColumnFiledNames(null).sheet("模板").doWrite(data);
    }

    /**
    * @Author ShangKun
    * @Description //TODO重复写
    * @Date 11:35 2020/5/30
    * @Param []
    * @return void
    **/
    @Test
    public void  write1(){

        // 写法2
        String fileName1 = PATH + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写
        ExcelWriter excelWriter = EasyExcel.write(fileName1, DemoData.class).build();
        WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
        excelWriter.write(data(), writeSheet);
        for (int i = 0; i < 5; i++) {
            excelWriter.write(data(),writeSheet);
        }
        // 千万别忘记finish 会帮忙关闭流
        excelWriter.finish();

    }


    /**
    * @Author ShangKun
    * @Description //TODO不同的工作簿写
    * @Date 11:36 2020/5/30
    * @Param []
    * @return void
    **/
    @Test
    public void  write2(){

        // 写法2
        String fileName1 = PATH + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写
        ExcelWriter excelWriter = EasyExcel.write(fileName1, DemoData.class).build();
        for (int i = 0; i < 3; i++) {
            WriteSheet writeSheet = EasyExcel.writerSheet("模板"+i).build();
            excelWriter.write(data(), writeSheet);
        }
        // 千万别忘记finish 会帮忙关闭流
        excelWriter.finish();

    }



}
