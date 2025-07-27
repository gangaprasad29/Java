/* Q.
    for a given n line on x-axis , use 2 lines to form a container
    such that it holds maxiimum water. 
    height=[1,8,6,2,5,4,8,3,7]
 */


 // Brute Force Approach

// import java.util.ArrayList;
// public class MyArrayList2 {
//     public static int StoredWater(ArrayList<Integer> height){
//         int maxWater= 0;
//         //brute force  O(n^2)
//         for(int i=0;i<height.size();i++){
//             for(int j=i+1;j<height.size();j++){
//                 int ht=Math.min(height.get(i),height.get(j));
//                 int width=j-i;
//                 int currWater=ht*width;
//                 maxWater=Math.max(maxWater,currWater);
//             }
//         }
//         return maxWater;
//     }
//     public static void main(String[] args) {
//         ArrayList<Integer> height= new ArrayList<>();
//         height.add(1);
//         height.add(8);
//         height.add(6);
//         height.add(2);
//         height.add(5);
//         height.add(4);
//         height.add(8);
//         height.add(3);
//         height.add(7);

//         System.out.println(StoredWater(height));
//     }
// }



///// Two pointer Approach


// import java.util.ArrayList;
// public class MyArrayList2 {
//     public static int StoredWater(ArrayList<Integer> height){
//         int maxWater= 0;
//         // two pointer approach
//         int lp=0;
//         int rp=height.size()-1;
//         while(lp<rp){
//             // calculate water area
//             int ht=Math.min(height.get(rp),height.get(lp));
//             int width = rp-lp;
//             int currWater=ht*width;
//             maxWater=Math.max(maxWater,currWater);

//             // update ptr
//             if(height.get(lp)<height.get(rp)){
//                 lp++;
//             }else{
//                 rp--;
//             }
//         }
//         return maxWater;
//     }
//     public static void main(String[] args) {
//         ArrayList<Integer> height= new ArrayList<>();
//         height.add(1);
//         height.add(8);
//         height.add(6);
//         height.add(2);
//         height.add(5);
//         height.add(4);
//         height.add(8);
//         height.add(3);
//         height.add(7);

//         System.out.println(StoredWater(height));
//     }
// }




// // ////  PAIR SUM 
// BRUTE FORCE APPROACH

// import java.util.ArrayList;
// public class MyArrayList2 {
//     // Brute-force approach to check if any pair sums to target
//     public static boolean pairSum(ArrayList<Integer> list, int target) {
//         for (int i = 0; i < list.size(); i++) {
//             for (int j = i + 1; j < list.size(); j++) {
//                 if (list.get(i) + list.get(j) == target) {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }

//     public static void main(String[] args) {
//         ArrayList<Integer> list = new ArrayList<>();
//         list.add(1);
//         list.add(2);
//         list.add(3);
//         list.add(4);
//         list.add(5);
//         list.add(6);

//         int target = 5;
//         System.out.println(pairSum(list, target));  // Output: true (1+4 or 2+3)
//     }
// }



///    Pair Sum
/////  Two pointer approach  



// import java.util.ArrayList;

// public class MyArrayList2 {
//     // Brute-force approach to check if any pair sums to target
//     public static boolean pairSum(ArrayList<Integer> list, int target) {
//         int lp=0;
//         int rp=list.size()-1;

//     while(lp<rp){
//         int sum=list.get(lp)+list.get(rp);
//         if(sum==target ){
//             return true;
//         }else if(sum<target){
//             lp++;
//         }else{
//             rp--;
//         }
//     }
//     return false;
//     }

//     public static void main(String[] args) {
//         ArrayList<Integer> list = new ArrayList<>();
//         list.add(1);
//         list.add(2);
//         list.add(3);
//         list.add(4);
//         list.add(5);
//         list.add(6);

//         int target = 5;
//         System.out.println(pairSum(list, target));  // Output: true (1+4 or 2+3)
//     }
// }




/// Pair sum2


import java.util.ArrayList;

public class MyArrayList2 {
    // Two-pointer approach for rotated sorted array
    public static boolean pairSum2(ArrayList<Integer> list, int target) {
        int breakpt = -1;
        int n = list.size();

        // Find the breaking point (where array is rotated)
        for (int i = 0; i < n - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                breakpt = i;
                break;
            }
        }

        // Set two pointers
        int lp = (breakpt + 1) % n; // smallest element
        int rp = breakpt;           // largest element

        // Apply circular two-pointer approach
        while (lp != rp) {
            int sum = list.get(lp) + list.get(rp);

            if (sum == target) {
                return true;
            } else if (sum < target) {
                lp = (lp + 1) % n;
            } else {
                rp = (n + rp - 1) % n;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        int target = 16;
        System.out.println(pairSum2(list, target));  // Output: true (6 + 10)
    }
}
