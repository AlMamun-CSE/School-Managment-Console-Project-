/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 *
 * @author almam
 */
public class Teacher implements User {

    int choise;
    String quiz1, quiz2, viva, assignment, performance_attendance, result;
    String studentUserId;

    String teacher_id;
    String teacher_pass;

    public Teacher(String teacher_id, String teacher_pass) {
        this.teacher_id = teacher_id;
        this.teacher_pass = teacher_pass;
    }

    @Override
    public void login() {
        if (HomePage.teacher_id_list.contains(teacher_id) && HomePage.teacher_pass_list.contains(teacher_pass)) {

            welcomeTeacher();

            //TeacherOptions();
        } else {
            System.out.println("");
            System.out.println("\t\t\t\t\t\t      Please input valid User_id and Password.");
            System.out.println("");
        }
    }

    private void welcomeTeacher() {
        System.out.println("");
        System.out.println("\t\t\t\t\t\t\t\t\t     Login Successful");
        System.out.println("");
        //System.out.println("\t\t\t\t\t\t\t\t *****************************");
        System.out.println("\t\t\t\t\t\t\t\t      # Welcome to the Teacher Portal #");
        System.out.println("\t\t\t\t\t\t\t\t      =================================");
        System.out.println("");
        System.out.println("");

        System.out.println("\t\t\t\t\t\t\t\t          Choose any mention number...");
        System.out.println("");
        System.out.println("\t\t\t\t\t\t\t        +-------------------------------------------+");
        System.out.println("\t\t\t\t\t\t\t        |                                           |");
        System.out.println("\t\t\t\t\t\t\t        |       1.Teacher Details                   |");
        System.out.println("\t\t\t\t\t\t\t        |                                           |");
        System.out.println("\t\t\t\t\t\t\t        |            2.Update/Modify result         |");
        System.out.println("\t\t\t\t\t\t\t        |                                           |");
        System.out.println("\t\t\t\t\t\t\t        |                3.Logout                   |");
        System.out.println("\t\t\t\t\t\t\t        |                                           |");
        System.out.println("\t\t\t\t\t\t\t        +-------------------------------------------+");
        Scanner sc2 = new Scanner(System.in);
        System.out.println("");
        System.out.println("\t\t\t\t\t\t\t\t              Enter Your Choise");
        choise = sc2.nextInt();
        TeacherOptions(choise);
    }

    private void TeacherOptions(int choise) {
        switch (choise) {
            case 1:
                //Add teacher details method
                Admin a1 = new Admin();
                a1.showTeacInfo();
                welcomeTeacher();
                break;

            case 2:
                System.out.println("\t\t\t\t\t\t\t\t          Press the mention number...");
                System.out.println("");
                System.out.println("\t\t\t\t\t\t\t\t       +---------------------------------+");
                System.out.println("\t\t\t\t\t\t\t\t       |                                 |");
                System.out.println("\t\t\t\t\t\t\t\t       |         1. See Course           |");
                System.out.println("\t\t\t\t\t\t\t\t       |         2. Set Student Result   |");
                System.out.println("\t\t\t\t\t\t\t\t       |         3. Re-Check Application |");
                System.out.println("\t\t\t\t\t\t\t\t       |         4. <<<Go Back(press 0)  |");
                System.out.println("\t\t\t\t\t\t\t\t       |                                 |");
                System.out.println("\t\t\t\t\t\t\t\t       +---------------------------------+");
                System.out.println("");

                Scanner sc2 = new Scanner(System.in);
                System.out.println("");
                System.out.println("\t\t\t\t\t\t\t\t              Enter Your Choise");
                choise = sc2.nextInt();

                seeCourse(choise);
                break;

            case 3:
                System.out.println("\t\t\t\t\t\t      You Are Loged Out From The System.");
                return;

            case 4:

                break;

            default:
                System.out.println("");
                System.out.println("\t\t\t\t\t\t      Please input valid number.");

        }
    }

    private void seeCourse(int choise) {
        switch (choise) {
            case 0:
                //Go To Back
                welcomeTeacher();
                break;
            case 1:
                System.out.println("");
                System.out.println("\t\t\t\t\t\t\t       ===============< Choose a Course >============");
                System.out.println("");
                System.out.println("\t\t\t\t\t\t\t       +------------------+  \t   +-----------------+");
                System.out.println("\t\t\t\t\t\t\t       |                  |  \t   |                 |");
                System.out.println("\t\t\t\t\t\t\t       |     1. OOP-1     |  \t   |     2. OOP-2    |");
                System.out.println("\t\t\t\t\t\t\t       |                  |  \t   |                 |");
                System.out.println("\t\t\t\t\t\t\t       +------------------+  \t   +-----------------+");
                System.out.println("\t\t\t\t\t\t\t       |             3. <<<Go Back(press 0)         |");
                System.out.println("");
                System.out.println("\t\t\t\t\t\t\t       ==============================================");

                Scanner sc2 = new Scanner(System.in);
                System.out.println("");
                System.out.println("\t\t\t\t\t\t\t\t              Enter Your Choise");
                choise = sc2.nextInt();

                choiseCourse(choise);

            case 2:
                //create result

                createStudentResult();

                break;
            case 3:
                //check application

                MyFile.readStudentApplicationFile();
                TeacherOptions(2);

                break;

            default:
                System.out.println("");
                System.out.println("\t\t\t\t\t\t      Please input valid number.");
        }
    }

    private void choiseCourse(int choise) {

        switch (choise) {
            case 0:
                //Go To Back
                TeacherOptions(2);
                break;

            case 1:
                System.out.println("\t\t\t\t\t\t\t\t       ==============< Choose a section >===========");
                System.out.println("\t\t\t\t\t\t\t\t       |                                           |");
                System.out.println("\t\t\t\t\t\t\t\t       |  +------------------+                     |");
                System.out.println("\t\t\t\t\t\t\t\t       |  |                  |                     |");
                System.out.println("\t\t\t\t\t\t\t\t       |  |   1. Section-E   |                     |");
                System.out.println("\t\t\t\t\t\t\t\t       |  |                  |                     |");
                System.out.println("\t\t\t\t\t\t\t\t       |  +------------------+                     |");
                System.out.println("\t\t\t\t\t\t\t\t       |                       +-----------------+ |");
                System.out.println("\t\t\t\t\t\t\t\t       |                       |                 | |");
                System.out.println("\t\t\t\t\t\t\t\t       |                       |  2. Section-F   | |");
                System.out.println("\t\t\t\t\t\t\t\t       |                       |                 | |");
                System.out.println("\t\t\t\t\t\t\t\t       |                       +-----------------+ |");
                System.out.println("\t\t\t\t\t\t\t\t       |                                           |");
                System.out.println("\t\t\t\t\t\t\t\t       |             3. <<<Go Back(press 0)        |");
                System.out.println("\t\t\t\t\t\t\t\t       =============================================");

                Scanner sc2 = new Scanner(System.in);
                System.out.println("");
                System.out.println("\t\t\t\t\t\t\t\t              Enter Your Choise");
                choise = sc2.nextInt();

                choiseSections(choise);

                break;
            case 2:
                System.out.println("\t\t\t\t\t\t\t\t       ==============< Choose a section >===========");
                System.out.println("\t\t\t\t\t\t\t\t       |                                           |");
                System.out.println("\t\t\t\t\t\t\t\t       |  +------------------+                     |");
                System.out.println("\t\t\t\t\t\t\t\t       |  |                  |                     |");
                System.out.println("\t\t\t\t\t\t\t\t       |  |   1. Section-c   |                     |");
                System.out.println("\t\t\t\t\t\t\t\t       |  |                  |                     |");
                System.out.println("\t\t\t\t\t\t\t\t       |  +------------------+                     |");
                System.out.println("\t\t\t\t\t\t\t\t       |                       +-----------------+ |");
                System.out.println("\t\t\t\t\t\t\t\t       |                       |                 | |");
                System.out.println("\t\t\t\t\t\t\t\t       |                       |  2. Section-D   | |");
                System.out.println("\t\t\t\t\t\t\t\t       |                       |                 | |");
                System.out.println("\t\t\t\t\t\t\t\t       |                       +-----------------+ |");
                System.out.println("\t\t\t\t\t\t\t\t       |                                           |");
                System.out.println("\t\t\t\t\t\t\t\t       |             3. <<<Go Back(press 0)        |");
                System.out.println("\t\t\t\t\t\t\t\t       =============================================");

                Scanner sc3 = new Scanner(System.in);
                System.out.println("");
                System.out.println("\t\t\t\t\t\t\t\t              Enter Your Choise");
                choise = sc3.nextInt();

                uploadAndModifySection(choise);
            case 3:
                break;

            default:
                System.out.println("");
                System.out.println("\t\t\t\t\t\t      Please input valid number.");
        }
    }

    private void choiseSections(int choise) {
        switch (choise) {
            case 0:
                //Go To Back..........
                seeCourse(1);
                break;

            case 1:
                System.out.println("\t\t\t\t\t\t\t\t              Upload/Modify result of E section...");
                System.out.println("\t\t\t\t\t\t\t\t           ==========================================");
                System.out.println("");
                //Result Method
                break;
            case 2:
                System.out.println("\t\t\t\t\t\t\t\t              Upload/Modify result of F section...");
                System.out.println("\t\t\t\t\t\t\t\t           ==========================================");
                System.out.println("");
                //Result Method
                break;

            default:
                System.out.println("");
                System.out.println("\t\t\t\t\t\t      Please input valid number.");
        }
    }

    private void uploadAndModifySection(int choise) {

        switch (choise) {
            case 0:
                //Go To Back
                seeCourse(1);
                break;

            case 1:
                System.out.println("\t\t\t\t\t\t\t\t              Upload/Modify result of C section...");
                System.out.println("\t\t\t\t\t\t\t\t           ==========================================");
                System.out.println("");
                break;
            case 2:
                System.out.println("\t\t\t\t\t\t\t\t              Upload/Modify result of D section...");
                System.out.println("\t\t\t\t\t\t\t\t           ==========================================");
                System.out.println("");
                break;
            case 3:
                break;

            default:
                System.out.println("");
                System.out.println("\t\t\t\t\t\t      Please input valid number.");
        }
    }

    private void createStudentResult() {
        Scanner sc4 = new Scanner(System.in);
        System.out.println("");
        System.out.print("\t\t\t\t\t\t\t\t              Enter Student UserId: ");
        studentUserId = sc4.nextLine();
        System.out.println();
        System.out.print("\t\t\t\t\tEnter Quiz1 Marks                           : ");
        quiz1 = sc4.nextLine();
        System.out.print("\t\t\t\t\tEnter Quiz2 Marks                           : ");
        quiz2 = sc4.nextLine();
        System.out.print("\t\t\t\t\tEnter Viva Marks                            : ");
        viva = sc4.nextLine();
        System.out.print("\t\t\t\t\tEnter Assignment Marks                      : ");
        assignment = sc4.nextLine();
        System.out.print("\t\t\t\t\tEnter Performance & Attendance Marks        : ");
        performance_attendance = sc4.nextLine();

        int total = Integer.parseInt(quiz1) + Integer.parseInt(quiz2) + Integer.parseInt(viva) + Integer.parseInt(assignment) + Integer.parseInt(performance_attendance);
        result = String.valueOf(total);
        System.out.print("\t\t\t\t\tTotal Marks        : " + result);

        //Create Result File And Write Data..........................
        MyFile.createStudentResultFile();
        MyFile.writeStudentResultFile(studentUserId, quiz1, quiz2, viva, assignment, performance_attendance, result);
        System.out.println("\t\t\t\t\t\t Set Another Student Marks                           : ");
        //Go To Back
        TeacherOptions(2);
    }

}
