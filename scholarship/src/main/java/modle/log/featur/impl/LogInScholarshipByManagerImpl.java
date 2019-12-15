package modle.log.featur.impl;


import core.database.Database;
import modle.log.featur.usecase.LogInScholarshipByManagerUC;
import java.sql.*;
import java.util.Scanner;


public class LogInScholarshipByManagerImpl implements LogInScholarshipByManagerUC{
    private String username,password;
    public void setDatabase() {
        getData();
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conn.prepareStatement("select username,managerLog.password from managerLog " +
                    "where username = ? and password = ?");
            conn = Database.getDatabaseConnection();

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            if (preparedStatement.executeQuery().equals(false)) {
                System.out.println("you failed !!! ");
            } else {
                System.out.println("You successed ...");
               preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void getData(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("username :");
        username = scanner.nextLine();
        System.out.println("password :");
        password = scanner.nextLine();
    }

}
