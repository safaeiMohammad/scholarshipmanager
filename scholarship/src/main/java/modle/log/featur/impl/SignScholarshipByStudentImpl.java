package modle.log.featur.impl;

import core.database.Database;
import modle.log.featur.usecase.SignScholarshipByStudent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SignScholarshipByStudentImpl implements SignScholarshipByStudent {
    private String username,password,naturalID,email,lastName,firstName;
    private int studentID;
    public void setData(){
        getData();
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;

        try {
            preparedStatement = conn.prepareStatement("insert into managerLog " +
                    "values (?,?,?,?,?)");
            conn = Database.getDatabaseConnection();

            preparedStatement.setString(1,naturalID);
            preparedStatement.setString(2,username);
            preparedStatement.setString(3,password);
            preparedStatement.setInt(4,studentID);
            preparedStatement.setString(5,email);

            int a = preparedStatement.executeUpdate();
            System.out.println("successful...");
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            conn = Database.getDatabaseConnection();
            preparedStatement1 = conn.prepareStatement("insert into scholarship " +
                    "(lastName,firstName) values (?,?)");
            preparedStatement1.setString(1,lastName);
            preparedStatement1.setString(2,firstName);
            preparedStatement1.executeUpdate();
            preparedStatement1.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getData(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("firstName :");
        username = scanner.nextLine();
        System.out.println("lastName :");
        password = scanner.nextLine();
        System.out.println("natural id :");
        naturalID = scanner.next();
        System.out.println("student id :");
        studentID = scanner.nextInt();
        System.out.println("username :");
        username = scanner.nextLine();
        System.out.println("password :");
        password = scanner.nextLine();
        System.out.println("email :");
        email = scanner.nextLine();

    }
}
