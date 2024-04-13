/**
 *  Trainer class representing the trainers in a Gym
 *
 * @author Zeena Ford 101229954, Zeina Mouhtadi 101169685
 * @version April 12, 2024
 */


import java.sql.*;

public class Trainer {
    AdministrativeClass ad = new AdministrativeClass();
    Member mem1 = new Member();

    /**
     * Allows trainers to set the time for which they are available and schedule a fitness class
     * @param trainerName represents the first name of the trainer
     * @param timeFrame represents the time that the trainer is available
     */
    public void scheduleManagement(String trainerName, String timeFrame) { //right order in parameter
        //url code containing the local host, user, password and name for the database
        String url = "jdbc:postgresql://localhost:5432/health and fitness management system";
        String user = "postgres";
        String password = "datapass";
        try {
            Class.forName("org.postgresql.Driver");
            //enabling connection between the database and the application using the provided driver
            Connection connectSQL = DriverManager.getConnection(url, user, password);
            Statement statement = connectSQL.createStatement();
            //executing database query to output the records from 'students' database
            String querySQL = "UPDATE schedule SET workout_time = ? WHERE trainer_name = ?; UPDATE rooms SET workout_time = ? WHERE trainer_name = ?; UPDATE rooms SET maintenance = 'being used' WHERE workout_time = ? "; //INSERT INTO schedule (trainer_name, member_name, available_date, workout_time, room_number) VALUES (?, ?, ?, ?, ?)";

            //ResultSet resultSet = statement.getResultSet();
            PreparedStatement prepState = connectSQL.prepareStatement(querySQL);
            prepState.setString(1, timeFrame);
            prepState.setString(2, trainerName);
            prepState.setString(3, timeFrame);
            prepState.setString(4, trainerName);
            prepState.setString(5, timeFrame);
            //statement.executeUpdate(querySQL);
            prepState.executeQuery();
            //statement.executeQuery("select * from SCHEDULE");
            //calling roomBookingManagement function to allow the trainer to book a workout room once they have scheduled a workout class into the SCHEDULE table with the timeframe included
            ad.roomBookingManagement(timeFrame);

            //statement.executeUpdate(querySQL);
            //statement.executeQuery("select * from STUDENTS");
            ResultSet resultSQL = prepState.getResultSet();
            //iterate through the table to output the provided results to display the records including the updated email
            while (resultSQL.next()) { //fourth difference
                System.out.println("trainer_name     member_name        available_date          workout_time       room_number" + "\n");
                System.out.println(resultSQL.getString("trainer_name") + "\t\t\t" + resultSQL.getString("member_name") + "\t\t\t" + resultSQL.getString("available_date") + "\t\t\t" + resultSQL.getString("workout_time")+ "\t\t\t" + resultSQL.getString("room_number"));
            }
            //catch exception (SQL Exception included) and print results
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Allows trainers to view the profile of the member they search
     * @param firstName represents the first name of the member that the trainer searches
     * @param lastName represents the last name of the member that the trainer searches
     */

    public void memberProfileViewing(String firstName, String lastName){
        //url code containing the local host, user, password and name for the database
        String url = "jdbc:postgresql://localhost:5432/health and fitness management system";
        String user = "postgres";
        String password = "datapass";
        try {
            Class.forName("org.postgresql.Driver");
            //enabling connection between the database and the application using the provided driver
            Connection connectSQL = DriverManager.getConnection(url, user, password);
            Statement statement = connectSQL.createStatement();
            //executing database query to allow the trainer to display the view of a member's profile

            String querySQL = "SELECT first_name, last_name, email, phone, join_date, credit_card_balance FROM members WHERE first_name = ? AND last_name = ?"; // WHERE workout_time = ? //UPDATE schedule SET member_name = ? WHERE workout_time = ? AND member_name IS NULL";
            PreparedStatement prepState = connectSQL.prepareStatement(querySQL);
            prepState.setString(1, firstName);
            prepState.setString(2, lastName);
            prepState.executeQuery();

            ResultSet resultSQL = prepState.getResultSet();
            //iterate through the table to output the provided results to display the records including the updated email
            while (resultSQL.next()) {
                System.out.println("first_name       last_name                email                     phone               join_date      credit_card_balance" + "\n");
                System.out.println(resultSQL.getString("first_name") + "\t\t\t\t\t" + resultSQL.getString("last_name") + "\t\t\t" + resultSQL.getString("email") + "\t\t\t" + resultSQL.getString("phone")+ "\t\t\t" + resultSQL.getString("join_date")+ "\t\t\t" + resultSQL.getString("credit_card_balance"));
            }
            //catch exception (SQL Exception included) and print results
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Allows trainers to end their workout class
     * @param trainerName represents the first name of the trainer
     * @param timeFrame represents the time that the workout began
     * @param clientMember represents the client (member) that the trainer is training
     */

    public void endWorkoutClass(String trainerName, String timeFrame, String clientMember){
        //url code containing the local host, user, password and name for the database
        String url = "jdbc:postgresql://localhost:5432/health and fitness management system";
        String user = "postgres";
        String password = "datapass";
        try {
            Class.forName("org.postgresql.Driver");
            //enabling connection between the database and the application using the provided driver
            Connection connectSQL = DriverManager.getConnection(url, user, password);
            Statement statement = connectSQL.createStatement();
            mem1.appleWatch(clientMember);
            //calling equipmentMaintenanceMonitoring to allow the maintenance staff to clean the workout room once the trainer has ended the class
            ad.equipmentMaintenanceMonitoring(trainerName, timeFrame);
            String querySQL = "UPDATE schedule SET workout_time = NULL WHERE trainer_name = ?; UPDATE rooms SET workout_time = NULL WHERE trainer_name = ?; UPDATE rooms SET status = 'room pending' WHERE trainer_name = ?";

            //ResultSet resultSet = statement.getResultSet();
            PreparedStatement prepState = connectSQL.prepareStatement(querySQL);
            prepState.setString(1, trainerName);
            prepState.setString(2, trainerName);
            prepState.setString(3, trainerName);

            //statement.executeUpdate(querySQL);
            prepState.executeUpdate();
            statement.executeQuery("select * from SCHEDULE");
            //statement.executeUpdate(querySQL);
            //statement.executeQuery("select * from STUDENTS");
            ResultSet resultSet = statement.getResultSet();

            //catch exception (SQL Exception included) and print results

        } catch (Exception e) {
            System.out.println(e);
        }

    }






}






