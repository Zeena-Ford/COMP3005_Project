/**
 *  Member class representing the members in a Gym
 *
 * @author Zeena Ford 101229954, Zeina Mouhtadi 101169685
 * @version April 12, 2024
 */


import java.sql.*;

public class Member {

    AdministrativeClass ac = new AdministrativeClass();

    /**
     * Allows new users to register into the gym database - credit card amount from each member on the dashboard decrements -100 after registering, and gets registered in billing history table - Inserts into Members table
     * @param firstName represents the first name of the new member
     * @param lastName represents the last name of the new member
     * @param memberEmail represents the member's email
     * @param memberNumber represents the member's phone number
     * @param joinedDate represents the member's join date
     * @param creditCard represents the member's credit card amount within his personal bank account
     */
    public void userRegistration(String firstName, String lastName, String memberEmail, String memberNumber, Date joinedDate, Integer creditCard) { //right order in parameter
        //url code containing the local host, user, password and name for the database
        String url = "jdbc:postgresql://localhost:5432/health and fitness management system";
        String user = "postgres";
        String password = "datapass";
        try {
            Class.forName("org.postgresql.Driver");
            //enabling connection between the database and the application using the provided driver
            Connection connectSQL = DriverManager.getConnection(url, user, password);

            Statement statement = connectSQL.createStatement();
            String newMembership = "new membership";
            Integer initialCost = 100;
            //calling billingAndPaymentHistory function to allow the new membership fee of the new registered member to be saved in the payment history file within the gym database
            ac.billingAndPaymentHistory(firstName, lastName, newMembership, initialCost);
            //executing database query to output the records from 'students' database
            String querySQL = "INSERT INTO members (first_name, last_name, email, phone, join_date, credit_card_balance) VALUES (?, ?, ?, ?, ?, ?)";

            //ResultSet resultSet = statement.getResultSet();

            PreparedStatement prepState = connectSQL.prepareStatement(querySQL);
            //setting the parameters of the query as the inputted parameters from the user
            prepState.setString(1, firstName);
            prepState.setString(2, lastName);
            prepState.setString(3, memberEmail);
            prepState.setString(4, memberNumber);
            prepState.setDate(5, joinedDate);
            prepState.setInt(6, creditCard);
            //statement.executeUpdate(querySQL);
            prepState.executeQuery();
            //prepState.executeUpdate();
            //statement.executeQuery("select * from SCHEDULE");
            ResultSet resultSQL = prepState.getResultSet();
            //iterate through the table to output the provided results to display the records including the new user
            while (resultSQL.next()) {
                System.out.println("first_name       last_name                email                     phone               join_date      credit_card_balance" + "\n");
                System.out.println(resultSQL.getString("first_name") + "\t\t\t\t\t" + resultSQL.getString("last_name") + "\t\t\t" + resultSQL.getString("email") + "\t\t\t" + resultSQL.getString("phone")+ "\t\t\t" + resultSQL.getString("join_date")+ "\t\t\t" + resultSQL.getString("credit_card_balance"));
            }

            // catch exception (SQL Exception included) and print results
        } catch (Exception e) {
            System.out.println("Error found: " + e.getMessage());
        }
    }


    /**
     * Allows members to update important information in their dashboard profile (such has fitness goals, achievements, etc.)
     * @param firstName represents the first name of the member
     * @param lastName represents the last name of the member
     * @param tableColomn represents the colomn title including the information that the member wants to update
     * @param afterUpdate represents the updated information that the member wants to use
     */
    public void profileManagement(String firstName, String lastName, String tableColomn, String afterUpdate) { //right order in parameter
        //url code containing the local host, user, password and name for the database
        String url = "jdbc:postgresql://localhost:5432/health and fitness management system";
        String user = "postgres";
        String password = "datapass";
        try {
            Class.forName("org.postgresql.Driver");
            //enabling connection between the database and the application using the provided driver
            Connection connectSQL = DriverManager.getConnection(url, user, password);
            Statement statement = connectSQL.createStatement();
            //executing database query to allow members to manage their profiles on the gym dashboard
            String querySQL = "UPDATE dashboard SET " + tableColomn + " = ? WHERE first_name = ? AND last_name = ?"; // WHERE workout_time = ? //UPDATE schedule SET member_name = ? WHERE workout_time = ? AND member_name IS NULL";

            //ResultSet resultSet = statement.getResultSet();
            PreparedStatement prepState = connectSQL.prepareStatement(querySQL);
            //setting the parameters of the query as the inputted parameters from the member
            prepState.setString(1, afterUpdate);
            prepState.setString(2, firstName);
            prepState.setString(3, lastName);
            //statement.executeUpdate(querySQL);
            //prepState.executeUpdate();
            prepState.executeQuery();
            //statement.executeQuery("select * from SCHEDULE");
            //appleWatch(memberName);


            //statement.executeUpdate(querySQL);
            //statement.executeQuery("select * from STUDENTS");
            ResultSet resultSQL = prepState.getResultSet();
            //iterate through the table to output the provided results to display the records including the updated email
            while (resultSQL.next()) { //fourth difference
                System.out.println("first_name     last_name        goals          achievement       active_time" + "\n");
                System.out.println(resultSQL.getString("first_name") + "\t\t\t" + resultSQL.getString("last_name") + "\t\t\t" + resultSQL.getString("goals") + "\t\t\t" + resultSQL.getString("achievements")+ "\t\t\t" + resultSQL.getString("active_time"));
            }
            // catch exception (SQL Exception included) and print results

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Allows members to display their information included in the gym dashboard
     * @param firstName represents the first name of the member
     * @param lastName represents the last name of the member
     */

    public void dashboardDisplay(String firstName, String lastName){
        //url code containing the local host, user, password and name for the database
        String url = "jdbc:postgresql://localhost:5432/health and fitness management system";
        String user = "postgres";
        String password = "datapass";
        try {
            Class.forName("org.postgresql.Driver");
            //enabling connection between the database and the application using the provided driver
            Connection connectSQL = DriverManager.getConnection(url, user, password);
            Statement statement = connectSQL.createStatement();
            //executing database query to display the dashboard profile of the member
            String querySQL = "SELECT first_name, last_name, goals, achievements, active_time FROM dashboard WHERE first_name = ? AND last_name = ?"; // WHERE workout_time = ? //UPDATE schedule SET member_name = ? WHERE workout_time = ? AND member_name IS NULL";
            //execute query
            PreparedStatement prepState = connectSQL.prepareStatement(querySQL);
            //setting the parameters of the query as the inputted parameters from the user
            prepState.setString(1, firstName);
            prepState.setString(2, lastName);
            prepState.executeQuery();
            //get results
            ResultSet resultSQL = prepState.getResultSet();
            //iterate through the table to output the provided results to display the dashboard
            while (resultSQL.next()) {
                System.out.println("first_name     last_name        goals          achievement       active_time" + "\n");
                System.out.println(resultSQL.getString("first_name") + "\t\t\t" + resultSQL.getString("last_name") + "\t\t\t" + resultSQL.getString("goals") + "\t\t\t" + resultSQL.getString("achievements")+ "\t\t\t" + resultSQL.getString("active_time"));
            }
            //catch exception (SQL Exception included) and print results
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * credit card amount from each member on the dashboard decrements -20 after scheduling class; Allows members to schedule a fitness class, if there is a trainer available during their desired time
     * @param firstName represents the first name of the member
     * @param lastName represents the last name of the member
     * @param timeFrame represents when the member wants to work out
     */

    public void scheduleManagement(String firstName, String lastName, String timeFrame) { //right order in parameter
        //url code containing the local host, user, password and name for the database
        String url = "jdbc:postgresql://localhost:5432/health and fitness management system";
        String user = "postgres";
        String password = "datapass";
        try {
            Class.forName("org.postgresql.Driver");
            //enabling connection between the database and the application using the provided driver
            Connection connectSQL = DriverManager.getConnection(url, user, password);
            Statement statement = connectSQL.createStatement();
            String fitnessClasses = "fitness class";
            Integer classCost = 20;
            //calling billingAndPaymentHistory function to allow the fitness class fee for the member to be registered in the payment history gym database
            ac.billingAndPaymentHistory(firstName, lastName, fitnessClasses, classCost);
            //executing database query to output the records from 'students' database
            String querySQL = "UPDATE schedule SET member_name = ? WHERE workout_time = ?"; // WHERE workout_time = ? //UPDATE schedule SET member_name = ? WHERE workout_time = ? AND member_name IS NULL";

            PreparedStatement prepState = connectSQL.prepareStatement(querySQL);
            //setting the parameters of the query as the inputted parameters from the user
            prepState.setString(1, firstName);
            prepState.setString(2, timeFrame);
            //execute query
            prepState.executeQuery();
            //statement.executeQuery("select * from SCHEDULE");
            //appleWatch(memberName);


            //statement.executeUpdate(querySQL);
            //statement.executeQuery("select * from STUDENTS");
            ResultSet resultSQL = prepState.getResultSet();
            //iterate through the table to output the provided results to display the SCHEDULE table after a member has scheduled a fitness class
            while (resultSQL.next()) { //fourth difference
                System.out.println("trainer_name     member_name        available_date          workout_time       room_number" + "\n");
                System.out.println(resultSQL.getString("trainer_name") + "\t\t\t" + resultSQL.getString("member_name") + "\t\t\t" + resultSQL.getString("available_date") + "\t\t\t" + resultSQL.getString("workout_time")+ "\t\t\t" + resultSQL.getString("room_number"));
            }
            //catch exception (SQL Exception included) and print results
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Allows members to use their applewatch to keep track of their active times; "active_time" on profile dashboard increments +[60 minutes] within the profile dashboard
     * @param memberName represents the first name of the member
     */

    public void appleWatch(String memberName){ //right order in parameter
        //url code containing the local host, user, password and name for the database
        String url = "jdbc:postgresql://localhost:5432/health and fitness management system";
        String user = "postgres";
        String password = "datapass";
        try {
            Class.forName("org.postgresql.Driver");
            //enabling connection between the database and the application using the provided driver
            Connection connectSQL = DriverManager.getConnection(url, user, password);
            Statement statement = connectSQL.createStatement();
            //executing database query to update the active time calculated from the applewatch, onto the member's dashboard profile
            String querySQL = "UPDATE dashboard SET active_time = active_time + 60 WHERE first_name = ?"; // WHERE workout_time = ? //UPDATE schedule SET member_name = ? WHERE workout_time = ? AND member_name IS NULL";

                //ResultSet resultSet = statement.getResultSet();
            PreparedStatement prepState = connectSQL.prepareStatement(querySQL);
            prepState.setString(1, memberName);
                //statement.executeUpdate(querySQL);
            prepState.executeUpdate();
            statement.executeQuery("select * from DASHBOARD");

                //statement.executeUpdate(querySQL);
                //statement.executeQuery("select * from STUDENTS");
                //ResultSet resultSQL = statement.getResultSet();
                //iterate through the table to output the provided results to display the records including the updated email
                //while (resultSQL.next()) {
                    //System.out.println(resultSQL.getString("trainer_name"));
                    //System.out.println(resultSQL.getString("member_name"));
                    //System.out.println(resultSQL.getString("room_number"));
                    //System.out.println(resultSQL.getString("workout_time"));
                    //System.out.println(resultSQL.getString("available_date"));
                //}
            //catch exception (SQL Exception included) and print results
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


    }




}
