///// Q} Majority Element \\\\\\

// import java.util.*;
// public class Hashing2 {
//     public static void main(String[] args) {
//         int nums[]={1,3,2,5,1,3,1,5,1};
//         int n=nums.length;
//         HashMap<Integer,Integer> map = new HashMap<>();

//         for(int i=0;i<n;i++){
//             if(map.containsKey(nums[i])){
//                 map.put(nums[i],map.get(nums[i]) + 1);
//             }else{
//                 map.put(nums[i],1);
//             }
//         }
        
//         Set<Integer> keySet = map.keySet();
//         for(Integer key : keySet){
//             if(map.get(key)>n/3){
//                 System.out.println(key);
//             }
//         }
//     }
// }



// //////// Valid Anagram \\\\\\\\\\\\


// import java.util.*;
// public class Hashing2 {
//     public static boolean isAnagram(String s,String t){
//          HashMap<Character,Integer> map=new HashMap<>();

//          for(int i=0;i<s.length();i++){
//             char ch=s.charAt(i);
//             map.put(ch,map.getOrDefault(ch, 0)+1);
//          }

//          for(int i=0;i<t.length();i++){
//             char ch=t.charAt(i);
//             if(map.get(ch)!=null){
//                 if(map.get(ch) == 1){  // if freqency is 1
//                     map.remove(ch);
//                 }else{
//                     map.put(ch,map.get(ch)-1);  // reduct freq by one
//                 }
//             }else {
//                 return false;
//             }
//          }
//          return map.isEmpty();
//     }
//     public static void main(String[] args) {
//         String s="knee";
//         String t="keen";

//         System.out.println(isAnagram(s, t));
//     }
// }


//////////// HashSet \\\\\\\\\\\\\

// import java.util.*;
// public class Hashing2 {
//     public static void main(String[] args) {
//         HashSet<Integer> hs = new HashSet<>();
//         hs.add(1);
//         hs.add(1); // duplicate
//         hs.add(2);
//         hs.add(3);
//         hs.add(4);
//         hs.add(3); // duplicate

//         System.out.println("HashSet: " + hs); // Output will be unique values only
//         System.out.println(hs.size()); 
//         System.out.println(hs.isEmpty()); 

//         if (hs.contains(2)) {
//             System.out.println("2 is present in the set.");
//         } else {
//             System.out.println("2 is not present.");
//         }
//     }
// }

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

///////// Iteration on HashSet \\\\\\

// import java.util.*;
// public class Hashing2 {
//     public static void main(String[] args) {
//         HashSet<String> cities = new HashSet<>();
//         cities.add("Mumbai");
//         cities.add("Nanded"); 
//         cities.add("Delhi");
//         cities.add("Pune");

//         ///////// (Using iteratiors) \\\\\\

//         // Iterator it = cities.iterator();
//         // while (it.hasNext()) {
//         //     System.out.println(it.next());
//         // }

//         ///////// using (Advance Loops) \\\\\\
//         for(String city : cities){
//             System.out.println(city);
//         }
//     }
// }



// ///// LinkedHashSet \\ \\\\\\

// public class Hashing2 {
//     public static void main(String[] args) {
//         HashSet<String> cities=new HashSet<>();
//         cities.add("Delhi");
//         cities.add("Mumbai");
//         cities.add("Noida");
//         cities.add("Bengaluru");
//         System.out.println(cities); // random order

//         LinkedHashSet<String> lhs=new LinkedHashSet<>();
//         lhs.add("Delhi");
//         lhs.add("Mumbai");
//         lhs.add("Noida");
//         lhs.add("Bengaluru");
//         System.out.println(lhs); //orderd o/p as i/p

//         TreeSet<String> ts=new TreeSet<>();
//         ts.add("Delhi");
//         ts.add("Mumbai");
//         ts.add("Noida");
//         ts.add("Bengaluru"); 
//         System.out.println(ts); // sorted o/p

//     }
// }




// ////// Q} Count Distinct \\ \\\\\

// public class Hashing2 {

//     public static void main(String[] args) {
//         int nums[]={4,3,2,5,6,7,3,4,2,1};
//         HashSet<Integer> set =new HashSet<>();
//         for(int i=0;i<nums.length;i++){
//             set.add(nums[i]);
//         }
//         System.out.println("size of unique is : "+set.size());
//     }
// }


// /// Union and Intersection of 2 arrays \\ \\\\\\\



// import java.util.HashSet;
// public class Hashing2 {
//     public static void main(String[] args) {
//         int arr1[]={7,3,9};
//         int arr2[]={6,3,9,2,9,4};

//         HashSet<Integer> set = new HashSet<>();

//         /// Union
//         for(int i=0;i<arr1.length;i++){
//             set.add(arr1[i]);
//         }
//         for(int i=0;i<arr2.length;i++){
//             set.add(arr2[i]);
//         }
//         System.out.println("union is: "+set);

//         /// Intersection
//         set.clear();

//         for(int i=0;i<arr1.length;i++){
//             set.add(arr1[i]);
//         }
//         int count=0;
//         HashSet<Integer> intersectionSet = new HashSet<>();
//         for(int i=0;i<arr2.length;i++){
//             if(set.contains(arr2[i])){
//                 count++;
//                 intersectionSet.add(arr2[i]);
//                 set.remove(arr2[i]);
//             }
//         }
//         System.out.println("size of Intersection is: "+count);
//         System.out.println("Intersection is: "+intersectionSet);
//     }
// }




//////// Q} find Itinerary from Tickets \\\\\\\\\\\\

import java.util.*;
public class Hashing2 {
    public static String getStarg(HashMap<String, String> tickets) {
        HashMap<String, String> revMap = new HashMap<>();

        for(String key : tickets.keySet()){
            revMap.put(tickets.get(key), key);
        }

        for(String key : tickets.keySet()){
            if(!revMap.containsKey(key)){
                return key;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Channai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Channai");
        tickets.put("Delhi", "Goa");

        String start = getStarg(tickets);
        while(tickets.containsKey(start)){
            System.out.print(start + " -> ");
            start = tickets.get(start);
        }
        System.out.println(start);
    }
}
