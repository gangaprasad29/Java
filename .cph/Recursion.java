// // Q} print numbers from n to 1 

// import java.util.Scanner;
// public class Recursion {
//     public static void printDec(int n){
//         //base case
//         if(n==1){
//             System.out.print(n+" ");
//             return ;
//         }
//         //work
//         System.out.print(n+" ");
//         // inner function call
//         printDec(n-1);
//     }
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         System.out.print("enter a no:");
//         int n=sc.nextInt();
//         printDec(n);
//     }
// }



///// print sum of n

// public class Recursion{
//     public static int printSum(int n){
//         if(n==0){
//             return 0;
//         }
//         return n+printSum(n-1);
//     }
//     public static void main(String[] args) {
//         int n=10;
//         System.out.println("sum of "+n+" natural numbers is: "+printSum(n));
//     }
    
// }


// // Q} print numbers in increaseing order 

// import java.util.Scanner;
// public class Recursion {
//     public static void printInc(int n){
//         if(n==1){
//             System.out.print(n+" ");
//             return ;
//         }
//         printInc(n-1);
//         System.out.print(n+" ");
//     }

//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         System.out.print("enter a no:");
//         int n=sc.nextInt();
//         printInc(n);
//     }
// }




// // Q} print factorial of n

// import java.util.Scanner;
// public class Recursion {
//     public static int printfact(int n){
//         if(n==0){
//             return 1;
//         }
//         return n*printfact(n-1);
//     }

//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         System.out.print("enter a no:");
//         int n=sc.nextInt();
//         int fact=printfact(n);
//         System.out.println("Factorial of " + n + " is: " + fact);
//     }
// }



// // Q} print sum of n natural number

// import java.util.Scanner;
// public class Recursion {
//     public static int printsum(int n){
//         if(n==1){
//             return 1;
//         }
//         return n+printsum(n-1);
//     }

//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         System.out.print("enter a no:");
//         int n=sc.nextInt();
//         int sum=printsum(n);
//         System.out.println("sum of " + n + " natural no is: " + sum);
//     }
// }



// // Q} print Nth fibonacci number

// import java.util.Scanner;
// public class Recursion {

//     public static int printfibo(int n){
//         if(n == 0 || n==1) return n;
//         return printfibo(n - 1) + printfibo(n - 2);
//     }
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         System.out.print("enter a no:");
//         int n=sc.nextInt();
//         int fibo=printfibo(n);
//         System.out.println(n+"th fibonacci number is :"+fibo);
//     }
// }


// // Q} check if a given array is sorted or not 


// public class Recursion {

//     public static boolean isSorted(int arr[],int i){
//         if(i == arr.length-1) return true;

//         if(arr[i]>arr[i+1]){
//             return false;
//         }
//         return isSorted(arr, i+1);

//     }
//     public static void main(String[] args) {
//         int arr[]={1,2,3,4,5,6};
//         System.out.print(isSorted(arr, 0));
//     }
// }


// // Q} write a function to find the first occurance of an element in an array

// import java.util.Scanner;
// public class Recursion {

//     public static int firstocc(int arr[], int i, int n){
//         if(i == arr.length) return -1; // Base case: not found
//         if(arr[i] == n) return i;      // Element found
//         return firstocc(arr, i+1, n);  // Recursive call
//     }

//     public static void main(String[] args) {
//         int arr[] = {8, 3, 6, 9, 5, 10, 2, 5, 3};
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter number to find: ");
//         int n = sc.nextInt();
//         int index = firstocc(arr, 0, n);
//         if(index == -1) {
//             System.out.println(n + " not found in array.");
//         } else {
//             System.out.println(n + " found at index: " + index);
//         }
//     }
// }




// // same like above but last occurance


// import java.util.Scanner;
// public class Recursion {

//     public static int lastocc(int arr[], int i, int n){
//         if(i < 0) return -1; // Base case: not found
//         if(arr[i] == n) return i;      // Element found
//         return lastocc(arr, i-1, n);  // Recursive call
//     }

//     public static void main(String[] args) {
//         int arr[] = {8, 3, 6, 9, 5, 10, 2, 5, 3};
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter number to find: ");
//         int n = sc.nextInt();
//         int index = lastocc(arr, arr.length - 1, n); // Start from end
//         if(index == -1) {
//             System.out.println(n + " not found in array.");
//         } else {
//             System.out.println(n + " last found at index: " + index);
//         }
//     }
// }



// // // Print x^n


// import java.util.Scanner;
// public class Recursion {

//     public static int printPow(int x,int n){
//         if(n==0) return 1;

//         return x*printPow(x, n-1);
//     }
//     public static void main(String[] args) {
//         Scanner sc= new Scanner(System.in);
//         System.out.print("enter x:");
//         int x=sc.nextInt();
//         System.out.print("enter n:");
//         int n=sc.nextInt();
        
//         int pow=printPow(x, n);
//         System.out.print(pow);
//     }
// }



// // Print x^n in O(logn)

// import java.util.Scanner;
// public class Recursion {

//     public static int printPow(int x,int n){
//         if(n==0) return 1;

//         int half = printPow(x, n / 2);

//         if(n % 2 == 0){
//             return half * half;
//         } else {
//             return x * half * half;
//         }
//     }
//     public static void main(String[] args) {
//         Scanner sc= new Scanner(System.in);
//         System.out.print("enter x:");
//         int x=sc.nextInt();
//         System.out.print("enter n:");
//         int n=sc.nextInt();
        
//         int pow=printPow(x, n);
//         System.out.print(pow);
//     }
// }




// // Q} Tiling Problem
    /*
     given a "2*n" brod(floor) and tiles of size "2*1" , count the number of 
     ways to tile the given board using the 2*1 tiles.
     (A tile can either be placed horizontally or vertically) 
     */

  
// public class Recursion {
//     public static int tillingProblem(int n){ // 2 x n (floor size)
//         //base case
//         if(n==0 || n==1){
//             return 1;
//         }
//         //work
//         //vertical choice
//         int verticalTiles=tillingProblem(n-1);

//         //horizontal choice
//         int horizontalTiles=tillingProblem(n-2);

//         int totalWays=verticalTiles+horizontalTiles;
//         return totalWays;



//           ////// below base case we can use single line
//         //   return tillingProblem(n-1)+tillingProblem(n-2);

//     }
//     public static void main(String[] args) {
//         System.out.print(tillingProblem(4));
//     }
// }     