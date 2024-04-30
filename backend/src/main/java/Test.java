

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import com.main.TextObject;

public class Test {
    public static void main(String[] args) {
        // Create a BufferedImage with desired width and height
        int width = 1080;
        int height = 1920;
        BufferedImage introImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        // Get the Graphics2D object from the BufferedImage
        Graphics2D g2d = introImage.createGraphics();

        // draw background
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, width, height);


        TextObject quickText = new TextObject("Quick", "Arial", 50, new float[]{100.0f, 100.0f}, Color.BLUE);
        TextObject howWellText = new TextObject("How Well Do You Know", "Arial", 50, new float[]{300.0f, 100.0f}, Color.RED);

        // load in my background image
        BufferedImage backgroundImage = null;
        try {
            backgroundImage = ImageIO.read(new File("backend/database/topics/AOT/5/S4 P1_3.jpeg"));
        } catch (Exception e) {
            throw new RuntimeException("Failed to read the image file", e);
        }
        g2d.drawImage(backgroundImage, 0, 0, null);





        // Set the font and color of the text
        g2d = quickText.ApplyGraphics(g2d);
        g2d = howWellText.ApplyGraphics(g2d);


        // Dispose the Graphics2D object
        g2d.dispose();

        // Save the BufferedImage as a PNG file
        File outputFile = new File("output.png");
        try {
            ImageIO.write(introImage, "PNG", outputFile);
            System.out.println("Image saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving image: " + e.getMessage());
        }
    }
}