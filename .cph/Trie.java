///  Insertion in Trie

// public class Trie {
//     static class Node{
//         Node children[]=new Node[26];
//         boolean endOfWord=false;

//         Node(){
//             for(int i=0;i<26;i++){
//                 children[i]=null;
//             }
//         }
//     }
//     public static Node root=new Node(); //empty

//     public static void Insert(String words){
//         Node curr = root;
//         for(int level=0;level<words.length();level++){
//             int idx= words.charAt(level)-'a';
//             if(curr.children[idx]==null){
//                 curr.children[idx]=new Node();
//             }
//             curr=curr.children[idx]; // updating current
//         }
//         curr.endOfWord=true;
//     }

//     // ////// Search in Trie \\ \\\\\
//     public static boolean Search(String key){
//         Node curr = root;
//         for(int level=0;level<key.length();level++){
//             int idx= key.charAt(level)-'a';
//             if(curr.children[idx]==null){
//                 return false;
//             }
//             curr=curr.children[idx]; // updating current
//         }
//         return curr.endOfWord==true;
//     }

//     // Word break problem
//     public static boolean wordBreak(String key){
//         if(key.length()==0){
//             return true;
//         }
//         for(int i=1;i<=key.length();i++){ 
//             if(Search(key.substring(0,i)) && wordBreak(key.substring(i))){
//                 return true;
//             }
//         }
//         return false;
//     }

//     public static void main(String[] args) {

//     //   String words[]={"the","a","there","any","thee"};
//     //   for(int i=0;i<words.length;i++){
//     //     Insert(words[i]);
//     //   }
//     //   System.out.println("words inserted into Trie");
//     //   System.out.println(Search("thee"));
//     //   System.out.println(Search("thor"));

//       // for word break problem 
//       String arr[]={"i","like","samsung","mobile","ice"};
//       for(int i=0;i<arr.length;i++){
//         Insert(arr[i]);
//       }
//       String key="ilikesamsung";
//       System.out.println(wordBreak(key));
//    } 
// }






// /// Prefix Problem \\ \\\  (hard)

// public class Trie {
//     static class Node {
//         Node[] children = new Node[26];
//         int freq;

//         public Node() {
//             for (int i = 0; i < 26; i++)
//                 children[i] = null;
//             freq = 0; // Start with 0, increment when visited
//         }
//     }

//     public static Node root = new Node();

//     public static void Insert(String word) {
//         Node curr = root;
//         for (int i = 0; i < word.length(); i++) {
//             int idx = word.charAt(i) - 'a';
//             if (curr.children[idx] == null) {
//                 curr.children[idx] = new Node();
//             }
//             curr = curr.children[idx];
//             curr.freq++; // Increment frequency for each visit
//         }
//     }

//     public static void findPrefix(Node node, String prefix) {
//         if (node == null)
//             return;

//         if (node.freq == 1) {
//             System.out.println(prefix);
//             return;
//         }

//         for (int i = 0; i < 26; i++) {
//             if (node.children[i] != null) {
//                 findPrefix(node.children[i], prefix + (char) (i + 'a'));
//             }
//         }
//     }
//     public static void main(String[] args) {
//         String[] words = {"zebra", "dog", "duck", "dove"};
//         for (String word : words) {
//             Insert(word);
//         }
//         findPrefix(root, "");
//     }
// }




// ////// StartsWith Problem \\ \\\\\\\


// public class Trie {
//     static class Node {
//         Node[] children = new Node[26];
//         boolean endOfWord = false;

//         Node() {
//             for (int i = 0; i < 26; i++) {
//                 children[i] = null;
//             }
//         }
//     }
//     public static Node root = new Node(); // empty

//     public static void Insert(String word){
//         int level=0;
//         int length=word.length();
//         int idx=0;

//         Node curr = root;
//         for(level=0;level<length;level++){
//             idx = word.charAt(level) - 'a';
//             if(curr.children[idx] == null){
//                 curr.children[idx] = new Node();
//             }
//             curr = curr.children[idx]; // updating current
//         }
//         curr.endOfWord = true; // mark the end of the word
//     }

//     public static boolean Search(String key) {
//         Node curr = root;
//         for (int level = 0; level < key.length(); level++) {
//             int idx = key.charAt(level) - 'a';
//             if (curr.children[idx] == null) {
//                 return false;
//             }
//             curr = curr.children[idx]; // updating current
//         }
//         return curr.endOfWord == true;
//     }

//     public static boolean startsWith(String prefix) {
//         Node curr = root;
//         for (int level = 0; level < prefix.length(); level++) {
//             int idx = prefix.charAt(level) - 'a';
//             if (curr.children[idx] == null) {
//                 return false;
//             }
//             curr = curr.children[idx]; // updating current
//         }
//         return true; // If we reach here, the prefix exists
//     }
//     public static void main(String[] args) {
//         String[] words = {"apple", "app", "banana", "bat"};
//         String prefix1 = "app";
//         String prefix2 = "moon";

//         for(int i = 0; i < words.length; i++) {
//             Insert(words[i]);
//         }
//         System.out.println(startsWith(prefix1));
//         System.out.println(startsWith(prefix2));
//     }
// }

