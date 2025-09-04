package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil 
{
    private static Connection connection;
    
    static
    {
        try
        {
            Class.forName("org.h2.Driver");
            System.out.println("Driver loaded!");

            connection = DriverManager.getConnection("jdbc:h2:C:\\Users\\aakas\\Documents\\finalProject_Mit", "sa", "");
            System.out.println("Connectin established!");
        }
        catch(ClassNotFoundException exception)
        {
            exception.printStackTrace();
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
        }
    }

    public static Connection getConnection()
    {
        return connection;
    }
}