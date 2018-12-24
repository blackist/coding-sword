package offer;

import java.util.Stack;

public class _07StackToQueue {

    static class MQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        MQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public MQueue push(Integer node) {
            stack1.push(node);
            return MQueue.this;
        }

        public Integer pop() {
            if (stack1.isEmpty() && stack2.isEmpty()) {
                return null;
            }
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        public int size() {
            return stack1.size() + stack2.size();
        }

        public void print() {
            while (this.size() > 0 ) {
                System.out.println(this.pop());
            }
        }
    }

    public static void main(String[] args) {
        MQueue mQueue = new MQueue();
        mQueue.push(1).push(2).push(3).push(4);
        mQueue.print();
    }
}
