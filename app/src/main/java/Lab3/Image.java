package Lab3;

import java.util.ArrayList;
import java.util.Random;

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
    
    public void flipH() {
        if (!isCompressed()) {
            for (int i = 0; i < (width * height); i++){
                Pixel pix = pixs.get(i);
                pix.setY(height - 1 - pix.getY());
            }
        }
    }
    
    public void flipV() {
        if (!isCompressed()) {
            for (int i = 0; i < (width * height); i++){
                Pixel pix = pixs.get(i);
                pix.setX(width - 1 - pix.getX());
            }
        }
    }
    
    public void crop(int x1, int y1, int x2, int y2) {
        if (!isCompressed()){
            Pixel pix;
            int x, y;
            
            for (int i = 0; i < (width * height); i++){
                pix = pixs.get(i);
                x = pix.getX(); 
                y = pix.getY();
                
                if (x1 <= x && x <= x2){
                    if (y1 <= y && y <= y2){
                        pix.setX(x - x1);
                        pix.setY(y - y1);
                    }
                }
            }
            setWidth(x2 - x1 + 1);
            setHeight(y2 - y1 + 1);
        }
    }
    
    public Histograma histogram() {
        if (!isCompressed()){
            Histograma histo = new Histograma();
            
            if (isBitmap()){
                histo.histogramaBit(pixs);
            }
            if (isBitmap()){
                histo.histogramaBit(pixs);
            }
            if (isBitmap()){
                histo.histogramaBit(pixs);
            }
            return histo;
        }
        return null;
    }
    
    public void rgbToHex() {
        if (isPixmap() && !isCompressed()) {
            ArrayList<Pixel> pixsHex = new ArrayList<>();
            Pixrgb p;
            Pixhex pix;
            String hex;
            int[] rgb;
            
            for (int i = 0; i < (width * height); i++) {
                p = (Pixrgb) pixs.get(i);
                rgb = p.getRgb();
                hex = String.format("#%02X%02X%02X", rgb[0], rgb[1], rgb[2]);
                pix = new Pixhex(p.getX(), p.getY(), hex, p.getDepth());
                pixsHex.add(pix);
            }
            setPixs(pixsHex);
        }
    }
    
    public void crearBitmap() {
        Random rand = new Random();
        ArrayList<Pixel> pixeles = new ArrayList<>();
        Pixel pix;
        int bit, depth;
        
        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                bit = rand.nextInt(2);
                depth = rand.nextInt(10);
                pix = new Pixbit(i, j, bit, depth);
                pixeles.add(pix);
            }
        }
        
        setPixs(pixeles);
    }
    
    public void crearPixmap() {
        Random rand = new Random();
        ArrayList<Pixel> pixeles = new ArrayList<>();
        Pixel pix;
        int r, g, b, depth;
        
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                r = rand.nextInt(255);
                g = rand.nextInt(255);
                b = rand.nextInt(255);
                depth = rand.nextInt(10);
                pix = new Pixrgb(i, j, r, g, b, depth);
                pixeles.add(pix);
            }
        }
        
        setPixs(pixeles);
    }
    
    public void crearHexmap() {
        Random rand = new Random();
        ArrayList<Pixel> pixeles = new ArrayList<>();
        Pixel pix;
        String hex;
        int r, g, b, depth;
        
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                r = rand.nextInt(255);
                g = rand.nextInt(255);
                b = rand.nextInt(255);
                depth = rand.nextInt(10);
                hex = String.format("#%02X%02X%02X", r, g, b);
                pix = new Pixhex(i, j,hex, depth);
                pixeles.add(pix);
            }
        }
        
        setPixs(pixeles);
    }
    
}
