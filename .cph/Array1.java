// import java.util.*;

// public class Array1 {
//     public static void main(String[] args) {
//          int marks[]=new int[50];
//          Scanner s=new Scanner(System.in);
//         //  int phy=s.nextInt();
//         marks[0]=s.nextInt();
//         marks[1]=s.nextInt();
//         marks[2]=300;
//         s.close();

//          System.out.println(marks[2]);
//          System.out.println(marks[0]);
//          System.out.println(marks[1]);
//          System.out.println("length"+marks.length);
//     }
    
// }



// public class Array1 {
//     public static void updatearr(int marks[]){
//         for(int i=0;i<marks.length;i++){
//             marks[i]+=1;
//         }
//     }
//     public static void main(String[] args) {
//          int marks[]= {97,98,99};
           
//          updatearr(marks);
//          for(int i=0;i<marks.length;i++){
//               System.out.print(marks[i]+" ");
//          }
     
//     }
    
// }




// public class Array1 {
//  public static int leanersearch(int numbers[],int key){
//     for(int i=0;i<numbers.length;i++){
//         if(numbers[i]==key){
//             return i;
//         }
//     }
//     return -1;
//  }
//     public static void main(String[] args) {
//         int numbers[]={2,4,6,8,10,12,14,16};
//         int key=10;

//         int index= leanersearch(numbers, key);
//         if(index == -1){
//             System.out.println(key +"is not found ");
//         }
//         else{
//             System.out.println(key +" is at index "+ index);
//         }
//     }
// }


// // largest in array


// public class Array1 {
//    public static int  largestINarray(int arr[]){
//     int largest=Integer.MIN_VALUE; // or we can write largest=arr[0]
//     for(int i=0;i<arr.length;i++){
//         if(arr[i]>largest){
//             largest=arr[i];
//         }
//     }
//     return largest;
//    }
//     public static void main(String[] args) {
//         int arr[]={22,3,45,6,7,25,565,21,5,2,455};
        
//         int largest=largestINarray(arr);
//         System.out.println("largest element in the array is: "+largest);
//     }
// }



// binary search


// public class Array1 {
//     public static int binarySearch(int arr[], int key) {
//         int start = 0; // Start should be the index, not the array value
//         int end = arr.length - 1; // End should be the last index of the array
        
//         while (start <= end) {
//             int mid = start + (end - start) / 2; // Avoid potential overflow with (start + end) / 2
            
//             if (arr[mid] == key) {
//                 return mid; // Key found
//             } else if (key < arr[mid]) {
//                 end = mid - 1; // Search in the left half
//             } else {
//                 start = mid + 1; // Search in the right half
//             }
//         }
//         return -1; // Key not found
//     }
//     public static void main(String[] args) {
//         int arr[] = {1, 2, 3, 4, 5, 6, 77, 88, 99, 105, 144};
//         int key = 99;

//         int index = binarySearch(arr, key);

//         if (index != -1) {
//             System.out.println("Key is found at index " + index);
//         } else {
//             System.out.println("Key not found in the array");
//         }
//     }
// }



// Reverse an array

    // public class Array1 {
    //     public static void reverseArr(int arr[]) {
    //         int start = 0, end = arr.length - 1;
    //         while (start < end) {
    //             // Swapping elements
    //             int temp = arr[start];
    //             arr[start] = arr[end];
    //             arr[end] = temp;
    //             // Move pointers
    //             start++;
    //             end--;
    //         }
    //     }
    //     public static void main(String[] args) {
    //         int arr[] = {4, 6, 8, 7, 10};
    //         reverseArr(arr);
    //         // Print the reversed array
    //         for (int i = 0; i < arr.length; i++) {
    //             System.out.print(arr[i] + " ");
    //         }
    //         System.out.println();
    //     }
    // }
    



    // // pairs in an array

    // public class Array1 {
    //   public static void printPairs(int arr[]){
    //     int totalPair=0;
    //     for(int i=0;i<arr.length;i++){
    //         for(int j=i+1;j<arr.length;j++){
    //                System.out.print("("+arr[i]+","+arr[j]+")");
    //                totalPair++;
    //        }
    //         System.out.println();
    //     }
    //     System.out.print("total pairs="+totalPair);
    //   }
    //     public static void main(String[] args) {
    //         int arr[]={2,4,6,8,10};
    //         printPairs(arr);
    //     }
    // } 



    // // PRINT SUBARRAY


    public class Array1 {
      public static void printSubarray(int arr[]){
        int totalSubarray=0;
           for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k]+" ");
                }
                totalSubarray++;
                System.out.println();
            }
            System.out.println();
           }
           System.out.print("no. of subarray="+totalSubarray);
      }
        public static void main(String[] args) {
            int arr[]={2,4,6,8,10};
            printSubarray(arr);
        }
    }




    