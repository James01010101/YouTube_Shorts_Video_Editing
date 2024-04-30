

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.font.GlyphVector;

import com.main.TextObject;

public class Test {
    public static void main(String[] args) {
        // Create a BufferedImage with desired width and height
        int[] screenSize = new int[]{1080, 1920};
        BufferedImage introImage = new BufferedImage(screenSize[0], screenSize[1], BufferedImage.TYPE_INT_ARGB);

        // Get the Graphics2D object from the BufferedImage
        Graphics2D g2d = introImage.createGraphics();

        // Improve rendering quality
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);


        // draw background
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, screenSize[0], screenSize[1]);


        TextObject quickText = new TextObject("Quick", "Arial", 100, new int[]{0, 150}, Color.YELLOW, 20, 900, -15);
        TextObject howWellText = new TextObject("How Well Do You Know", "Arial", 100, new int[]{0, 300}, Color.BLUE, 20, 900, -15);

        // load in my background image
        BufferedImage backgroundImage = null;
        try {
            backgroundImage = ImageIO.read(new File("backend/database/topics/AOT/5/S4 P1_3.jpeg"));
        } catch (Exception e) {
            throw new RuntimeException("Failed to read the image file", e);
        }
        g2d.drawImage(backgroundImage, 0, 0, null);


        // Set the font and color of the text
        quickText.ApplyGraphics(g2d, screenSize);
        howWellText.ApplyGraphics(g2d, screenSize);


        /*
        // Convert text to shape
        GlyphVector gv = font.createGlyphVector(g2d.getFontRenderContext(), text);
        Shape textShape = gv.getOutline(x, y);

        // Draw the outline
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Set the outline thickness
        g2d.draw(textShape);

         // Draw the main text over the outline
        g2d.setColor(Color.RED); // Main text color
        g2d.drawString(text, x, y);
        */


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