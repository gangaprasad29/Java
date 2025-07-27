///// Array Q.

// public class Backtracking {
//     public static void printArr(int arr[]){
//         for(int i=0;i<arr.length;i++){
//             System.out.print (arr[i]+" ");
//         }
//         System.out.println();
//     }

//     public static void ChangeArr(int arr[], int i, int val){
//         //base case  (will print one array)
//         if(i==arr.length){
//             printArr(arr);
//             return;
//         }
//         //recursion 
//         arr[i]=val;     // (will print one array)
//         ChangeArr(arr, i+1, val+1);
//         arr[i]=arr[i]-2;   // Backtracking Step (change the  array)
//     }
//     public static void main(String[] args) {
//         int arr[]= new int[5];
//         ChangeArr(arr,0,1);
//         printArr(arr);   // print the changed array
//     }
// }



// Q} FIND SUBSET

// public class Backtracking {
//     public static void FindSubsets(String str,String ans, int i){
//         // base case
//         if(i== str.length()){
//             System.out.println(ans);
//             return;
//         }
//         // recursion
//         // yes choice
//         FindSubsets(str, ans+str.charAt(i), i+1);
//         // no choice
//         FindSubsets(str, ans, i+1);
//     }
//     public static void main(String[] args) {
//         String str="abc";
//         FindSubsets(str,"",0);
//     }
// }



// FIND PERMUTATION

// public class Backtracking {
//     public static void FindPermutation(String str,String ans){
//         // base case
//         if(str.length()==0){
//             System.out.println(ans);
//             return;
//         }
//         //recursion
//         for(int i=0;i<str.length();i++){
//             char curr= str.charAt(i);
//             // "abcde"=> "ab"+"de"="abde"
//             String Newstr=str.substring(0,i)+str.substring(i+1);
//             FindPermutation(Newstr, ans+curr);
//         }
//     }
//     public static void main(String[] args) {
//         String str="abc";
//         FindPermutation(str, "");
//     }
// }


/// N-Queens

// public class Backtracking {

//     public static void nQueens(char board[][], int row) {
//         // base case
//         if (row == board.length) {
//             printBoard(board);
//             count++;
//             return;
//         }

//         for (int j = 0; j < board.length; j++) {
//             if (isSafe(board, row, j)) {
//                 board[row][j] = 'Q';            // place queen
//                 nQueens(board, row + 1);        // recursive call
//                 board[row][j] = '.';            // backtrack
//             }
//         }
//     }

//     public static boolean isSafe(char[][] board, int row, int col) {
//         // check vertical up
//         for (int i = row-1; i >= 0; i--) {
//             if (board[i][col] == 'Q') return false;
//         }

//         // check diagonal left up
//         for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
//             if (board[i][j] == 'Q') return false;
//         }

//         // check diagonal right up
//         for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
//             if (board[i][j] == 'Q') return false;
//         }

//         return true;
//     }

//     public static void printBoard(char board[][]) {
//         for (int i = 0; i < board.length; i++) {
//             for (int j = 0; j < board.length; j++) {
//                 System.out.print(board[i][j] + " ");
//             }
//             System.out.println();
//         }
//         System.out.println(); // for spacing between solutions
//     }

//     static int count=0; // to c
//     public static void main(String[] args) {
//         int n = 4; // You can change n
//         char board[][] = new char[n][n];

//         // initialize with dots
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 board[i][j] = '.';
//             }
//         } 

//         nQueens(board, 0); //  fixed semicolon
//         System.out.println("total ways:"+count);
//     }
// }




//// N-Queens 1 solution


public class Backtracking {

    // Flag to stop after first solution
    public static boolean solutionFound = false;

    public static void nQueens(char board[][], int row) {
        if (solutionFound) return;  // Stop recursion if a solution is already found

        // base case: all rows are filled
        if (row == board.length) {
            printBoard(board);
            solutionFound = true;  // mark solution found
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';            // place queen
                nQueens(board, row + 1);        // recursive call
                board[row][j] = '.';            // backtrack
            }
        }
    }

    public static boolean isSafe(char[][] board, int row, int col) {
        // check vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') return false;
        }

        // check diagonal left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // check diagonal right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    public static void printBoard(char board[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(); // spacing
    }

    public static void main(String[] args) {
        int n = 4; // try n = 8 for standard chess board
        char board[][] = new char[n][n];

        // initialize board with dots
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        nQueens(board, 0);

        if (!solutionFound) {
            System.out.println("No solution exists for n = " + n);
        }
    }
}
