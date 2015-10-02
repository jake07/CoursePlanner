package courseplanner.services;

import java.util.ArrayList;
import java.util.List;

import courseplanner.model.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private ArrayList<Comment> comments;

    public CommentService() {
        comments = new ArrayList<Comment>();
        comments.add(new Comment("Peter Parker", "This is a comment."));
        comments.add(new Comment("John Doe", "This is *another* comment."));
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Comment> addComment(Comment comment) {
        comments.add(comment);
        return comments;
    }
}
