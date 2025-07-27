// //// Activity selection \\\\ \\ 


// import java.util.*;
// public class Greedy {
//     public static void main(String[] args) {
//         int start[] = {1, 3, 0, 5, 8, 5};
//         int end[] = {2, 4, 6, 7, 9, 9};

//         // sorting
//         int activities[][] = new int[start.length][3];
//         for (int i = 0; i < start.length; i++) {
//             activities[i][0] = i;
//             activities[i][1] = start[i];
//             activities[i][2] = end[i];
//         }

//         // lambda function -> shortform
//         Arrays.sort(activities, Comparator.comparingInt(o -> o[2]));

//         // end time basis sorted
//         int maxAct = 0;
//         ArrayList<Integer> ans = new ArrayList<>(); // to store idx of activities

//         maxAct = 1;
//         ans.add(activities[0][0]); // adding first activity
//         int lastEnd = activities[0][2];

//         for (int i = 1; i < end.length; i++) {
//             if (activities[i][1] >= lastEnd) {
//                 maxAct++;
//                 ans.add(activities[i][0]);
//                 lastEnd = activities[i][2];
//             }
//         }

//         System.out.println("maximum activities = " + maxAct);
//         for (int i = 0; i < ans.size(); i++) {
//             System.out.println(ans.get(i));
//         }
//     }
// }



// ///// Fractional Knapsack \\ \\\\\\\\\


// import java.util.*;
// public class Greedy {
//     public static void main(String[] args) {
//         int values[] = {60, 100, 120};
//         int weights[] = {10, 20, 30};
//         int w = 50;

//         double ratio[][] = new double[values.length][2];
//         // 0th col = idx;  and on,   1st col = ratio
//         for (int i = 0; i < values.length; i++) {
//             ratio[i][0] = i;
//             ratio[i][1] = values[i] / (double) weights[i];
//         }

//         // assending order sorting according to ratio
//         Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

//         int capacity = w;
//         int finalVal = 0;
//         // reverse sorting because more ratio then good 
//         for (int i = ratio.length - 1; i >= 0; i--) {
//             int idx = (int) ratio[i][0];
//             if (capacity >= weights[idx]) {
//                 finalVal += values[idx];
//                 capacity -= weights[idx];
//             } else {
//                 // including fractonal item
//                 finalVal += (int)(ratio[i][1] * capacity);
//                 capacity = 0;
//                 break;
//             }
//         }
//         System.out.println("final value :" + finalVal);
//     }
// }



// /// Min Absolute Difference Pairs \\ \\\\

// import java.util.*;
// public class Greedy {
//     public static void main(String[] args) {
//         int A[]={4,1,8,7};
//         int B[]={2,3,6,5};

//         Arrays.sort(A);
//         Arrays.sort(B);

//         int minDiff=0;
//         for(int i=0;i<A.length;i++){
//             minDiff += Math.abs(A[i]-B[i]); 
//         }
//         System.out.println("min absolute diff is : "+minDiff);
//     }
// }




// ///// Max Length Chain of Pairs \\ \\\\\\

// import java.util.*;
// public class Greedy {
//     public static void main(String[] args) {
//         int Pairs[][] = {{5,24},{39,60},{2,28},{27,40},{50,90}};
//         Arrays.sort(Pairs, Comparator.comparingDouble(o -> o[1])); // end sort
        
//         int chainlength = 1;
//         int pairend = Pairs[0][1]; // keeps track of the end value of the last selected pair

//         for (int i = 1; i < Pairs.length; i++) {
//             if (Pairs[i][0] > pairend) {
//                 chainlength++;
//                 pairend = Pairs[i][1]; // updating pairend
//             } 
//         }
//         System.out.println("max length of chain is : " + chainlength);
//     }
// }



// /////  Indial Coins \\ \\\\\\

import java.util.*;

public class Greedy {
    public static void main(String[] args) {
        Integer[] Coins = {1, 2, 5, 10, 20, 50, 100, 500, 2000}; // Integer because to sort desending
        Arrays.sort(Coins, Comparator.reverseOrder());

        int countCoin = 0;
        int amount = 590;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < Coins.length; i++) {
            if (Coins[i] <= amount) {
                while (Coins[i] <= amount) {
                    countCoin++;
                    ans.add(Coins[i]);
                    amount -= Coins[i];
                }
            }
        }

        System.out.println("total min coins used = " + countCoin);
        System.out.println("coins used = " + ans);
    }
}
