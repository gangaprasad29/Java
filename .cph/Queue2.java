// import java.util.Queue;
// import java.util.ArrayDeque;
// import java.util.LinkedList;

// public class Queue2 {
//     public static void main(String[] args) {
//         // Queue<Integer> q = new LinkedList<>();
//         //or
        
//         Queue<Integer> q = new ArrayDeque<>();
//         q.add(1);
//         q.add(2);
//         q.add(3);
//         q.add(4);
//         while (!q.isEmpty()) {
//             System.out.println(q.peek());
//             q.remove();
//         }
//     }
// }


//////  Q} Queue Using 2 Stacks (Using Push O(n) )

// import java.util.*;
// public class Queue2 {
//     static class Queue {
//         static Stack<Integer> s1= new Stack<>();    
//         static Stack<Integer> s2= new Stack<>();  
        
//         public static boolean isEmpty(){
//             return s1.isEmpty();
//         }
//         //add
//         public static void add(int data){
//             while(!s1.isEmpty()){
//                 s2.push(s1.pop());
//             }
//             s1.push(data);
//             while(!s2.isEmpty()){
//                 s1.push(s2.pop());
//             }
//         }
//         //remove
//         public static int remove(){
//             if(isEmpty()){
//                 return -1;
//             }
//             return s1.pop();
//         }
//         //peek
//         public static int peek(){
//             if(isEmpty()){
//                 return -1;
//             }
//             return s1.peek();
//         }
//     }
//     public static void main(String[] args) {
//         Queue q = new Queue();
//         q.add(1);
//         q.add(2);
//         q.add(3);
        
//         while (!q.isEmpty()) {
//             System.out.println(q.peek());
//             q.remove();
//         }
//     }
// }



//////  Q} Stack Using 2 Queus



import java.util.*;

public class Queue2 {
    static class MyStack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        // add / push
        public static void push(int data) {
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        // remove / pop
        public static int pop() {
            if (isEmpty()) {
                System.out.println("empty stack");
                return -1;
            }

            int top = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        // peek (optional)
        public static int peek() {
            if (isEmpty()) {
                System.out.println("empty stack");
                return -1;
            }

            int top = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }

    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("Top: " + s.peek());
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}

