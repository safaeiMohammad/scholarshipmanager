package modle.log.featur.impl;

import core.database.Database;
import modle.log.featur.usecase.SignScholarshipByManagerUC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SignScholarshipByManagerImpl implements SignScholarshipByManagerUC {
    private String username,password,naturalIDManager,email,lastName,firstName;
    public void setData(){
        getData();
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conn.prepareStatement("insert into managerLog " +
                    "values (?,?,?,?,?,?)");
            conn = Database.getDatabaseConnection();

            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,naturalIDManager);
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
        naturalIDManager = scanner.nextLine();
        System.out.println("username :");
        username = scanner.nextLine();
        System.out.println("password :");
        password = scanner.nextLine();
        System.out.println("email :");
        email = scanner.nextLine();

    }
}
