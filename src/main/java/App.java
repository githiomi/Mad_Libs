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
    }
}
