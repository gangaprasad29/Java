// representation of 2D matrix

// import java.util.*;
// public class _2Darray {
//  public static void main(String[] args) {
//     int matrix[][] = new int[3][3];
//     int n=matrix.length, m=matrix[0].length;
//     System.out.print("enter input:");
//     Scanner sc=new Scanner(System.in);
//      for(int i=0;i<n;i++){
//       for(int j=0;j<m;j++){
//          matrix[i][j]=sc.nextInt();
//       }
//      }
//     sc.close();
//     //printing
//     for(int i=0;i<n;i++){
//       for(int j=0;j<m;j++){
//          System.out.print(matrix[i][j]+" ");
//       }
//       System.out.println();
//     }
//  }
    
// }  // give input 1 2 3 4 5 6 7 8 9



// find the key in  the matrix and return its (i,j)

// import java.util.*;
// public class _2Darray {

//    public static boolean search(int matrix[][],int key , int n, int m){
//       for(int i=0;i<n;i++){
//          for(int j=0;j<m;j++){
//             if(matrix[i][j]==key){
//                System.out.print("key found at: "+ (i+","+j));
//                return true;
//             }
//          }
//       }
//       System.out.print("key is not found ");
//          return false;
//    }
//  public static void main(String[] args) {
//     int matrix[][] = new int[3][3];
//     int n=matrix.length, m=matrix[0].length;
//     System.out.print("enter input:");
//     Scanner sc=new Scanner(System.in);
//      for(int i=0;i<n;i++){
//       for(int j=0;j<m;j++){
//          matrix[i][j]=sc.nextInt();
//       }
//      }
//     System.out.print("enter a key");
//     int key=sc.nextInt();
//     sc.close();
//    search(matrix, key, n, m);
//  }
    
// }  // give input 1 2 3 4 5 6 7 8 9




// SPIREL MATRIX


// import java.util.*;
// public class _2Darray {
//     public static void spiral(int matrix[][],int n, int m){
//        int st_row=0;
//        int end_row=n-1;
//        int st_col=0;
//        int end_col=m-1;
//        while(st_row<=end_row && st_col<=end_col){
//           //top
//           for(int j=st_col;j<=end_col;j++){
//              System.out.print(matrix[st_row][j]+" ");
//           }
//           //right
//           for(int i=st_row+1;i<=end_row;i++){
//              System.out.print(matrix[i][end_col]+" ");
//           }
//           //bottom
//           if(st_row < end_row) {
//               for(int j=end_col-1;j>=st_col;j--){
//                  System.out.print(matrix[end_row][j]+" ");
//               }
//           }
//           //left
//           if(st_col < end_col) {
//               for(int i=end_row-1;i>st_row;i--){
//                  System.out.print(matrix[i][st_col]+" ");
//               }
//           }
//           st_col++;
//           st_row++;
//           end_col--;
//           end_row--;
//        }
//        System.out.println();
//     }

//     public static void main(String[] args) {
//         int matrix[][] = new int[3][3];
//         int n=matrix.length, m=matrix[0].length;
//         System.out.print("enter input:");
//         Scanner sc=new Scanner(System.in);
        
//         for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//               matrix[i][j]=sc.nextInt();
//            }
//         }
//         sc.close();
//         spiral(matrix, n, m);
//     }      
// } 
// // give input 1 2 3 4 5 6 7 8 9



// DIAGONAL SUM

// import java.util.*;

// public class _2Darray {
//     public static int diagonalSum(int matrix[][]){
//         int sum = 0;

//       //   // Brute force approach to calculate diagonal sum
//       //   for(int i = 0; i < matrix.length; i++){
//       //       for(int j = 0; j < matrix[0].length; j++){
//       //           // For primary diagonal
//       //           if(i == j){
//       //               sum += matrix[i][j];
//       //           }
//       //           // For secondary diagonal
//       //           else if(i + j == matrix.length - 1){
//       //               sum += matrix[i][j];
//       //           }
//       //       }
//       //   }

//       for(int i=0;i<matrix.length;i++){
//          // primary diagonal
//          sum+=matrix[i][i];

//          // secondary diagonal
//          if(i != matrix.length-i-1){   // means i!=j  we know (i+j=matrix.length-1)  therefore j=matrix.length-i-1
//             sum+=matrix[i][matrix.length-i-1];
//          }
//       }
//         return sum;
//     }

//     public static void main(String[] args) {
//         int matrix[][] = new int[4][4];
//         System.out.print("Enter input for a 4x4 matrix: ");
//         Scanner sc = new Scanner(System.in);
        
//         for(int i = 0; i < matrix.length; i++){
//             for(int j = 0; j < matrix[0].length; j++){
//                 matrix[i][j] = sc.nextInt();
//             }
//         }

//         sc.close();

//         int result = diagonalSum(matrix);
//         System.out.println("The sum of the diagonals is: " + result);
//     }
// }




// SEARCH IN MATRIX

// import java.util.Scanner;
// public class _2Darray {
//     public static boolean search(int matrix[][], int key) {
//         for (int i = 0; i < matrix.length; i++) {
//             for (int j = 0; j < matrix[0].length; j++) {
//                 if (matrix[i][j] == key) {
//                     return true; 
//                 }
//             }
//         }
//         return false; 
//     }

//     public static void main(String[] args) {
//         int matrix[][] = new int[4][4];
//         System.out.print("Enter input for a 4x4 matrix: ");
//         Scanner sc = new Scanner(System.in);

//         // Read the matrix elements
//         for (int i = 0; i < matrix.length; i++) {
//             for (int j = 0; j < matrix[0].length; j++) {
//                 matrix[i][j] = sc.nextInt();
//             }
//         }
        
//         // Ask the user for the key to search
//         System.out.print("Enter a key: ");
//         int key = sc.nextInt();
        
//         // Call the search function and print the result
//         boolean found = search(matrix, key);
//         if (found) {
//             System.out.println("Key found in the matrix.");
//         } else {
//             System.out.println("Key not found in the matrix.");
//         }

//         // Close the scanner
//         sc.close();
//     }
// }




// search method 2


// import java.util.Scanner;
// public class _2Darray {
//     public static boolean search(int matrix[][], int key) {
//       int row=0 , col=matrix[0].length-1;
//       while(row<=matrix.length-1 && col>=0){
//         if(matrix[row][col]==key){
//             System.out.println("key found at ("+ row+ "," +col +")" );
//             return true;
//         }
//         else if(key<matrix[row][col]){
//             col--;
//         }else{
//             row++;
//         }
//       }
//         return false; 
//     }

//     public static void main(String[] args) {
//         int matrix[][] = new int[4][4];
//         System.out.print("Enter input for a 4x4 matrix: ");
//         Scanner sc = new Scanner(System.in);

//         // Read the matrix elements
//         for (int i = 0; i < matrix.length; i++) {
//             for (int j = 0; j < matrix[0].length; j++) {
//                 matrix[i][j] = sc.nextInt();
//             }
//         }
        
//         // Ask the user for the key to search
//         System.out.print("Enter a key: ");
//         int key = sc.nextInt();
//         sc.close();
        
//         // Call the search function and print the result
//         boolean found = search(matrix, key);
//         System.out.println(found);
//     }
// }
