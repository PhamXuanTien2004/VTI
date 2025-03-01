package Collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueDemo {
    public static void main(String[] args) {
        Stack <String> stack = new Stack<>();
        stack.add("Nguyễn Văn Nam");
        stack.add("Nguyễn Văn Huyên") ;
        stack.add("Trần Văn Nam") ;
        stack.add("Nguyễn Văn A") ;
        // in ra phần từ ở đầu mà k lm mất nos đi ở danh sách
        System.out.println(stack.peek());
        while (!stack.empty()){
            // lấy ra hẳn phần từ ở đâu
            System.out.println(stack.pop());
        }
        System.out.println("------------------------------------------ ");
        Queue<String> queue = new LinkedList<>();

        queue.add("Nguyễn Văn Nam");
        queue.add("Nguyễn Văn Huyên") ;
        queue.add("Trần Văn Nam") ;
        queue.add("Nguyễn Văn A") ;
        System.out.println(queue.poll());

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }

    }
}
