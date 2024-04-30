package com.main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// here ill create all of the text i need and allows me to modify it as i need

public class TextObject {
    private String text; // text to write
    private String fontname; // fonts name
    private Font font; // actual font object
    private int size; // size of the text
    private int[] positionOffset; // this is an offset from center xy
    private Color colour; // colour of the main text
    private int thickness; // thickness of the black border around the text
    private int maxCharWidth; // width in pixels before the text wraps onto a new line
    private int interlineOffset; // offset between lines of text

    public TextObject(String text, String font, int size, int[] positionOffset, Color colour, int thickness, int maxCharWidth, int interlineOffset) {
        this.text = text;
        this.fontname = font;
        this.size = size;
        this.positionOffset = positionOffset; 
        this.colour = colour;
        this.thickness = thickness;
        this.maxCharWidth = maxCharWidth;
        this.interlineOffset = interlineOffset;


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

    public int[] GetPositionOffset() {
        return positionOffset;
    }
    public void SetPositionOffset(int[] newPositionOffset) {
        positionOffset = newPositionOffset;
    }



    // this will set the graphics render with all of the settings for this text
    // like colour and position and everything
    public void ApplyGraphics(Graphics2D g2d, int[] screenSize) {
        /* PARAMS
        g2d: Graphics2D object
        text: The text to draw
        font: The font to use
        xOffset: The x offset from the center
        yOffset: The y offset from the center
        thickness: The thickness of the black border line
        interlineOffset: The offset between lines
        maxCharWidth: The max size before text is wrapped (in pixels) onto a new line
        screenSize: The screen size
        */
        FontMetrics fm = g2d.getFontMetrics();
        int lineHeight = fm.getHeight();
        String[] words = text.split(" ");
        StringBuilder line = new StringBuilder();
        Shape textShape = null;
        String textToPrint = "";

        int centeredX = 0;
        lineHeight += interlineOffset; // adjust the interline from what is chosen
        g2d.setFont(font);

        int yPosition = positionOffset[1];

        for (String word : words) {
            String nextLine = line.toString() + " " + word;
            if (fm.stringWidth(nextLine.trim()) > maxCharWidth) {
                textToPrint = line.toString().trim();
                centeredX = ((screenSize[0] - fm.stringWidth(textToPrint)) / 2) + positionOffset[0];
                textShape = font.createGlyphVector(g2d.getFontRenderContext(), textToPrint).getOutline(centeredX, yPosition);

                // Draw the outline
                g2d.setColor(Color.BLACK);
                g2d.setStroke(new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Set the outline thickness
                g2d.draw(textShape);

                g2d.setColor(colour);
                g2d.drawString(textToPrint, centeredX, yPosition);


                line = new StringBuilder(word + " ");
                yPosition += lineHeight;
            } else {
                line.append(word).append(" ");
            }
        }

        //TODO: #14 if text doesnt wrap it is incorrectly centered on x axis
        if (line.length() > 0) {
            textToPrint = line.toString().trim();
            centeredX = ((screenSize[0] - fm.stringWidth(textToPrint)) / 2) + positionOffset[0];
            textShape = font.createGlyphVector(g2d.getFontRenderContext(), textToPrint).getOutline(centeredX, yPosition);
            
            System.out.println(textToPrint + centeredX);

            // Draw the outline
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); // Set the outline thickness
            g2d.draw(textShape);

            g2d.setColor(colour);
            g2d.drawString(textToPrint, centeredX, yPosition);
        }
    }
}