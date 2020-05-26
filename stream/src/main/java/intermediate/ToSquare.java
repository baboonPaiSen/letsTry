package intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToSquare {
    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4).stream();
        List<Integer> squareList = stream.map(n -> n * n).collect(Collectors.toList());
        System.out.println(squareList.toString());// [1, 4, 9, 16]
    }
}