package intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

/**
 * @Project Name: steamDemo
 * @File Name: PickAllWordsTest
 * @Description: TODO
 * @Date: 2020/5/7 14:42
 * @Author: ShangKun
 * @Version: 1.0.0
 */
public class PickAllWordsTest {


    public static void main(String[] args) {
        String title = " private final Color color; private final int weight; enum Color {RED, BLACK";

        String[] s = StringUtils.split(title," ");

        List<String> collect = Arrays.stream(s).collect(Collectors.toList());
        for (String s1 : collect) {
            System.out.println(s1);
        }

    }
}
