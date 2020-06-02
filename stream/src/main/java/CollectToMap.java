import java.util.*;
import java.util.stream.Collectors;

import pojo.Student;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

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
        Student student6 = new Student(5,"张4",1);
        Student student7 = new Student(6,"张4",11);


        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);



        Map<Integer, List<Student>> collect = students.stream().collect(Collectors.groupingBy(Student::getId));
        /*toMap*/
//        Map<String, Student> collect6 = students.stream().collect(Collectors.toMap(Student::getName, v -> v));

        /*分组计数*/

        Map<Integer, Long> collect4 = students.stream().collect(Collectors.groupingBy(Student::getId, counting()));

        Map<Integer, List<Student>> collect6 = students.stream().collect(groupingBy(Student::getId));
        collect6.forEach((k,v)-> {
            List<Student> collect1 = v.stream().peek(x -> x.setAge(null)).collect(Collectors.toList());
        });
        /*瞎写的 好像分组后又取了其中一个值*/
        Map<Integer, Set<String>> collect5 = students.stream().collect(Collectors.groupingBy(Student::getAge, Collectors.mapping(Student::getName, Collectors.toSet())));

        collect5.forEach((k,v)-> System.out.println(k+"|"+v));




        /*获取最大的*/
        Optional<Student> max = students.stream().max(Comparator.comparing(Student::getAge));

        /*获取最小的*/
        Optional<Student> min = students.stream().min(Comparator.comparing(Student::getAge));

        /*获取平均值*/

        Double collect1 = students.stream().collect(Collectors.averagingDouble(Student::getAge));

        /*取上面所有的*/
        IntSummaryStatistics collect2 = students.stream().collect(Collectors.summarizingInt(Student::getAge));
        long sum = collect2.getSum();
        int min1 = collect2.getMin();

        /*拼接字符串*/
       String join =students.stream().map(Student::getAge).map(String::valueOf).collect(Collectors.joining("|"));

       /*reduce求和*/
       Integer collect3 = students.stream().map(Student::getAge).reduce(0, Integer::sum);
    }
}
