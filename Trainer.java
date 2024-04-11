import java.sql.*;

public class Trainer {
    AdministrativeClass ad = new AdministrativeClass();
    Member mem1 = new Member();
    public void scheduleManagement(String trainerName, String timeFrame) { //right order in parameter

        String url = "jdbc:postgresql://localhost:5432/health and fitness management system";
        String user = "postgres";
        String password = "datapass";
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            String sqls = "UPDATE schedule SET workout_time = ? WHERE trainer_name = ?; UPDATE rooms SET workout_time = ? WHERE trainer_name = ?; UPDATE rooms SET maintenance = 'being used' WHERE workout_time = ? "; //INSERT INTO schedule (trainer_name, member_name, available_date, workout_time, room_number) VALUES (?, ?, ?, ?, ?)";

            //ResultSet resultSet = statement.getResultSet();
            PreparedStatement preparedStatement = connection.prepareStatement(sqls);
            preparedStatement.setString(1, timeFrame);
            preparedStatement.setString(2, trainerName);
            preparedStatement.setString(3, timeFrame);
            preparedStatement.setString(4, trainerName);
            preparedStatement.setString(5, timeFrame);
            //statement.executeUpdate(sqls);
            preparedStatement.executeUpdate();
            statement.executeQuery("select * from SCHEDULE");
            ad.roomBookingManagement(timeFrame);

            //statement.executeUpdate(sqls);
            //statement.executeQuery("select * from STUDENTS");
            ResultSet resultSet = statement.getResultSet();
            //iterate through the table to output the provided results to display the records including the updated email
            //while (resultSet.next()) {
                //System.out.println(resultSet.getString("trainer_name"));
                //System.out.println(resultSet.getString("member_name"));
               // System.out.println(resultSet.getString("available_date"));
               // System.out.println(resultSet.getString("workout_time"));
               // System.out.println(resultSet.getString("room_number"));
           // }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void memberProfileViewing(String firstName, String lastName){
        String url = "jdbc:postgresql://localhost:5432/health and fitness management system";
        String user = "postgres";
        String password = "datapass";
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            String sqls = "SELECT first_name, last_name, email, phone, join_date, credit_card_balance FROM members WHERE first_name = ? AND last_name = ?"; // WHERE workout_time = ? //UPDATE schedule SET member_name = ? WHERE workout_time = ? AND member_name IS NULL";
            PreparedStatement preparedStatement = connection.prepareStatement(sqls);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.executeUpdate();
            statement.executeQuery("select * from MEMBERS");



            ResultSet resultSet = preparedStatement.getResultSet();
            System.out.println(resultSet.getString("first_name"));
            System.out.println(resultSet.getString("last_name"));
            System.out.println(resultSet.getString("email"));
            System.out.println(resultSet.getString("phone"));
            System.out.println(resultSet.getString("join_date"));
            System.out.println(resultSet.getString("credit_card_balance"));
            //iterate through the table to output the provided results to display the records including the updated email
            //while (resultSet.next()) {
            //System.out.println(resultSet.getString("first_name"));
            // System.out.println(resultSet.getString("last_name"));
            // System.out.println(resultSet.getString("goals"));
            // System.out.println(resultSet.getString("achievements"));
            //System.out.println(resultSet.getString("active_time"));
            //}

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void endWorkoutClass(String trainerName, String timeFrame, String clientMember){
        String url = "jdbc:postgresql://localhost:5432/health and fitness management system";
        String user = "postgres";
        String password = "datapass";
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            mem1.appleWatch(clientMember);
            ad.equipmentMaintenanceMonitoring(trainerName, timeFrame);
            String sqls = "UPDATE schedule SET workout_time = NULL WHERE trainer_name = ?; UPDATE rooms SET workout_time = NULL WHERE trainer_name = ?; UPDATE rooms SET status = 'room pending' WHERE trainer_name = ?";

            //ResultSet resultSet = statement.getResultSet();
            PreparedStatement preparedStatement = connection.prepareStatement(sqls);
            preparedStatement.setString(1, trainerName);
            preparedStatement.setString(2, trainerName);
            preparedStatement.setString(3, trainerName);

            //statement.executeUpdate(sqls);
            preparedStatement.executeUpdate();
            statement.executeQuery("select * from SCHEDULE");
            //statement.executeUpdate(sqls);
            //statement.executeQuery("select * from STUDENTS");
            ResultSet resultSet = statement.getResultSet();



        } catch (Exception e) {
            System.out.println(e);
        }

    }






}
