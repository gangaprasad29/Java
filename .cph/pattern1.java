// import java.util.Scanner;

// public class pattern1 {
//     public static void main(String[] args) {
//         Scanner s=new Scanner(System.in);
//         System.out.print("enter a no:");
//         int n=s.nextInt();
//         s.close();
//         for(int i=1;i<=n;i++){
//             for(int j=1;j<=i;j++){
//                 System.out.print("*");
//             }
//             System.out.println();
//         }
//     }
// }





// import java.util.Scanner;

// public class pattern1 {
//     public static void main(String[] args) {
//         Scanner s=new Scanner(System.in);
//         System.out.print("enter a no:");
//         int n=s.nextInt();
//         s.close();
//         for(int i=1;i<=n;i++){
//             for(int j=1;j<=n-i+1;j++){
//                 System.out.print("*");
//             }
//             System.out.println();
//         }
//     }
// }





// import java.util.Scanner;

// public class pattern1 {
//     public static void main(String[] args) {
//         Scanner s=new Scanner(System.in);
//         System.out.print("enter a no:");
//         int n=s.nextInt();
//         s.close();
//         for(int i=1;i<=n;i++){
//             for(int j=1;j<=i;j++){
//                 System.out.print(j);
//             }
//             System.out.println();
//         }
//     }
// }





import java.util.Scanner;

public class pattern1 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.print("enter a no:");
        int n=s.nextInt();
        s.close();
        char ch='A';
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }
    }
}