package intermediate;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Peek {
    public static void main(String[] args) {
        Stream.of("one", "two", "three", "four")
                .filter(p -> p.length() > 3)
                .peek(v -> System.out.println("Filtered Value:" + v))
                .map(String::toUpperCase)
                .peek(v -> System.out.println("Mapped Value:" + v))
                .collect(Collectors.toList());
        // 1. Filtered Value:three
        // 2. Mapped Value:THREE
        // 3. Filtered Value:four
        // 4. Mapped Value:FOUR


    }
}