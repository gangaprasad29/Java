import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTree2 {

    // Node class
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Method 1: Recursive approach
    public static void KthLevelRecursive(Node root, int level, int k) {
        if (root == null) return;

        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }

        KthLevelRecursive(root.left, level + 1, k);
        KthLevelRecursive(root.right, level + 1, k);
    }

    // Method 2: Level-order traversal using BFS and manual level tracking
    public static void printKthLevelBFS(Node root, int level, int k) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            if (level == k) {
                for (int i = 0; i < size; i++) {
                    Node curr = q.poll();
                    System.out.print(curr.data + " ");
                }
                return;
            }

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }

            level++;
        }
    }

    // Helper method to find path from root to node (used in LCA approach 1)
    public static boolean getPath(Node root, int target, ArrayList<Node> path) {
        if (root == null) return false;

        path.add(root);

        if (root.data == target) return true;

        if (getPath(root.left, target, path) || getPath(root.right, target, path)) return true;

        path.remove(path.size() - 1);
        return false;
    }

    // LCA Approach 1 - Using Paths
    public static Node Lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        boolean found1 = getPath(root, n1, path1);
        boolean found2 = getPath(root, n2, path2);

        if (!found1 || !found2) return null;

        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) break;
        }

        return path1.get(i - 1);
    }

    // LCA Approach 2 - Single traversal (efficient)
    public static Node Lca2(Node root, int n1, int n2) {
        if (root == null) return null;

        if (root.data == n1 || root.data == n2) return root;

        Node leftLca = Lca2(root.left, n1, n2);
        Node rightLca = Lca2(root.right, n1, n2);

        if(rightLca == null) return leftLca;
        if(leftLca == null) return rightLca;

        return root;
    }

    // MIN distance b/n two nodes

    public static int lcaDist(Node root, int n){
        if(root==null) return -1;

        if(root.data == n) return 0; // because dist between lca(root)  and n is 0

        int leftDist=lcaDist(root.left, n);
        int rightDist=lcaDist(root.right, n);

        if(leftDist==-1 && rightDist==-1){
            return -1;
        }else if(leftDist == -1){
            return rightDist+1;
        }else{
            return leftDist+1;
        }
    }
    public static int minDist(Node root , int n1 , int n2){
        Node Lca = Lca2(root,n1,n2);

        int dist1 = lcaDist(Lca,n1);
        int dist2 = lcaDist(Lca,n2);
        return dist1 + dist2;
    }

    // Kth ancestor of a node 
    public static int KthAncestor(Node root,int n, int k){
        if(root == null) return -1;

        if(root.data==n){
            return 0;
        }
        int leftDist= KthAncestor(root.left,n,k);
        int rightDist= KthAncestor(root.right,n,k);

        if(leftDist == -1 && rightDist == -1) return -1;

        int max = Math.max(leftDist,rightDist);
        if(max+1 == k){ 
            System.out.println(root.data);
        }
        return max+1;
    }

    // Transformation to a sum tree

    public static int TransformSum(Node root){
        if(root == null) return 0;

        int leftSum=TransformSum(root.left);
        int rightSum=TransformSum(root.right);

        int oldVal=root.data;

        root.data=leftSum+rightSum;

        return leftSum+rightSum+oldVal;
    }
    public static void preorder(Node root) {
    if (root == null) return;
    System.out.print(root.data + " ");
    preorder(root.left);
    preorder(root.right);
}

    // Main method
    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             / \  / \
            4  5 6   7
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int k = 3;

        System.out.println("Kth level using recursion:");
        KthLevelRecursive(root, 1, k);

        System.out.println("\nKth level using level order traversal:");
        printKthLevelBFS(root, 1, k); // start from level 1

        // LCA Tests
        int a = 4, b = 5;
        System.out.println("\nLCA of " + a + " and " + b + " (Approach 1): " + Lca(root, a, b).data);

        a = 4;
        b = 7;
        System.out.println("LCA of " + a + " and " + b + " (Approach 2): " + Lca2(root, a, b).data);

        a=4;
        b=5;
        System.out.println(minDist(root, a, b));

        a=5;
        k=2;
        KthAncestor(root,a,k);

        TransformSum(root);
        preorder(root);
        
    }
}
