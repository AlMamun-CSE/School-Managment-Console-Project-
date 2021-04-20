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
import java.util.Scanner;

/**
 *
 * @author almam
 */
public class MyFile {
    public static void createStudentFile() {
        try {
            File myObj = new File("student.txt");
            if (myObj.createNewFile()) {
//                System.out.println("File created: " + myObj.getName());
            } else {
//                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeStudentFile(String Username,String UserId) {
        try {
            FileWriter myWriter = new FileWriter("student.txt",true);
            myWriter.write("UserId: "+UserId+" "+"UserName: "+Username+" \n");
            Admin.totalStudent+=1;
            myWriter.close();
//            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void readStudentFile() {
        try {
            File myObj = new File("student.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
//                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    //Get File Information
    public static void showAllStudentInformations() {
        File myObj = new File("student.txt");
        if (myObj.exists()) {
            System.out.println("File name: " + myObj.getName());
            System.out.println("Absolute path: " + myObj.getAbsolutePath());
            System.out.println("Writeable: " + myObj.canWrite());
            System.out.println("Readable " + myObj.canRead());
            System.out.println("File size in bytes " + myObj.length());
        } else {
            System.out.println("The file does not exist.");
        }
    }
    
    
    //Student Result Related.....................................
    public static void createStudentResultFile() {
        try {
            File myObj = new File("studentResult.txt");
            if (myObj.createNewFile()) {
//                System.out.println("File created: " + myObj.getName());
            } else {
//                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public static void writeStudentResultFile(String UserId,String Quiz1,String Quiz2,String Viva,String Assignment,String per_attend,String totalResult) {
        try {
            FileWriter myWriter = new FileWriter("studentResult.txt",true);
            myWriter.write("UserId: "+UserId+" "+"Quiz1: "+Quiz1+" "+"Quiz2: "+Quiz2+" "+"Viva: "+Viva+" "+"Assignment: "+
                    Assignment+" "+"Performance & Attendance: "+per_attend+" "+"Total Marks: "+totalResult+"\n");
            myWriter.close();
//            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    
     //Teacher  Related.....................................
    public static void createTeacherFile() {
        try {
            File myObj = new File("teacher.txt");
            if (myObj.createNewFile()) {
//                System.out.println("File created: " + myObj.getName());
            } else {
//                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public static void writeTeacherFile(String UserId,String UserName) {
        try {
            FileWriter myWriter = new FileWriter("teacher.txt",true);
            myWriter.write("UserId: "+UserId+" "+"UserName: "+UserName+" \n");
            Admin.totalTeacher+=1;
            myWriter.close();
//            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    
    
    //Student Application File Create,Write And Read
        public static void createStudentApplicationFile() {
        try {
            File myObj = new File("studentApplication.txt");
            if (myObj.createNewFile()) {
//                System.out.println("File created: " + myObj.getName());
            } else {
//                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeStudentApplicationFile(String UserId,String Description) {
        try {
            FileWriter myWriter = new FileWriter("studentApplication.txt",true);
            myWriter.write("UserId: "+UserId+" \n"+"Description: "+Description);
            myWriter.close();
//            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void readStudentApplicationFile() {
        try {
            File myObj = new File("studentApplication.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
