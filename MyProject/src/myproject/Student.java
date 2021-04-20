/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author almam
 */
public class Student implements User {

    int choise;
    String student_id;
    String student_pass;

    public Student(String student_id, String student_pass) {
        this.student_id = student_id;
        this.student_pass = student_pass;

    }

    @Override
    public void login() {
        try {
            Scanner reader = new Scanner(new File("student.txt"));
            PrintWriter writer = new PrintWriter(new File("myfile2.txt"));
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] tokens = line.split(" ");

                writer.println(tokens[0] + ", " + tokens[1] + ", " + tokens[2]);
                if (tokens[1].equals(student_id) && tokens[3].equals(student_pass)) {
                    welcomeStudent();
                } else {
                    System.out.println("");
                    System.out.println("");
                }
            }
            writer.close();
            reader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }

    private void welcomeStudent() {
        System.out.println("");
        System.out.println("\t\t\t\t\t\t\t\t\t     Login Successful");
        System.out.println("");
        System.out.println("\t\t\t\t\t\t\t\t      # Welcome to the Student Portal #");
        System.out.println("\t\t\t\t\t\t\t\t      =================================");
        System.out.println("");
        System.out.println("");

        System.out.println("\t\t\t\t\t\t\t\t          Choose any mention number...");
        System.out.println("");

        System.out.println("\t\t\t\t\t\t\t        +~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
        System.out.println("\t\t\t\t\t\t\t        |                                           |");
        System.out.println("\t\t\t\t\t\t\t        |       1.See Result                        |");
        System.out.println("\t\t\t\t\t\t\t        |                                           |");
        System.out.println("\t\t\t\t\t\t\t        |            2.Application for re-check     |");
        System.out.println("\t\t\t\t\t\t\t        |                                           |");
        System.out.println("\t\t\t\t\t\t\t        |                 3.Logout                  |");
        System.out.println("\t\t\t\t\t\t\t        |                                           |");
        System.out.println("\t\t\t\t\t\t\t        +~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");

        Scanner i = new Scanner(System.in);

        System.out.println("");
        System.out.println("\t\t\t\t\t\t\t\t              Enter Your Choise");
        System.out.println("");
        choise = i.nextInt();
        StudentOptions(choise);
    }

    private void StudentOptions(int choise) {
        switch (choise) {

            case 1:
                //result method 
                showResult();

                break;
            case 2:
                System.out.println("\t\t\t\t\t\t\t\t                 Application");
                System.out.println("\t\t\t\t\t\t\t\t      =================================");
                System.out.println("");
                //application method
                applicationCheck(student_id);
                break;
            case 3:
                System.out.println("\t\t\t\t\t\t      You Are Loged Out From The System.");
                return;

            default:
                System.out.println("");
                System.out.println("\t\t\t\t\t\t      Please input valid number.");
                System.out.println("");
        }
    }

    //........................................Show Result
    public void showResult() {
        try {
            System.out.println("\t\t\t\t\t\t\t\t                   Result");
            System.out.println("\t\t\t\t\t\t\t\t      =================================");
            System.out.println("");

            Scanner reader = new Scanner(new File("studentResult.txt"));
            PrintWriter writer = new PrintWriter(new File("myResultQueryfile.txt"));
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] tokens = line.split(" ");

                writer.println(tokens[0] + ", " + tokens[1] + ", " + tokens[2] + ", " + tokens[3] + ", " + tokens[4] + ", "
                        + tokens[5] + ", " + tokens[6] + ", " + tokens[7] + ", " + tokens[8] + ", " + tokens[9] + ", " + tokens[10] + ", " + tokens[11]
                        + ", " + tokens[12] + ", " + tokens[13] + ", " + tokens[14] + ", " + tokens[15] + ", " + tokens[16]);

                if (tokens[1].equals(student_id)) {
                    System.out.println(
                            "UserId                  :  " + tokens[1] + ", " + "\n"
                            + "Quiz1                   :  " + tokens[3] + ", " + "\n"
                            + "Quiz2                   :  " + tokens[5] + ", " + "\n"
                            + "Viva                    :  " + tokens[7] + ", " + "\n"
                            + "Assignment              :  " + tokens[9] + ", " + "\n"
                            + "Performance & Attendanc :  " + tokens[13] + ", " + "\n"
                            + "Total Marks             :  " + tokens[16] + ", " + "\n"
                    );
                } else {
                    System.out.println("");
//                    System.out.println("\t\t\t\t\t\t      Please input valid User_id and Password.");
                    System.out.println("");
                }
            }
            writer.close();
            reader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private void applicationCheck(String student_id) {
        String descriptions;
        Scanner i = new Scanner(System.in);
       
        System.out.println("");
        System.out.print("\t\t\t\t\t\t\t\t              Enter Your UserId: ");
        choise = i.nextInt();
        

        System.out.println("");
        System.out.println("\t\t\t\t\t\t\t\t              Enter Your applications : ");
        System.out.print("Application: ");
        descriptions = i.next();
        
        MyFile.createStudentApplicationFile();
        MyFile.writeStudentApplicationFile(student_id, descriptions);
        
        System.out.println("\t\t\t\t\t\t\t\t              Successfully Send Applications : ");
        
        
        
        
    }

}
