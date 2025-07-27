// import java.util.Scanner;
// public class functions {
//     // Function 1 / Method
//     public static void printHello() {
//         System.out.println("Hello, This is a function");
//         return; // Optional for void methods
//     }
    
//     // Function 2
//     public static int sumofNum(int a, int b) {  // here a & b are parameters or formal parameters(at function definition)
//         int sum = a + b;
//         System.out.println("Sum is: " + sum);
//         return sum;
//     }
    
//     public static void main(String[] args) {
//         printHello(); // Call the printHello method
        
//         Scanner s = new Scanner(System.in);
//         System.out.print("Enter a: ");
//         int a = s.nextInt();
//         System.out.print("Enter b: ");
//         int b = s.nextInt();
//         s.close(); // Close the Scanner to prevent resource leaks

//         sumofNum(a, b); // here a & b are arguments or actual parameters(at function call)
//     }
// } 




// // product of a and b

// import java.util.Scanner;

// public class functions {
 
//    public static int multiply(int a,int b){
        
//         int product=a*b;
//         return product;
//     }
//     public static void main(String[] args) {
//         Scanner s=new Scanner(System.in);
//         System.out.print("enter a:");
//         int a=s.nextInt();
//         System.out.print("enter b:");
//         int b=s.nextInt();
//         s.close();

//         int product=multiply(a,b); // function call
//         System.out.println(product);
//     }
// }



// // calculate factorial of a no. n

// import java.util.Scanner;

// public class functions {
// public static int Fact(int n){
//    int fact=1;
//    for(int i=n;i>=1;i--){
//     fact*=i;
//    }
//    return fact;
// }
//     public static void main(String[] args) {
//         Scanner s=new Scanner(System.in);
//         System.out.print("enter n:");
//         int n=s.nextInt();
//         s.close();
//         int ans=Fact(n);
//         System.out.println("factorial of n:"+ans);
//     }
// }



// // calculate binomial coefficient ncr

import java.util.*;

public class functions {
    // Method to calculate factorial
    public static int factorial(int num) {
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

    // Method to calculate binomial coefficient
    public static int binofact(int n, int r) {
        int ans = factorial(n) / (factorial(r) * factorial(n - r));
        return ans;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = s.nextInt();
        System.out.print("Enter r: ");
        int r = s.nextInt();
        s.close();

        int ans=binofact(n, r);
        System.out.println(ans);
    }
}