package componentClasses;

public class Comment
{
    private int commentId;
    private int postId;
    private int userId;
    private String commentContent;

    public Comment(int commentId, int postId, int userId, String commentContent)
    {
        this.commentId = commentId;
        this.postId = postId;
        this.userId = userId;
        this.commentContent = commentContent;
    }

    public int getCommentId()
    {
        return commentId;
    }

    public int getPostId()
    {
        return postId;
    }

    public int getUserId()
    {
        return userId;
    }

    public String getCommentContent()
    {
        return commentContent;
    }
}