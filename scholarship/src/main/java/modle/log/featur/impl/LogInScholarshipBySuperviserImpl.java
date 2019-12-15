package modle.log.featur.impl;

import core.database.Database;
import modle.log.featur.usecase.LogInScholarshipBySuperviserUC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class LogInScholarshipBySuperviserImpl implements LogInScholarshipBySuperviserUC {
    private String username,password,supervisor;
    public void setDatabase() {
        getData();
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conn.prepareStatement("select username,managerLog.password from scholarship.supervisorLog" +
                    "where username = ? and password = ? and supervisorID = ?");
            conn = Database.getDatabaseConnection();

            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,supervisor);
            if(preparedStatement.executeQuery().equals(false)){
                System.out.println("you failed !!! ");
            }else {
                System.out.println("You succeeded ...");
            }
            preparedStatement.close();
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
        System.out.println("supervisor id :");
        supervisor = scanner.nextLine();
    }
}
