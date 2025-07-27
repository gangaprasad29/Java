// import java.util.*;

// public class Heap {
//     public static void main(String[] args) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>();

//         // // if we want to reverse the answer/priority 
//         // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

//         pq.add(1);
//         pq.add(5);
//         pq.add(8);
//         pq.add(4);

//         while(!pq.isEmpty()){
//             System.out.println(pq.peek());
//             pq.remove();
//         }
//     }
// }



/////// PriorityQueue for Objects(ex.Student)

// import java.util.*;
// public class Heap {
//     static class  Student implements Comparable<Student> {
//          String name;
//          int rank;

//          public Student(String name,int rank){
//             this.name=name;
//             this.rank=rank;
//          }

//          @Override
//          public int compareTo(Student s2){
//             return this.rank - s2.rank;
//          }
//     }
//     public static void main(String[] args) {
//         PriorityQueue<Student> pq = new PriorityQueue<>();

//         pq.add(new Student("anshul", 3));
//         pq.add(new Student("ganga", 1));
//         pq.add(new Student("prathamesh",5));
//         pq.add(new Student("yogesh",2));

//         while(!pq.isEmpty()){
//             System.out.println(pq.peek().name + "-> " + pq.peek().rank);
//             pq.remove();
//         }
//     }
// }



/////////////// Heap \\\\\\\\\\\\\\

// import java.util.*;
// public class Heap {
//     static class InnerHeap {
//         ArrayList<Integer> arr = new ArrayList<>();

//         // Add a new element to the Min-Heap
//         public void add(int data) {
//             arr.add(data); // Add at last index

//             int x = arr.size() - 1; // Child index
//             int parentIdx = (x - 1) / 2; // parent idx

//             while (x > 0 && arr.get(x) < arr.get(parentIdx)) {
//                 // Swap child and parent
//                 int temp = arr.get(x);
//                 arr.set(x, arr.get(parentIdx));
//                 arr.set(parentIdx, temp);
//                 // update
//                 x=parentIdx;
//                 parentIdx=(x-1)/2;
//             }
//         }
//         // min in heap
//         public int peek(){
//             return arr.get(0);
//         }

//         // Delete in heap

//         private void Heapify(int i){
//                 int left=2*i+1;
//                 int right=2*i+2;
//                 int minIdx=i;

//                 if(left < arr.size() && arr.get(left)<arr.get(minIdx)){
//                     minIdx=left;
//                 }
//                 if(right < arr.size() && arr.get(right)<arr.get(minIdx)){
//                     minIdx=right;
//                 }

//                 if(minIdx!=i){
//                     //swap
//                     int temp=arr.get(i);
//                     arr.set(i, arr.get(minIdx));
//                     arr.set(minIdx, temp);

//                     Heapify(minIdx);
//                 }
//             }

//         public int remove(){
//             int data=arr.get(0);

//             // step 1: swap 1st and last
//             int temp=arr.get(0);
//             arr.set(0, arr.get(arr.size()-1));
//             arr.set(arr.size()-1, temp);

//             //step 2: delete last 
//             arr.remove(arr.size()-1);

//             //step 3: Heapify
//             Heapify(0);
//             return data;
//         }

//         public boolean isEmpty(){
//             return arr.size() == 0;
//         }
//     }
//     public static void main(String[] args) {
//         InnerHeap heap = new InnerHeap();
//         heap.add(3);
//         heap.add(4);
//         heap.add(1);
//         heap.add(5);

//         while(!heap.isEmpty()){
//             System.out.println(heap.peek());
//             heap.remove();
//         }

//     }
// }




// //////// Heap Sort \\\\\\\\\\ \\

import java.util.*;
public class Heap {
    public static void heapify(int arr[] , int i,int size){
        int left=2*i+1;
        int right=2*i+2;
        int maxIdx=i;

        if(left<size && arr[left]>arr[maxIdx]){
            maxIdx=left;
        }
        if(right<size && arr[right]>arr[maxIdx]){
            maxIdx=right;
        }

        if(maxIdx!=i){
            //swap
            int temp=arr[i];
            arr[i]=arr[maxIdx];
            arr[maxIdx]=temp;

            heapify(arr,maxIdx,size);
        }
    }
    public static void heapSort(int arr[]){
        // step1: build maxHeap
        int n=arr.length;
        for(int i=n/2;i>=0;i--){
            heapify(arr,i,n);
        }
        //step2: push largest at end 
        for(int i=n-1;i>0;i--){
            //swap(first with last)
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;

            heapify(arr,0,i);
        }

    }
    public static void main(String[] args) {
        int arr[]= {1,2,4,5,3};
        heapSort(arr);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}