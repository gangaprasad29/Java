// STRING BUILDER

// public class Strings2 {
//     public static void main(String[] args) {
//         StringBuilder sb= new StringBuilder("");
//         for(char ch='a';ch<'z';ch++){
//             sb.append(ch);
//         }
//         System.out.println(sb);
//         System.out.print(sb.length());
//     }
// }



// // Q} for a given string convert each the first letter of each word to uppercase,

// public class Strings2 {
//     public static String toUppercase(String str) {
//         StringBuilder sb = new StringBuilder();
//         char ch = Character.toUpperCase(str.charAt(0));
//         sb.append(ch);

//         for (int i = 1; i < str.length(); i++) {
//             if (str.charAt(i) == ' ' && i < str.length() - 1) {
//                 sb.append(str.charAt(i)); // Append space
//                 i++; // Move to the next character
//                 sb.append(Character.toUpperCase(str.charAt(i))); // Convert to uppercase
//             } else {
//                 sb.append(str.charAt(i));
//             }
//         }
//         return sb.toString(); // Return the modified string
//     }

//     public static void main(String[] args) {
//         String str = "hi, i am ganga";
//         String ans = toUppercase(str);
//         System.out.println(ans);
//     }
// }




// // Q} String compression

public class Strings2 {
    public static String compress(String str) {
        StringBuilder newStr = new StringBuilder("");

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int count = 1;

            while (i + 1 < str.length() && str.charAt(i + 1) == str.charAt(i)) {
                count++;
                i++; // Move to the next character
            }

            newStr.append(ch); // Append character
            if (count > 1) {
                newStr.append(count); // Append count if greater than 1
            }
        }
        return newStr.toString(); // Return the compressed string
    }

    public static void main(String[] args) {
        String str = "aaabbcccdd";
        String ans = compress(str);
        System.out.println(ans); // Output: a3b2c3d2
    }
}
