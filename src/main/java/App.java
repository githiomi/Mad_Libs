import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main (String[] args){
        String layout = "/templates/layout.vtl";

        get("/", (request, response) -> {
            Map<String, Object> formLayout = new HashMap<String, Object>();
            formLayout.put("template", "templates/form.vtl");
            return new ModelAndView(formLayout, layout);
        }, new VelocityTemplateEngine());

        get("/story", (request, response) ->{
            Map<String, Object> storyShow = new HashMap<String, Object>();
            storyShow.put("person1", request.queryParams("person1"));
            storyShow.put("person2", request.queryParams("person2"));
            storyShow.put("animal", request.queryParams("animal"));
            storyShow.put("exclamation", request.queryParams("exclamation"));
            storyShow.put("verb", request.queryParams("verb"));
            storyShow.put("noun", request.queryParams("noun"));
            storyShow.put("template", "templates/story.vtl");
            return new ModelAndView(storyShow, layout);
        }, new VelocityTemplateEngine());
    }
}
