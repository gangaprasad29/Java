// // #3  operators

public class operators {
    public static void main(String args[]){
        // binary operator  
        int A=10;
          int B=5;
          System.out.println("sum="+ (A+B));
          System.out.println("sub="+ (A-B));
          System.out.println("mult="+ (A*B));
          System.out.println("div="+ (A/B));
          System.out.println("mod="+ (A%B));

          // unary operator
          int a=10;
          System.out.println(a++); // post increment
          System.out.println(++a); // pre increment
          System.out.println(a--); // post decrement
          System.out.println(--a); // pre decrement

          // Relational operators
          System.out.println((A==B));
          System.out.println((A!=B));
          System.out.println((A>B));
          System.out.println((A<B));
          System.out.println((A<=B));
          System.out.println((A>=B));
    }
}

