import io.javalin.Javalin;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;



public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.defaultContentType = "text/plain";
            config.enableCorsForAllOrigins(); // This will help in frontend-backend communication
        }).start(7001);

        System.out.println("\nServer started at http://localhost:7001/");
        
        // go through and create all of my routes
        configureRoutes(app);

        
    }

    private static void configureRoutes(Javalin app) {
        app.get("/", ctx -> ctx.result("Welcome to the homepage!"));
        app.get("/about", ctx -> ctx.result("About us page content here."));

        app.get("/get_name", ctx -> {
            Map<String, Object> person = new HashMap<>();
            person.put("Name", "James");
            person.put("Age", 21);

            List<String> interests = new ArrayList<>();
            interests.add("Football");
            interests.add("Reading");
            interests.add("Gaming");

            person.put("Interests", interests);

            // set the data to be sent
            ctx.json(person);

            // debug message to know what was done
            System.out.println("Sending person data to frontend: " + person);
        });
       
    }
}