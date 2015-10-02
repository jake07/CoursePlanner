package com.CoursePlanner.controllers;

import java.util.List;
import java.util.Map;

import com.CoursePlanner.JSCompilerImpl;
import com.CoursePlanner.model.Comment;
import com.CoursePlanner.services.CommentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class DemoController {

    private JSCompilerImpl jsCompiler;

    @Autowired
    private CommentService commentService;

    @Autowired
    private ObjectMapper mapper;

    public DemoController() throws Exception {
        jsCompiler = new JSCompilerImpl();
    }

    @RequestMapping(value = "/index")
    public String index(Map<String, Object> model) throws Exception {
        List<Comment> comments = commentService.getComments();
        String commentBox = jsCompiler.renderCommentBox(comments);
        String data = mapper.writeValueAsString(comments);
        model.put("content", commentBox);
        model.put("data", data);
        return "index";
    }
}
