// // #4 Conditional statements

// import java.util.Scanner;

// public class conditional_statements {
//     public static void main(String args[]){
//           Scanner s=new Scanner(System.in);
//           int age=s.nextInt();
//           s.close();
//           if(age>=18){
//             System.out.println("adult: can drive , can vote");
//           }
//           else if(age>=13 && age<18){
//             System.out.println("teenager");
//           }
//           else{
//             System.out.println("not an adult");
//           }
//     }
// } 


// // income tax calculatot

// import java.util.Scanner;

// public class conditional_statements {

//     public static void main(String args[]){
//         Scanner s=new Scanner(System.in);
//         float salary=s.nextFloat();
//         s.close();
//         if(salary<500000){
//             System.out.println("in  hand="+salary);
//         }
//         else if(salary>=500000 && salary<1000000){
//             System.out.println("in hand after 20% tax="+salary*(0.8));
//         }
//         else{
//             System.out.println("in hand after 30% tax="+salary*(0.7));
//         }

//         int A=1,B=3,C=6;
//         if((A>=B) && (A>=C)){
//             System.out.println("grater is:"+A);
//         }
//         else if(B>=C){
//             System.out.println("grater is:"+B);
//         }
//         else{
//             System.out.println("grater is:"+C);
//         }

//         // ternary operator

//         int number=4;

//         String type=(number%2==0)? "even" : "odd";
//         System.out.println(type);
//     }
// }


// // switch statement

// public class conditional_statements {

//     public static void main(String args[]){
//         int number=2;
//         switch (number) {
//             case 1:
//                 System.out.println("samosa");
//                 break;
//             case 2:
//                 System.out.println("burger");
//                 break;
//                 case 3:
//                 System.out.println("coldring");

//             default:
//             System.out.println("nothing is matching");
//                 break;
//         }
//     }
// }

import java.util.Scanner;

public class conditional_statements {

    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int a=s.nextInt();
        int b=s.nextInt();
        char operator = s.next().charAt(0);
        s.close();
        switch (operator) {
            case '+':
                System.out.println(a+b);
                break;
            case '-':
            System.out.println(a-b);
                break;
            case '*':
            System.out.println(a*b);
                break;
            case '/':
            System.out.println(a/b);
                break;

            default:
            System.out.println("enter valid operator");
        }
    }
}