// /// Nearby Cars \\ \\\\

// import java.util.PriorityQueue;
// public class Heap2 {
//     static class point implements Comparable<point> {
//         int x;
//         int y;
//         int distSq;

//         public point(int x, int y, int distSq) {
//             this.x = x;
//             this.y = y;
//             this.distSq = distSq;
//         }

//         @Override
//         public int compareTo(point p2) {
//             return this.distSq - p2.distSq; // ascending order (min-heap)
//         }

//         @Override
//         public String toString() {
//             return "(" + x + "," + y + ")";
//         }
//     }

//     public static void main(String[] args) {
//         int pts[][] = { {3, 3}, {5, -1}, {-2, 4} };
//         int k = 2;

//         PriorityQueue<point> pq = new PriorityQueue<>();
//         for (int i = 0; i < pts.length; i++) {
//             int distSq = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
//             pq.add(new point(pts[i][0], pts[i][1], distSq));
//         }

//         // Print k nearest points
//         for (int i = 0; i < k; i++) {
//             System.out.print("C" + pq.remove() + " ");
//         }
//     }
// }



// ///// Connect N Ropes \\ \\\\\\

// import java.util.PriorityQueue;
// public class Heap2 {
//     public static void main(String[] args) {
//        int ropes[]={4,3,2,6};
       
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for(int i=0;i<ropes.length;i++){
//             pq.add(ropes[i]);
//        }

//        int cost=0;
//        while(pq.size()>1){
//         int min=pq.remove();
//         int min2=pq.remove();
//         cost+=min+min2;
//         pq.add(min+min2);
//        }
//        System.out.println("Cost is:"+cost);
//     }
// }



// ///// Weakest Soldier \\ \\\\\

// import java.util.*;
// public class Heap2 {
//     // Class to represent each row with number of soldiers and row index
//     static class Row implements Comparable<Row> {
//         int soldiers;
//         int idx;
//         // Constructor
//         public Row(int soldiers, int idx) {
//             this.soldiers = soldiers;
//             this.idx = idx;
//         }
//         // Compare rows by soldier count, then by index
//         @Override
//         public int compareTo(Row r2) {
//             if (this.soldiers == r2.soldiers) {
//                 return this.idx - r2.idx; // smaller index comes first
//             } else {
//                 return this.soldiers - r2.soldiers; // fewer soldiers come first
//             }
//         }
//     }
//     public static void main(String[] args) {
//         int[][] army = {
//             {1, 0, 0, 0},
//             {1, 1, 1, 1},
//             {1, 0, 0, 0},
//             {1, 0, 0, 0}
//         };
//         int k = 2;

//         // Min-heap to store rows with weakest ones on top
//         PriorityQueue<Row> pq = new PriorityQueue<>();

//         // Count soldiers in each row and add to priority queue
//         for (int i = 0; i < army.length; i++) {
//             int count = 0;
//             for (int j = 0; j < army[0].length; j++) {
//                 if (army[i][j] == 1) {
//                     count++;
//                 } else {
//                     break; // 1s are always before 0s, stop early
//                 }
//             }
//             pq.add(new Row(count, i));
//         }
//         // Extract the indices of the k weakest rows
//         for (int i = 0; i < k; i++) {
//             System.out.println(pq.remove().idx);
//         }
//     }
// }



// ////// Sliding Window Maximum \\ \\\\\\ (Hard)


import java.util.*;
public class Heap2 {
    // Function to find max in each sliding window using PriorityQueue
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];

        // PriorityQueue stores pairs [value, index], sorted by value descending
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> b[0] - a[0] // Max-heap based on value
        );
        for (int i = 0; i < n; i++) {
            // Add current element and its index
            maxHeap.offer(new int[]{nums[i], i});

            // Remove the elements which are outside the window
            while (maxHeap.peek()[1] <= i - k) {
                maxHeap.poll();
            }

            // If we've reached size k, record the maximum
            if (i >= k - 1) {
                result[i - k + 1] = maxHeap.peek()[0];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] result = maxSlidingWindow(nums, k);

        System.out.println("Sliding Window Maximums:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}

