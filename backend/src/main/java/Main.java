import io.javalin.Javalin;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;



public class Main {
    public static void main(String[] args) {
        // create the app that the frontend will connect to
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



        // TODO: #4 Attach this to the database when i get it working instead of this temp data
        app.get("/get_all_topics", ctx -> {
            List<String[]> topics = new ArrayList<>();

            topics.add(new String[]{"TWD", "The Walking Dead"});
            topics.add(new String[]{"AOT", "Attack On Titan"});
            topics.add(new String[]{"Fortnite", "Fortnite"});
            topics.add(new String[]{"Horizon", "Horizon"});
            topics.add(new String[]{"Invincible", "Invincible"});
            topics.add(new String[]{"JJK", "Jujutsu Kaisen"});
            topics.add(new String[]{"MCU", "Marvel Cinematic Universe"});
            topics.add(new String[]{"Star Wars", "Star Wars"});
            topics.add(new String[]{"TLOU", "The Last Of Us"});

            // set the data to be sent
            ctx.json(topics);

            // debug message to know what was done
            System.out.println("Sending topics data to frontend");
        });
       
    }
}