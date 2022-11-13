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
}
