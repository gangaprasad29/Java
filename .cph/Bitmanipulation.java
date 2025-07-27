// // even or odd using bit manipulation

// import java.util.Scanner;
// public class Bitmanipulation {
//     public static void EvenorOdd(int n){
        
//         if((n&1)== 1){
//           System.out.println("odd");
//       }
//       else{
//             System.out.println("even");
//         }
//     }
//     public static void main(String args[]){
//         Scanner sc=new Scanner(System.in);
//         System.out.print("enter a number:");
//         int n=sc.nextInt();
//         sc.close();
//         EvenorOdd(n);
//     }
// }


// // Get ith bit

// import java.util.Scanner;
// public class Bitmanipulation {
//    // Get ith bit
//    public static void GetithBit(int n, int i) {
//         if ((n & (1 << i)) != 0) {
//             System.out.println("ith bit is 1");
//         } else {
//             System.out.println("ith bit is 0");
//         }
//    }

//    // Set ith bit
//    public static int SetithBit(int n, int i) {
//         return n | (1 << i);  // Set the ith bit to 1
//    }

//     // clear ith bit
//     public static int ClearithBit(int n, int i) {
//         return n & ~(1 << i);  // clear the ith bit to 1
//    }
//     // update ith bit
//     public static int UpdateithBit(int n, int i,int newBit) {
//         if(newBit == 0){
//             return ClearithBit(n, i);
//         }else{
//             return SetithBit(n, i);
//         }

//         // OR

//         // n = ClearithBit(n, i);
//         // return n|(newBit<<i);
//    }

//      // clear last i bit's
//      public static int ClearLastiBits(int n, int i) {
//         return n & ((-1) << i);  // clear the i bit's 
//    }


//    // clear range of bits
//    public static int ClearBitsinRange(int n,int i,int j){
//     int a=((-1)<<(j+1));
//     int b=((1<<i)-1);
//     int bitMask=(a|b);
//     return n & bitMask;
//    }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter a number: ");
//         int n = sc.nextInt();
//         sc.close();

//         // Get the 2nd bit
//         GetithBit(n, 2);

//         // Set the 3rd bit and print the new number
//         int updatedNumber = SetithBit(n, 3);
//         System.out.println("After setting the 3rd bit, the new number is: " + updatedNumber);

//         int updatedNumber2 = ClearithBit(n, 1);
//         System.out.println("After clearing the 1st bit, the new number is: " + updatedNumber2);

//         int updatedNumber3 = UpdateithBit(7, 2,0);
//         System.out.println("After updating the st bit, the new number is: " + updatedNumber3);

       
//         int updatedNumber4 =  ClearLastiBits(7,2);
//         System.out.println("After clearing the last i bits, the new number is: " + updatedNumber4);

//         int updatedNumber5 =  ClearBitsinRange(10,2,4); //ans 2
//         System.out.println("After clearing the bits, the new number is: " + updatedNumber5);
//     }
// }








// // Q} check if a no. is a power of 2 or not


// import java.util.Scanner;
// public class Bitmanipulation {
//   public static void Checkpowerof2(int n){
//     if((n&(n-1))==0){
//         System.out.println(n+" is power of 2"); ;
//       }
//       else{
//       System.out.println(n+" is not power of 2"); ;
//     }
//   }
//      public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         System.out.print("enter a no:");
//         int n=sc.nextInt();
//         sc.close();
//         Checkpowerof2(n);
//      }     
// }




// // Q} count set bits in a no.



// import java.util.Scanner;
// public class Bitmanipulation {
//   public static int CountSetBits(int n){
//     int count=0;
//     while(n>0){
//         if((n&1) !=0){ // check out LSB
//           count++;
//         }
//         n=n>>1;
//     }
//     return count;
   
//   }
//      public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         System.out.print("enter a no:");
//         int n=sc.nextInt();
//         sc.close();
//         int result = CountSetBits(n);
//         System.out.println("Number of set bits: " + result);
//      }     
// }





// // FAST EXPONENTIATION


public class Bitmanipulation {
  public static int fastExpo(int a,int n){
    int ans=1;

    while(n>0){
      if((n&1) !=0){ // ckeck LSB
         ans=ans*a;
      }
      a=a*a;
      n=n>>1;
    }
    return ans;
  }
  public static void main(String[] args) {
    System.out.println(fastExpo(2, 3));
  }
} 