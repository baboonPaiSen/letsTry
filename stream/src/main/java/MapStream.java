import java.util.*;

/**
 * @description: TODO
 * @date: 2020/6/3 10:23
 * @author: ShangKun
 * @version: 2.0.0
 */
public class MapStream {
    public static void main(String[] args) {
        Map<Integer, String> map = new LinkedHashMap<>();

        for (int i = 0; i < 10; i++) {
            map.put(i,"这是第"+i+"个数据");
        }
        ArrayList<Object> objects = new ArrayList<>();
        map.forEach((k,v)->objects.add(k)
        );











    }



}
