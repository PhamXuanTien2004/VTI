package Collection;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        set.add(23);
        set.add(1);
        set.add(2);
        set.add(0);
        set.add(6);

        System.out.println(set);

    }
}
