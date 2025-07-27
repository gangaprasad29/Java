// // function overloading

// public class functionstwo{
    //     // func to cal sum of 2
    //     public static int sum(int a, int b){
        //         return a+b;
        //     }
        //     // func to cal sum of 2
        //     public static int sum(int a, int b, int c){
            //         return a+b+c;
//     }
//     public static void main(String[] args) {
    //         System.out.println(sum(5,9));
    //         System.out.println(sum(5,9,3));
    //     }
    // }
    
    
    
    
 // // function overloading using data types
    

//     public class functionstwo{
//     // func to cal sum of int data type
//     public static int sum(int a, int b){
//         return a+b;
//     }
//     // func to cal sum of 2
//     public static float sum(float a, float b){
//         return a+b;
//     }
//     public static void main(String[] args) {
//         System.out.println(sum(5,9));
//         System.out.println(sum(5.22f,8.5f));
//     }
// }


// isPrime optimal code

// public class functionstwo{
//     public static boolean isPrime(int n){
//         boolean isPrime=true;
//         if(n==2){
//             return true;
//         }
//         for(int i=2;i<Math.sqrt(n);i++){
//             if(n%i==0){
//                 isPrime=false;
//                 break;
//             }

//         }
//         return isPrime;
//     }
//     public static void main(String[] args) {
//         System.out.println(isPrime(7));
//     }
// }


// prime numbers upto an number


// import java.util.Scanner;
// public class functionstwo{
//     public static boolean isPrime(int n){
//         boolean isPrime=true;
//         for(int i=2;i<n;i++){
//             if(n%i==0){
//                 isPrime=false;
//                 break;
//             }

//         }
//         return isPrime;
//     }
//     public static void primeInRange(int n){
//           for(int i=2;i<=n;i++){
//             if(isPrime(i)){
//                 System.out.print(i);
//             }
//           }
//           System.out.println();
//     }
//     public static void main(String[] args) {
//         Scanner s=new Scanner(System.in);
//         System.out.print("enter a no:");
//         int n=s.nextInt();
//         s.close();
//         primeInRange(n);
//     }
// }



// Binary to Decimal


// public class functionstwo {
//    public static void binToDec(int binNum){
//        int myNum=binNum;
//        int pow=0;
//        int decNum=0;

//        while(binNum>0){
//           int lastDig=binNum%10;
//           decNum+=(lastDig* (int)Math.pow(2,pow));
//           pow++;
//           binNum/=10;
//        }
//        System.out.println("decimal of "+myNum+" = "+decNum);
//    }
//     public static void main(String[] args) {
//          binToDec(101);
//     }
// }


// Decimal ot binary

// public class functionstwo {
//     public static void decToBin(int n){
//         int myNum=n;
//         int pow=0;
//         int binNum=0;
 
//         while(n>0){
//            int remender=n%2;
//            binNum+=(remender*(int)Math.pow(10,pow));
//            pow++;
//            n/=2;
//         }
//         System.out.println("decimal of "+myNum+" = "+binNum);
//     }
//      public static void main(String[] args) {
//           decToBin(5);
//      }
//  }