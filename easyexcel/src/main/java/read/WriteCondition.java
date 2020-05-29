package read;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.excel.EasyExcel;
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
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }

    @Test
    public void simpleWrite() {
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
}
