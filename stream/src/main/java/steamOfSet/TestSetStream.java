package steamOfSet;

import java.util.ArrayList;


/**
 * @description: TODO
 * @date: 2020/5/16 16:46
 * @author: ShangKun
 * @version: 2.0.0
 */
public class TestSetStream {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);



         list.stream().forEach(x->x++);
    }
}
