package core;

import core.database.Database;
import featur.impl.*;
import modle.log.featur.impl.*;
import modle.scholarship.Scholarship;
import user.User;

import java.util.Scanner;

public class ScholarshipMain {
    Scanner scanner = new Scanner(System.in);
    static String scholarshipID ;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("select one option(login|sign up|exit)");
        String string1 = scanner.nextLine();
        if (string1.compareTo("exit") == 0) {
            System.out.println("bye !!!");
            return;
        }
        System.out.println("select type (student|supervisor|manager|exit)");
        String string2 = scanner.nextLine();
        try {
            if (string1.equals("login")) {
                login(string2);
            } else if (string1.equals("sign up")) {
                signUp(string2);
                login(string2);
            } else if (string1.equals("exit")) {
                System.out.println("bye!!!");
                return;
            }
            if (string2.equals("student")) {
                System.out.println("select (show dashboard|request|find scholarship by student)");
                Scholarship scholarship = new Scholarship();
                string1 = scanner.nextLine();
                if (string1.equals("request"))
                    new RequestScholarshipByStudentImpl().updateStatus(scholarshipID);
                else if (string1.equals("show dashboard"))
                    new Dashboard().showDashboard();
                else if (string1.equals("find scholarship by student")) {
                    new FindScholarshipByStudentImpl().find();
                }

            } else if (string2.equals("supervisor")) {
                System.out.println("select (show dashboard|find scholarship by supervisor)");
                string2 = scanner.nextLine();
                if (string2.equals("show dashboard")) {
                    new Dashboard().showDashboard();
                }
                else if (string2.equals("find scholarship by supervisor"))
                    new FindScholarshipBySuperviserImpl().find();
                System.out.println("select (accept|reject)");
                string2 = scanner.nextLine();
                if (string2.equals("accept")){
                    System.out.println("Enter scholarship id");
                    string1 = scanner.nextLine();
                    new AcceptScholarshipBySuperviserImpl().updateStatus(string1);
                }else if (string2.equals("reject")){
                    System.out.println("Enter scholarship id");
                    string1 = scanner.nextLine();
                    new RejectScholarshipBySuperviserImpl().updateStatus(string1);
                }

            }
            else if (string2.equals("manager")){
                String string3;
                System.out.println("select (show dashboard|find scholarship for manager|exit)");
                string3 = scanner.nextLine();
                if(string3.equals("show dashboard")) {
                    new Dashboard().showDashboard();
                    System.out.println("select (find scholarship for manager|exit");
                    string3 = scanner.nextLine();
                    if (string3.equals("find scholarship for manager"))
                        new FindScholarshipByMangerImpl().find();
                }
                else if (string3.equals("find scholarship for manager"))
                    new FindScholarshipByMangerImpl().find();

                System.out.println("select (accept|reject|exit)");
                string3 = scanner.nextLine();
                if (string3.equals("accept")){
                    scholarshipID = scanner.nextLine();
                    new AcceptScholarshipByManagerImpl().updateStatus(scholarshipID);
                }else if (string3.equals("reject")){
                    scholarshipID = scanner.nextLine();
                    new RejectScholarshipByMangerImpl().updateStatus(scholarshipID);
                }else return;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    private static void login(String string2){
        if(string2.equals("student"))
            new LogInScholarshipByStudentImpl().setDatabase();
        else if(string2.equals("supervisor"))
            new LogInScholarshipBySuperviserImpl().setDatabase();
        else if (string2.equals("manger"))
            new LogInScholarshipByManagerImpl().setDatabase();
    }
    private static void signUp(String string2){
        if (string2.equals("student"))
            new SignScholarshipByStudentImpl().setData();
        else if (string2.equals("supervisor"))
            new SignScholarshipBySuperviserImpl().setData();
        else if (string2.equals("manager"))
            new SignScholarshipByManagerImpl().setData();
    }
}
