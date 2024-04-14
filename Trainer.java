/**
 *  Administrative class representing the administrative staff in a Gym
 *
 * @author Zeena Ford 101229954, Zeina Mouhtadi, 101169685
 * @version April 12, 2024
 */

import java.sql.*;

public class AdministrativeStaff {

    /**
     * Allows administrative staff book a workout room once the trainer has booked a time slot - status of room changes to 'booked'
     * @param timeFrame represents the time that the room was booked
     */
    public void roomBookingManagement(String timeFrame, String trainerName, String stat){ //right order in parameter
        //url code containing the local host, user, password and name for the database
        String url = "jdbc:postgresql://localhost:5432/health and fitness management system";
        String user = "postgres";
        String password = "datapass";
        try {
            Class.forName("org.postgresql.Driver");
            //enabling connection between the database and the application using the provided driver
            Connection connectSQL = DriverManager.getConnection(url, user, password);
            Statement statement = connectSQL.createStatement();

            //executing database query to allow the staff to book a room once a trainer schedules their available time for a workout room
            String querySQL = "UPDATE rooms SET status = ? WHERE workout_time = ? AND trainer_name = ?"; //INSERT INTO schedule (trainer_name, member_name, available_date, workout_time, room_number) VALUES (?, ?, ?, ?, ?)";

            //ResultSet resultSet = statement.getResultSet();
            PreparedStatement prepState = connectSQL.prepareStatement(querySQL);
            //setting the parameters of the query as the inputted parameter for the trainer time
            prepState.setString(1, stat);
            prepState.setString(2, timeFrame);
            prepState.setString(3, trainerName);
            //statement.executeUpdate(querySQL);
            prepState.executeQuery();
            //statement.executeQuery("select * from ROOMS");

            //statement.executeUpdate(querySQL);
            //statement.executeQuery("select * from STUDENTS");
            ResultSet resultSQL = prepState.getResultSet();
            //iterate through the table to output the provided results to display the records including the updated email
            while (resultSQL.next()) { //fourth difference
                System.out.println("trainer_name     room_number        workout_time          status       maintenance" + "\n");
                System.out.println(resultSQL.getString("trainer_name") + "\t\t\t" + resultSQL.getString("room_number") + "\t\t\t" + resultSQL.getString("workout_time") + "\t\t\t" + resultSQL.getString("status")+ "\t\t\t" + resultSQL.getString("maintenance"));
            }
            //catch exception (SQL Exception included) and print results
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * Allows administrative staff to clean the workout room once the trainer has ended the class
     * @param trainerName represents the trainer that has booked the class
     * @param timeFrame represents the time slot that the room is booked for
     */

    public void equipmentMaintenanceMonitoring(String trainerName, String timeFrame){ //right order in parameter
        //url code containing the local host, user, password and name for the database
        String url = "jdbc:postgresql://localhost:5432/health and fitness management system";
        String user = "postgres";
        String password = "datapass";
        try {
            Class.forName("org.postgresql.Driver");
            //enabling connection between the database and the application using the provided driver
            Connection connectSQL = DriverManager.getConnection(url, user, password);
            Statement statement = connectSQL.createStatement();

            //executing database query to update the maintenance of the room to "cleaned" after the workout room has been used
            String querySQL = "UPDATE rooms SET maintenance = 'cleaned' WHERE trainer_name = ? AND workout_time = ?"; //INSERT INTO schedule (trainer_name, member_name, available_date, workout_time, room_number) VALUES (?, ?, ?, ?, ?)";

            //ResultSet resultSet = statement.getResultSet();
            PreparedStatement prepState = connectSQL.prepareStatement(querySQL);
            //setting the parameters of the query as the inputted parameters from the user
            prepState.setString(1, trainerName);
            prepState.setString(2, timeFrame);
            //statement.executeUpdate(querySQL);
            prepState.executeQuery();
            //statement.executeQuery("select * from ROOMS");

            //statement.executeUpdate(querySQL);
            //statement.executeQuery("select * from STUDENTS");
            ResultSet resultSQL = prepState.getResultSet();
            //iterate through the table to output the provided results to display the records including the updated email
            while (resultSQL.next()) { //fourth difference
                System.out.println("trainer_name     room_number        workout_time          status       maintenance" + "\n");
                System.out.println(resultSQL.getString("trainer_name") + "\t\t\t" + resultSQL.getString("room_number") + "\t\t\t" + resultSQL.getString("workout_time") + "\t\t\t" + resultSQL.getString("status")+ "\t\t\t" + resultSQL.getString("maintenance"));
            }
            //catch exception (SQL Exception included) and print results
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    /**
     * Allows staff to update the class schedule (if a class was cancelled, etc.)
     * @param trainerName represents the trainer that currently has a scheduled workout class
     * @param timeFrame represents the time slot that the trainer has booked
     */

    public void classScheduleUpdating(String trainerName, String timeFrame, String upDate){ //right order in parameter
        //url code containing the local host, user, password and name for the database
        String url = "jdbc:postgresql://localhost:5432/health and fitness management system";
        String user = "postgres";
        String password = "datapass";
        try {
            Class.forName("org.postgresql.Driver");
            //enabling connection between the database and the application using the provided driver
            Connection connectSQL = DriverManager.getConnection(url, user, password);
            Statement statement = connectSQL.createStatement();
            //executing database query to output the SCHEDULE table after updates
            String querySQL = "UPDATE schedule SET workout_time = ? WHERE trainer_name = ? AND workout_time = ?"; //INSERT INTO schedule (trainer_name, member_name, available_date, workout_time, room_number) VALUES (?, ?, ?, ?, ?)";

            //ResultSet resultSet = statement.getResultSet();
            PreparedStatement prepState = connectSQL.prepareStatement(querySQL);
            prepState.setString(1, upDate);
            prepState.setString(2, trainerName);
            prepState.setString(3, timeFrame);
            //statement.executeUpdate(querySQL);
            prepState.executeQuery();
            //statement.executeQuery("select * from SCHEDULE");

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
     * Keeps the history of payments that is updated; the credit card amount of each member on the profile dashboard decreases (decrements) once a member provides a payment of some sort (either $20 for fitness class or $100 for new membership fee from userRegistration)
     * @param firstName represents the first name of the member that provided a payment
     * @param lastName represents the last name of the member that provided a payment
     * @param feeType represents the fee type of the payment (ex: new membership fee, fitness class fee)
     * @param cost represents the cost of the fee type (ex: new membership fee = $100, fitness class fee = $20)
     *
     */

    public void billingAndPaymentHistory(String firstName, String lastName, String feeType, int cost){ //right order in parameter
        //url code containing the local host, user, password and name for the database
        String url = "jdbc:postgresql://localhost:5432/health and fitness management system";
        String user = "postgres";
        String password = "datapass";
        try {
            Class.forName("org.postgresql.Driver");
            //enabling connection between the database and the application using the provided driver
            Connection connectSQL = DriverManager.getConnection(url, user, password);
            Statement statement = connectSQL.createStatement();
            //executing database query to output the billing payment history that gets updated once a member provides a payment of some sort (new membership fee or fitness class fee)

            String querySQL = "UPDATE members SET credit_card_balance = credit_card_balance - ? WHERE first_name = ? AND last_name = ?; INSERT INTO payment (first_name, last_name, fee_type, amount) VALUES (?,?,?,?)";//INSERT INTO schedule (trainer_name, member_name, available_date, workout_time, room_number) VALUES (?, ?, ?, ?, ?)";

            //ResultSet resultSet = statement.getResultSet();
            PreparedStatement prepState = connectSQL.prepareStatement(querySQL);
            prepState.setInt(1, cost);
            prepState.setString(2, firstName);
            prepState.setString(3, lastName);
            prepState.setString(4, firstName);
            prepState.setString(5, lastName);
            prepState.setString(6, feeType);
            prepState.setInt(7, cost);

            //statement.executeUpdate(querySQL);
            prepState.executeQuery();
            //statement.executeQuery("select * from SCHEDULE");

            ResultSet resultSQL = prepState.getResultSet();
            //iterate through the table to output the provided results to display the SCHEDULE table after a member has scheduled a fitness class
            while (resultSQL.next()) { //fourth difference
                System.out.println("first_name     last_name        fee_type          amount" + "\n");
                System.out.println(resultSQL.getString("first_name") + "\t\t\t" + resultSQL.getString("last_name") + "\t\t\t" + resultSQL.getString("fee_type") + "\t\t\t" + resultSQL.getString("amount")+ "\t\t\t");
            }

            //catch exception (SQL Exception included) and print results
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void resetDay(){ //right order in parameter
        //url code containing the local host, user, password and name for the database
        String url = "jdbc:postgresql://localhost:5432/health and fitness management system";
        String user = "postgres";
        String password = "datapass";
        try {
            Class.forName("org.postgresql.Driver");
            //enabling connection between the database and the application using the provided driver
            Connection connectSQL = DriverManager.getConnection(url, user, password);
            Statement statement = connectSQL.createStatement();
            //executing database query to output the SCHEDULE table after updates
            //String querySQL = "UPDATE schedule SET workout_time = NULL; UPDATE schedule SET member_name = NULL; //INSERT INTO schedule (trainer_name, member_name, available_date, workout_time, room_number) VALUES (?, ?, ?, ?, ?)";

            //ResultSet resultSet = statement.getResultSet();
            //PreparedStatement prepState = connectSQL.prepareStatement(querySQL);
            //prepState.setString(1, trainerName);
            //prepState.setString(2, timeFrame);
            //statement.executeUpdate(querySQL);
            //prepState.executeQuery();
            statement.executeQuery("UPDATE schedule SET workout_time = NULL; UPDATE schedule SET member_name = NULL");

            ResultSet resultSQL = statement.getResultSet();
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

}
