import java.util.*;

class StudentMarkManagementSystem{


public static void main(String [] args){
   

    Scanner input=new Scanner(System.in);
    boolean exit = false;

   

        PrintMenu();
        System.out.println("Enter an option to continue >");
        int choise = input.nextInt();

         switch (choise) {
            case 1:
                AddNewStudent(input);   
               break;
            case 2:
                AddStudentWithMarks(input);
                break;
            case 3:
                AddMarks(input);
                break;          
            case 4:
                UpdateStudentDetails(input);
                break;
            case 5:
                UpdateMarks(input);
                break;
            case 6:
                DeleteStudent(input);
                break;
            case 7:
                PrintStudentDetails(input);
                break;
            case 8:
                PrintStudentRanks(input);
                break;
            case 9:
                BestInProgrammingFundamentals(input);
                break;
            case 10:
                BestInDatabaseManagementSystem(input);
                break;
            
                default:
                System.out.println("Invalid option! Please select again.");
       }

  }
   // input.close();


public  static void PrintMenu(){

    System.out.println();
        System.out.println("============================================================================================================");
        System.out.println("|                               WELCOME TO GDSE MARKS MANAGEMENT SYSTEM                                    |");
        System.out.println("============================================================================================================");
        System.out.println("|  [1]. Add New Student                        [2]. Add New Student with Marks                             |");
        System.out.println("|  [3]. Add Marks                              [4]. Update Student Details                                 |");
        System.out.println("|  [5]. Update Marks                           [6]. Delete Student                                         |");
        System.out.println("|  [7]. Print Student Details                  [8]. Print Student Ranks                                    |");
        System.out.println("|  [9]. Best in Programming Fundamentals       [10]. Best in Database Management System                    |");
        System.out.println("============================================================================================================");
        System.out.println();
        
}
    public static void AddNewStudent(Scanner input) {
        System.out.println("a");
        
    }

    public static void AddStudentWithMarks(Scanner input) {
        System.out.println("1");
        
    }

    public static void AddMarks(Scanner input){
        System.out.println("2");

    }

    public static void UpdateStudentDetails(Scanner input){
        System.out.println("2");

    }

    public static void UpdateMarks(Scanner input){
        System.out.println('7');

    }

    public static void DeleteStudent(Scanner input){
        System.out.println("9");

    }

    public static void PrintStudentDetails(Scanner input){
        System.out.println("10");

    }

    public static void PrintStudentRanks(Scanner input){
        System.out.println("4");

    }

    public static void BestInProgrammingFundamentals(Scanner input){
        System.out.println("8");

    }

    public static void BestInDatabaseManagementSystem(Scanner input){
        System.out.println("5");
    }


    }




    


