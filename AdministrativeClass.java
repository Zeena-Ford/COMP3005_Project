import java.sql.*;

public class AdministrativeClass {
    public void roomBookingManagement(String timeFrame2){ //right order in parameter

        String url = "jdbc:postgresql://localhost:5432/health and fitness management system";
        String user = "postgres";
        String password = "datapass";
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();


            String sqls = "UPDATE rooms SET status = 'booked' WHERE workout_time = ?"; //INSERT INTO schedule (trainer_name, member_name, available_date, workout_time, room_number) VALUES (?, ?, ?, ?, ?)";

            //ResultSet resultSet = statement.getResultSet();
            PreparedStatement preparedStatement = connection.prepareStatement(sqls);
            preparedStatement.setString(1, timeFrame2);
            //statement.executeUpdate(sqls);
            preparedStatement.executeUpdate();
            statement.executeQuery("select * from ROOMS");

            //statement.executeUpdate(sqls);
            //statement.executeQuery("select * from STUDENTS");
            //ResultSet resultSet = statement.getResultSet();
            //iterate through the table to output the provided results to display the records including the updated email
            //while (resultSet.next()) {
             //   System.out.println(resultSet.getString("room_number"));
              //  System.out.println(resultSet.getString("workout_time"));
               // System.out.println(resultSet.getString("status"));
            //}

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void equipmentMaintenanceMonitoring(String trainerName3, String timeFrame3){ //right order in parameter

        String url = "jdbc:postgresql://localhost:5432/health and fitness management system";
        String user = "postgres";
        String password = "datapass";
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();


            String sqls = "UPDATE rooms SET maintenance = 'cleaned' WHERE trainer_name = ? AND workout_time = ?"; //INSERT INTO schedule (trainer_name, member_name, available_date, workout_time, room_number) VALUES (?, ?, ?, ?, ?)";

            //ResultSet resultSet = statement.getResultSet();
            PreparedStatement preparedStatement = connection.prepareStatement(sqls);
            preparedStatement.setString(1, trainerName3);
            preparedStatement.setString(2, timeFrame3);
            //statement.executeUpdate(sqls);
            preparedStatement.executeUpdate();
            statement.executeQuery("select * from ROOMS");

            //statement.executeUpdate(sqls);
            //statement.executeQuery("select * from STUDENTS");
            //ResultSet resultSet = statement.getResultSet();
            //iterate through the table to output the provided results to display the records including the updated email
            //while (resultSet.next()) {
            //   System.out.println(resultSet.getString("room_number"));
            //  System.out.println(resultSet.getString("workout_time"));
            // System.out.println(resultSet.getString("status"));
            //}

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void classScheduleUpdating(String trainerName4, String timeFrame4){ //right order in parameter

        String url = "jdbc:postgresql://localhost:5432/health and fitness management system";
        String user = "postgres";
        String password = "datapass";
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            String sqls = "UPDATE schedule SET workout_time = NULL WHERE trainer_name = ? AND workout_time = ?"; //INSERT INTO schedule (trainer_name, member_name, available_date, workout_time, room_number) VALUES (?, ?, ?, ?, ?)";

            //ResultSet resultSet = statement.getResultSet();
            PreparedStatement preparedStatement = connection.prepareStatement(sqls);
            preparedStatement.setString(1, trainerName4);
            preparedStatement.setString(2, timeFrame4);
            //statement.executeUpdate(sqls);
            preparedStatement.executeUpdate();
            statement.executeQuery("select * from SCHEDULE");


        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void billingAndPaymentHistory(String firstName, String lastName, String feeType, int cost){ //right order in parameter

        String url = "jdbc:postgresql://localhost:5432/health and fitness management system";
        String user = "postgres";
        String password = "datapass";
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            String sqls = "UPDATE members SET credit_card_balance = credit_card_balance - 20 WHERE first_name = ? AND last_name = ?; INSERT INTO payment (first_name, last_name, fee_type, amount) VALUES (?,?,?,?)";//INSERT INTO schedule (trainer_name, member_name, available_date, workout_time, room_number) VALUES (?, ?, ?, ?, ?)";

            //ResultSet resultSet = statement.getResultSet();
            PreparedStatement preparedStatement = connection.prepareStatement(sqls);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, lastName);
            preparedStatement.setString(5, feeType);
            preparedStatement.setInt(6, cost);

            //statement.executeUpdate(sqls);
            preparedStatement.executeUpdate();
            statement.executeQuery("select * from SCHEDULE");


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
