
import java.sql.*;


//this is the main class, therefore other classes won't print or pass to the database (that's why you call all functions in here
//don't put NOT NULL because a room can be pending for a trainer (NULL)
//don't type unique so that you can have more than one fitness class as the fee type for multiple people
//right order in parameter
//put .setDate if parameter is Date or .setInt etc.
//put filename.md (for readme) and filename.SQL (for SQL type of file)
public class Gym {

    public static void main(String[] args) {
        //Trainer t1 = new Trainer();
        Member m1 = new Member();

        //getAllStudents();
        //addStudent();
        //addStudent("Lilly", "Turner", "lilly.turner@example.com", Date.valueOf("2024-04-04"));
        //t1.scheduleManagement("Emily", "5pm");
        //m1.scheduleManagement("Krist", "Loth", "5pm");
        //t1.endWorkoutClass("Emily", "5pm", "Krist");
        //m1.userRegistration("Lea", "Mol", "leamol@gmail.com", "613-212-2222", Date.valueOf("2023-04-04"), 2000);
        //m1.profileManagement("Ema", "Smith", "goals", "Abs");
        //m1.dashboardDisplay("Milly","Doe");

        //updateStudentEmail();
        //deleteStudent();
    }




}
