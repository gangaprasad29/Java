// // #1

// public class hello{
//     public static void main(String args[]){
//         System.out.println("hello");
//         System.out.println("hello");
//     }
// }

// ///  Variables in java

// public class hello{
//     public static void main(String args[]){
//         int a=10 , b=5;
//         int ans=2*(a+b);
//         System.out.println(a);
//         System.out.println(b);
//         System.out.println(ans);
        
//         a=50;   // variable can be change
//         System.out.println(a);

//     }
// }


// //// DATA TYPES IN JAVA

// public class hello {
//     public static void main(String args[]){
//         byte b=8;
//         System.out.println(b);
//         char ch='a';
//         System.out.println(ch);
//         // float f = 10.5;
//         // System.out.println(f);
//         boolean var=false;
//         System.out.println(var);
//     }
// }


//  ///  input in JAVA

// import java.util.*;  // automatically comes after the 47 line

// public class hello {
//     public static void main(String[] args) {
//         Scanner s = new Scanner(System.in);
//         // String input = s.next(); // Reads only one word
//         String name = s.nextLine(); // Reads only one word
//         System.out.println("You entered: " + name);
        
//         // for number input
//         int number = s.nextInt();
//         System.out.println("number is: "+number);
//         s.close(); // Close the scanner to prevent resource leaks
//     }
// }
 


// // take a and b as input and print their sum

// import java.util.*;

// public class hello {

//     public static void main(String args[]){
//         Scanner s=new Scanner(System.in);
//         System.out.println("enter the a & b:");
//         int a=s.nextInt();
//         int b=s.nextInt();
//         int sum=a+b;
//         int pro=a*b;
//         System.out.println("sum = "+sum);
//         System.out.println("product = "+pro);
//         s.close();
//     }
// }


// // print area of a circle by taking radious as input

// import java.util.Scanner;

// public class hello {

//     public static void main(String args[]){
//         Scanner s=new Scanner(System.in);
//         System.out.println("Enter the radius of the circle:");
//         int radious = s.nextInt();
//         double area=3.14*radious*radious;
//         System.out.println(area);
//         s.close();
//     }
// }

// // OR 

import java.util.Scanner;

public class hello {
    public static void main(String[] args) {
        // Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user for radius
        System.out.print("Enter the radius of the circle: ");
        
        // Read radius from user
        double radius = scanner.nextDouble();
        
        // Calculate area using formula: A = πr²
        double area = Math.PI * radius * radius;
        
        // Print the result
        System.out.printf("The area of the circle is: %.2f", area);
        
        // Close scanner to prevent resource leak
        scanner.close();
    }
}