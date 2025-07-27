public class LinkedList {
    public static class Node {
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

    // Add at beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
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
        tail = newNode;
    }

    //  Add at a specific index (middle)
    public void addMiddle(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while (i < idx - 1 && temp != null) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;

    } 

    // remove first node
    public int removeFirst(){
        if(size==0){
            System.out.println("list is empty ");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }

    //remove last
    public int removeLast(){
        if(size==0){
            System.out.println("list is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        // prev: i= size-2
        Node prev=head;
        for(int i=0; i<size-2;i++){
            prev=prev.next;
        }

        int val=prev.next.data; // tail ka data
        prev.next=null;
        size--;
        return val;

    }
    // search in linked list (iterative)
    public int itrSearch(int key){
        Node temp=head;
        int i=0;
        while(temp!=null){
            if(temp.data==key){
                return i;
            }
            temp=temp.next;
            i++;
        }
        return -1;
    }

    // Recursive search
    public int helper(Node head, int key) {
        if (head == null) {
            return -1; // Base case: reached end of list without finding the key
        }
        if (head.data == key) {
            return 0; // Found the key at this node
        }
        int idx = helper(head.next, key); // Recursive call on next node
        if (idx == -1) {
            return -1; // Key was not found in the rest of the list
        }
        return idx + 1; // Key found further down, so add 1 to the index
    }

    public int recSearch(int key){
        return helper(head,key);
    }


    // Reverse a LinkedList(iterative approach)
    public void Recerse(){
        Node prev=null;
        Node curr=tail=head;
        Node nextnode;
        while(curr != null){
            nextnode=curr.next;
            curr.next=prev;  // reverse step
            prev=curr;
            curr=nextnode;
        } 
        head=prev;

    }


    // Find and remove the N^th node from the END
    public void deleteNthnode(int n){
        int size=0;
        Node temp=head;
        while (temp !=null) {
            temp=temp.next;
            size++;
        }
        //base case
        if(n==size){
            head=head.next; // remove first
            return;
        }
        // reach up to (size-n
        int i=1;
        int iTofind=size-n;
        Node prev= head;
        while(i<iTofind){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return;

    }


    // check pelendrom \\
    
        // slow-fast function to find mid
        public Node findMid(Node head){
            Node slow =head;
            Node fast=head;
            while(fast!=null && fast.next!=null){
                slow=slow.next;    //+1
                fast=fast.next.next; //+2
            }
            return slow; // slow is my mid
        }
    public boolean checkPelendrom(){
        // base case
        if(head==null || head.next==null){
            return true;
        }
        //step 1: slow-fast appraoch 
        Node miNode=findMid(head);

        // step 2: reverse 2^nd half
        Node prev=null;
        Node curr=miNode;
        Node nextNode;
        while(curr!=null){
            nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
        Node right =prev; //right half ka head
        Node left=head;

        // step 3: check left and right half
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;

    }
    // Print the list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);  // 3 -> 2 -> 1

        ll.addLast(4);
        ll.addLast(5);   // 3 -> 2 -> 1 -> 4 -> 5

        ll.addMiddle(2, 99);  // Insert 99 at index 2

        ll.printList();  // Output: 3 -> 2 -> 99 -> 1 -> 4 -> 5 -> null
        System.out.println(ll.size);

        ll.removeFirst();
        ll.printList();

        ll.removeLast();
        ll.printList();

        System.out.println(ll.itrSearch(3));

        System.out.println(ll.recSearch(4));

        ll.Recerse();
        ll.printList();

        ll.deleteNthnode(2);
        ll.printList();

        System.out.println(ll.checkPelendrom());
    }
}



