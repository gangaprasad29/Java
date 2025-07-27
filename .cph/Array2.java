// // Max subarray_sum-I (brute force)    time complexity=O(n^3)

// public class Array2 {
//     public static int maxSum(int arr[]){
//         int currentsum=0;
//         int maxsum=Integer.MIN_VALUE;
//          for(int i=0;i<arr.length;i++){
//             for(int j=i;j<arr.length;j++){
//                 currentsum=0;
//                 for(int k=i;k<=j;k++){
//                     currentsum+=arr[k];
//                 }
//                 if(currentsum > maxsum){
//                      maxsum=currentsum;
//                 }
//             }
//          }
//          return maxsum;
//     }
//     public static void main(String[] args) {
//         int arr[]={2,4,6,8,10};
//         int ans=maxSum(arr);
//         System.out.println(ans);
//     }
    
// }



// // max_subarray sum-II  (PREFIX SUM)      time complexity=O(n^2)


// public class Array2 {
//     public static int maxSum(int arr[]){
//         int currentsum=0;
//         int maxsum=Integer.MIN_VALUE;
//         int prefix[]= new int[arr.length];  // new prefix array
//         prefix[0]=arr[0];
//         for(int i=1;i<prefix.length;i++){
//             prefix[i]=prefix[i-1]+arr[i];
//         }
         
//          for(int i=0;i<arr.length;i++){
//             int start=i;
//             for(int j=i;j<arr.length;j++){
//                 int end=j;
//                 currentsum = start == 0 ? prefix[end] : prefix[end]-prefix[start-1];
                
//                 if(currentsum > maxsum){
//                      maxsum=currentsum;
//                 }
//             }
//          }
//          return maxsum;
//     }
//     public static void main(String[] args) {
//         int arr[]={1,-2,6,-1,3};
//         int ans=maxSum(arr);
//         System.out.println("max sum="+ans);
//     }
    
// }



// // MAX_SUBARRAY SUM (KADANE_S Algorithm)


public class Array2 {

public static void KADANE_S(int arr[]){
  int ms=Integer.MIN_VALUE;
  int cs=0;
  // edge case - if hole array is negative
 
  for(int i=0;i<arr.length;i++){
    cs+=arr[i];
    if(cs<0){
        cs=0;
    }
    ms=Math.max(cs,ms);
  }
  System.out.println("our max sub array sum is:"+ms);
}

        public static void main(String[] args) {
            int arr[]={-2,-3,4,-1,-2,1,5,-3};
            KADANE_S(arr);
        }
        
    }



// // Trapping Rainwater   // O(n)

/*
  given n non-negative integers representing an elevation map
  where the width of each bar is 1, compute how much
  water it can trap after raining.
 */


//  public class Array2 {
//    public static int TrapedWater(int height[]){
//     // left max boundry - array 
//     int n=height.length;
//     int left_max[]= new int[n];
//     left_max[0]=height[0];
//     for(int i=1;i<n;i++){
//       left_max[i]=Math.max(height[i],left_max[i-1]);
//     }
//     // right max boundry - array
//     int right_max[]=new int[n];
//     right_max[n-1]=height[n-1];  // last se chalu hoga
//     for(int i=n-2;i>=0;i--){
//       right_max[i]=Math.max(height[i] , right_max[i+1]);
//     }

//     //loop
//     int trapedwater=0;
//     for(int i=0;i<n;i++){
//       //waterlevel = min(left_max , right_max)
//         int  waterlevel = Math.min(left_max[i] , right_max[i]);
//         // trapedwater = waterlevel-height[i]
//         trapedwater += waterlevel-height[i];
//     }  

//     return trapedwater;

//    }
//   public static void main(String[] args) {
//     int height[]={4,2,0,6,3,2,5};
//     System.out.println(TrapedWater(height));
//   }
//  }



// // Buy and Sell Stock



// public class Array2 {
//   public static int buyAndSellStock(int prices[]){
//        int buyPrice=Integer.MAX_VALUE;
//        int maxProfit=0;

//        for(int i=0;i<prices.length;i++){
//         if(prices[i]>buyPrice){
//           int profit=prices[i]-buyPrice;
//           maxProfit=Math.max(maxProfit,profit);
//         }else{
//           buyPrice=prices[i];
//         }
//        }
//        return maxProfit;
//   }
//   public static void main(String[] args) {
//     int prices[]={7,1,5,3,6,4};
//     System.out.println(buyAndSellStock(prices));
//   }
// }