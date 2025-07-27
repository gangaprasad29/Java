import java.util.*;



// public class ArrayQ {
//     public static boolean isTwice(int[] arr){
//          int n=arr.length;
//          Arrays.sort(arr); //// *******
//          for(int i=0;i<n-1;i++){
//             if((arr[i]^arr[i+1])==0){
//                 return true;
//             }
//         }
//         return false;
//     }
//     public static void main(String[] args) {
//         int[] arr={1,2,3,1};
//         System.out.println(isTwice(arr));
//     }
// }



// Q.3

public class ArrayQ {
   public static void Stock(int[] prices){
    int Buy = Integer.MAX_VALUE;
    int maxProfit = 0;
    int n = prices.length;

       for(int i=0;i<n;i++){
        if(prices[i]<Buy){
            Buy=prices[i];
        }
        else {
            maxProfit = Math.max(maxProfit, prices[i] - Buy); // Calculate max profit
        }
        
    }
    System.out.println(maxProfit);
   }
    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4};
        Stock(prices);
    }
}