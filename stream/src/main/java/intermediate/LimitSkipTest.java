package intermediate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LimitSkipTest {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        LimitSkipTest limitSkipTest = new LimitSkipTest();
        for (int i = 0; i < 100; i++) {
            users.add(limitSkipTest.new User(i, "name_" + i)); // 内部类构造
        }

        List<String> userList = users.stream()
                .map(User::getName) // name_0name_1name_2name_3name_4name_5name_6name_7name_8name_9
                .limit(10)
                .skip(3)
                .collect(Collectors.toList());

        System.out.println(userList);// [name_3, name_4, name_5, name_6, name_7, name_8, name_9]
    }
    // 内部类
    class User {
        public int no;
        private final String name;
        public User(int no, String name) { this.no = no; this.name = name; }
        public String getName() { System.out.print(name); return name; }
    }
}