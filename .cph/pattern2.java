// import java.util.Scanner;

// public class pattern2 {

//     public static void star_square(){
//         Scanner s=new Scanner(System.in);
//         System.out.print(":Enter number of rows: ");
//         int n=s.nextInt();
//         s.close();
//         for(int i=1;i<=n;i++){
//             for(int j=1;j<=n;j++){
//                 if(i==1 || i== n || j==1 || j==n){
//                     System.out.print("* ");
//                 }
//                 else{
//                     System.out.print("  ");
//                 }
//             }
//             System.out.println();
//         }
        
//     }
//     public static void main(String args[]){
        
//         star_square();
//     }
// }







// import java.util.Scanner;

// public class pattern2 {

//     public static void star_square(){
//         Scanner s=new Scanner(System.in);
//         System.out.print(":Enter number of rows: ");
//         int n=s.nextInt();
//         s.close();
//         for(int i=1;i<=n;i++){
//             for(int j=1;j<=n-i;j++){
//                System.out.print(" ");
//             }
//             for(int j=1;j<=i;j++){
//                 System.out.print("*");
//             }
//             System.out.println();
//         }
        
//     }
//     public static void main(String args[]){
        
//         star_square();
//     }
// }




// import java.util.Scanner;
// public class pattern2 {
//     public static void numpat(){
//         Scanner s=new Scanner(System.in);
//         System.out.print(":Enter number of rows: ");
//         int n=s.nextInt();
//         s.close();
//         for(int i=1;i<=n;i++){
//             for(int j=1;j<=n-i+1;j++){
//                 System.out.print(j);
//             }
//             System.out.println();
//         }
//     }
//     public static void main(String[] args) {
//         numpat();
//     }
// }



// import java.util.Scanner;
// public class pattern2 {
//     public static void numpat(){
//         Scanner s=new Scanner(System.in);
//         System.out.print(":Enter number of rows: ");
//         int n=s.nextInt();
//         s.close();
//         int count=1;
//         for(int i=1;i<=n;i++){
//             for(int j=1;j<=i;j++){
//                 System.out.print(count);
//                 count++;
//             }
//             System.out.println();
//         }
//     }
//     public static void main(String[] args) {
//         numpat();
//     }
// }




// import java.util.Scanner;
// public class pattern2 {
//     public static void numpat(){
//         Scanner s=new Scanner(System.in);
//         System.out.print(":Enter number of rows: ");
//         int n=s.nextInt();
//         s.close();
//         for(int i=1;i<=n;i++){
//             for(int j=1;j<=i;j++){
//                if((i+j)%2==0){
//                 System.out.print("1");
//                }
//                else{
//                 System.out.print("0");
//                }
//             }
//             System.out.println();
//         }
//     }
//     public static void main(String[] args) {
//         numpat();
//     }
// }




// import java.util.Scanner;

// public class pattern2 {
//     public static void numpat() {
//         Scanner s = new Scanner(System.in);
//         System.out.print("Enter number of rows: ");
//         int n = s.nextInt();
//         s.close();

//         // Upper part of the butterfly
//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= n * 2; j++) {
//                 if (j <= i || j > (2 * n) - i) {
//                     System.out.print("* ");
//                 } else {
//                     System.out.print("  ");
//                 }
//             }
//             System.out.println();
//         }

//         // Lower part of the butterfly
//         for (int i = n; i >= 1; i--) {
//             for (int j = 1; j <= n * 2; j++) {
//                 if (j <= i || j > (2 * n) - i) {
//                     System.out.print("* ");
//                 } else {
//                     System.out.print("  ");
//                 }
//             }
//             System.out.println();
//         }
//     }

//     public static void main(String[] args) {
//         numpat();
//     }
// }



// import java.util.Scanner;
// public class pattern2 {
//     public static void rombuspat(){
//         Scanner s = new Scanner(System.in);
//         System.out.print("Enter number of rows: ");
//         int n = s.nextInt();
//         s.close();
//         for(int i=1;i<=n;i++){
//             for(int j=1;j<n-i+1;j++){
//                 System.out.print(" ");
//             }
//             for(int j=1;j<=n;j++){
//                 System.out.print("*");
//             }
//             System.out.println();
//         }
//     }
//     public static void main(String[] args) {
//        rombuspat();
//     }
// }






// import java.util.Scanner;
// public class pattern2 {
//     public static void Hrombuspat(){
//         Scanner s = new Scanner(System.in);
//         System.out.print("Enter number of rows: ");
//         int n = s.nextInt();
//         s.close();
//         for(int i=1;i<=n;i++){
//             for(int j=1;j<n-i+1;j++){
//                 System.out.print(" ");
//             }
//             for(int j=1;j<=n;j++){
//                 if(i==1 || i==n || j==1 || j==n){
//                     System.out.print("*");
//                 }
//                 else{
//                     System.out.print(" ");
//                 }
//             }
//             System.out.println();
//         }
//     }
//     public static void main(String[] args) {
//        Hrombuspat();
//     }
// }

import java.util.Scanner;

public class pattern2 {
  public static void dimondpat(){
    Scanner s = new Scanner(System.in);
            System.out.print("Enter number of rows: ");
            int n = s.nextInt();
            s.close();
            for(int i=1;i<=n;i++){
                for(int j=1;j<=(n-i);j++){
                    System.out.print(" ");
                }
                for(int j=1;j<=(2*i)-1;j++){
                    System.out.print("*");
                }
            System.out.println();
        }
        //second half
        for(int i=n;i>=1;i--){
            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }
            for(int j=1;j<=(2*i)-1;j++){
                System.out.print("*");
            }
        System.out.println();
    }
  }
    public static void main(String[] args) {
        dimondpat();
    }
}