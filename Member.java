import java.sql.*;

public class Member {

    AdministrativeClass ac = new AdministrativeClass();


    public void userRegistration(String firstName, String lastName, String memberEmail, String phoneNumber, Date joinedDate, Integer creditCard) { //right order in parameter

        String url = "jdbc:postgresql://localhost:5432/health and fitness management system";
        String user = "postgres";
        String password = "datapass";
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            String newMembership = "new membership";
            Integer initialCost = 100;
            ac.billingAndPaymentHistory(firstName, lastName, newMembership, initialCost);
            String sqls = "INSERT INTO members (first_name, last_name, email, phone, join_date, credit_card_balance) VALUES (?, ?, ?, ?, ?, ?)";

            //ResultSet resultSet = statement.getResultSet();
            PreparedStatement preparedStatement = connection.prepareStatement(sqls);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, memberEmail);
            preparedStatement.setString(4, phoneNumber);
            preparedStatement.setDate(5, joinedDate);
            preparedStatement.setInt(6, creditCard);
            //statement.executeUpdate(sqls);
            preparedStatement.executeUpdate();
            statement.executeQuery("select * from SCHEDULE");
            ResultSet resultSet = statement.getResultSet();
            //iterate through the table to output the provided results to display the records including the updated email
            //while (resultSet.next()) {
                //System.out.println(resultSet.getString("trainer_name"));
                //System.out.println(resultSet.getString("member_name"));
                //System.out.println(resultSet.getString("room_number"));
                //System.out.println(resultSet.getString("workout_time"));
                //System.out.println(resultSet.getString("available_date"));
                //System.out.println(resultSet.getString("available_date"));
            //}

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void profileManagement(String firstName, String lastName, String tableColomn, String afterUpdate) { //right order in parameter

        String url = "jdbc:postgresql://localhost:5432/health and fitness management system";
        String user = "postgres";
        String password = "datapass";
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            String sqls = "UPDATE dashboard SET " + tableColomn + " = ? WHERE first_name = ? AND last_name = ?"; // WHERE workout_time = ? //UPDATE schedule SET member_name = ? WHERE workout_time = ? AND member_name IS NULL";

            //ResultSet resultSet = statement.getResultSet();
            PreparedStatement preparedStatement = connection.prepareStatement(sqls);
            preparedStatement.setString(1, afterUpdate);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            //statement.executeUpdate(sqls);
            preparedStatement.executeUpdate();
            statement.executeQuery("select * from SCHEDULE");
            //appleWatch(memberName);


            //statement.executeUpdate(sqls);
            //statement.executeQuery("select * from STUDENTS");
            ResultSet resultSet = statement.getResultSet();
            //iterate through the table to output the provided results to display the records including the updated email
            //while (resultSet.next()) {
                //System.out.println(resultSet.getString("trainer_name"));
                //System.out.println(resultSet.getString("member_name"));
                //System.out.println(resultSet.getString("room_number"));
                //System.out.println(resultSet.getString("workout_time"));
                //System.out.println(resultSet.getString("available_date"));
            //}

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void dashboardDisplay(String firstName, String lastName){
        String url = "jdbc:postgresql://localhost:5432/health and fitness management system";
        String user = "postgres";
        String password = "datapass";
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            String sqls = "SELECT first_name, last_name, goals, achievements, active_time FROM dashboard WHERE first_name = ? AND last_name = ?"; // WHERE workout_time = ? //UPDATE schedule SET member_name = ? WHERE workout_time = ? AND member_name IS NULL";
            PreparedStatement preparedStatement = connection.prepareStatement(sqls);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.executeUpdate();
            statement.executeQuery("select * from DASHBOARD");


            //statement.executeQuery("select * from DASHBOARD");

            ResultSet resultSet = preparedStatement.getResultSet();
            System.out.println(resultSet.getString("first_name"));
            System.out.println(resultSet.getString("last_name"));
            System.out.println(resultSet.getString("goals"));
            System.out.println(resultSet.getString("achievements"));
            System.out.println(resultSet.getString("active_time"));
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

    public void scheduleManagement(String firstName, String lastName, String timeFrames) { //right order in parameter

        String url = "jdbc:postgresql://localhost:5432/health and fitness management system";
        String user = "postgres";
        String password = "datapass";
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            String fitnessClasses = "fitness class";
            Integer classCost = 20;
            ac.billingAndPaymentHistory(firstName, lastName, fitnessClasses, classCost);
            String sqls = "UPDATE schedule SET member_name = ? WHERE workout_time = ?"; // WHERE workout_time = ? //UPDATE schedule SET member_name = ? WHERE workout_time = ? AND member_name IS NULL";

            //ResultSet resultSet = statement.getResultSet();
            PreparedStatement preparedStatement = connection.prepareStatement(sqls);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, timeFrames);
            //statement.executeUpdate(sqls);
            preparedStatement.executeUpdate();
            statement.executeQuery("select * from SCHEDULE");
            //appleWatch(memberName);


            //statement.executeUpdate(sqls);
            //statement.executeQuery("select * from STUDENTS");
            ResultSet resultSet = statement.getResultSet();
            //iterate through the table to output the provided results to display the records including the updated email
            while (resultSet.next()) {
                System.out.println(resultSet.getString("trainer_name"));
                System.out.println(resultSet.getString("member_name"));
                System.out.println(resultSet.getString("room_number"));
                System.out.println(resultSet.getString("workout_time"));
                System.out.println(resultSet.getString("available_date"));
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }



    public void appleWatch(String memberName2){ //right order in parameter

        String url = "jdbc:postgresql://localhost:5432/health and fitness management system";
        String user = "postgres";
        String password = "datapass";
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            String sqls = "UPDATE dashboard SET active_time = active_time + 60 WHERE first_name = ?"; // WHERE workout_time = ? //UPDATE schedule SET member_name = ? WHERE workout_time = ? AND member_name IS NULL";

                //ResultSet resultSet = statement.getResultSet();
            PreparedStatement preparedStatement = connection.prepareStatement(sqls);
            preparedStatement.setString(1, memberName2);
                //statement.executeUpdate(sqls);
            preparedStatement.executeUpdate();
            statement.executeQuery("select * from DASHBOARD");

                //statement.executeUpdate(sqls);
                //statement.executeQuery("select * from STUDENTS");
                //ResultSet resultSet = statement.getResultSet();
                //iterate through the table to output the provided results to display the records including the updated email
                //while (resultSet.next()) {
                    //System.out.println(resultSet.getString("trainer_name"));
                    //System.out.println(resultSet.getString("member_name"));
                    //System.out.println(resultSet.getString("room_number"));
                    //System.out.println(resultSet.getString("workout_time"));
                    //System.out.println(resultSet.getString("available_date"));
                //}

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


    }




}
