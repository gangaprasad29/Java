//////// Operations in HashMap \\\\\\\\\\

// import java.util.*;
// public class Hashing {

//     public static void main(String[] args) {
//         // create
//         HashMap<String,Integer> hm = new HashMap<>();
        
//         //Insert O(1)     HashMaps are the Unorderd maps
//         hm.put("India", 150);
//         hm.put("Us", 150);
//         hm.put("china", 100);

//         System.out.println(hm);

//         // Get O(1)
//         int populatoin = hm.get("India");
//         System.out.println(populatoin);

//         System.out.println(hm.get("Pakistan")); // if not exist then return null

//         //ContainsKey O(1)
//         System.out.println(hm.containsKey("India"));
//         System.out.println(hm.containsKey("Pakistan"));
        
//         // remove  O(1)
//         System.out.println(hm.remove("china"));
//         System.out.println(hm);

//         // size
//         System.out.println(hm.size());

//         //IsEmpty
//         System.out.println(hm.isEmpty());
//         hm.clear();
//         System.out.println(hm.isEmpty());

//     }
// }



// import java.util.*;
// public class Hashing {
//     public static void main(String[] args) {
//         HashMap<String, Integer> hm = new HashMap<>();
//         hm.put("India", 150);
//         hm.put("Pakistan", 0);
//         hm.put("Us", 150);
//         hm.put("china", 100);
//         hm.put("Nepal", 100);

//         // Iterate 1: keySet()
//         Set<String> keys = hm.keySet();
//         System.out.println(keys);

//         for (String k : keys) {
//             System.out.println("key = " + k + " , value = " + hm.get(k));
//         }

//         //// // Iterate 2: entrySet()
        
//         // Set<Map.Entry<String, Integer>> entries = hm.entrySet();
//         // System.out.println("Iteration from entrySet:");
//         // for (Map.Entry<String, Integer> e : entries) {
//         //     System.out.println("key = " + e.getKey() + " , value = " + e.getValue());
//         // }
//     }
// }


// /////////// Iimplementation Hashmap \\ \\\\\\\\\\\\\\  (bi->bucket Idx, di->data Idx)

// import java.util.*;
// import java.util.LinkedList;
// import java.util.ArrayList; 

// public class Hashing {
//     static class HashMap<K, V> {
//         private class Node {
//             K key;
//             V value;

//             public Node(K key, V value) {
//                 this.key = key;
//                 this.value = value;
//             }
//         }

//         private int size; // Number of key-value pairs (n)
//         private LinkedList<Node>[] buckets; // Array of buckets (N)

//         @SuppressWarnings("unchecked")
//         public HashMap() {
//             this.size = 0;
//             this.buckets = new LinkedList[4];
//             for (int i = 0; i < 4; i++) {
//                 this.buckets[i] = new LinkedList<>();
//             }
//         }

//         private int hashFunction(K key) {
//             int hashCode = key.hashCode();
//             return Math.abs(hashCode) % buckets.length;
//         }

//         private int searchInLL(K key, int bi) {
//             LinkedList<Node> ll = buckets[bi];
//             for (int i = 0; i < ll.size(); i++) {
//                 if (ll.get(i).key.equals(key)) {
//                     return i;
//                 }
//             }
//             return -1;
//         }

//         private void rehash() {
//             LinkedList<Node>[] oldBuckets = buckets;
//             buckets = new LinkedList[oldBuckets.length * 2];
//             for (int i = 0; i < buckets.length; i++) {
//                 buckets[i] = new LinkedList<>();
//             }
//             size = 0;

//             for (LinkedList<Node> ll : oldBuckets) {
//                 for (Node node : ll) {
//                     put(node.key, node.value);
//                 }
//             }
//         }

//         public void put(K key, V value) {
//             int bi = hashFunction(key); // bucket index
//             int di = searchInLL(key, bi); // data index

//             if (di != -1) {
//                 Node node = buckets[bi].get(di);
//                 node.value = value;
//             } else {
//                 buckets[bi].add(new Node(key, value));
//                 size++;
//             }

//             double lambda = (double) size / buckets.length;
//             if (lambda > 2.0) {
//                 rehash();
//             }
//         }

//         public boolean containsKey(K key) {
//             int bi = hashFunction(key);
//             int di = searchInLL(key, bi);
//             return di != -1;
//         }

//         public V get(K key) {
//             int bi = hashFunction(key);
//             int di = searchInLL(key, bi);
//             if (di != -1) {
//                 Node node = buckets[bi].get(di);
//                 return node.value;
//             }
//             return null;
//         }

//         public V remove(K key) {
//             int bi = hashFunction(key);
//             int di = searchInLL(key, bi);
//             if (di != -1) {
//                 Node node = buckets[bi].remove(di);
//                 size--;
//                 return node.value;
//             }
//             return null;
//         }

//         public ArrayList<K> keySet() {
//             ArrayList<K> keys = new ArrayList<>();
//             for (LinkedList<Node> bucket : buckets) {
//                 for (Node node : bucket) {
//                     keys.add(node.key);
//                 }
//             }
//             return keys;
//         }

//         public boolean isEmpty() {
//             return size == 0;
//         }

//         public int size() {
//             return size;
//         }
//     }

//     public static void main(String[] args) {
//         HashMap<String, Integer> map = new HashMap<>();
//         map.put("India", 100);
//         map.put("China", 150);
//         map.put("USA", 50);
//         map.put("Nepal", 30);
//         map.put("Bhutan", 20);

//         System.out.println("India: " + map.get("India"));
//         System.out.println("USA: " + map.get("USA"));

//         System.out.println("Contains China? " + map.containsKey("China"));
//         map.remove("China");
//         System.out.println("Contains China after removal? " + map.containsKey("China"));

//         System.out.println("All keys: " + map.keySet());
//         System.out.println("Size: " + map.size());

//         System.out.println("Is empty? " + map.isEmpty());
//     }
// }








// // ////// LinkedHashMap \\ \\\\\


// import java.util.*;
// public class Hashing {
//     public static void main(String[] args) {
//         LinkedHashMap<String,Integer> lhm = new LinkedHashMap<>();
//         lhm.put("India",150);
//         lhm.put("chaina",100);
//         lhm.put("Pakistan",10);

//         HashMap<String,Integer> hm = new HashMap<>();
//         hm.put("India",150);
//         hm.put("chaina",100);
//         hm.put("Pakistan",10);
        
//         // "LinkedHashMap(orderd as per key insert"
//         System.out.println(lhm);

//         System.out.println(hm); 
//     }
// }



// ////// TreeMap \\ \\\\\


import java.util.*;
public class Hashing {
    public static void main(String[] args) {
        TreeMap<String,Integer> tm = new TreeMap<>();
        tm.put("India",150);
        tm.put("Chaina",100);
        tm.put("Pakistan",10);

        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("India",150);
        hm.put("Chaina",100);
        hm.put("Pakistan",10);
        
        System.out.println(tm);  // key are sorted (alphabet ka order )

        System.out.println(hm); 
    }
}