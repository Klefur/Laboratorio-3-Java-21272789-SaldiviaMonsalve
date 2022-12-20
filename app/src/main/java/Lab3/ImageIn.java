package Lab3;

import java.util.ArrayList;

public interface ImageIn_21272789_SaldiviaMonsalve {
    
    boolean isBitmap();
    
    boolean isPixmap();
    
    boolean isHexmap();
    
    boolean isCompressed();
    
    void flipH();
    
    void flipV();
    
    void crop(int x1, int y1, int x2, int y2);
    
    void rgbToHex();
    
    Histograma_21272789_SaldiviaMonsalve histogram();
    
    void rotate90();
    
    void compress();

    void changePixel(Pixel_21272789_SaldiviaMonsalve pMod);

    void invertColorBit();

    void invertColorRGB();

    String imgToString();

    ArrayList<Image_21272789_SaldiviaMonsalve> depthLayers();

    void decompress();

    void crearBitmap();

    void crearPixmap();

    void crearHexmap();
    
    void sortPixs(ArrayList<Pixel_21272789_SaldiviaMonsalve> pixs);
    
    void sortDepth(ArrayList<Pixel_21272789_SaldiviaMonsalve> pixs);
}
