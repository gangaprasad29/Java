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

import java.util.*;
public class Hashing2 {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(1); // duplicate
        hs.add(2);
        hs.add(3);
        hs.add(4);
        hs.add(3); // duplicate

        System.out.println("HashSet: " + hs); // Output will be unique values only
        System.out.println(hs.size()); 
        System.out.println(hs.isEmpty()); 

        if (hs.contains(2)) {
            System.out.println("2 is present in the set.");
        } else {
            System.out.println("2 is not present.");
        }
    }
}
