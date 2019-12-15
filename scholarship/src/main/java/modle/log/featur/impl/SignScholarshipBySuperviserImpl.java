package modle.log.featur.impl;

import core.database.Database;
import modle.log.featur.usecase.SignScholarshipBySuperviserUC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SignScholarshipBySuperviserImpl implements SignScholarshipBySuperviserUC {
    private String username,password,naturalIDSupervisor,email,lastName,firstName,supervisorId;
    public void setData(){
        getData();
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conn.prepareStatement("insert into scholarship.supervisorLog " +
                    "values (?,?,?,?,?,?,?)");
            conn = Database.getDatabaseConnection();

            preparedStatement.setString(1,naturalIDSupervisor);
            preparedStatement.setString(2,username);
            preparedStatement.setString(3,password);
            preparedStatement.setString(4,email);
            preparedStatement.setString(5,lastName);
            preparedStatement.setString(6,firstName);

            int a = preparedStatement.executeUpdate();
            System.out.println("successful...");
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
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
        naturalIDSupervisor = scanner.nextLine();
        System.out.println("supervisor id :");
        supervisorId = scanner.nextLine();
        System.out.println("username :");
        username = scanner.nextLine();
        System.out.println("password :");
        password = scanner.nextLine();
        System.out.println("email :");
        email = scanner.nextLine();

    }
}

