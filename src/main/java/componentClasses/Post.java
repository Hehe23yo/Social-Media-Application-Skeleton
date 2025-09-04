package componentClasses;

public class Post
{
    private int postId;
    private int userId;
    private String postContent;

    public Post(int postId, int userId, String postContent)
    {
        this.postId = postId;
        this.userId = userId;
        this.postContent = postContent;
    }

    public int getPostId()
    {
        return postId;
    }

    public int getUserId()
    {
        return userId;
    }

    public String getPostContent()
    {
        return postContent;
    }
}