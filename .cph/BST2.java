
// public class BST2 {
//     static class Node{
//         int data;
//         Node left,right;

//         Node(int data){
//             this.data=data;
//             this.left = this.right = null;
//         }
//     }  

//     // Preorder 
//     public static void Preorder(Node root){
//         if(root==null) return;

//         System.out.print(root.data+" ");
//         Preorder(root.left);
//         Preorder(root.right);
//     }

//     // function for convert sorted array to Balanced BST

//     public static Node sortedArrtoBST(int arr[],int st,int end){
//         if(st>end) return null;

//         int mid=(st + end)/2;
//         Node root=new Node(arr[mid]);
        
//         root.left=sortedArrtoBST(arr, st, mid-1);
//         root.right=sortedArrtoBST(arr, mid+1, end);
//         return root;
//     }

//     public static void main(String[] args) {
//         int arr[]={3,5,6,8,10,11,12};

//         Node root=sortedArrtoBST(arr, 0, arr.length-1);
//         Preorder(root);
//     }
// }



// convert BST to balanced BST

// import java.util.ArrayList;
// public class BST2 {
//     static class Node {
//         int data;
//         Node left, right;

//         Node(int data) {
//             this.data = data;
//             this.left = this.right = null;
//         }
//     }

//     // BST to Balanced BST

//     // Step 1: Get inorder traversal
//     public static void getInorder(Node root, ArrayList<Integer> inorder) {
//         if (root == null) return;

//         getInorder(root.left, inorder);
//         inorder.add(root.data);
//         getInorder(root.right, inorder);
//     }

//     // Step 2: Build balanced BST from sorted list
//     public static Node buildBalancedBST(ArrayList<Integer> inorder, int start, int end) {
//         if (start > end) return null;

//         int mid = (start + end) / 2;
//         Node root = new Node(inorder.get(mid));

//         root.left = buildBalancedBST(inorder, start, mid - 1);
//         root.right = buildBalancedBST(inorder, mid + 1, end);

//         return root;
//     }

//     public static Node balancedBST(Node root) {
//         // Inorder sequence
//         ArrayList<Integer> inorder = new ArrayList<>();
//         getInorder(root, inorder);

//         // Build balanced BST from sorted inorder list
//         return buildBalancedBST(inorder, 0, inorder.size() - 1);
//     }

//     // Preorder traversal
//     public static void preorder(Node root) {
//         if (root == null) return;

//         System.out.print(root.data + " ");
//         preorder(root.left);
//         preorder(root.right);
//     }

//     public static void main(String[] args) {
//         /*
//             Original Unbalanced BST:
//                        8
//                      /   \
//                     6    10
//                    /       \
//                   5        11
//                  /            \
//                 3             12
//         */

//         Node root = new Node(8);
//         root.left = new Node(6);
//         root.left.left = new Node(5);
//         root.left.left.left = new Node(3);

//         root.right = new Node(10);
//         root.right.right = new Node(11);
//         root.right.right.right = new Node(12);

//         // Convert to balanced BST
//         Node balancedRoot = balancedBST(root);

//         System.out.println("Preorder of Balanced BST:");
//         preorder(balancedRoot);
//     }
// }








// import java.util.ArrayList;
// public class BST2 {
//     static class Node {
//         int data;
//         Node left, right;

//         Node(int data) {
//             this.data = data;
//             this.left = this.right = null;
//         }
//     }

//     static class Info {
//         boolean isBST;
//         int size;
//         int min;
//         int max;

//         public Info(boolean isBST, int size, int min, int max) {
//             this.isBST = isBST;
//             this.size = size;
//             this.min = min;
//             this.max = max;
//         }
//     }

//     public static int maxBST = 0;  // track largest size

//     public static Info largestBST(Node root) {
//         if (root == null) {
//             return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
//         }

//         Info leftInfo = largestBST(root.left);
//         Info rightInfo = largestBST(root.right);

//         int size = leftInfo.size + rightInfo.size + 1;
//         int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
//         int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

//         if(root.data <= leftInfo.max || root.data >= rightInfo.min){
//             return new Info(false,size,min,max); 
//         }

//         if (leftInfo.isBST && rightInfo.isBST) {
//             maxBST = Math.max(maxBST, size);
//             return new Info(true, size, min, max); // RETURN when valid BST
//         }

//         return new Info(false, size, min, max);
//     }

//     public static void main(String[] args) {
//         /*
//             Tree:
//                     50
//                    /  \
//                  30    60
//                 /  \   / \
//                5   20 45 70
//                            / \
//                           65 80

//             Expected: Largest BST subtree is:
//                        60
//                       /  \
//                     45    70
//                           / \
//                          65 80

//             Size = 5
//         */

//         Node root = new Node(50);
//         root.left = new Node(30);
//         root.left.left = new Node(5);
//         root.left.right = new Node(20);

//         root.right = new Node(60);
//         root.right.left = new Node(45);
//         root.right.right = new Node(70);
//         root.right.right.left = new Node(65);
//         root.right.right.right = new Node(80);

//         largestBST(root);
//         System.out.println("Size of the largest BST in the tree: " + maxBST);
//     }
// }





// ///// Merge 2 BST's \\ \\\\\

import java.util.ArrayList;
public class BST2 {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Function to get inorder traversal of a BST
    public static void getInorder(Node root, ArrayList<Integer> arr) {
        if (root == null) return;

        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }

    // Function to create a balanced BST from sorted array
    public static Node createBST(ArrayList<Integer> arr, int st, int end) {
        if (st > end) return null;

        int mid = (st + end) / 2;
        Node root = new Node(arr.get(mid));

        root.left = createBST(arr, st, mid - 1);
        root.right = createBST(arr, mid + 1, end);

        return root;
    }

    // Function to merge two BSTs into a balanced BST
    public static Node mergeBST(Node root1, Node root2) {
        // Step 1: Get inorder of BST1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);

        // Step 2: Get inorder of BST2
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        // Step 3: Merge two sorted arrays
        ArrayList<Integer> finalArr = new ArrayList<>();
        int i = 0, j = 0;
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) <= arr2.get(j)) {
                finalArr.add(arr1.get(i));
                i++;
            } else {
                finalArr.add(arr2.get(j));
                j++;
            }
        }

        while (i < arr1.size()) {
            finalArr.add(arr1.get(i++));
        }

        while (j < arr2.size()) {
            finalArr.add(arr2.get(j++));
        }

        // Step 4: Build balanced BST from merged sorted array
        return createBST(finalArr, 0, finalArr.size() - 1);
    }

    // Preorder to verify tree structure
    public static void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        /*
            BST 1:
                    2
                   / \
                  1   4  
        */
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4); 

        /*
            BST 2:
                    9
                   / \
                  3   12  
        */
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node mergedRoot = mergeBST(root1, root2);

        System.out.println("Preorder of Merged Balanced BST:");
        preorder(mergedRoot);
    }
}
