import java.util.ArrayList;

public class BST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Insert into BST
    public static Node Insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) { // left subtree
            root.left = Insert(root.left, val);
        } else { // right subtree
            root.right = Insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Search in BST
    public static boolean Search(Node root, int key) {
        if (root == null) return false;

        if (root.data == key) return true;

        if (key < root.data) { // search in leftsubtree
            return Search(root.left, key);
        } else { // search in rightsubtree
            return Search(root.right, key);
        }
    }

    // print in Range 
    public static void printinRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        // Case1:
        if (root.data >= k1 && root.data <= k2) {
            printinRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printinRange(root.right, k1, k2);
        }
        // Case 2:
        else if (root.data < k1) {
            printinRange(root.right, k1, k2);
        }
        // Case 3:
        else {
            printinRange(root.left, k1, k2);
        }
    }

    // print root to Leaf Path
    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size() - 1; i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println("Null");
    }

    public static void printRootToLeafPath(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        //base case
        if (root.left == null && root.right == null) { // reach to leaf node
            printPath(path);
        }

        printRootToLeafPath(root.left, path);
        printRootToLeafPath(root.right, path);
        path.remove(path.size() - 1);
    }

    // Validate BST
    public static boolean isVaildBST(Node root, Node min, Node max) {
        if (root == null) return true;

        if (min != null && root.data <= min.data) return false;

        if (max != null && root.data >= max.data) return false;

        return isVaildBST(root.left, min, root) && isVaildBST(root.right, root, max);
    }

    // Mirror of BST
    public static Node Mirror(Node root) {
        if (root == null) return null;
        // mirror the left and right subtree
        Node leftSubTree = Mirror(root.left);
        Node rightSubTree = Mirror(root.right);

        // then root node ke left ko rightsubTree and right ko leftsubTree 
        root.left = rightSubTree;
        root.right = leftSubTree;
        return root;
    }

    public static void main(String[] args) {
        /*
                Constructed BST:
                        8
                       / \
                      3   10
                     / \    \
                    1   6    14
                       / \   /
                      4   7 13
        */

        int values[] = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = Insert(root, values[i]);
        }

        System.out.println("Inorder Traversal:");
        inorder(root);

        System.out.println();
        if (Search(root, 6)) {
            System.out.println("found");
        } else {
            System.out.println("not found");
        }

        System.out.print("Nodes in range [5,13]: ");
        printinRange(root, 5, 13);
        System.out.println();

        System.out.println("Root to Leaf Paths:");
        printRootToLeafPath(root, new ArrayList<>());

        if (isVaildBST(root, null, null)) {
            System.out.println("valid BST");
        } else {
            System.out.println("not a valid BST");
        }

        System.out.print("Mirror of the BST (Inorder): ");
        root = Mirror(root);
        inorder(root);
    }
} 
