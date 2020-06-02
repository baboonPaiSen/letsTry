import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import pojo.Student;

import javax.swing.text.html.Option;

import static java.util.stream.Collectors.*;

/**
 * @description: TODO
 * @date: 2020/5/28 20:01
 * @author: ShangKun
 * @version: 2.0.0
 */
public class CollectToMap {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        Student student1 = new Student(1,"张1",2);
        Student student2 = new Student(2,"张2",2);
        Student student3 = new Student(3,"张3",1);
        Student student4 = new Student(3,"张4",2);
        Student student5 = new Student(4,"张4",11);
        Student student6 = new Student(4,"张4",1);
        Student student7 = new Student(6,"张4",11);


        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);



        Map<Integer, List<Student>> collect = students.stream().collect(groupingBy(Student::getId));
        /*toMap*/
//        Map<String, Student> collect6 = students.stream().collect(Collectors.toMap(Student::getName, v -> v));

        /*分组计数*/

        Map<Integer, Long> collect4 = students.stream().collect(groupingBy(Student::getId, counting()));

        Map<Integer, Integer> collect6 = students.stream().collect(toMap(Student::getId, Student::getAge, (a, b)->a+b+1));
        /*瞎写的 好像分组后又取了其中一个值*/

        /*toMap并处理相同的key对应的value*/
        Map<Integer, Set<String>> collect5 = students.stream().collect(groupingBy(Student::getAge, mapping(Student::getName, toSet())));

        /*group分组并确保顺序再操作 2个对比*/
        Map<Integer, List<Student>> collect7 = students.stream().sorted(Comparator.comparing(Student::getAge)).collect(groupingBy(Student::getId,LinkedHashMap::new, toList()));
        Map<Integer, List<Student>> collect8 = students.stream().sorted(Comparator.comparing(Student::getAge)).collect(groupingBy(Student::getId));



        /*分组并尝试一次性修改分组后的数据*/
        LinkedHashMap<Integer, List<Student>> collect9 = students.stream().collect(groupingBy(Student::getId, LinkedHashMap::new, collectingAndThen(
                toList(), (s -> s)
        )));


        /*获取最大的*/
        Optional<Student> max = students.stream().max(Comparator.comparing(Student::getAge));

        /*获取最小的*/
        Optional<Student> min = students.stream().min(Comparator.comparing(Student::getAge));

        /*获取平均值*/

        Double collect1 = students.stream().collect(averagingDouble(Student::getAge));

        /*取上面所有的*/
        IntSummaryStatistics collect2 = students.stream().collect(summarizingInt(Student::getAge));
        long sum = collect2.getSum();
        int min1 = collect2.getMin();

        /*拼接字符串*/
       String join =students.stream().map(Student::getAge).map(String::valueOf).collect(joining("|"));

       /*reduce求和*/
       Integer collect3 = students.stream().map(Student::getAge).reduce(0, Integer::sum);



       /*分组后尝试操作包装后的收集器*/
        Map<Integer, Student> collect10 = students.stream().collect(groupingBy(Student::getId, collectingAndThen(toList(), v -> v.get(0))));

        Map<Integer, Student> collect11 = students.stream().collect(groupingBy(Student::getId, collectingAndThen(maxBy(Comparator.comparing(Student::getAge)), Optional::get)));


        /*正确尝试1*/
        Map<Integer, List<Student>> collect12 = students.stream().collect(groupingBy(Student::getId, collectingAndThen(toList(), (list) ->

                    list.stream().filter(x -> x.getAge() < 5).collect(toList())

        )));

        Map<Integer, List<Student>> collect13 = students.stream().

                collect(groupingBy(Student::getId, collectingAndThen(toList(), (list) ->

                list.stream().peek(x -> x.setName("对不对就看你了")).collect(toList())

        )));

        List<String> s1 = Arrays.asList("a", "bb", "cc", "ddd");

        Map<Integer, String> r1 = s1.stream()
                .collect(groupingBy(String::length, joining(",", "[", "]")));

        System.out.println(r1); // {1=[a], 2=[bb,cc], 3=[ddd]}









    }





}
