/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 *
 * @author almam
 */
public class HomePage {

    /**
     * @param args the command line arguments
     */
    static List<String> student_id_list = new ArrayList<String>();//creating new generic arraylist  
    static List<String> student_pass_list = new ArrayList<String>();//creating new generic arraylist  
    static List<String> teacher_id_list = new ArrayList<String>();//creating new generic arraylist  
    static List<String> teacher_pass_list = new ArrayList<String>();//creating new generic arraylist 

    public static void main(String[] args) {
        // TODO code application logic here

        mainMethod();

    }

    public static void mainMethod() {
        String user_id, password;
        int choise;
        boolean q = false;
        if (!q) {
            System.out.println("");
            System.out.println("\t\t\t\t\t\t\t          +----------------------------------------+");
            System.out.println("\t\t\t\t\t\t\t          |                                        |");
            System.out.println("\t\t\t\t\t\t\t          |  Welcomle to Result Processing System  |");
            System.out.println("\t\t\t\t\t\t\t          |                                        |");
            System.out.println("\t\t\t\t\t\t\t          +----------------------------------------+");
            System.out.println("");
            System.out.println("\t\t\t\t\t\t\t         Choose any number where you want to go....!");
            System.out.println("");
            System.out.println("\t\t\t\t\t\t\t          =============  \t     =============     \t     =============");
            System.out.println("\t\t\t\t\t\t\t             1. login    \t    2. Registrations   \t      0. Exit    ");
            System.out.println("\t\t\t\t\t\t\t          =============  \t     =============     \t     =============");
            System.out.println("");

            //by default 1 teacher add admin
            teacher_id_list.add("teacher");
            teacher_pass_list.add("teacher");

            Scanner sc = new Scanner(System.in);

            //System.out.println("\t\t\t\t\t\t\t         	      Enter Your Choise");
            choise = sc.nextInt();
            switch (choise) {
                case 1:
                    System.out.println("");
                    System.out.println("\t\t\t\t\t\t\t\t    .~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~.");
                    System.out.println("\t\t\t\t\t\t\t\t    |          1. Teacher              |");
                    System.out.println("\t\t\t\t\t\t\t\t    |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
                    System.out.println("\t\t\t\t\t\t\t\t    |          2. Student              |");
                    System.out.println("\t\t\t\t\t\t\t\t    |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
                    System.out.println("\t\t\t\t\t\t\t\t    |          3. Admin                |");
                    System.out.println("\t\t\t\t\t\t\t\t    '~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~'");
                    Scanner sc1 = new Scanner(System.in);

                    System.out.println("");
                    System.out.println("\t\t\t\t\t\t\t\t              Enter Your Choise");
                    choise = sc1.nextInt();

                    switch (choise) {
                        //Loging Teacher.............................
                        case 1:
                            System.out.println("\t\t\t\t\t\t\t\t        Enter your User_ID & User_Password");
                            System.out.println("\t\t\t\t\t\t\t\t      ---------------------------------");
                            System.out.println("");
                            System.out.println("");
                            System.out.print("\t\t\t\t\t\t  Enter Your UserId : ");
                            Scanner x = new Scanner(System.in);
                            user_id = x.nextLine();

                            System.out.print("\t\t\t\t\t\t  Enter Your UserPassword : ");
                            Scanner x1 = new Scanner(System.in);
                            password = x1.nextLine();

                            Teacher t1 = new Teacher(user_id, password);
                            t1.login();

                            break;
                            
                            //Loging Student...........................
                        case 2:
                            System.out.println("\t\t\t\t\t\t\t\t        Enter your User_ID & User_Password");
                            System.out.println("\t\t\t\t\t\t\t\t      ---------------------------------");
                            System.out.println("");
                            System.out.println("");
                            System.out.print("\t\t\t\t\t\t  Enter Your UserId : ");
                            Scanner s = new Scanner(System.in);
                            user_id = s.nextLine();

                            System.out.print("\t\t\t\t\t\t  Enter Your User_Password : ");
                            Scanner s2 = new Scanner(System.in);
                            password = s2.nextLine();

                            Student s1 = new Student(user_id, password);
                            s1.login();

                            break;

                            //Loging Admin........................
                        case 3:
                            System.out.println("\t\t\t\t\t\t\t\t        Enter your User_ID & password");
                            System.out.println("\t\t\t\t\t\t\t\t      ---------------------------------");
                            System.out.println("");
                            System.out.print("\t\t\t\t\t\t  Enter Your UserId : ");
                            Scanner ad = new Scanner(System.in);
                            user_id = ad.nextLine();

                            System.out.print("\t\t\t\t\t\t  Enter Your User_Password : ");
                            Scanner ad1 = new Scanner(System.in);
                            password = ad1.nextLine();

                            Admin a1 = new Admin(user_id, password);
                            a1.login();

                            break;

                    }
                    break;
                case 2:
                    //Registrations System.......................
                    registrations();

                    break;

                case 0:
                    q = true;
                    break;
                default:
                    System.out.println("");
                    System.out.println("\t\t\t\t\t\t      Please input valid number.");
                    System.out.println("");

            }
        } else {
            System.out.println("\t\t\t\t\t\t\t\t      Take Care. Stay Home, Stay Safe....");
        }
    }

    private static void registrations() {
        System.out.println("\t\t\t\t\t\t\t          +----------------------------------------+");
        System.out.println("\t\t\t\t\t\t\t          |                                        |");
        System.out.println("\t\t\t\t\t\t\t          |  Only Student for registration!  |");
        System.out.println("\t\t\t\t\t\t\t          |                                        |");
        System.out.println("\t\t\t\t\t\t\t          +----------------------------------------+");
        Scanner scanner = new Scanner(System.in);
        System.out.print("\t\t\t\t\t\t\t                    Enter your UserId        => ");
        String userName = scanner.nextLine();
        student_id_list.add(userName);

        System.out.print("\t\t\t\t\t\t\t                    Enter your User_Password => ");
        String userPassword = scanner.nextLine();
        student_pass_list.add(userPassword);

        //File Create and Write..........................
        MyFile.createStudentFile();
        MyFile.writeStudentFile(userPassword, userName);
        MyFile.readStudentFile();
       

        

        System.out.println(" ");
        System.out.println("\t\t\t\t\t\t\t          +----------------------------------------+");
        System.out.println("\t\t\t\t\t\t\t          |                                        |");
        System.out.println("\t\t\t\t\t\t\t          |  Thank you for your registration!  |");
        System.out.println("\t\t\t\t\t\t\t          |                                        |");
        System.out.println("\t\t\t\t\t\t\t          +----------------------------------------+");

        System.out.println("\t\t\t\t\t\t\t          +----------------------------------------+");
        System.out.println("\t\t\t\t\t\t\t          |                                        |");
        System.out.println("\t\t\t\t\t\t\t          |  Please, login continue  |");
        System.out.println("\t\t\t\t\t\t\t          |                                        |");
        System.out.println("\t\t\t\t\t\t\t          +----------------------------------------+");
        
        //caling main method................................
        mainMethod();
    }
    
}
