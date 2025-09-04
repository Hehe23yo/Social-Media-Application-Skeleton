<html>
    <head>
        <meta charset="UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>HOME</h1>
        
        <%@ page import="java.util.List" %>
        <%@ page import="componentClasses.Post" %>
        <%@ page import="componentClasses.Comment" %>
        <%@ page import="dbManagers.PostsDBManager" %>
        <%@ page import="dbManagers.CommentsDBManager" %>
        <%@ page import="dbManagers.UserDBManager" %>
        
        <%
            UserDBManager userManager = new UserDBManager();
            PostsDBManager postManager = new PostsDBManager();
            CommentsDBManager commentManager = new CommentsDBManager();
        %>

        <form action="createPost.jsp">
            <input type="submit" value="Create Post">
        </form>

        <table border collapse>
        <tr>
            <% 
                List<Post> posts = postManager.getPosts();
                for(int i = posts.size() - 1; i >= 0; i--)
                { 
            %>      <h3> <%= userManager.getUserName((posts.get(i)).getUserId()) %></h3>
                    <p>
                        <%= (posts.get(i)).getPostContent() %>
                    </p>
                    <br>
                    <tr border collapse>
                    <%
                        List<Comment> comments = commentManager.getComments();
                        for(int j = comments.size() - 1; j >= 0; j--)
                        {
                    %>      
                            <% 
                                if(comments.get(j).getPostId() == posts.get(i).getPostId())
                                {
                            %>
                                    <p>
                                        <%= (comments.get(j)).getCommentContent() %>
                                    </p>
                            <% } %>
                    <% } %>

                    <form action="addComment" method="post">
                        <input type="text" name="commentContent" required>
                        <input type="hidden" name="postId" value="<%= (posts.get(i)).getPostId() %>">
                        <input type="submit" value="comment">
                    </form>
                    </tr>
            <%  } %>
        </tr>
        </table>
    </body>
</html>