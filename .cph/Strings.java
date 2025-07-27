// import java.util.Scanner;

// public class Strings {
//     public static void main(String[] args) {

//         // char arr[]={'a','b','c','d'};
//         // String str="abcd";                        // both are same
//         // String str2=new String("xyz"); // both are same
        
//         // Scanner sc=new Scanner(System.in);
//         // String name;
//         // System.out.print("enter text including spaces:");
//         // name=sc.nextLine();
//         // System.out.println(name);
//         // System.out.println("length is : "+name.length());


//         // // CONCATENATION

//         // String firstname="Gangaprasad";
//         // String lastname="Urekar";
//         // String fullname=firstname+" "+lastname;
//         // System.out.print(fullname);


//         // // Accessing each element in string

//         String str="Gangaprasad";
//         System.out.println(str.charAt(0));
//         // for accessing every element
//         for(int i=0;i<str.length();i++){
//             System.out.print(str.charAt(i)+" ");
//         }
//     }
// }




// // Q. check if the str is pelindrome

// import java.util.Scanner;
// public class Strings {
//     public static boolean isPalindrome(String str) {
//         int start = 0;
//         int end = str.length() - 1;
        
//         while (start < end) {
//             if (str.charAt(start) != str.charAt(end)) {
//                 return false; 
//             }
//             start++;
//             end--;
//         }
//         return true; 
//     }
//     public static void main(String[] args) {
//         System.out.print("enter a string : ");
//         Scanner sc = new Scanner(System.in);
//         String str = sc.nextLine();
//         sc.close();

//         if (isPalindrome(str)) {
//             System.out.println(str + " is a palindrome.");
//         } else {
//             System.out.println(str + " is not a palindrome.");
//         }
//     }
// }


// // Q }  given a route containing 4 directions (E,W,S,N),
////         find the shoutest path to reach destination.



// public class Strings {
//     public static  int getShortestPath(String str) {
//         int x=0,y=0;

//         for(int i=0;i<str.length();i++){
//             char direction=str.charAt(i);

//             if(direction=='S'){
//                 y--;
//             }
//             else if(direction=='N'){
//                 y++;
//             }
//             else if(direction=='W'){
//                 x--;
//             }else{
//                 x++;
//             }
//         }
//         return (int)Math.sqrt((x*x)+(y*y));
       
//     }
//     public static void main(String[] args) {
//       String path="WNEENESENNN";
//       int result=getShortestPath(path);
//       System.out.println(result);
        
//     }
// }



// .// comparision of string 

// public class Strings {
//     public static void main(String[] args) {
//         String s1 = "Hello";
//         String s2 = "Hello";
//         String s3 = "hello";

//         // Using .equals() for case-sensitive comparison
//         System.out.println(s1.equals(s2)); // true
//         System.out.println(s1.equals(s3)); // false (case-sensitive)

//         // Using .equalsIgnoreCase() for case-insensitive comparison
//         System.out.println(s1.equalsIgnoreCase(s3)); // true
//     }
// }



// //  STRING FUNCTIONS (SUBSTRING)

// public class Strings {
//    public static String subString(String str,int si,int ei){
//         String substr="";
//         for(int i=si;i<ei;i++){
//             substr+= str.charAt(i);
//         }
//         return substr;
//    }
//     public static void main(String[] args) {
//         String str="HelloWorld!";
//         System.out.println(subString(str,0,5));

//         // //  OR we have direct substring function which is below
//         // System.out.println(str.substring(1,5));
//     }
// }




// // Q} for a given string set ,print the largest string (lexicographically)

// public class Strings {
//     public static void main(String[] args) {
//         String fruits[]={"apple","mango","banana","orange"};

//         String largest=fruits[0];
//         for(int i=1;i<fruits.length;i++){
//              if(largest.compareTo(fruits[i])<0){
//                 largest=fruits[i];
//              }
//         }
//         System.out.println(largest);
//     }
// }