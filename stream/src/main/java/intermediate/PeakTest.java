package intermediate;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Project Name: steamDemo
 * @File Name: PeakTest
 * @Description: TODO
 * @Date: 2020/5/7 16:55
 * @Author: ShangKun
 * @Version: 1.0.0
 */
public class PeakTest {
    public static void main(String[] args) {
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
    }



}
