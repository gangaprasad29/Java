/////// Q} remove duplicates in string

// public class Recursion2 {
//     pubic static void removeDuplicate(String str,idx,StringBuilder newStr,boolean map[]){
//         if(idx==str.length()){
//             System.out.println(newStr);
//             return ;
//         }
//         //work
//         char currChar=str.charAt(idx);
//         if(map[currChar-'a']==true){
//             //duplicate
//             removeDuplicate(str,idx+1,newStr,map);
//         }else{
//             map[currChar-'a']=true;
//             removeDuplicate(str,idx+1,newStr.append(currChar),map);
//         }
//     }
//     public static void main(String[] args) {
//         String str="appnnacollege";
//         removeDuplicate(str,0,new StringBuilder(""),new boolean[26]);
//     }
// }



////// Q} Friends Pairing Problem
 /*
  given n friends, each one can remain single or can be paired up with some other
  friend.Each friend can be paired only once. find out the total number of ways in
  which friends can remain single or can be paired up.
  */

//   public class Recursion2 {
   
//     public static int FriendPair(int n){
//         //base case
//         if(n==1 || n==2){
//             return n;
//         }

//         //choice
//         //single
//         int fnm1 = FriendPair(n-1);

//         //pair
//         int fnm2= FriendPair(n-2);
//         int pairWays=(n-1)*fnm2;

//         //totways
//         int totalWays=fnm1+pairWays;
//         return totalWays;



//         ////// below base case we can use single line
//         // return FriendPair(n-1)+(n-1)*FriendPair(n-2);
//     }
//     public static void main(String[] args) {
//         System.out.println(FriendPair(3));
//     } 
//   }



////// print all binary strings of size N without consecutive ones


public class Recursion {

    public static void printBinary(int n,int lastPlace,String str){
        //base case
        if(n==0){
            System.out.println(str);
            return ;
        }
        //work

        // if(lastPlace==0){
        //     // sit 0 on chair n
        //     printBinary(n-1, 0, str.append("0"));
        //     printBinary(n-1, 1, str.append("1"));
        // }else{
        //     printBinary(n-1, 0, str.append("0"));
        // }
        
        //OR
        
        printBinary(n-1, 0, str+"0");
        if(lastPlace==0){
            printBinary(n-1, 1, str+"1");
        }


    } 
    public static void main(String[] args) {
        printBinary(3, 0, "");
    }
}

