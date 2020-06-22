package write;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.junit.Test;
import com.gsk.pojo.pojo.DemoData;
import com.gsk.pojo.pojo.ImageData;
import com.gsk.pojo.pojo.WidthAndHeightData;

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

    @Test
    public void writeImage() throws  Exception{
        String fileName1 = PATH + "WriteImage" + System.currentTimeMillis() + ".xlsx";

        ImageData imageData = new ImageData();
        imageData.setFile(new File("G:\\Test\\letsTry\\easyexcel\\src\\main\\resources\\test.jpeg"));
        imageData.setInputStream(new FileInputStream(new File("G:\\Test\\letsTry\\easyexcel\\src\\main\\resources\\test.jpeg")));
        imageData.setString("G:\\Test\\letsTry\\easyexcel\\src\\main\\resources\\test.jpeg");
        imageData.setUrl(new URL("https://pics4.baidu.com/feed/b3fb43166d224f4abcd8bedaed8951549922d138.jpeg?token=52eaf1b21ce50a5fc102d95eccf25c2c&s=B90BA056487498DE001A8C870300F08B"));

        byte[] bytes = new byte[(int)new File("G:\\Test\\letsTry\\easyexcel\\src\\main\\resources\\test.jpeg").length()];
        FileInputStream fileInputStream = new FileInputStream("G:\\Test\\letsTry\\easyexcel\\src\\main\\resources\\test.jpeg");

        fileInputStream.read(bytes,0,(int)new File("G:\\Test\\letsTry\\easyexcel\\src\\main\\resources\\test.jpeg").length());
        imageData.setByteArray(bytes);
        List<ImageData> list = new ArrayList<>();

        list.add(imageData);
        EasyExcel.write(fileName1,ImageData.class).sheet("image").doWrite(list);
    }

    @Test
    public void writeWithWidth() throws  Exception{
        String fileName1 = PATH + "WriteImage" + System.currentTimeMillis() + ".xlsx";

        List<WidthAndHeightData> list = new ArrayList<>();

        WidthAndHeightData widthAndHeightData = new WidthAndHeightData();
        widthAndHeightData.setString("");
        widthAndHeightData.setDate(new Date());
        widthAndHeightData.setDoubleDate(0.0D);
        WidthAndHeightData widthAndHeightData1 = new WidthAndHeightData();
        widthAndHeightData1.setString("222222");
        widthAndHeightData1.setDate(new Date());
        widthAndHeightData1.setDoubleDate(2.222D);
        list.add(widthAndHeightData);
        list.add(widthAndHeightData1);



        EasyExcel.write(fileName1, WidthAndHeightData.class).sheet("width").doWrite(list);}



}
