package Pruebas;

import java.util.Arrays;

public class Pixrgb extends Pixel {
    private int[] rgb;

    public Pixrgb(int x, int y,int r, int g, int b, int depth) {
        super(x, y, depth);
        this.rgb = new int[3];
        
        if(0<= r && r <= 255){
            this.rgb[0] = r;
        }
        else {
            this.rgb[0] = 255;
        }
        
        if(0<= g && g <= 255){
            this.rgb[1] = g;
        }
        else {
            this.rgb[1] = 255;
        
        }if(0<= b && b <= 255){
            this.rgb[2] = b;
        }
        else {
            this.rgb[2] = 255;
        }
        setTipo("rgb");
    }

    public int[] getRgb() {
        return rgb;
    }

    public void setRgb(int[] rgb) {
        this.rgb = rgb;
    }

    @Override
    public String toString() {
        return Arrays.toString(rgb);
    }
       
    
}
