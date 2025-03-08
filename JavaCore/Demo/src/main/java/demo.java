import java.util.Iterator;
import java.util.LinkedList;

public class demo {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        int a = 8;
        list.add(a);
        list.add(8);
        list.add(5);
        list.add(1);

        // Duyệt danh sách đúng cách
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        String str = new String("Phạm Xuân Tiến");
        System.out.println(str);
    }
}
