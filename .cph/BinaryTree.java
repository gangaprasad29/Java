import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;


import java.util.*;

public class BinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Binarytree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        // preorder traversal
        public static void preorder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        // Inorder traversal
        public static void Inorder(Node root) {
            if (root == null) {
                return;
            }
            Inorder(root.left);
            System.out.print(root.data + " ");
            Inorder(root.right);
        }

        // Post order traversal
        public static void postorder(Node root) {
            if (root == null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        // Level order traversal
        public static void Leverorder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null); // for next line
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }

        //// Height of a tree 
        public static int Height(Node root) {
            if (root == null) {
                return 0;
            }
            int lh = Height(root.left);
            int rh = Height(root.right);
            int height = Math.max(lh, rh) + 1;
            return height;
        }

        // Count Nodes in a tree
        public static int Count(Node root){
            if(root==null){
                return 0;
            }
            int Lcount = Count(root.left);
            int Rcount = Count(root.right);
            int TotalCount = Lcount + Rcount + 1;
            return TotalCount;
        }

        // Sum of Nodes in a tree
        public static int Sum(Node root){
            if(root==null){
                return 0;
            }
            int lSum=Sum(root.left);
            int rSum=Sum(root.right);
            int TotalSum=lSum+rSum+root.data;
            return TotalSum;
        }

        // Diameter of a tree (Approach 1)  O(n^2) 
        public static int Diameter1(Node root){
            if(root==null){
                return 0;
            }
            // if diameter is with root
            int lh = Height(root.left);
            int rh = Height(root.right);
            int rootDiameter = lh + rh + 1; 
            //if diameter is without root
            int lDiameter=Diameter1(root.left);
            int rDiameter=Diameter1(root.right);
            int withoutrootDmtr=Math.max(lDiameter,rDiameter);

            int finalDiameter=Math.max(rootDiameter,withoutrootDmtr);
            return finalDiameter;
        }

        // Approach 2
        // Helper class to store both height and diameter
        static class TreeInfo {
            int height;
            int diam;

            TreeInfo(int height, int diam) {
                this.height = height;
                this.diam = diam;
            }
        }

        // Diameter of a tree (Approach 2) O(n)
        public static TreeInfo Diameter2(Node root){
            if(root == null){
                return new TreeInfo(0, 0);
            }

            TreeInfo left = Diameter2(root.left);
            TreeInfo right = Diameter2(root.right);

            int myDiameter = Math.max(left.height + right.height + 1, Math.max(left.diam, right.diam));
            int myHeight = Math.max(left.height, right.height) + 1;

            return new TreeInfo(myHeight, myDiameter);
        }

        // Subtree of a Tree
        public static boolean isIdentical(Node node, Node subRoot){
            if(node == null && subRoot == null){
                return true; // identical
            }
            else if(node == null || subRoot == null || node.data != subRoot.data){
                return false; // non-identical
            }

            if(!isIdentical(node.left, subRoot.left)){
                return false;
            }
            if(!isIdentical(node.right, subRoot.right)){
                return false;
            }

            return true; // all matched
        }

        public static boolean isSubtree(Node root, Node subRoot){
            if(root == null){
                return false;
            }
            // if our starting root node is the required node then
            if(root.data == subRoot.data){
                if(isIdentical(root, subRoot)){
                    return true;
                }
            }
            // if above false
            boolean leftAns = isSubtree(root.left, subRoot);
            boolean rightAns = isSubtree(root.right, subRoot);
            return leftAns || rightAns;
        }


        //////// Top view of a tree \\\\\\\\\
        
        static class Info {
            Node node;
            int HD;

            public Info(Node node,int HD){
                this.node=node;
                this.HD=HD;
            }
        }

        public static void TopView(Node root){
            //level order traversal
            if(root == null) return;

            Queue<Info> q= new LinkedList<>();
            HashMap<Integer,Node> map= new HashMap<>();

            int min=0,max=0;
            q.add(new Info(root, 0));


            while(!q.isEmpty()){
                Info curr = q.remove();
                if(curr==null){
                    if(q.isEmpty()){ 
                        break;
                    }else{
                        q.add(null); 
                    }
                }
                if(!map.containsKey(curr.HD)){ // first time HD occurs
                    map.put(curr.HD, curr.node);
                }
                
                if(curr.node.left != null){
                    q.add(new Info(curr.node.left, curr.HD-1));
                    min=Math.min(min,curr.HD-1);
                }
                if(curr.node.right !=null){
                    q.add(new Info(curr.node.right,curr.HD+1));
                    max=Math.max(max, curr.HD+1);
                }
            }
            for(int i=min;i<=max;i++){
                System.out.print(map.get(i).data+" ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int nodes1[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        int nodes2[] = { 2, 4, -1, -1, 5, -1, -1 };

        Binarytree tree = new Binarytree();
        Binarytree.idx = -1;
        Node root = tree.buildTree(nodes1);
 
        Binarytree.idx = -1;
        Node subRoot = tree.buildTree(nodes2);

        System.out.println(root.data);

        tree.preorder(root);

        System.out.println(); // used for next line

        tree.Inorder(root);

        System.out.println(); // used for next line

        tree.postorder(root);

        System.out.println(); // used for next line

        tree.Leverorder(root);

        System.out.println(); // used for next line

        System.out.println("Height of the tree is: " + Binarytree.Height(root));

        System.out.println(); // used for next line

        System.out.println("No. of Nodes in a tree are : " + Binarytree.Count(root));

        System.out.println(); // used for next line

        System.out.println("Sum of Nodes is : " + Binarytree.Sum(root));

        System.out.println(); // used for next line

        System.out.println("Diameter of a tree is with 1st approach is : " + Binarytree.Diameter1(root));

        System.out.println("Diameter of a tree with 2nd approach is : " + Binarytree.Diameter2(root).diam);

        System.out.println("Is subRoot a subtree of main tree? : " + Binarytree.isSubtree(root, subRoot));

        System.out.print("Top view is: ");
        Binarytree.TopView(root);

    }
}
