package dbManagers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import componentClasses.User;
import util.DbUtil;

public class UserDBManager
{
    public int insertUser(User user)
    {
        try
        {
            String sqlQuery = "insert into users(user_name, user_password) values(?,?);";
            PreparedStatement preparedStatement = DbUtil.getConnection().prepareStatement(sqlQuery);

            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getUserPassword());

            int result = preparedStatement.executeUpdate();
            return result;
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
        }
        
        return 0;
    }

    public int updateUser(User user)
    {
        try
        {
            String sqlQuery = "update users set user_name = ?, user_password = ? where user_id = ?;";
            PreparedStatement preparedStatement = DbUtil.getConnection().prepareStatement(sqlQuery);

            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getUserPassword());
            preparedStatement.setInt(3, user.getUserId());

            int result = preparedStatement.executeUpdate();
            return result;
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
        }
        
        return 0;
    }

    public int deleteUser(int userId)
    {
        try
        {
            String sqlQuery = "delete from users where user_id = ?;";
            PreparedStatement preparedStatement = DbUtil.getConnection().prepareStatement(sqlQuery);

            preparedStatement.setInt(1, userId);

            int result = preparedStatement.executeUpdate();
            return result;
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
        }
        
        return 0;
    }

    public boolean isRegisteredUser(User user) throws SQLException
    {
        String sqlQuery = "select user_password,user_name from users;";
        Statement statement = DbUtil.getConnection().createStatement();
        //preparedStatement.setString(1, user.getUserName());
        
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        
        // Use statement and select, check both username and password down below

        while(resultSet.next())
        {            
            if((resultSet.getString(1)).equals(user.getUserPassword()) && (resultSet.getString(2)).equals(user.getUserName()))
               return true;
        }

        return false;
    }

    public int getUserId(User user)
    {
        try
        {
            String sqlQuery = "select user_id,user_name from users;";
            Statement statement = DbUtil.getConnection().createStatement();

            ResultSet resultSet = statement.executeQuery(sqlQuery);
            
            while(resultSet.next())
            {
                if(resultSet.getString(2).equals(user.getUserName()))
                    return resultSet.getInt(1);
            }
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
        }
        
        return 0;
    }

    public String getUserName(int userId)
    {
        try
        {
            String sqlQuery = "select user_name from users where user_id = ?;";
            PreparedStatement preparedStatement = DbUtil.getConnection().prepareStatement(sqlQuery);

            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next())
            {
                return resultSet.getString(1);
            }
        }
        catch(SQLException exception)
        {
            return exception.getMessage();
        }

        return "";
    }
}
