package courseplanner.controllers;

import java.util.List;

import courseplanner.model.Comment;
import courseplanner.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments.json")
public class CommentController {

    @Autowired
    private CommentService commentService;

    public CommentController() {}

    @RequestMapping(method = RequestMethod.GET)
    public List<Comment> getComments() {
        return commentService.getComments();
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<Comment> addComment(Comment comment) {
        return commentService.addComment(comment);
    }
}
