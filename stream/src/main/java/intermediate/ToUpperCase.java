package intermediate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToUpperCase {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("hello", "world", "java8", "stream");
        List<String> wordList = stream.map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(wordList.toString());// [HELLO, WORLD, JAVA8, STREAM]

        stream = Stream.of("hello", "world", "java8", "stream");
        wordList = stream.map(s -> { return s.toUpperCase(); }).collect(Collectors.toList());
        System.out.println(wordList.toString());// [HELLO, WORLD, JAVA8, STREAM]

        stream = Stream.of("hello", "world", "java8", "stream");
        wordList = stream.map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(wordList.toString());// [HELLO, WORLD, JAVA8, STREAM]
    }
}