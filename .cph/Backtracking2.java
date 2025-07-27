// Grid problem

// public class Backtracking2 {
//     public static int gridWays(int i, int j, int n, int m){
//         // base case
//         if(i== n-1 && j==m-1){ // last cell
//             return 1;
//         }else if(i==n || j==m){ // boundry cross condition
//             return 0;
//         }
//         //work
//         int w1=gridWays(i+1, j, n, m);
//         int w2=gridWays(i, j+1, n, m);
//         return w1+w2;

//     }
//     public static void main(String[] args) {
//         int n=3 , m=3;
//         System.out.println(gridWays(0, 0, n, m));
//     }
// }



// Grid problem (with good time complexity) 

// public class Backtracking2 {
//     // Efficient factorial function
//     public static long factorial(int num) {
//         long fact = 1;
//         for (int i = 2; i <= num; i++) {
//             fact *= i;
//         }
//         return fact;
//     }
//     // Function using permutation formula
//     public static long gridWays(int n, int m) {
//         // Total moves = n-1 down, m-1 right => (n-1 + m-1)! / [(n-1)! * (m-1)!]
//         return factorial(n-1 + m-1) / (factorial(n - 1) * factorial(m - 1));
//     }
//     public static void main(String[] args) {
//         int n = 3, m = 3;
//         System.out.println(gridWays(n, m)); // Output: 6
//     }
// }





///// Sudoku 

public class Backtracking2 {
    // Sudoku Solver Function
    public static boolean sudokuSolver(int[][] Sudoku, int row, int col) {
        // If we've reached the end of the grid
        if (row == 9) {
            return true;
        }
        // Move to next cell
         int nextRow = row;
        int nextCol = col + 1;
        if (nextCol == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }
        // Skip pre-filled cells
        if (Sudoku[row][col] != 0) {
            return sudokuSolver(Sudoku, nextRow, nextCol);
        }
        // Try all digits 1 to 9
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(Sudoku, row, col, digit)) {
                Sudoku[row][col] = digit; // Place digit
                if (sudokuSolver(Sudoku, nextRow, nextCol)) {
                    return true; // If success, stop
                }
                Sudoku[row][col] = 0; // Backtrack
            }
        }

        return false; // No valid digit found
    }
    // Check if placing digit is valid
    public static boolean isSafe(int[][] Sudoku, int row, int col, int digit) {
        // Check row and column
        for (int i = 0; i < 9; i++) {
            if (Sudoku[row][i] == digit || Sudoku[i][col] == digit) {
                return false;
            }
        }
        // Check 3x3 grid
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (Sudoku[i][j] == digit) {
                    return false;
                }
            }
        }

        return true;
    }
    // Print the Sudoku board
    public static void printSudoku(int[][] Sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(Sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Main Function
    public static void main(String[] args) {
        int[][] Sudoku = {
            {0, 0, 8, 0, 0, 0, 0, 0, 0},
            {4, 9, 0, 1, 5, 7, 0, 0, 2},
            {0, 0, 3, 0, 0, 4, 1, 9, 0},
            {1, 8, 5, 0, 6, 0, 0, 2, 0},
            {0, 0, 0, 0, 2, 0, 0, 6, 0},
            {9, 6, 0, 4, 0, 5, 3, 0, 0},
            {0, 3, 0, 0, 7, 2, 0, 0, 4},
            {0, 4, 9, 0, 3, 0, 0, 5, 7},
            {8, 2, 7, 0, 0, 9, 0, 1, 3}
        };

        if (sudokuSolver(Sudoku, 0, 0)) {
            System.out.println("Sudoku Solved:");
            printSudoku(Sudoku);
        } else {
            System.out.println("No solution exists.");
        }
    }
}



///////////        How This Works   \\\\\\\\\\\\\

// Start at cell (0, 0).

// If a cell is already filled (not zero), go to the next cell.

// If it's empty (0), try putting digits 1 to 9 one by one.

// Before placing a digit, check:

// Is it not repeated in the row?

// Is it not repeated in the column?

// Is it not repeated in the 3x3 subgrid?

// If a digit is safe, place it and move to next cell.

// If placing leads to a solution, return true.

// If not, remove the digit (backtrack) and try the next one.

// Repeat until you reach the end (row == 9), meaning solved!