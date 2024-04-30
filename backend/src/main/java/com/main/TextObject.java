package com.main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// here ill create all of the text i need and allows me to modify it as i need

public class TextObject {
    private String text;
    private String fontname;
    private Font font;
    private int size;
    private float[] position;
    private Color colour;


    public TextObject(String text, String font, int size, float[] position, Color colour) {
        this.text = text;
        this.fontname = font;
        this.size = size;
        this.position = position;
        this.colour = colour;

        this.font = new Font(this.fontname, Font.PLAIN, this.size);
    }



    // getters and setters
    public String GetText() {
        return text;
    }
    public void SetText(String newText) {
        text = newText;
    }

    public int GetSize() {
        return size;
    }
    public void SetSize(int newSize) {
        size = newSize;
    }

    public float[] GetPosition() {
        return position;
    }
    public void SetPosition(float[] newPosition) {
        position = newPosition;
    }



    // this will set the graphics render with all of the settings for this text
    // like colour and position and everything
    public Graphics2D ApplyGraphics(Graphics2D g2d) {
        g2d.setFont(font);
        g2d.setColor(colour);
        g2d.drawString(text, position[0], position[1]);

        return g2d;
    }
    
}