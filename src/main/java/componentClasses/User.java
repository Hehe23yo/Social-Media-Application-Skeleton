package componentClasses;

public class User
{
    private int userId;
    private String userName;
    private String userPassword;

    public User(int userId, String userName, String userPassword)
    {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public int getUserId()
    {
        return userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public String getUserPassword()
    {
        return userPassword;
    }
}