public class AVLtree {
    static class Node {
        int data, height;
        Node left, right; 

        Node(int data) {
            this.data = data;
            this.height = 1; // height of a leaf node is 1
        }
    }

    public static Node root;

    // Get height of a node
    public static int height(Node node) {
        if (node == null) return 0;
        return node.height;
    }

    // Get balance factor
    public static int getBalance(Node node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    // Right rotate
    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x; // New root
    }

    // Left rotate
    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y; // New root
    }

    // Insert a node into AVL tree
    public static Node insert(Node node, int key) {
        // Step 1: Normal BST insert
        if (node == null) return new Node(key);

        if (key < node.data)
            node.left = insert(node.left, key);
        else if (key > node.data)
            node.right = insert(node.right, key);
        else // Duplicates not allowed
            return node;

        // Step 2: Update height
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Step 3: Get balance factor
        int balance = getBalance(node);

        // Step 4: Balance the node

        // Left Left Case
        if (balance > 1 && key < node.left.data)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.data)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node; // Return the unchanged node pointer
    }

    // Preorder traversal
    public static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Main method
    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        /*
        AVL Tree Output :
                  30
                /    \
              20      40
             /  \        \
           10   25       50
        */

        System.out.println("Preorder traversal of AVL Tree:");
        preorder(root);
    }
}
