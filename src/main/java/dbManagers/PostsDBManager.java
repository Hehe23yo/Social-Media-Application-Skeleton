package dbManagers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import componentClasses.Post;
import util.DbUtil;

public class PostsDBManager
{
    public int insertPost(Post post)
    {
        try
        {
            String sqlQuery = "insert into posts(post_content, user_id) values(?, ?);";
            PreparedStatement preparedStatement = DbUtil.getConnection().prepareStatement(sqlQuery);

            preparedStatement.setString(1, post.getPostContent());
            preparedStatement.setInt(2, post.getPostId());

            int result = preparedStatement.executeUpdate();
            return result;
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
        }
        
        return 0;
    }

    public int updatePost(Post post)
    {
        try
        {
            String sqlQuery = "update posts set post_content = ?, user_id = ? where post_id = ?;";
            PreparedStatement preparedStatement = DbUtil.getConnection().prepareStatement(sqlQuery);

            preparedStatement.setString(1, post.getPostContent());
            preparedStatement.setInt(2, post.getUserId());
            preparedStatement.setInt(3, post.getPostId());

            int result = preparedStatement.executeUpdate();
            return result;
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
        }
        
        return 0;
    }
    
    public int deletePost(int postId)
    {
        try
        {
            String sqlQuery = "delete from posts where post_id = ?;";
            PreparedStatement preparedStatement = DbUtil.getConnection().prepareStatement(sqlQuery);

            preparedStatement.setInt(1, postId);

            int result = preparedStatement.executeUpdate();
            return result;
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
        }
        
        return 0;
    }

    public List<Post> getPosts()
    {
        List<Post> posts = new ArrayList<>();
        try
        {
            String sqlQuery = "select * from posts;";
            Statement statement = DbUtil.getConnection().createStatement();

            ResultSet resultSet = statement.executeQuery(sqlQuery);
            
            while(resultSet.next())
            {
                posts.add(new Post(resultSet.getInt(1), resultSet.getInt(4), resultSet.getString(2)));
            }
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
        }

        return posts;
    }
}
