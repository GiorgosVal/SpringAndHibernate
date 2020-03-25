package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String url = "jdbc:mysql://localhost:3306/hb_01_one_to_one_uni?useSSL=false&serverTimezone=UTC";
        String user = "val";
        String pass = "giorgaras";


        try {
            Connection connection = DriverManager.getConnection(url, user, pass);

            System.out.println("okkkk");


            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
