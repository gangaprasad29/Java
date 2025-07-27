// /// LOOPS
// // WHILE LOOP

// import java.util.Scanner;

// public class loops {
//     public static void main(String[] args) {
//         Scanner s=new Scanner(System.in);
//         System.out.println("enter a no:");
//         int n=s.nextInt();
//         s.close();
//         int count=1;
//         while(count<=n){
//             System.out.println(count);
//             count++;
//         }
//     }
// }



// import java.util.Scanner;

// public class loops {

//     public static void main(String[] args) {
//         Scanner s=new Scanner(System.in);
//         System.out.println("enter a no:");
//         int n=s.nextInt();
//         s.close();
//         int sum=0;
//         int i=0;
//         while(i<=n){
//             sum=sum+i;
//             i++;
//         }
//         System.out.println(sum);
//     }
// }


// // FOR LOOP

// public class loops {

//     public static void main(String[] args) {
//         for(int i=0;i<4;i++){
//             for(int j=0;j<4;j++){
//                 System.err.print("*");
//             }
//             System.out.println();
//         }
//     }
// }


// // print reverse of a given no


// import java.util.Scanner;

// public class loops {

//     public static void main(String[] args) {
//         Scanner s=new Scanner(System.in);
//         System.out.print("enter a no:");
//         int n=s.nextInt();
//         s.close();
//         while(n>0){
//             int lastdig=n%10;
//             System.out.print(lastdig);
//             n/=10;
//         }
//         System.out.println();
//     }
// }


// //  *(not same as above) reverse the given no (we are changing the exact no means original no.)


// import java.util.Scanner;

// public class loops {

//     public static void main(String[] args) {
//         Scanner s=new Scanner(System.in);
//         System.out.print("enter a no:");
//         int n=s.nextInt();
//         s.close();
//         int rev=0;
//         while(n>0){
//             int lastdig=n%10;
//             rev=(rev*10)+lastdig;
//             n/=10;
//         }
//         System.out.print(rev);
//     }
// }



// //  do while loop

//  public class loops {
 
//     public static void main(String[] args) {
//         int counter=0;
//         do{
//             System.out.println("hello");
//             counter++;
//         }while(counter<=10);
//     }
//  }


// // break statement

// public class loops {

//      public static void main(String[] args) {
//         for(int i=0;i<5;i++){
//             if(i==3){
//                 break;
//             }
//             System.out.println(i);
//         }
//      }
// }


// // take a no from user and print it until enters some multiple of 10

// import java.util.Scanner;

// public class loops {

//     public static void main(String[] args) {
//         Scanner s= new Scanner(System.in);
//         do{
//             System.out.print("enter your no:");
//             int n=s.nextInt();
//             if(n%10==0){
//                 break;
//             }
//             System.out.println(n);
//         }while(true);
//     }
// }


// // continue statement



// public class loops {

//     public static void main(String[] args) {
//        for(int i=0;i<=5;i++){
//         if(i==3){
//             continue;
//         }
//         System.out.println(i);
//        }
//     }
// }



// // display all no which user enters except multiple of 10


// import java.util.Scanner;

// public class loops {
//   public static void main(String[] args) {
//     Scanner s=new Scanner(System.in);
//     do{
//         System.out.print("enter a no:");
//         int n=s.nextInt();
//         if(n%10==0){
//             continue;
//         }
//         System.out.println("your no. is :"+n);
//     }while(true);
//   }  
// }



// // Q. check a no. is prime or not

import java.util.*;
public class loops {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.print("enter a no:");
        int n=s.nextInt();
        s.close();

        if(n==2){
            System.out.println(n+" is prime no.");
        }else{
         
            boolean isPrime=true;
            for(int i=2;i<Math.sqrt(n);i++){
               if(n%i==0){
                isPrime=false;
            }
        }
        if(isPrime==true){
            System.out.println(n+" is a prime no.");
        }
        else{
            System.out.println(n+" is not a prime no.");
            }
        }

    }
}