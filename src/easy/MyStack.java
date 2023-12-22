package easy;

import java.util.LinkedList;
import java.util.Queue;

// 225. Implement Stack using Queues
class MyStack {
    private final Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
        }
        return queue.remove();
    }

    public int top() {
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
        }
        int top = queue.remove();
        queue.add(top);
        return top;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}