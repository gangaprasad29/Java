// search in a linked list(iterative)

public class LinkedList2 {
    public class Node {
        int data;
        Node next; 

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    // Insert at first
    public void insertAtFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    // Method to check for cycle
    public boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // Remove cycle
    public void removeCycle(){
        // s1: detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false; /// used to track if cycle is exis or not
        while(fast != null && fast.next != null){
            slow = slow.next;        //slow +1
            fast = fast.next.next;   //fast +2
            if(slow == fast){
                cycle = true;
                break;
            }
        }
        if(!cycle){
            return;
        }
        // s2: find meeting point
        slow = head;     //starting slow from head
        //base case (when 2^nd time fast and slow meet at head)
        if(slow == fast){
            while(fast.next != slow){
                fast = fast.next;
            }
            fast.next = null;
            return;
        }
        Node prev = null;
        while(slow != fast){
            prev = fast;  // last node
            slow = slow.next;
            fast = fast.next;
        }
        // s3: remove cycle => last.next=null 
         prev.next = null;
    }
    public static void main(String[] args) {
        LinkedList2 ll = new LinkedList2();
        ll.insertAtFirst(10);
        ll.insertAtFirst(20);
        ll.insertAtFirst(30);
        ll.tail.next = ll.head; // creating cycle manually 
        System.out.println("Cycle exists: " + ll.isCycle()); 
        ll.removeCycle();
        System.out.println("Cycle exists: " + ll.isCycle()); 
    }
}


