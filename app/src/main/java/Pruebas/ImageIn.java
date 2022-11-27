package Pruebas;

import java.util.ArrayList;

public interface ImageIn {
    
    boolean isBitmap();
    
    boolean isPixmap();
    
    boolean isHexmap();
    
    boolean isCompressed();
    
    void flipH();
    
    void flipV();
    
    void crop(int x1, int y1, int x2, int y2);
    
    void rgbToHex();
    
    Histograma histogram();
    
    void rotate90();
    
    void compress();

    void changePixel(Pixel pMod);

    void invertColorBit();

    void invertColorRGB();

    String imgToString();

    ArrayList<Image> depthLayers();

    void decompress();

    void crearBitmap();

    void crearPixmap();

    void crearHexmap();
    
    void sortPixs(ArrayList<Pixel> pixs);
    
    void sortDepth(ArrayList<Pixel> pixs);
}
