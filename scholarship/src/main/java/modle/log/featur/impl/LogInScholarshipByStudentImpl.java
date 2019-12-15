package modle.log.featur.impl;

import core.database.Database;
import modle.log.featur.usecase.LogInScholarshipBystudentUC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class LogInScholarshipByStudentImpl implements LogInScholarshipBystudentUC {
    private String username,password;
    private int studentId;

    public void setDatabase() {
        getData();
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conn.prepareStatement("select username,password,studentID from studentLogLog " +
                    "where username = ? and password = ? and studentID = ?");
            conn = Database.getDatabaseConnection();

            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.setInt(3,studentId);
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
        System.out.println("student id :");
        studentId = scanner.nextInt();
    }
}
