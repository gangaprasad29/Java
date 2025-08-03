// ///// Largest Sumarray with 0 Sum

// import java.util.*;
// public class Hashing3 {
//     public static void main(String[] args) {
//         int arr[]={15,-2,2,-8,1,7,10,23};
//         HashMap<Integer,Integer> map=new HashMap<>();

//         int sum=0;
//         int length=0;

//         for(int j=0;j<arr.length;j++){
//             sum+=arr[j];
//             if(map.containsKey(sum)){
//                 length=Math.max(length,j-map.get(sum));
//             }else{
//                 map.put(sum, j);
//             }
//         }
//         System.out.println("largest subarr with sum 0 is with length : "+length);
//     }
// }


// /// Subarray Sum Equals to k

import java.util.HashMap;
public class Hashing3 {
    public static void main(String[] args) {
        int arr[] = {10, 2, -2, -20, 10};
        int k = -10;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // Handle subarrays starting from index 0

        int sum = 0;
        int count = 0;

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println(count);
    }
}
