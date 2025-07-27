// import java.util.Scanner;
// public class pattern3 {
//     public static void numpyramid(){
//         System.out.print("enter n:");
//         Scanner s=new Scanner(System.in);
//         int n=s.nextInt();
//         s.close();
//         for(int i=1;i<=n;i++){
//             for(int j=1;j<=n-i;j++){
//                 System.out.print(" ");
//             }
//             for(int j=1;j<=i;j++){
//                 System.out.print(i+" ");
//             }
//             System.out.println();
//         }
//     }
//     public static void main(String[] args) {
//         numpyramid();
//     }
// }



import java.util.Scanner;

public class pattern3 {
    public static void numpalindrom(){
        System.out.print("enter n:");
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        s.close();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=i;j>=1;j--){
                System.out.print(j);
            }
            for(int j=2;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        numpalindrom();
    }
}


                   