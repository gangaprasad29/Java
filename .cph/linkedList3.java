// // java collections framework

// import java.util.LinkedList;
// public class linkedList3 {
//     public static void main(String[] args) {
//         //create
//         LinkedList<Integer> ll = new LinkedList<>();

//         //add
//         ll.addLast(1);
//         ll.addLast(2);
//         ll.addFirst(0);
//         System.out.println(ll);
//         //remove
//         ll.removeLast();
//         ll.removeFirst();
//         System.out.println(ll);
//     }
// }


// // merge sort on a linkedlist


// import java.util.*;
// class Node {
//     int data;
//     Node next;

//     Node(int data){
//         this.data = data;
//         this.next = null;
//     }
// }

// class LinkedList {
//     Node head;

//     public void addFirst(int data){
//         Node newNode = new Node(data);
//         newNode.next = head;
//         head = newNode;
//     }

//     public String toString(){
//         StringBuilder sb = new StringBuilder();
//         Node temp = head;
//         while(temp != null){
//             sb.append(temp.data);
//             if(temp.next != null){
//                 sb.append(" -> ");
//             }
//             temp = temp.next;
//         }
//         return sb.toString();
//     }

//     // Zig-Zag the linkedlist\
//     public void zigZag(){
//         //find middle
//         Node slow=head;
//         Node fast=head.next;
//         while(fast!=null && fast.next!=null){
//             slow=slow.next;
//             fast=fast.next.next;
//         }
//         Node mid=slow;

//         //reverse 2nd half 
//         Node curr=mid.next;
//         mid.next=null;
//         Node prev=null;
//         Node next;

//         while(curr!=null){
//             next=curr.next;
//             curr.next=prev;
//             prev=curr;
//             curr=next;
//         }
//         Node leftH=head;
//         Node rightH=prev;
//         Node nextL,nextR;

//         // alternate merge
//         while(leftH != null && rightH != null){
//             nextL=leftH.next;
//             leftH.next=rightH;
//             nextR=rightH.next;
//             rightH.next=nextL;

//             leftH=nextL;
//             rightH=nextR;
//         }
//     }
// }

// public class linkedList3 {
//     private Node getMid(Node head){
//         Node slow=head;
//         Node fast=head.next;
//         while(fast!=null && fast.next!=null){
//             slow=slow.next;
//             fast=fast.next.next;
//         }
//         return slow; // mid
//     }

//     private Node merge(Node head1, Node head2){
//         Node mergedLL=new Node(-1);
//         Node temp=mergedLL;
//         while(head1 !=null && head2!=null){
//             if(head1.data<=head2.data){
//                 temp.next=head1;
//                 head1=head1.next;
//                 temp=temp.next;
//             }else{
//                 temp.next=head2;
//                 head2=head2.next;
//                 temp=temp.next;
//             }
//         }   ///  for remaining elements we are using below two loops
//         while(head1!=null){
//             temp.next=head1;
//             head1=head1.next;
//             temp=temp.next;
//         }
//         while(head2!=null){
//             temp.next=head2;
//             head2=head2.next;
//             temp=temp.next;
//         }
//         return mergedLL.next;
//     }

//     public static Node mergeSortLL(Node head){
//         if(head==null || head.next==null){
//             return head;
//         }
//         //find mid
//         linkedList3 obj = new linkedList3();
//         Node mid=obj.getMid(head);

//         //left and right MS(merge sort)
//         Node rightHead=mid.next; // right half
//         mid.next=null;  // left half
//         Node newLeft=mergeSortLL(head);
//         Node newRight=mergeSortLL(rightHead);

//         //merge      
//         return obj.merge(newLeft,newRight);
//     }

//     public static void main(String[] args) {
//         LinkedList ll=new LinkedList();
//         ll.addFirst(1);
//         ll.addFirst(2);
//         ll.addFirst(3);
//         ll.addFirst(4);
//         ll.addFirst(5);
//         System.out.println(ll);
//         ll.head=mergeSortLL(ll.head);
//         System.out.println(ll);

//         ll.zigZag();
//         System.out.println(ll);
//     }
// }





/////////////////  Doubly LinkedList \\\\\\\\\\\\\\\\\

public class linkedList3 {
    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // Add at beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Add at end
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Remove from beginning
    public int removeFirst() {
        if (head == null) {
            System.out.println("List is empty.");
            return -1;
        }
        int val = head.data;
        size--;
        if (head == tail) { // only one node
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        return val;
    }

    // Remove from end
    public int removeLast() {
        if (tail == null) {
            System.out.println("List is empty.");
            return -1;
        }
        int val = tail.data;
        size--;
        if (head == tail) { // only one node
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        return val;
    }

    //reverse
    public void reverse(){
        Node curr=head;
        Node prev=null;
        Node next;
        while(curr != null){
            next=curr.next;
            curr.next=prev;
            curr.prev=next;
            prev=curr;
            curr=next;
        }
        head=prev;
    }

    // Print list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method to test
    public static void main(String[] args) {
        linkedList3 dll = new linkedList3();

        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);

        dll.addLast(4);
        dll.addLast(5);

        System.out.print("List after additions: ");
        dll.printList(); // 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> null

        dll.removeFirst();
        dll.removeLast();

        System.out.print("List after removals: ");
        dll.printList(); // 2 <-> 3 <-> 4 <-> null

        System.out.println("Size: " + size);

        dll.reverse();
        dll.printList();
    }
}
