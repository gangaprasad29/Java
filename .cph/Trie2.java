// ///// Count Unique Substrings using Trie /////

// public class Trie2 {
//     static class Node {
//         Node[] children = new Node[26];
//         boolean endOfWord = false;  

//         public Node() {
//             for (int i = 0; i < 26; i++) {
//                 children[i] = null;
//             }
//         }
//     }
//     public static Node root = new Node(); // empty

//     public static void Insert(String word){
//         Node curr=root;
//         for(int level=0;level<word.length();level++){
//             int idx=word.charAt(level)-'a';
//             if(curr.children[idx]==null){
//                 curr.children[idx]=new Node();
//             }
//             curr=curr.children[idx]; // updating current
//         }
//         curr.endOfWord=true; // mark the end of the word
//     }
//     public static int countNodes(Node root){
//         if(root == null) return 0;

//         int count=0;
//         for(int i=0;i<26;i++){
//             if(root.children[i] != null){
//                 count += countNodes(root.children[i]);
//             }
//         }
//         return count + 1; // +1 for the current node
//     }
//     public static void main(String[] args) {
//         String str="ababa";
//         // suffix
//         for(int i=0;i<str.length();i++){
//             String suffix= str.substring(i);
//             Insert(suffix);
//         }
//         System.out.println("Count of unique substrings: " + countNodes(root));
//     }
// }



// ////// Longest Word with all prefixes \\ \\\\\

public class Trie2 {
    static class Node {
        Node[] children = new Node[26];
        boolean endOfWord = false;

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();
    public static String ans = "";
    public static StringBuilder temp = new StringBuilder();

    public static void Insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.endOfWord = true;
    }

    public static void LongestWord(Node root) {
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].endOfWord) {
                temp.append((char) (i + 'a'));

                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                LongestWord(root.children[i]);
                temp.deleteCharAt(temp.length() - 1); // backtrack
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};

       for(int i = 0; i < words.length; i++) {
            Insert(words[i]);
        }
        LongestWord(root);
        System.out.println("Longest word built character by character: " + ans);
    }
}
