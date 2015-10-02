package com.CoursePlanner;

import javax.script.ScriptEngineManager;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import com.CoursePlanner.model.Comment;
import jdk.nashorn.api.scripting.NashornScriptEngine;

public class JSCompilerImpl {
    private NashornScriptEngine nashorn;

    public JSCompilerImpl() throws Exception {
        nashorn = (NashornScriptEngine) new ScriptEngineManager().getEngineByName("nashorn");
        nashorn.eval(read("js/nashorn-polyfill.js"));
        nashorn.eval(read("js/react.js"));
        nashorn.eval(read("js/showdown.js"));
        nashorn.eval(read("js/commentBox-babel.js"));
    }

    private Reader read(String path) {
        InputStream in = getClass().getClassLoader().getResourceAsStream(path);
        return new InputStreamReader(in);
    }

    public String renderCommentBox(List<Comment> comments) {
        try {
            Object html = nashorn.invokeFunction("renderServer", comments);
            return String.valueOf(html);
        }
        catch (Exception e) {
            throw new IllegalStateException("failed to render react component", e);
        }
    }
}
