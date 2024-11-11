import java.util.*;

class StudentMarkManagementSystem{

    // Define arrays to store data
    static String[] studentIDs = new String[100];
    static String[] studentNames = new String[100];
    static int[] progMarks = new int[100];  // Automatically initialized to 0
    static int[] dbmsMarks = new int[100];  // Automatically initialized to 0
    static int studentCount = 0;


public static void main(String [] args){
   

    Scanner input=new Scanner(System.in);
    boolean exit = false;

   
    while (!exit) {
        PrintMenu();
        System.out.print("Enter an option to continue >");
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
            case 11:
            exit = true;
                    System.out.println("Exiting...");
                    break;
            
                default:
                System.out.println("Invalid option! Please select again.");
       }
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
        System.out.println("|  [9]. Best in Programming Fundamentals       [10]. Best in Database Management System          __________|");
        System.out.println("|                                                                                               | 11. Exit |");
        System.out.println("============================================================================================================");
        System.out.println();
        
}
    public static void AddNewStudent(Scanner input) {
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                            ADD NEW STUDENT                                               |");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println(" ");
        System.out.print("Enter Student ID: ");
        String id=input.next();
        if (studentExists(id)) {
            System.out.println("Student ID already exists!");
            return;
        }

        System.out.print("enter student name :");
        String name=input.next();
        studentIDs[studentCount]=id;
        studentNames[studentCount]=name;
        studentCount++;
        System.out.println(" ");
        System.out.println("  Student added successfully ...!    ");
    }
    

    public static void AddStudentWithMarks(Scanner input) {
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                         ADD STUDENT WITH MARKS                                           |");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println(" ");
        System.out.print("Enter Student ID: ");
        String id = input.next();
        if (studentExists(id)) {
            System.out.println("Student ID already exists!");
            return;
        }
    
        System.out.print("Enter student name: ");
        String name = input.next();
        studentIDs[studentCount] = id;
        studentNames[studentCount] = name;
        
    
        addMarksForStudent(input, studentCount);
        studentCount++;
    
       
    }
    public static void AddMarks(Scanner input){
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                                ADD MARKS                                                 |");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println(" ");
        System.out.print("Enter Student ID: ");
        String id = input.next();
        int index = findStudent(id);
        if (index == -1) {
            System.out.println("Student ID not found!");
        } else {
            addMarksForStudent(input, index);
        }
    }

    public static void addMarksForStudent(Scanner input, int index) {
        System.out.print("Enter Programming Fundamentals marks (0-100): ");
        progMarks[index] = validateMarks(input);
        System.out.print("Enter DBMS marks (0-100): ");
        dbmsMarks[index] = validateMarks(input);
        System.out.println(" ");
        System.out.println("Marks added successfully!");
    }

    public static void UpdateStudentDetails(Scanner input){
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                        UPDATE STUDENT DETAILS                                            |");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println(" ");
        System.out.print("Enter Student ID: ");
        String id = input.next();
        int index = findStudent(id);
        if (index == -1) {
            System.out.println("Student ID not found!");
        } else {
            System.out.print("Enter new Student Name: ");
            studentNames[index] = input.next();
            System.out.println(" ");
            System.out.println("Student details updated successfully!");
        }
    }

    public static void UpdateMarks(Scanner input){
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                            UPDATE MARKS                                                  |");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println(" ");
        System.out.print("Enter Student ID: ");
        String id =input.next();
        int index = findStudent(id);
        if (index == -1) {
            System.out.println(" ");
            System.out.println("Student ID not found!");
        } else {
            addMarksForStudent(input, index);
        }
    }

    public static void DeleteStudent(Scanner input){
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                            DELETE STUDENT                                                |");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println(" ");
        System.out.print("Enter Student ID: ");
        String id = input.next();
        int index = findStudent(id);
        if (index == -1) {
            System.out.println(" ");
            System.out.println("Student ID not found!");
        } else {
            // Shift all subsequent elements to the left
            for (int i = index; i < studentCount - 1; i++) {
                studentIDs[i] = studentIDs[i + 1];
                studentNames[i] = studentNames[i + 1];
                progMarks[i] = progMarks[i + 1];
                dbmsMarks[i] = dbmsMarks[i + 1];
            }
            studentCount--;
            System.out.println("Student deleted successfully!");
        }
    }


    public static void PrintStudentDetails(Scanner input){
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                            PRINT STUDENT DETAILS                                         |");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println(" ");
        System.out.print("Enter Student ID: ");
        String id = input.next();
        int index = findStudent(id);
        if (index == -1) {
            System.out.println(" ");
            System.out.println("Student ID not found!");
        } else {
            System.out.println("Student ID: " + studentIDs[index]);
            System.out.println("Student Name: " + studentNames[index]);
            System.out.println("Programming Fundamentals: " + progMarks[index]);
            System.out.println("DBMS: " + dbmsMarks[index]);
            int total = progMarks[index] + dbmsMarks[index];
            System.out.println("Total Marks: " + total);
            System.out.println("Average Marks: " + total / 2);
        }
    }


    public static void PrintStudentRanks(Scanner input){
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                            PRINT STUDENT RANKS                                           |");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println(" ");
        int[] totalMarks = new int[studentCount];
        for (int i = 0; i < studentCount; i++) {
            totalMarks[i] = progMarks[i] + dbmsMarks[i];
        }
        for (int i = 0; i < studentCount - 1; i++) {
            for (int j = i + 1; j < studentCount; j++) {
                if (totalMarks[i] < totalMarks[j]) {
                    int temp = totalMarks[i];
                    totalMarks[i] = totalMarks[j];
                    totalMarks[j] = temp;
                    swapStudents(i, j);
                }
            }
        }
        System.out.println("\n--- Student Ranks ---");
        for (int i = 0; i < studentCount; i++) {
            System.out.println((i + 1) + ". " + studentNames[i] + " (Total: " + totalMarks[i] + ")");
        }
    }

    public static void BestInProgrammingFundamentals(Scanner input){
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                  BEST IN PROGRAMMING FUNDAMENTALS                                        |");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println(" ");
        if (studentCount == 0) {
            System.out.println(" ");
            System.out.println("No students available.");
            return;
        }

        int maxProgMarks = -1;
        int bestStudentIndex = -1;

        for (int i = 0; i < studentCount; i++) {
            if (progMarks[i] > maxProgMarks) {
                maxProgMarks = progMarks[i];
                bestStudentIndex = i;
            }
        }

        if (bestStudentIndex != -1) {
            System.out.println("Best in Programming Fundamentals: " + studentNames[bestStudentIndex] 
                                + " (Marks: " + progMarks[bestStudentIndex] + ")");
        }
    }


    public static void BestInDatabaseManagementSystem(Scanner input){
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                   BEST IN DATABASE MANAGEMENT                                            |");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println(" ");
        if (studentCount == 0) {
            System.out.println(" ");
            System.out.println("No students available.");
            return;
        }

        int maxDBMSMarks = -1;
        int bestStudentIndex = -1;

        for (int i = 0; i < studentCount; i++) {
            if (dbmsMarks[i] > maxDBMSMarks) {
                maxDBMSMarks = dbmsMarks[i];
                bestStudentIndex = i;
            }
        }

        if (bestStudentIndex != -1) {
            System.out.println("Best in DBMS: " + studentNames[bestStudentIndex] 
                                + " (Marks: " + dbmsMarks[bestStudentIndex] + ")");
        }
    }


    public static int findStudent(String id) {
        for (int i = 0; i < studentCount; i++) {
            if (studentIDs[i].equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean studentExists(String id) {
        return findStudent(id) != -1;
    }


    public static int validateMarks(Scanner input) {
        int marks;
        do {
            marks = input.nextInt();
            if (marks < 0 || marks > 100) {
                System.out.println(" ");
                System.out.println("Invalid input! Marks should be between 0 and 100.");
            }
        } while (marks < 0 || marks > 100);
        return marks;
    }

    public static void swapStudents(int i, int j) {
        String tempID = studentIDs[i];
        String tempName = studentNames[i];
        int tempProg = progMarks[i];
        int tempDbms = dbmsMarks[i];

        studentIDs[i] = studentIDs[j];
        studentNames[i] = studentNames[j];
        progMarks[i] = progMarks[j];
        dbmsMarks[i] = dbmsMarks[j];

        studentIDs[j] = tempID;
        studentNames[j] = tempName;
        progMarks[j] = tempProg;
        dbmsMarks[j] = tempDbms;
    }
}

    
    




    


