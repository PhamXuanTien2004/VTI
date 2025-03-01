package Collection;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(4);
        list.add(8);

        System.out.println(list);
        System.out.println(list.get(2));
    }
}
