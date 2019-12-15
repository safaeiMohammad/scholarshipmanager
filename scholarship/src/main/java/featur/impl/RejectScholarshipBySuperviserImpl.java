package featur.impl;

import core.database.Database;
import featur.usecase.RejectScholarShipBySuperviserUC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Calendar;

public class RejectScholarshipBySuperviserImpl implements RejectScholarShipBySuperviserUC {
    @Override
    public void updateStatus(String ScholarshipID) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = Database.getDatabaseConnection();
            preparedStatement = conn.prepareStatement("update scholarship" +
                    "set (status ='reject by supervisor',dateChangeSupervisor = ?);");
            Calendar calendar = Calendar.getInstance();
            preparedStatement.setTime(1, (Time) calendar.getTime());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
