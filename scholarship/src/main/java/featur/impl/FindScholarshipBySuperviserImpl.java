package featur.impl;

import core.database.Database;
import featur.usecase.FindScholarshipBySuperviserUC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FindScholarshipBySuperviserImpl implements FindScholarshipBySuperviserUC {
    private String lastGrade,lastField,lastUniversity,destinationGrade
            ,destinationField,destinationUniversity,dateRequested;
    private double gp;
    private int studentID;
    public void find(){
        Connection conn = null;
        Statement statement = null;

        try {
            conn = Database.getDatabaseConnection();
            statement = conn.createStatement();
            String sql = "SELECT  * FROM scholarship where status = 'requested by student'";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                lastGrade = rs.getString("lastGrade");
                lastField = rs.getString("lastField");
                lastUniversity = rs.getString("lastUniversity");
                gp = rs.getDouble("gp");
                destinationGrade = rs.getString("destinationGrade");
                destinationField = rs.getString("destinationField");
                destinationUniversity = rs.getString("destinationUniversity");
                dateRequested = rs.getString("dateRequested");
                studentID = rs.getInt("studentID");

                String leftAlignFormat = "| %-15s | %-10s |%n";

                System.out.format("+-------  ---------------+-------------------+%n");
                System.out.format("|   Column name          |     result        |%n");
                System.out.format("+------------------------+-------------------+%n");

                System.out.format(leftAlignFormat, "studentID" + 0, (char)studentID);
                System.out.format(leftAlignFormat, "lastGrade" + 1, lastGrade);
                System.out.format(leftAlignFormat, "lastField" + 2, lastField);
                System.out.format(leftAlignFormat, "lastUniversity" + 3, lastUniversity);
                System.out.format(leftAlignFormat, "gp" + 4,(char)gp);
                System.out.format(leftAlignFormat, "destinationGrade" + 5, destinationGrade);
                System.out.format(leftAlignFormat, "destinationField" + 6, destinationField);
                System.out.format(leftAlignFormat, "destinationUniversity" + 7, destinationUniversity);
                System.out.format(leftAlignFormat, "dateRequested" + 8, dateRequested);

                System.out.format("+------------------------+-------------------+%n");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

