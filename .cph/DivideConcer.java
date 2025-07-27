///// merge sort (imp)

// public class DivideConcer {
//     // printing function for sorted array
//    public static void printArray(int arr[]){
//       for(int i=0;i<arr.length;i++){
//          System.out.print(arr[i]+" ");
//       }
//       System.out.println();
//    }

//    public static void mergeSort(int arr[],int si, int ei){
//       //base case
//       if(si>=ei){
//          return;
//       }
//       //work  (will happen recursively)
//       int mid=si+(ei-si)/2;
//       mergeSort(arr, si, mid); //for left part
//       mergeSort(arr, mid+1, ei); //for right part
//       merge(arr, si, mid,ei); // merging all the individual part 
//    }

//    public static void merge(int arr[], int si, int mid, int ei) {
//       int temparr[] = new int[ei - si + 1]; 
//       int i = si; // pointer to left part
//       int j = mid + 1; // pointer to right part
//       int k = 0;  // pointer for temp arr 
  
//       while(i <= mid && j <= ei) {  // loop for left and right part 
//           if(arr[i] < arr[j]) {     // compairing left and right part
//               temparr[k++] = arr[i++];
//           } else {
//               temparr[k++] = arr[j++];
//           }
//       }
//   // below loops are if someting is remaining from left and right 
//       // left part
//       while(i <= mid) {
//           temparr[k++] = arr[i++];
//       }
//       // right part
//       while(j <= ei) { // FIXED this line
//           temparr[k++] = arr[j++];
//       }
  
//       // copy temp to original array
//       for(k = 0, i = si; k < temparr.length; k++, i++) {
//           arr[i] = temparr[k];
//       }
//   }
  
//    public static void main(String[] args) {
//       int arr[]={6,3,9,5,2,8};
//       mergeSort(arr, 0, arr.length-1);
//       printArray(arr);
//    }
// }



///// Quick sort

// public class DivideConcer {
//     // printing function 
//    public static void printArray(int arr[]) {
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//    }

//    public static void QuickSort(int arr[], int si, int ei) {
//        // base case
//        if (si >= ei) {
//            return;
//        }
//        // work
//        int Pidx = partition(arr, si, ei);
//        QuickSort(arr, si, Pidx - 1); // left part
//        QuickSort(arr, Pidx + 1, ei); // right part
//    }

//    public static int partition(int arr[], int si, int ei) {
//        int pivot = arr[ei];
//        int i = si - 1; // to make place for elements smaller than pivot
//        for (int j = si; j < ei; j++) { // j is pointer to original array
//            if (arr[j] <= pivot) {
//                i++;
//                // swap
//                int temp = arr[j];
//                arr[j] = arr[i];
//                arr[i] = temp;
//            }// for arr= 6,3,9,8,2,5  (5 is pivot)
//            // this loop will get arr= 3,2,9,8,6,5
//        }
//        i++;
//        // swap pivot  to its correct position
//        int temp = arr[i];
//        arr[i] = arr[ei];
//        arr[ei] = temp;

//        return i; // return pivot index
//    }

//    public static void main(String[] args) {
//        int arr[] = { 6, 3, 9, 8, 2, 5 };
//        QuickSort(arr, 0, arr.length - 1);
//        printArray(arr);
//    }
// }



/////// Serch in sorted rotated array (imp for interview)

// public class DivideConcer {
//     public static int Serch(int[] arr, int target, int si, int ei) {
//         // base case
//         if (si > ei) {
//             return -1;
//         }
//         // work
//         int mid = si + (ei - si) / 2;
//         // case found
//         if (arr[mid] == target) {
//             return mid;
//         }
//         // mid on L1
//         if (arr[si] <= arr[mid]) {
//             // case a: left
//             if (target >= arr[si] && target <= arr[mid]) {
//                 return Serch(arr, target, si, mid - 1);
//             } else {
//                 // case b: right
//                 return Serch(arr, target, mid + 1, ei);
//             }
//         }
//         // mid on L2
//         else {
//             // case c: right
//             if (target >= arr[mid] && target <= arr[ei]) {
//                 return Serch(arr, target, mid + 1, ei);
//             } else {
//                 // case d: left
//                 return Serch(arr, target, si, mid - 1);
//             }
//         }
//     }

//     public static void main(String[] args) {
//         int[] arr = {4, 5, 6,7, 0, 1, 2};
//         int target = 0; // expected output -> index 4
//         int tarIdx = Serch(arr, target, 0, arr.length - 1);
//         System.out.println(tarIdx);
//     }
// }
