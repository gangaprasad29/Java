import java.util.ArrayList;
import java.util.Collections;



// public class MyArrayList {
//     public static void main(String[] args) {
//         ArrayList<Integer> list = new ArrayList<>();
//         ArrayList<String> list2 = new ArrayList<>();

//         // add operaion
//         list.add(1);         // O(1)
//         list.add(2);
//         list.add(3);
//         list.add(4);
//         list.add(3,9);  // (idx,val)  O(n)
//         System.out.println(list); // Output: [1, 2, 3, 4]

//         // size of arraylist
//         System.out.println(list.size());

//         // get operation
//         int element=list.get(2);
//         System.out.println(element);

//         // remove element
//         list.remove(2);
//         System.out.println(list);

//         //set element at index
//         list.set(2,10);
//         System.out.println(list);

//         // contains (return true if element is present else false)
//         System.out.println(list.contains(1));
//         System.out.println(list.contains(11));

//       // print the arraylist
//         System.out.println("List in order:");
//         for(int i = 0; i < list.size(); i++) {
//             System.out.print(list.get(i) + " ");
//         }
//         System.out.println();

//         // print the arraylist in reverse
//         System.out.println("List in reverse:");
//         for(int i = list.size() - 1; i >= 0; i--) {
//             System.out.print(list.get(i) + " ");
//         }
//         System.out.println();

//         // find maximum in an arraylist O(1)
//         int max=Integer.MIN_VALUE;
//         for(int i = 0; i < list.size(); i++) {
//             if(list.get(i)>max){
//                 max=list.get(i);
//             }
//         }
        
//         //// or
//         /// max=Math.max(max,list.get(i));
//         System.out.println("maximum is :"+max);
//     }
// }



/// swap two numbers


// public class MyArrayList {
//     public static void main(String[] args) {
//         // Create an ArrayList and add numbers
//         ArrayList<Integer> list = new ArrayList<>();
//         list.add(10);
//         list.add(20);
//         list.add(30);
//         list.add(40); 
//         System.out.println("Before Swap: " + list);

//         // Indices to swap
//         int index1 = 1; // value 20
//         int index2 = 3; // value 40

//         // Swap logic
//         int temp = list.get(index1);
//         list.set(index1, list.get(index2));
//         list.set(index2, temp);

//         System.out.println("After Swap: " + list);
//     }
// }



// // Sorting in arrylist (inbuilt method)

// public class MyArrayList {
//     public static void main(String[] args) {
//         ArrayList<Integer> list = new ArrayList<>();
//         list.add(10);
//         list.add(2);
//         list.add(90);
//         list.add(40);
//         // assending order
//         Collections.sort(list);
//         System.out.println(list);
//         // desending order
//         Collections.sort(list,Collections.reverseOrder());
//         System.out.println(list); 
//     }    
// }



// // Multi-Dimentional ArratList

// public class MyArrayList {
//     public static void main(String[] args) {
//         ArrayList<ArrayList<Integer>> mainList= new ArrayList<>();
        
//         ArrayList<Integer> list= new ArrayList<>();
//         list.add(1);
//         list.add(2);
//         mainList.add(list);
        
//         ArrayList<Integer> list2= new ArrayList<>();
//         list2.add(1);
//         list2.add(2);
//         mainList.add(list2);

//         for(int i=0;i<mainList.size();i++){
//             ArrayList<Integer> currList= mainList.get(i);
//             for(int j=0;j<currList.size();j++){
//                 System.out.print(currList.get(j)+" ");
//             }
//             System.out.println();
//         }
//         System.out.println(mainList);
//     }
// }


//// // Q} print the multi list 1 2 3 4 5 , 2 4 6 8 10 , 3 6 9 12 15

public class MyArrayList {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mainList= new ArrayList<>();
        
        ArrayList<Integer> list= new ArrayList<>();
        ArrayList<Integer> list2= new ArrayList<>();
        ArrayList<Integer> list3= new ArrayList<>();

        for(int i=1;i<=5;i++){
            list.add(i*1);   //1 2 3 4 5
            list2.add(i*2);  //2 4 6 8 10
            list3.add(i*3);  //3 6 9 12 15
        }

        mainList.add(list);
        mainList.add(list2);
        mainList.add(list3);

        for(int i=0;i<mainList.size();i++){
            ArrayList<Integer> currList= mainList.get(i);
            for(int j=0;j<currList.size();j++){
                System.out.print(currList.get(j)+" ");
            }
            System.out.println();
        }
        System.out.println(mainList);
    }
}