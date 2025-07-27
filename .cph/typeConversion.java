// // #2

// // TYPE CONVERSION (below code only runs without error)
 
// import java.util.Scanner;

// public class typeConversion {
//     public static void main(String args[]){
//         Scanner s= new Scanner(System.in);
//         float number=s.nextInt();
//         System.out.println(number);
        
//         s.close();
//     }
// }


// // TYPE CASTING

// import java.util.Scanner;

// public class typeConversion {
//     public static void main(String args[]){
//         Scanner s= new Scanner(System.in);
//         float a=25.25f;
//         int b=(int)a;
//         System.out.println(b);
// // below is type conversion's part
//         char ch='a';
//         int number=ch;
//         System.out.println(number);

//         s.close();
//     }
// }



// // TYPE PROMOTION IN EXPRESSIONS

public class typeConversion {

    public static void main(String args[]){
        char a='a';
        char b='b';
        System.out.println((int)(a));
        System.out.println((int)(b));
        System.out.println(b-a);
        System.out.println(b-10);

        int a2=10;
        float b2=20.21f;
        long c=25;
        double d=30;
        double ans=a2+b2+c+d;
        System.out.println("ans="+ans);

    }
}