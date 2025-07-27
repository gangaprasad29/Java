// // Q} valid parenthesis

// import java.util.Stack;
// public class Stack2 {
//     public static boolean isValid(String str) {
//         Stack<Character> s = new Stack<>();

//         for (int i = 0; i < str.length(); i++) {
//             char ch = str.charAt(i);  // a bracket is stored in this ch
//             // opening
//             if (ch == '(' || ch == '{' || ch == '[') {
//                 s.push(ch);
//             } else {
//                 // closing
//                 if (s.isEmpty()) {
//                     return false;
//                 }
//                 // pair chacking
//                 if ((s.peek() == '(' && ch == ')') ||     //()
//                     (s.peek() == '{' && ch == '}') ||    //{}
//                     (s.peek() == '[' && ch == ']')) {    //[]
//                     s.pop();
//                 } else {
//                     return false;
//                 }
//             }
//         }
//         //  in last if the stack is empty then valid otherwise not a valid parenthesis
//         if(s.isEmpty()){
//             return true;
//         }else{
//             return false;
//         }
//     }

//     public static void main(String args[]) {
//         String str = "({})[]";   // true
//         System.out.println(isValid(str));
//     }
// }



// // Q} find Duplicate Parentheses


// import java.util.Stack;
// public class Stack2 {
//     public static boolean isDuplicate(String str){
//         Stack<Character> s= new Stack<>();
//         for(int i=0;i<str.length();i++){
//             char ch=str.charAt(i);
//             // closeing
//             if(ch==')'){
//                 int count=0;
//                 while(s.peek() != '(' ){
//                     s.pop();
//                     count++;
//                 }
//                 if(count < 1){
//                     return true; // duplicatee
//                 }else{
//                     s.pop(); //opening pair
//                 }
//             }else{
//  // opening,operators,operands
//                 s.push(ch);
//             }
//         }
//         return false; // duplicate not exist
//     }
//     public static void main(String[] args) {
//         String str="((a+b))"; //true
//         String str2="(a-b)"; //false
//         System.out.println(isDuplicate(str));
//         System.out.println(isDuplicate(str2));
//     }
// }



// // Q}  Maximum Area in Histogram



import java.util.Stack;
public class Stack2 {
    public static void maxArea(int arr[]){
        int maxArea=0;
        int nsR[]= new int[arr.length];
        int nsL[]= new int[arr.length];

        // next smaller right
        Stack<Integer> s= new Stack<>();

        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsR[i]=arr.length; // =n
            }else{
                nsR[i]=s.peek();
            }
            s.push(i);
        }
        // next smaller left
        s= new Stack<>();

        for(int i=0;i<arr.length;i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsL[i]= -1; // -1
            }else{
                nsL[i]=s.peek();
            }
            s.push(i);
        }
        // current area = height*width
        for(int i=0;i<arr.length;i++){
            int height=arr[i];
            int width=nsR[i]-nsL[i]-1;
            int currArea=height*width;
            maxArea=Math.max(maxArea, currArea);
        }
        System.out.println("max area in histogram is:"+maxArea);

    }
    public static void main(String[] args) {
        int arr[]={2,1,5,6,2,3}; // height in histogram
        maxArea(arr);
    }
}