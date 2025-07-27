// public class OOPs {
//     public static void main(String[] args) {
//         Pen pen=new Pen(); // created a pen object
//         pen.setColor("blue");
//         System.out.println(pen.color);

//         BankAccount myAcc=new BankAccount();
//         myAcc.username="ganga";
//         // myAcc.password="aldfjlf";   // not accessable because of protected

//         myAcc.setPassword("adfjl");
//     }
// }

// class Pen{
//     String color;
//     int tip;

//     void setColor(String newColor){ //function
//         color=newColor;
//     }
//     void setTip(int newTip){
//         tip=newTip;
//     }
// }

// class Student{
//     String name;
//     int age;
//     float percentage;

//     void calcPercentage(int phy,int chem,int math){
//         percentage=(phy+chem+math)/3;
//     }
// }
// // Access Modifiers
// class BankAccount{
//     public String username; 
//     private String password;

//     public void setPassword(String pwd){
//         password=pwd;
//     }
// }







// // /////    GETTERS AND SETTERS \\\\\\\\\\\\



// class Pen {
//     String color;
//     int tip;

//     // Getter method for color
//     String getColor() {
//         return this.color;
//     }

//     // Setter method for color
//     void setColor(String newColor) {
//         color = newColor;
//     }

//     // Setter method for tip
//     void setTip(int newTip) {
//         tip = newTip;
//     }
// }

// public class OOPs {
//     public static void main(String[] args) {
//         // Create a Pen object
//         Pen myPen = new Pen();
        
//         // Set properties using setter methods
//         myPen.setColor("Blue");
//         myPen.setTip(10);
        
//         // Get and print properties using getter method
//         System.out.println("Pen color: " + myPen.getColor());
//         System.out.println("Pen tip: " + myPen.tip);
//     }
// }



// //  /////// CONSTRUCTIOR \\\\\\\\\\


// class Student {
//     String name;
//     int roll;

//     // Default constructor 
//     Student() {
//         this.name = "Unknown";
//         this.roll = 0;
//     }
// }

// public class OOPs {
//     public static void main(String[] args) {
//         // Creating an object using the default constructor
//         Student s1 = new Student();
//         System.out.println("Student 1 - Name: " + s1.name + ", Roll: " + s1.roll);
//     }
// }




// class Student {
//     String name;
//     int roll;

//     // Parameterized constructor
//     Student(String name) {
//         this.name = name;
//     }
// }

// public class OOPs {
//     public static void main(String[] args) {
//         // Creating an object using the parameterized constructor
//         Student s1 = new Student("Ganga");
//         System.out.println("Student 1 - Name: " + s1.name + ", Roll: " + s1.roll);
//     }
// }







// class Student {
//     String name;

//     // Regular constructor
//     public Student(String name) {
//         this.name = name;
//     }

//     // Copy constructor
//     public Student(Student other) {
//         this.name = other.name;
//     }
// }

// public class OOPs {
//     public static void main(String[] args) {
//         // Creating an object using the regular constructor
//         Student s1 = new Student("Ganga");

//         // Creating another object using the copy constructor
//         Student s2 = new Student(s1);  // Copy constructor is called

//         // Displaying the name of the copied student
//         System.out.println("Student 2 (Copy) - Name: " + s2.name);
//     }
// }

