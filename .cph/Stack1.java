// // Implementation of stack using ArrayList

// import java.util.ArrayList;
// public class Stack1 {
//     static class Stack{
//         static ArrayList<Integer> list=new ArrayList<>();
//         public static boolean isEmpty(){
//             return list.size()==0;  // if size of list is 0 then it returns true
//         }

//         //push
//         public static void push(int data){
//             list.add(data);
//         }
//         //pop
//         public static int pop(){
//             //base case if shack is empty
//             if(isEmpty()){
//                 return -1;
//             }
//             int top=list.get(list.size()-1); // list element of list
//             list.remove(list.size()-1);
//             return top;
//         }
//         // peek
//         public static int peek(){
//             //base case if shack is empty
//             if(isEmpty()){
//                 return -1;
//             }

//             return list.get(list.size()-1);
//         }
//     }
//     public static void main(String[] args) {
//         Stack s =new Stack();
//         s.push(1);
//         s.push(2);
//         s.push(3);

//         while (!s.isEmpty()) {
//             System.out.println(s.peek());
//             s.pop();
//         }
//     }
// }




// Implementation of stack using LinkedList

// public class Stack1 {
//     static class Node{
//         int data;
//         Node next;

//         Node(int data){
//             this.data=data;
//             this.next=null;
//         }

//     }
//     static class Stack{
//         static Node head= null;

//         public static boolean isEmpty(){
//             return head==null;
//         }
//         //push
//         public static void push(int data){
//             Node newNode=new Node(data); 
//             //base case if linkedlist is empty
//             if(isEmpty()){
//                 head=newNode;
//                 return;
//             }
//             newNode.next=head;
//             head=newNode;
//         }
//         //pop
//         public static int pop(){
//             if(isEmpty()){
//                 return -1;
//             }
//             int top=head.data;
//             head=head.next;
//             return top;
//         }
//         // peek
//         public static int peek(){
//             if(isEmpty()){
//                 return -1;
//             }
//             return head.data;
//         }
//     }
//     public static void main(String[] args) {
//         Stack s =new Stack();
//         s.push(1);
//         s.push(2);
//         s.push(3);

//         while (!s.isEmpty()) {
//             System.out.println(s.peek());
//             s.pop();
//         }
//     }
// }



//// stack using java collection framework

// import java.util.*;
// public class Stack1 {
//     public static void main(String[] args) {
//         Stack<Integer> s=new Stack<>();
//         s.push(1);
//         s.push(2);
//         s.push(3);

//          while (!s.isEmpty()) {
//             System.out.println(s.peek());
//             s.pop();
//         }
//     }
// }













// /////// Q} push at the bottom of the stack


// import java.util.*;

// public class Stack1 {
//     public static void pushAtBottom(Stack<Integer> s, int data){
//         // corner case (work)
//         if(s.isEmpty()){
//             s.push(data);
//             return;
//         }
//         int top = s.pop();   // remove while going up 
//         pushAtBottom(s, data);  // recursive step
//         s.push(top);  // add while going down
//     }

//     ////  Q} Reverse a String using a stack
//     public static String reverseString(String str){
//         Stack<Character> s = new Stack<>();
//         int idx = 0;
//         while (idx < str.length()) {
//             s.push(str.charAt(idx));
//             idx++;
//         }
//         StringBuilder result = new StringBuilder("");
//         while (!s.isEmpty()) {
//             char curr = s.pop();
//             result.append(curr);
//         }
//         str = result.toString();
//         return str;
//     }

//     // Q} Reverse a stack 
//     public static void reverseStack(Stack<Integer> s){
//         if(s.isEmpty()){
//             return ;
//         }
//         int top = s.pop(); // while going up in stack
//         reverseStack(s);  // recursive step 
//         pushAtBottom(s, top); // while going down in stack
//     }

//     public static void printStack(Stack<Integer> s){
//         while(!s.isEmpty()){
//             System.out.println(s.pop());
//         }
//     }

//     public static void main(String[] args) {
//         Stack<Integer> s = new Stack<>();

//         s.push(1);
//         s.push(2);
//         s.push(3);

//         pushAtBottom(s, 4);
//         System.out.println("Stack after pushAtBottom:");
//         printStack(s); // This will empty the stack

//         String str = "abc";
//         String result = reverseString(str);
//         System.out.println("Reversed string is :" + result);

//         // Re-fill stack for reverseStack demo
//         s.push(1);
//         s.push(2);
//         s.push(3);
//         s.push(4);

//         reverseStack(s);
//         System.out.println("Stack after reverseStack:");
//         printStack(s);
//     }
// }
 


// // Q} stock span problem 

// import java.util.*;
// public class Stack1 {
//     public static void stockSpan(int stocks[], int span[]){
//         Stack<Integer> s= new Stack<>();
//         span[0]=1; // always span of 0 is 1
//         s.push(0); // pushing idx 0 in the stack
//         for(int i=1;i<stocks.length;i++){
//             int currPrice=stocks[i];
//             while (!s.isEmpty() && currPrice>stocks[s.peek()]) {
//                 s.pop();
//             }
//             if(s.isEmpty()){
//                 span[i]=i+1;
//             }else{
//                 int prevHigh=s.peek();
//                 span[i]=i-prevHigh;
//             }
//             s.push(i);
//         }
//     }
//     public static void main(String[] args) {
//         int stocks[]={100,80,60,70,60,85,100};
//         int span[]=new int[stocks.length]; // span array with the lenght of the same of stocks array
//         stockSpan(stocks,span);

//         for(int i=0;i<span.length;i++){
//             System.out.print(span[i]+" ");
//         }
//     }
// }



// // Q} Next Greater element

import java.util.*;

public class Stack1 {
    public static void main(String[] args) {
        int arr[] = {6, 8, 0, 1, 3};
        Stack<Integer> s = new Stack<>();
        int nextGreater[] = new int[arr.length];

        for (int i = arr.length-1; i >= 0; i--) {
            // 1
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            // 2
            if (s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()];
            }
            // 3
            s.push(i);
        }

        for (int i = 0; i < nextGreater.length; i++) {
            System.out.print(nextGreater[i] + " ");
        }
        System.out.println();
    }
}
