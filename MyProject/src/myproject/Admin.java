/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject;

import java.util.*;

/**
 *
 * @author almam
 */
public class Admin implements User {

    int choise;
    String admin_id_check = "admin";
    String admin_pass_check = "admin";
    String admin_id;
    String admin_pass;

    String teacherName, studentName;
    String teacherId, studentId;
    String teacherDept = "CSE", StudentDept = "CSE";

    static int totalTeacher = 1, totalStudent;

    public Admin() {
        // default constructor
    }

    public Admin(String admin_id, String admin_pass) {
        this.admin_id = admin_id;
        this.admin_pass = admin_pass;
    }

    public void addNewTeacher() {
        System.out.println("\t\t\t\t\t\t\t\t        Add New Teacher");
        System.out.println("\t\t\t\t\t\t\t\t        Enter Teacher User_ID & password");
        System.out.println("\t\t\t\t\t\t\t\t      ---------------------------------");
        System.out.println("");
        System.out.print("\t\t\t\t\t\t  Enter Teacher UserId : ");
        Scanner ad = new Scanner(System.in);
        teacherId = ad.nextLine().toString();
        System.out.print("\t\t\t\t\t\t  Enter Teacher Name : ");
        teacherName = ad.nextLine().toString();

        HomePage.teacher_id_list.add(teacherId);
        HomePage.teacher_pass_list.add(teacherName);

        MyFile.createTeacherFile();
        MyFile.writeTeacherFile(teacherId, teacherName);

        System.out.print("\t\t\t\t\t\t  Teacher Added Sucessfully ");

        System.out.println("");
        totalTeacher = HomePage.teacher_id_list.size();
        System.out.println("\t\t\t\t  Total Teacher:" + totalTeacher);
    }

    public void addNewStudent() {
        System.out.println("\t\t\t\t\t\t\t\t        Add New Student");
        System.out.println("\t\t\t\t\t\t\t\t        Enter Student User_ID & User_Name");
        System.out.println("\t\t\t\t\t\t\t\t      ---------------------------------");
        System.out.println("");
        System.out.print("\t\t\t\t\t\t  Enter Student UserId : ");
        Scanner ad = new Scanner(System.in);
        studentId = ad.nextLine().toString();
        System.out.print("\t\t\t\t\t\t  Enter Student Name : ");
        studentName = ad.nextLine().toString();

        HomePage.student_id_list.add(studentId);
        HomePage.student_pass_list.add(studentName);
        MyFile.writeStudentFile(studentName, studentId);

        System.out.print("\t\t\t\t\t\t  Student Added Sucessfully ");

        System.out.println("");
        totalStudent = HomePage.student_id_list.size();
        System.out.println("\t\t\t\t  Total Student:" + totalStudent);
    }

    public void deleteTeacher(String teacherId) {
        if (!HomePage.teacher_id_list.isEmpty()) {
            if (HomePage.teacher_id_list.contains(teacherId)) {
                HomePage.teacher_id_list.remove(teacherId);
                System.out.println("Teacher Remove Sucessfully.");
                totalTeacher -= 1;
                System.out.println("\t\t\t\t  Total Student:" + totalTeacher);
            } else {
                System.out.println("Please type valid ID.");
            }
        } else {
            System.out.println("Number of Teacher Id Null.");
        }

    }

    public void deleteStudent(String studentId) {
        if (!HomePage.student_id_list.isEmpty()) {
            if (HomePage.student_id_list.contains(studentId)) {
                HomePage.student_id_list.remove(studentId);
                System.out.println("Student Remove Sucessfully.");
                totalStudent -= 1;

                System.out.println("\t\t\t\t  Total Student:" + totalStudent);
            } else {
                System.out.println("Please type valid ID.");
            }
        } else {
            System.out.println("Number of Student Id Null.");
        }
    }

    public void showTeacInfo() {
        System.out.println("");

        if (totalTeacher == 0) {
            System.out.println("No teacher Listed");
        }
        for (int i = 0; i < totalTeacher; i++) {
            System.out.println();
            System.out.println("\t\t    Teacher Number is      : " + (i + 1));
            System.out.println("==============================================");
            System.out.println("Teacher Name           : " + HomePage.teacher_id_list.get(i));
            System.out.println("Teacher ID             : " + HomePage.teacher_pass_list.get(i));
            System.out.println("Teacher Dept.          : " + teacherDept);
            System.out.println();
        }
        System.out.println("Total Teacher is       : " + totalTeacher);
        System.out.println();
    }

    public void showStudentInfo() {
        System.out.println("");

        if (totalStudent == 0) {
            System.out.println("No Student Listed");
        }
        for (int i = 0; i < totalStudent; i++) {
            System.out.println();
            System.out.println("\t\tStudent Number is      : " + (i + 1));
            System.out.println("==============================================");
            System.out.println("Student Name           : " + HomePage.student_id_list.get(i));
            System.out.println("Student ID             : " + HomePage.student_pass_list.get(i));
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void login() {
        if (admin_id_check.equals(admin_id) && admin_pass_check.equals(admin_pass)) {

            welcomeAdmin();

        } else {
            System.out.println("");
            System.out.println("\t\t\t\t\t\t      Please input valid User_id and Password.");
            System.out.println("");
        }
    }

    private void welcomeAdmin() {
        System.out.println("");
        System.out.println("\t\t\t\t\t\t\t\t\t     Login Successful");
        System.out.println("");
        System.out.println("\t\t\t\t\t\t\t\t      #  Welcome to the Admin Portal  #");
        System.out.println("\t\t\t\t\t\t\t\t      =================================");
        System.out.println("");
        System.out.println("");

        System.out.println("\t\t\t\t\t\t\t\t          Choose any mention number...");
        System.out.println("");
        System.out.println("\t\t\t\t\t\t\t        +~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
        System.out.println("\t\t\t\t\t\t\t        |                                           |");
        System.out.println("\t\t\t\t\t\t\t        |          1.Manage Teacher                 |");
        System.out.println("\t\t\t\t\t\t\t        |                                           |");
        System.out.println("\t\t\t\t\t\t\t        |              2.Manage Student             |");
        System.out.println("\t\t\t\t\t\t\t        |                                           |");
        System.out.println("\t\t\t\t\t\t\t        |                   3.Logout               |");
        System.out.println("\t\t\t\t\t\t\t        |                                           |");
        System.out.println("\t\t\t\t\t\t\t        +~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
        Scanner i2 = new Scanner(System.in);

        System.out.println("");
        System.out.println("\t\t\t\t\t\t\t\t              Enter Your Choise");
        choise = i2.nextInt();

        adminOptions(choise);

    }

    private void adminOptions(int choise) {
        switch (choise) {
            case 1:
                System.out.println("\t\t\t\t\t\t\t\t            Choose any mention number...");
                System.out.println("\t\t\t\t\t\t\t\t                  +------------+");
                System.out.println("\t\t\t\t\t\t\t\t                  |   1. Add   |");
                System.out.println("\t\t\t\t\t\t\t\t                  +------------+");
                System.out.println("");
                System.out.println("\t\t\t\t\t\t\t\t                  +-------- ---+");
                System.out.println("\t\t\t\t\t\t\t\t                  | 2. Delete  |");
                System.out.println("\t\t\t\t\t\t\t\t                  +------------+");
                System.out.println("");
                System.out.println("\t\t\t\t\t\t\t\t                  +-------- ---+");
                System.out.println("\t\t\t\t\t\t\t\t                  | 3. Details |");
                System.out.println("\t\t\t\t\t\t\t\t                  +------------+");

                Scanner i2 = new Scanner(System.in);

                System.out.println("");
                System.out.println("\t\t\t\t\t\t\t\t                Enter Your Choise");
                choise = i2.nextInt();

                databaseTeacherOptions(choise);

                break;
            //STUDENT

//ADD method 
            case 2:
                System.out.println("\t\t\t\t\t\t\t\t            Choose any mention number...");
                System.out.println("\t\t\t\t\t\t\t\t                  +------------+");
                System.out.println("\t\t\t\t\t\t\t\t                  |   1. Add   |");
                System.out.println("\t\t\t\t\t\t\t\t                  +------------+");
                System.out.println("");
                System.out.println("\t\t\t\t\t\t\t\t                  +-------- ---+");
                System.out.println("\t\t\t\t\t\t\t\t                  | 2. Delete  |");
                System.out.println("\t\t\t\t\t\t\t\t                  +------------+");
                System.out.println("");
                System.out.println("\t\t\t\t\t\t\t\t                  +-------- ---+");
                System.out.println("\t\t\t\t\t\t\t\t                  | 3. Details |");
                System.out.println("\t\t\t\t\t\t\t\t                  +------------+");
                System.out.println("\t\t\t\t\t\t\t\t       |      4. <<<Go Back(press 0)       |");

                Scanner i3 = new Scanner(System.in);

                System.out.println("");
                System.out.println("\t\t\t\t\t\t\t\t                Enter Your Choise");
                choise = i3.nextInt();

                databaseStudentOptions(choise);

                break;

            case 3:
                System.out.println("\t\t\t\t\t\t      You Are Loged Out From The System.");

                HomePage.mainMethod();
                return;

            default:
                System.out.println("");
                System.out.println("\t\t\t\t\t\t      Please input valid number.");
                System.out.println("");
        }
    }

    private void databaseTeacherOptions(int choise) {
        switch (choise) {
            case 0:
                welcomeAdmin();
                break;
            //MANAGE TEACHER
            case 1:
                System.out.println("\t\t\t\t\t\t\t\t                  Add Teacher");
                System.out.println("\t\t\t\t\t\t\t\t      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                //add method 
                addNewTeacher();
                welcomeAdmin();

                break;
            case 2:
                System.out.println("\t\t\t\t\t\t\t\t                 Delete Teacher");
                System.out.println("\t\t\t\t\t\t\t\t      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                Scanner i2 = new Scanner(System.in);

                System.out.println("");
                System.out.println("\t\t\t\t\t\t\t\t                 Please Enter Teacher ID");
                String nameChoise = i2.nextLine().toString();
                //delete method
                deleteTeacher(nameChoise);
                welcomeAdmin();

                break;
            case 3:
                System.out.println("\t\t\t\t\t\t\t\t                 Teachers Detail");
                System.out.println("\t\t\t\t\t\t\t\t      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                showTeacInfo();
                welcomeAdmin();

                break;

            default:
                System.out.println("");
                System.out.println("\t\t\t\t\t\t      Please input valid number.");
                System.out.println("");
        }
    }

    private void databaseStudentOptions(int choise) {
        switch (choise) {
            //MANAGE Student
            case 1:
                System.out.println("\t\t\t\t\t\t\t\t                   Add Student");
                System.out.println("\t\t\t\t\t\t\t\t      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                //add method
                addNewStudent();
                welcomeAdmin();
                break;
            case 2:
                System.out.println("\t\t\t\t\t\t\t\t                 Delete Student");
                System.out.println("\t\t\t\t\t\t\t\t      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                //delete method
                Scanner i2 = new Scanner(System.in);

                System.out.println("");
                System.out.println("\t\t\t\t\t\t\t\t                 Please Enter Student ID");
                String nameChoise = i2.nextLine().toString();
                //delete method
                deleteStudent(nameChoise);
                welcomeAdmin();
                break;
            case 3:
                System.out.println("\t\t\t\t\t\t\t\t                  Student Detail");
                System.out.println("\t\t\t\t\t\t\t\t      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                showStudentInfo();
                welcomeAdmin();

                break;

            default:
                System.out.println("");
                System.out.println("\t\t\t\t\t\t      Please input valid number.");
                System.out.println("");
        }
    }

}
