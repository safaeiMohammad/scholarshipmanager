package featur.impl;

import core.database.Database;
import featur.usecase.RejectScholarShipBySuperviserUC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Calendar;
import java.util.Scanner;

public class RequestScholarshipByStudentImpl implements RejectScholarShipBySuperviserUC {
    private String lastGrade,lastFiled,lastUniversity
            ,destinationGrade,destinationFiled,destinationUniversity;
    private double gp;
    @Override
    public void updateStatus(String ScholarshipID){
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        getData();

        try {
            conn = Database.getDatabaseConnection();
            preparedStatement = conn.prepareStatement("insert into scholarship " +
                    "(status,dateRequested,lastGrade,lastField,lastUniversity,gp,destinationGrade,destinationField,destinationUniversity)" +
                    "values ('requested by student',?,?,?,?,?,?,?,?)");
            Calendar calendar = Calendar.getInstance();
            preparedStatement.setTime(1, (Time) calendar.getTime());
            preparedStatement.setString(2,lastGrade);
            preparedStatement.setString(3,lastFiled);
            preparedStatement.setString(4,lastUniversity);
            preparedStatement.setDouble(5,gp);
            preparedStatement.setString(6,destinationGrade);
            preparedStatement.setString(7,destinationFiled);
            preparedStatement.setString(8,destinationUniversity);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    private void getData(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("last grade :");
        lastGrade = scanner.nextLine();
        System.out.println("last field :");
        lastFiled = scanner.nextLine();
        System.out.println("last university :");
        lastUniversity = scanner.nextLine();
        System.out.println("gp :");
        gp = scanner.nextDouble();
        System.out.println("destination grade :");
        destinationGrade = scanner.nextLine();
        System.out.println("destination field :");
        destinationFiled = scanner.nextLine();
        System.out.println("destination university :");
        destinationUniversity = scanner.nextLine();
    }
}
