import io.javalin.Javalin;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;


public class Main {

    // this will be where my settings json object is stored but i wont know what one it is until i select the topic and quiz
    private static Map<String, Object> settings = null;



    public static void main(String[] args) {
        // create the app that the frontend will connect to
        Javalin app = Javalin.create(config -> {
            config.defaultContentType = "text/plain";
            config.enableCorsForAllOrigins(); // This will help in frontend-backend communication
        }).start(7001);

        System.out.println("\nServer started at PORT 7001");

        // create me editor
        Editor editor = new Editor();

        
        // go through and create all of my routes
        configureBasicRoutes(app);
        configureEditorRoutes(app);


        
    }

    private static void configureBasicRoutes(Javalin app) {
        app.get("/", ctx -> ctx.result("Welcome to the homepage!"));
        app.get("/about", ctx -> ctx.result("About us page content here."));

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


    private static void loadQuizSettings(String topicShort, int quiz_num) {
        // load settings file and return is as a hashmap (json)
        ObjectMapper mapper = new ObjectMapper();

        String filePath = "database/topics/" + topicShort + "/" + quiz_num + "/Settings.json";
        try {
            settings = mapper.readValue(new File(filePath), HashMap.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void configureEditorRoutes(Javalin app) {
        app.get("/{topicShort}/{quiz_num}/load_intro_settings", ctx -> {
            String topicShort = ctx.pathParam("topicShort");
            int quiz_num = Integer.parseInt(ctx.pathParam("quizNum"));

            loadQuizSettings(topicShort, quiz_num);
        });
    }
}