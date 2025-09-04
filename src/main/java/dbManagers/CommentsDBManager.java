package dbManagers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import componentClasses.Comment;
import util.DbUtil;

public class CommentsDBManager
{
    public int insertComment(Comment comment)
    {
        try
        {
            String sqlQuery = "insert into comments(post_id, user_id, comment_content) values(?, ?, ?);";
            PreparedStatement preparedStatement = DbUtil.getConnection().prepareStatement(sqlQuery);

            preparedStatement.setInt(1, comment.getPostId());
            preparedStatement.setInt(2, comment.getUserId());
            preparedStatement.setString(3, comment.getCommentContent());

            int result = preparedStatement.executeUpdate();
            return result;
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
        }
        
        return 0;
    }

    public int updateComment(Comment comment)
    {
        try
        {
            String sqlQuery = "update comments set comment_content = ? where comment_id = ?;";
            PreparedStatement preparedStatement = DbUtil.getConnection().prepareStatement(sqlQuery);

            preparedStatement.setString(1, comment.getCommentContent());
            preparedStatement.setInt(2, comment.getCommentId());

            int result = preparedStatement.executeUpdate();
            return result;
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
        }
        
        return 0;
    }
    
    public int deleteComment(int commentId)
    {
        try
        {
            String sqlQuery = "delete from comments where comment_id = ?;";
            PreparedStatement preparedStatement = DbUtil.getConnection().prepareStatement(sqlQuery);

            preparedStatement.setInt(1, commentId);

            int result = preparedStatement.executeUpdate();
            return result;
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
        }
        
        return 0;
    }

    public List<Comment> getComments()
    {
        List<Comment> comments = new ArrayList<>();
        try
        {
            String sqlQuery = "select * from comments;";
            Statement statement = DbUtil.getConnection().createStatement();

            ResultSet resultSet = statement.executeQuery(sqlQuery);
            
            while(resultSet.next())
            {
                comments.add(new Comment(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3), resultSet.getString(4)));
            }
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
        }

        return comments;
    }
}
