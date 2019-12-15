package core;

import core.database.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dashboard {
    public void showDashboard(){
        Connection connection = null;
        Statement statement1 = null;
        try {
            connection = Database.getDatabaseConnection();
            statement1 = connection.createStatement();
            String sql = "SELECT row_number() over status,number from scholarship where status = 'requested by student' " +
                    "or status = 'accept by supervisor' or status = 'accept by supervisor';";
            ResultSet rs = statement1.executeQuery(sql);
            while (rs.next()){
                int requestByStudent = rs.getInt(1);
                int acceptBySupervisor = rs.getInt(2);
                int acceptByManager = rs.getInt(3);


                String leftAlignFormat = "| %-15s | %-10s |%n";
                System.out.format("+-------  ---------------+-------------------+%n");
                System.out.format("|   Column name          |     result        |%n");
                System.out.format("+------------------------+-------------------+%n");

                System.out.format(leftAlignFormat, "requested by student" + 0,requestByStudent);
                System.out.format(leftAlignFormat,"accept by supervisor" + 1,acceptBySupervisor);
                System.out.format(leftAlignFormat,"accept by manager" + 2,acceptByManager);
                System.out.format("+------------------------+-------------------+%n");
                System.out.println();

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
