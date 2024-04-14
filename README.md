# COMP 3005 Project V2 - Design and implement an application for a Health and Fitness Club Management System.



## Author: Zeena Ford, 101229954 and Zeina Mouhtadi, 101169685
Contact: zeenaford@cmail.carleton.ca



## Application description:

The application consists of Member, Trainer and Administrative Staff Functions that connect with the 'health and fitness management system' PostgreSQL database. All of these functions were implemented in either a Member class, Trainer class or AdministrativeStaff class in Java, and are all called within the Gym class, representing the main class. For example, the first function within the Member class includes'User Registration' is responsible for Allowing new membership users to input their information within the members table. Each function, along with the bonus functions, are placed in their corresponding classes, which contain the docstring and proper documentation needed to fully describe the details of the function.


## Installation

You **must** be using the IntelliJ IDEA to run the application. You must also ensure that you have downloaded the proper driver (psqlJDBC) to allow the interface between the JAVA application and the PostgreSQL database. Ensure that you are compiling with 'Maven'; this includes either downloading the latest version of the 'psqlJDBC' driver, or copying the code with the 'dependencies xml notation' into the proper libary. Ensure that all java files are running within the same directory (a single project folder.) 



## To run and compile the application

To run this application, ensure that all installation requirements are met, to avoid any errors during compilation. Each function is already included in the main signature within the 'Gym.java' class. A provided video from the following URL demonstrates the results from the application: https://www.youtube.com/channel/UC2cf0eqjOqizRZVe1OZRNfA. To compile successfully and verify each function, ensure that the initial data is included (consisting of Krist, Lilly, Ben, etc.), and simply remove the '//' notation before the function. For each function, add the given arguments (eg. if a first_name argument is required, input an example of a first name) and click the run icon. The outputted results should be displayed.
