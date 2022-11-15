/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab3;

import java.util.ArrayList;

/**
 *
 * @author joaquin
 */
public class Image {
    private int width;
    private int height;
    private ArrayList<Pixel> pixs;
    private String compressedColor;
    
    public Image(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixs = new ArrayList<>();
        this.compressedColor = "-1";
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ArrayList<Pixel> getPixs() {
        return pixs;
    }

    public void setPixs(ArrayList<Pixel> pixs) {
        this.pixs = pixs;
    }

    public String getCompressedColor() {
        return compressedColor;
    }

    public void setCompressedColor(String compressedColor) {
        this.compressedColor = compressedColor;
    }
    
    public boolean isBitmap() {
        for (int i = 0; i < (width * height); i++){
            Pixel pix = pixs.get(i);
            String tipo = pix.getTipo();
            
            if (!tipo.equals("bit"))
                return false;
        }
        
        return true;
    }
    
    public boolean isPixmap() {
        for (int i = 0; i < (width * height); i++){
            Pixel pix = pixs.get(i);
            String tipo = pix.getTipo();
            
            if (!tipo.equals("rgb"))
                return false;
        }
        
        return true;
    }
    
    public boolean isHexmap() {
        for (int i = 0; i < (width * height); i++){
            Pixel pix = pixs.get(i);
            String tipo = pix.getTipo();
            
            if (!tipo.equals("hex"))
                return false;
        }
        
        return true;
    }
    
    public boolean isCompressed() {
        return !compressedColor.equals("-1");
    }
    
}
