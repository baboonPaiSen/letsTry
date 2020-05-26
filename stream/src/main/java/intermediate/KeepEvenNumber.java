package intermediate;

import java.util.Arrays;
import java.util.stream.Stream;

public class KeepEvenNumber {
    public static void main(String[] args) {
        Integer[] sixNums = {1, 2, 3, 4, 5, 6};
        Integer[] evens = Stream.of(sixNums).filter(n -> n % 2 == 0).toArray(Integer[]::new);
        System.out.println(Arrays.toString(evens));// [2, 4, 6]
    }
}