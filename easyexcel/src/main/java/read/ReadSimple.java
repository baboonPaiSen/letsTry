package read;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import org.junit.Test;
import com.gsk.pojo.pojo.WidthAndHeightData;

/**
 * @description: TODO
 * @date: 2020/6/2 18:03
 * @author: ShangKun
 * @version: 2.0.0
 */
public class ReadSimple {

    @Test
    public  void simpleRead(){
        String path = "G:\\excel\\WriteImage1591090589375.xlsx";

        EasyExcel.read(path, WidthAndHeightData.class, new AnalysisEventListener<WidthAndHeightData>() {

            /**
             * 每解析一次表格一行数据，就调用一次该方法
             * @param data
             * @param context
             */
            @Override
            public void invoke(WidthAndHeightData data, AnalysisContext context) {
                System.out.println(data);
            }

            /**
             * 全部解析完调用此方法
             * @param context
             */

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {

            }
        }).sheet().doRead();



    }


    @Test
    public  void simpleRead1(){
        String path = "G:\\excel\\WriteImage1591090589375.xlsx";
        ExcelReader reader = EasyExcel.read(path, WidthAndHeightData.class, new AnalysisEventListener<WidthAndHeightData>() {

            @Override
            public void invoke(WidthAndHeightData data, AnalysisContext context) {
                System.err.println(data);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {

            }
        }).build();

        ReadSheet build = EasyExcel.readSheet(0).build();

        reader.read(build);
        /*必须关闭流*/
        reader.finish();
    }
}
