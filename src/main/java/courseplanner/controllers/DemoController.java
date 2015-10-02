package courseplanner.controllers;

import java.util.List;
import java.util.Map;

import courseplanner.JSCompilerImpl;
import courseplanner.model.Comment;
import courseplanner.services.CommentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    private JSCompilerImpl jsCompiler;

    @Autowired
    private CommentService commentService;

    @Autowired
    private ObjectMapper mapper;

    public DemoController() throws Exception {
        jsCompiler = new JSCompilerImpl();
        jsCompiler.polyfillToNashorn()
                .loadFromClassPath("js/react.js")
                .loadFromClassPath("js/showdown.js")
                .loadFromClassPath("js/commentBox-babel.js");
    }

    @RequestMapping(value = "/")
    public String index(Map<String, Object> model) throws Exception {
        List<Comment> comments = commentService.getComments();
        //String commentBox = jsCompiler.invokeFunction("renderServer", String::valueOf, comments);
        String data = mapper.writeValueAsString(comments);
        //model.put("content", commentBox);
        model.put("data", data);
        return "index";
    }
}
