// Bubble sort

// public class sorting {
//     public static void BubbleSort(int arr[]){
//         int n=arr.length;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n-i-1;j++){
//             if(arr[j]>arr[j+1]){
//                 int temp=arr[j];
//                 arr[j]=arr[j+1];
//                 arr[j+1]=temp;
//              }
//             }
//         }
//         for(int i=0;i<n;i++){
//             System.out.print(arr[i]+" ");
//         }
//     }
//     public static void main(String args[]){
//         int[] arr={5,4,1,3,2};
//         BubbleSort(arr);
//     }    
// }




// // Selection Sort

// public class sorting {
//     public static void SelectionSort(int arr[]){
//       int n=arr.length;
//     for(int i=0;i<n-1;i++){
//        int minidx=i;
//        for(int j=i+1;j<n;j++){
//          if(arr[j]<arr[minidx]){
//             minidx = j;
//          }
//        }
//            int temp=arr[i];
//            arr[i]=arr[minidx];
//            arr[minidx]=temp;

//     }
//     for(int i=0;i<n;i++){
//         System.out.print(arr[i]+" ");
//        }

//   }
//     public static void main(String[] args) {
//         int[] arr={5,4,1,3,2};
//         SelectionSort(arr);
//     }
//    }



// // Insertion sort

// public class sorting {
//  public static void InsertionSort(int arr[]){
//    int n=arr.length;
//    for(int i=1;i<n;i++){
//       int key=arr[i];
//       int j= i-1;
//      while(j>=0 && arr[j]>key){
//          arr[j+1]=arr[j];
//          j--;
//      }
//      arr[j+1]=key;
//    }
//    for(int i=0;i<n;i++){
//         System.out.print(arr[i]+" ");
//        }
//  }
//     public static void main(String[] args) {
//        int[] arr={5,4,1,3,2};
//        InsertionSort(arr);    
//     }
// }


// //  INBUILT SORT  nlog(n)

import java.util.*;
public class sorting {

   public static void main(String args[]) {
      Integer[] arr={5,4,1,3,2};
      // Arrays.sort(arr);

      // Arrays.sort(arr,0,3);


      // Arrays.sort(arr, Collections.reverseOrder()); // Sort in descending order
     
      Arrays.sort(arr, 0, 3, Collections.reverseOrder());

      for(int i=0;i<arr.length;i++){
      System.out.print(arr[i]+" ");
      }
   }
}




// //  COUNTING SORT

