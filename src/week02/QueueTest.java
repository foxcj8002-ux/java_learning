package week02;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.peek();
        queue.poll();
        queue.poll();
        queue.poll();

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(10);
        stack.pop();
        stack.peek();

        PriorityQueue<Integer> queue1 = new PriorityQueue<>();

        queue1.offer(30);
        queue1.offer(10);
        queue1.offer(20);

        for (Integer num : queue1) {
            System.out.println(num);
        }

        while (!queue1.isEmpty()) {
            System.out.println(queue1.poll());
        }

    }
}
