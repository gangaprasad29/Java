// ////// Q}  First non-repeating letter in a stream of characters


import java.util.Queue;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.LinkedList;

// public class Queue3 {
//     public static void printNonRepeating(String str) {
//         int freq[] = new int[26];
//         Queue<Character> q = new LinkedList<>();

//         for (int i = 0; i < str.length(); i++) {
//             char ch = str.charAt(i);
//             q.add(ch);
//             freq[ch - 'a']++;

//             // Remove repeating characters from front
//             while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
//                 q.remove();
//             }

//             if (q.isEmpty()) {
//                 System.out.print("-1 ");
//             } else {
//                 System.out.print(q.peek() + " ");
//             }
//         }
//         System.out.println();
//     }

//     public static void main(String[] args) {
//         String str = "aabccxb";
//         printNonRepeating(str);
//     }
// }



///// Q} interleave 2 Halves of a Queue (even length)

// import java.util.*;
// public class Queue3 {
//     public static void interleave(Queue<Integer> q) {
//         if (q.size() % 2 != 0) {
//             System.out.println("Queue contains odd number of elements");
//             return;
//         }

//         int size = q.size();
//         Queue<Integer> firstHalf = new LinkedList<>();

//         // Add first half to new queue
//         for (int i = 0; i < size / 2; i++) {
//             firstHalf.add(q.remove());
//         }

//         // Interleave both halves
//         while (!firstHalf.isEmpty()) {
//             q.add(firstHalf.remove());
//             q.add(q.remove());
//         }
//     }

//     public static void main(String[] args) {
//         Queue<Integer> q = new LinkedList<>();
//         q.add(1);
//         q.add(2);
//         q.add(3);
//         q.add(4);
//         q.add(5);
//         q.add(6);
//         q.add(7);
//         q.add(8);
//         q.add(9);
//         q.add(10);

//         interleave(q);

//         // Print the interleaved queue
//         while (!q.isEmpty()) {
//             System.out.print(q.remove() + " ");
//         }
//         System.out.println();
//     }
// }



///// Q} Queue Reversal

// public class Queue3 {
//     public static void reverse(Queue<Integer> q){
//         Stack<Integer> s = new Stack<>();
//         while(!q.isEmpty()){
//             s.push(q.remove());
//         }
//         while(!s.isEmpty()){
//             q.add(s.pop());
//         }
//     }
//     public static void main(String[] args) {
//         Queue<Integer> q = new LinkedList<>();
//         q.add(1);
//         q.add(2);
//         q.add(3);
//         q.add(4);
//         q.add(5);

//         reverse(q);

//         while(!q.isEmpty()){
//             System.out.println(q.remove());
//         }
//         System.out.println();
//     }
// }






///////////  Deque(double ended queue)    \\\\\\\\\

// import java.util.*;
// public class Queue3 {

//     public static void main(String[] args) {
//          Deque<Integer> dq=new LinkedList<>();
//          dq.addFirst(1);
//          dq.addFirst(2);
//          dq.addLast(3);
//          dq.addLast(4);
//          System.out.println(dq);
//          dq.removeFirst();
//          dq.removeLast();
//          System.out.println(dq);

//          System.out.println("first el:"+dq.getFirst());
//          System.out.println("first el:"+dq.getLast());
//     }
// }



// /// Implementation of stack using Deque \\\

// import java.util.*;
// public class Queue3 {
//     static class Stack{
//         Deque<Integer> dq=new LinkedList<>();
//         //add
//         public void push(int data){
//             dq.addLast(data);
//         }
//         //remove
//         public int pop(){
//             return dq.removeLast();
//         }
//         //peek
//         public int peek(){
//             return dq.getLast();
//         }
//     }
//     public static void main(String[] args) {
//         Stack s = new Stack();
//         s.push(1);
//         s.push(2);
//         s.push(3);
//         System.out.println("peek = "+s.peek());
        
//              System.out.println(s.pop());
//              System.out.println(s.pop());
//              System.out.println(s.pop());
        
//     }
// }




// Implementation of Queue using Deque \\\

import java.util.*;
public class Queue3 {
    static class Queue{
        Deque<Integer> dq=new LinkedList<>();
        //add
        public void add(int data){
            dq.addLast(data);
        }
        //remove
        public int remove(){
            return dq.removeFirst();
        }
        //peek
        public int peek(){
            return dq.getFirst();
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println("peek = "+q.peek());
        
             System.out.println(q.remove());
             System.out.println(q.remove());
             System.out.println(q.remove());
        
    }
}