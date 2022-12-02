package Lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Clase que represanta una imagen, se compone de largo y ancho int, pixeles de
 * tipo ArrayList de Pixel y un color comprimido String
 * @author joaquin
 * @version 11.0.17
 */
public class Image_21272789_SaldiviaMonsalve implements ImageIn_21272789_SaldiviaMonsalve{
    private int width;
    private int height;
    private ArrayList<Pixel_21272789_SaldiviaMonsalve> pixs;
    private String compressedColor;
    
    public Image_21272789_SaldiviaMonsalve(int width, int height, ArrayList<Pixel_21272789_SaldiviaMonsalve> pixs) {
        this.width = width;
        this.height = height;
        this.pixs = pixs;
        this.compressedColor = "-1";
    }
    
    /**
     * Obtiene el ancho de una imagen
     * @return int
     */
    public int getWidth() {
        return width;
    }
    
    /**
     * Modifica el ancho de una imagen
     * @param width (int)
     */
    public void setWidth(int width) {
        this.width = width;
    }
    
    /**
     * Obtiene el alto de una imagen
     * @return int
     */
    public int getHeight() {
        return height;
    }
    
    /**
     * Modifica el alto de una imagen
     * @param height (int)
     */
    public void setHeight(int height) {
        this.height = height;
    }
    
    /**
     * Obtiene los pixeles de una imagen
     * @return ArrayList Pixel
     */
    public ArrayList<Pixel_21272789_SaldiviaMonsalve> getPixs() {
        return pixs;
    }
    
    /**
     * Modifica los pixeles de una imagen
     * @param pixs (ArrayList Pixel)
     */
    public void setPixs(ArrayList<Pixel_21272789_SaldiviaMonsalve> pixs) {
        this.pixs = pixs;
    }
    
    /**
     * Obtiene el color comprimido de una imagen
     * @return String
     */
    public String getCompressedColor() {
        return compressedColor;
    }
    
    /**
     * Modifica el color comprimido de una imagen
     * @param compressedColor (String)
     */
    public void setCompressedColor(String compressedColor) {
        this.compressedColor = compressedColor;
    }
    
    /**
     * Verifica si la imagen es de tipo Bitmap
     * @return Boolean
     */
    @Override
    public boolean isBitmap() {
        for (int i = 0; i < (width * height); i++){
            Pixel_21272789_SaldiviaMonsalve pix = pixs.get(i);
            String tipo = pix.getTipo();
            
            if (!tipo.equals("bit"))
                return false;
        }
        
        return true;
    }
    
    /**
     * Verifica si la imagen es de tipo Pixmap
     * @return Boolean
     */
    @Override
    public boolean isPixmap() {
        for (int i = 0; i < (width * height); i++){
            Pixel_21272789_SaldiviaMonsalve pix = pixs.get(i);
            String tipo = pix.getTipo();
            
            if (!tipo.equals("rgb"))
                return false;
        }
        
        return true;
    }
    
    /**
     * Verifica si la imagen es de tipo Hexmap
     * @return Boolean
     */
    @Override
    public boolean isHexmap() {
        for (int i = 0; i < (width * height); i++){
            Pixel_21272789_SaldiviaMonsalve pix = pixs.get(i);
            String tipo = pix.getTipo();
            
            if (!tipo.equals("hex"))
                return false;
        }
        
        return true;
    }
    
    /**
     * Verifica si la imagen esta comprimida
     * @return Boolean
     */
    @Override
    public boolean isCompressed() {
        return !compressedColor.equals("-1");
    }
    
    /**
     * Voltea la imagen horizontalmente
     */
    @Override
    public void flipH() {
        if (!isCompressed()) {
            for (int i = 0; i < (width * height); i++){
                Pixel_21272789_SaldiviaMonsalve pix = pixs.get(i);
                pix.setY(height - 1 - pix.getY());
            }
        }
    }
    
    /**
     * Voltea la imagen verticalmente
     */
    @Override
    public void flipV() {
        if (!isCompressed()) {
            for (int i = 0; i < (width * height); i++){
                Pixel_21272789_SaldiviaMonsalve pix = pixs.get(i);
                pix.setX(width - 1 - pix.getX());
            }
        }
    }
    
    /**
     * Recorta una imagen dados 2 puntos x e y
     * @param x1 (int)
     * @param y1 (int)
     * @param x2 (int)
     * @param y2 (int)
     */
    @Override
    public void crop(int x1, int y1, int x2, int y2) {
        if (!isCompressed()){
            Pixel_21272789_SaldiviaMonsalve pix;
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
    
    /**
     * Transforma una imagen Pixmap a Hexmap
     */
    @Override
    public void rgbToHex() {
        if (isPixmap() && !isCompressed()) {
            ArrayList<Pixel_21272789_SaldiviaMonsalve> pixsHex = new ArrayList<>();
            Pixrgb_21272789_SaldiviaMonsalve p;
            Pixhex_21272789_SaldiviaMonsalve pix;
            String hex;
            int[] rgb;
            
            for (int i = 0; i < (width * height); i++) {
                p = (Pixrgb_21272789_SaldiviaMonsalve) pixs.get(i);
                rgb = p.getRgb();
                hex = String.format("#%02X%02X%02X", rgb[0], rgb[1], rgb[2]);
                pix = new Pixhex_21272789_SaldiviaMonsalve(p.getX(), p.getY(), hex, p.getDepth());
                pixsHex.add(pix);
            }
            setPixs(pixsHex);
        }
    }
    
    /**
     * obtiene el color mas repetido de una imagen
     * @return Histograma
     */
    @Override
    public Histograma_21272789_SaldiviaMonsalve histogram() {
        if (!isCompressed()){
            Histograma_21272789_SaldiviaMonsalve histo = new Histograma_21272789_SaldiviaMonsalve();
            
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
    
    /**
     * rota una imagen 90 grados en sentido horario
     */
    @Override
    public void rotate90(){
        if (!isCompressed()){
            int aux;

            for (Pixel_21272789_SaldiviaMonsalve pix : pixs) {
                aux = pix.getY();
                pix.setY(pix.getX());
                pix.setX(height - 1 - aux);
            }
            aux = width;
            width = height;
            height = aux;
        }
    }
    
    /**
     * comprime la imagen en base al color mas repetido
     */
    @Override
    public void compress(){
        if (!isCompressed()){
            Histograma_21272789_SaldiviaMonsalve histo = histogram();
            ArrayList<Pixel_21272789_SaldiviaMonsalve> pixs2 = new ArrayList<>();
            
            if (isBitmap()){
                Pixbit_21272789_SaldiviaMonsalve pBit;
                int colorBit = histo.getMasRepetidoBit();
                for (Pixel_21272789_SaldiviaMonsalve pix : pixs) {
                    pBit = (Pixbit_21272789_SaldiviaMonsalve) pix;
                    if (pBit.getBit() != colorBit){
                        pixs2.add(pBit);
                    }
                }
                setPixs(pixs2);
                setCompressedColor(String.valueOf(colorBit));
            }
            if (isPixmap()){
                Pixrgb_21272789_SaldiviaMonsalve pRgb;
                int[] colorRgb = histo.getMasRepetidoRGB();
                for (Pixel_21272789_SaldiviaMonsalve pix : pixs) {
                    pRgb = (Pixrgb_21272789_SaldiviaMonsalve) pix;
                    if (pRgb.getRgb() != colorRgb){
                        pixs2.add(pRgb);
                    }
                }
                setPixs(pixs2);
                setCompressedColor(String.valueOf(colorRgb[0] + "," + colorRgb[1] + "," + colorRgb[2]));
            }
            if (isHexmap()){
                Pixhex_21272789_SaldiviaMonsalve pHex;
                String colorHex = histo.getMasRepetidoHex();
                for (Pixel_21272789_SaldiviaMonsalve pix : pixs) {
                    pHex = (Pixhex_21272789_SaldiviaMonsalve) pix;
                    if (!pHex.getHex().equals(colorHex)){
                        pixs2.add(pHex);
                    }
                }
                setPixs(pixs2);
                setCompressedColor(colorHex); 
            } else {
            }
        }
    }
    
    /**
     * Se recibe un pixel y se cambia por el que tenga la misma posicion
     * @param pMod (Pixel)
     */
    @Override
    public void changePixel(Pixel_21272789_SaldiviaMonsalve pMod){
        if (!isCompressed()){
            ArrayList<Pixel_21272789_SaldiviaMonsalve> pixs2 = new ArrayList<>();
            for (Pixel_21272789_SaldiviaMonsalve pix: pixs) {
                if (pix.getX() == pMod.getX() && pix.getY() == pMod.getY()) {
                    pixs2.add(pMod);
                }
                else {
                    pixs2.add(pix);
                }
            }
            setPixs(pixs2);
        }
    }
    
    /**
     * Invierte los colores de bit en un imagen Bitmap
     */
    @Override
    public void invertColorBit(){
        if (!isCompressed() && isBitmap()){
            Pixbit_21272789_SaldiviaMonsalve pAux;
            for (Pixel_21272789_SaldiviaMonsalve pix: pixs) {
                pAux = (Pixbit_21272789_SaldiviaMonsalve) pix;
                pAux.setBit(1 - pAux.getBit());
            }
        }
    }
    
    /**
     * Invierte los colores de rgb en un imagen Pixmap
     */
    @Override
    public void invertColorRGB(){
        if (!isCompressed() && isPixmap()){
            Pixrgb_21272789_SaldiviaMonsalve pAux;
            int[] rgb;
            for (Pixel_21272789_SaldiviaMonsalve pix: pixs) {
                pAux = (Pixrgb_21272789_SaldiviaMonsalve) pix;
                rgb = pAux.getRgb();
                rgb[0] = 255 - rgb[0];
                rgb[1] = 255 - rgb[1];
                rgb[2] = 255 - rgb[2];
                pAux.setRgb(rgb);
            }
        }
    }
    
    /**
     * Convierte una imagen a string
     * @return String
     */
    @Override
    public String imgToString(){
        if (!isCompressed()){
            String str = "";
            int cont = 0;
            Pixel_21272789_SaldiviaMonsalve pix;
            sortPixs(pixs);
            for (int i = 0; i < height; i++){
                for (int j = 0; j < width; j++) {
                    pix = pixs.get(cont);
                    str = str + pix.toString() + " ";
                    cont++;
                }
                str += "\n";
            }
            return str;
        }
        return null;
    }
    
    /**
     * Por cada profundidad diferente en la imagen se crea una imagen con
     * profundidad homogenea
     * @return ArrayList Image
     */
    @Override
    public ArrayList<Image_21272789_SaldiviaMonsalve> depthLayers(){
        if (!isCompressed()){
            ArrayList<Image_21272789_SaldiviaMonsalve> imageList = new ArrayList<>();
            ArrayList<Pixel_21272789_SaldiviaMonsalve> auxPixs = new ArrayList<>();
            ArrayList<Pixel_21272789_SaldiviaMonsalve> auxPixs2 = new ArrayList<>();
            Image_21272789_SaldiviaMonsalve auxImg;
            Pixel_21272789_SaldiviaMonsalve pix;
            int last, cont;
            
            sortDepth(pixs);
            
            for (Pixel_21272789_SaldiviaMonsalve auxPix: pixs) {
                auxPixs.add(auxPix);
            }
            
            if (isBitmap()){
                auxPixs2.add(auxPixs.get(0));
                last = auxPixs.get(0).getDepth();
                auxPixs.remove(0);
                while (!auxPixs.isEmpty()) {
                    if (last == auxPixs.get(0).getDepth()){
                        auxPixs2.add(auxPixs.get(0));
                        auxPixs.remove(0);
                    }
                    else {
                        cont = 0;
                        sortPixs(auxPixs2);
                        for(int i = 0; i < height; i++){
                            for(int j = 0; j < width; j++){
                                try{
                                    pix = auxPixs2.get(cont);
                                    if (pix.getX() == j && pix.getY() == i){
                                        cont++;
                                    }
                                    else{
                                        auxPixs2.add(new Pixbit_21272789_SaldiviaMonsalve(j, i, 1, last));
                                    }
                                }
                                catch(Exception e){
                                    auxPixs2.add(new Pixbit_21272789_SaldiviaMonsalve(j, i, 1, last));
                                }
                            }
                        }
                        last = auxPixs.get(0).getDepth();
                        auxImg = new Image_21272789_SaldiviaMonsalve(width, height, new ArrayList<>());
                        auxImg.setPixs(auxPixs2);
                        imageList.add(auxImg);
                        auxPixs2 = new ArrayList<>();
                    }
                }
                
                cont = 0;
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        pix = auxPixs2.get(cont);
                        if (pix.getX() == j && pix.getY() == i){
                            cont++;
                        }
                        else{
                            auxPixs2.add(new Pixbit_21272789_SaldiviaMonsalve(j, i, 1, last));
                        }
                    }
                }
                auxImg = new Image_21272789_SaldiviaMonsalve(width, height, new ArrayList<>());
                auxImg.setPixs(auxPixs2);
                imageList.add(auxImg);
            }
            if (isPixmap()){
                auxPixs2.add(auxPixs.get(0));
                last = auxPixs.get(0).getDepth();
                auxPixs.remove(0);
                while (!auxPixs.isEmpty()) {
                    if (last == auxPixs.get(0).getDepth()){
                        auxPixs2.add(auxPixs.get(0));
                        auxPixs.remove(0);
                    }
                    else {
                        cont = 0;
                        sortPixs(auxPixs2);
                        for(int i = 0; i < height; i++){
                            for(int j = 0; j < width; j++){
                                try{
                                    pix = auxPixs2.get(cont);
                                    if (pix.getX() == j && pix.getY() == i){
                                        cont++;
                                    }
                                    else{
                                        auxPixs2.add(new Pixrgb_21272789_SaldiviaMonsalve(j, i, 255, 255, 255, last));
                                    }
                                }
                                catch(Exception e){
                                    auxPixs2.add(new Pixrgb_21272789_SaldiviaMonsalve(j, i, 255, 255, 255, last));
                                }
                            }
                        }
                        last = auxPixs.get(0).getDepth();
                        auxImg = new Image_21272789_SaldiviaMonsalve(width, height, new ArrayList<>());
                        auxImg.setPixs(auxPixs2);
                        imageList.add(auxImg);
                        auxPixs2 = new ArrayList<>();
                    }
                }
                
                cont = 0;
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        pix = auxPixs2.get(cont);
                        if (pix.getX() == j && pix.getY() == i){
                            cont++;
                        }
                        else{
                            auxPixs2.add(new Pixrgb_21272789_SaldiviaMonsalve(j, i, 255, 255, 255, last));
                        }
                    }
                }
                auxImg = new Image_21272789_SaldiviaMonsalve(width, height, new ArrayList<>());
                auxImg.setPixs(auxPixs2);
                imageList.add(auxImg);
            }
            if (isHexmap()){
                auxPixs2.add(auxPixs.get(0));
                last = auxPixs.get(0).getDepth();
                auxPixs.remove(0);
                while (!auxPixs.isEmpty()) {
                    if (last == auxPixs.get(0).getDepth()){
                        auxPixs2.add(auxPixs.get(0));
                        auxPixs.remove(0);
                    }
                    else {
                        cont = 0;
                        sortPixs(auxPixs2);
                        for(int i = 0; i < height; i++){
                            for(int j = 0; j < width; j++){
                                try{
                                    pix = auxPixs2.get(cont);
                                    if (pix.getX() == j && pix.getY() == i){
                                        cont++;
                                    }
                                    else{
                                        auxPixs2.add(new Pixhex_21272789_SaldiviaMonsalve(j, i, "#FFFFFF", last));
                                    }
                                }
                                catch(Exception e){
                                    auxPixs2.add(new Pixhex_21272789_SaldiviaMonsalve(j, i, "#FFFFFF", last));
                                }
                            }
                        }
                        last = auxPixs.get(0).getDepth();
                        auxImg = new Image_21272789_SaldiviaMonsalve(width, height, new ArrayList<>());
                        auxImg.setPixs(auxPixs2);
                        imageList.add(auxImg);
                        auxPixs2 = new ArrayList<>();
                    }
                }
                
                cont = 0;
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        pix = auxPixs2.get(cont);
                        if (pix.getX() == j && pix.getY() == i){
                            cont++;
                        }
                        else{
                            auxPixs2.add(new Pixhex_21272789_SaldiviaMonsalve(j, i, "#FFFFFF", last));
                        }
                    }
                }
                auxImg = new Image_21272789_SaldiviaMonsalve(width, height, new ArrayList<>());
                auxImg.setPixs(auxPixs2);
                imageList.add(auxImg);
            }
           
            return imageList;
        }
        
        return null;
    }
    
    /**
     * Se toma el color comprimido y se completa la imagen en base a ese color
     * perdiendo la informacion de profundidad
     */
    @Override
    public void decompress(){
        if (isCompressed()){
            int cont = 0;
            int bit, rgb[] = new int[3];
            String hex;
            
            sortPixs(pixs);
            Pixel_21272789_SaldiviaMonsalve pix;
            if (isBitmap()){
                bit = Integer.parseInt(compressedColor);
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        pix = pixs.get(cont);
                        try{
                            if (pix.getX() == j && pix.getY() == i){
                                cont++;
                            }
                            else{
                                pixs.add(new Pixbit_21272789_SaldiviaMonsalve(j, i, bit, 10));
                            }
                        } catch(Exception e) {
                            pixs.add(new Pixbit_21272789_SaldiviaMonsalve(j, i, bit, 10));
                        }
                    }
                    
                }

                compressedColor = "-1";
            }
            if (isPixmap()){
                String[] rgbStr = compressedColor.split(",");
                rgb[0] = Integer.parseInt(rgbStr[0]);
                rgb[1] = Integer.parseInt(rgbStr[1]);
                rgb[2] = Integer.parseInt(rgbStr[2]);
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        pix = pixs.get(cont);
                        try{
                            if (pix.getX() == j && pix.getY() == i){
                                cont++;
                            }
                            else{
                                pixs.add(new Pixrgb_21272789_SaldiviaMonsalve(j, i, rgb[0], rgb[1], rgb[2], 10));
                            }
                        } catch(Exception e) {
                            pixs.add(new Pixrgb_21272789_SaldiviaMonsalve(j, i, rgb[0], rgb[1], rgb[2], 10));
                        }
                    }
                }
                compressedColor = "-1";
            }
            if (isHexmap()){
                hex = compressedColor;
                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        pix = pixs.get(cont);
                        try{
                            if (pix.getX() == j && pix.getY() == i){
                                cont++;
                            }
                            else{
                                pixs.add(new Pixhex_21272789_SaldiviaMonsalve(j, i, hex, 10));
                            }
                        } catch(Exception e) {
                            pixs.add(new Pixhex_21272789_SaldiviaMonsalve(j, i, hex, 10));
                        }
                    }
                }
                compressedColor = "-1";
            }
        }
    }
    
    /**
     * Genera una imagen aleatorea de tipo Bitmap
     */
    @Override
    public void crearBitmap() {
        Random rand = new Random();
        ArrayList<Pixel_21272789_SaldiviaMonsalve> pixeles = new ArrayList<>();
        Pixel_21272789_SaldiviaMonsalve pix;
        int bit, depth;
        
        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                bit = rand.nextInt(2);
                depth = rand.nextInt(10);
                pix = new Pixbit_21272789_SaldiviaMonsalve(i, j, bit, depth);
                pixeles.add(pix);
            }
        }
        
        setPixs(pixeles);
    }
    
    /**
     * Genera una imagen aleatorea de tipo Pixmap
     */
    @Override
    public void crearPixmap() {
        Random rand = new Random();
        ArrayList<Pixel_21272789_SaldiviaMonsalve> pixeles = new ArrayList<>();
        Pixel_21272789_SaldiviaMonsalve pix;
        int r, g, b, depth;
        
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                r = rand.nextInt(255);
                g = rand.nextInt(255);
                b = rand.nextInt(255);
                depth = rand.nextInt(10);
                pix = new Pixrgb_21272789_SaldiviaMonsalve(i, j, r, g, b, depth);
                pixeles.add(pix);
            }
        }
        
        setPixs(pixeles);
    }
    
    /**
     * Genera una imagen aleatorea de tipo Hexmap
     */
    @Override
    public void crearHexmap() {
        Random rand = new Random();
        ArrayList<Pixel_21272789_SaldiviaMonsalve> pixeles = new ArrayList<>();
        Pixel_21272789_SaldiviaMonsalve pix;
        String hex;
        int r, g, b, depth;
        
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                r = rand.nextInt(255);
                g = rand.nextInt(255);
                b = rand.nextInt(255);
                depth = rand.nextInt(10);
                hex = String.format("#%02X%02X%02X", r, g, b);
                pix = new Pixhex_21272789_SaldiviaMonsalve(i, j,hex, depth);
                pixeles.add(pix);
            }
        }
        
        setPixs(pixeles);
    }
    
    /**
     * Ordena una lista de pixeles por ancho y luego por largo
     * @param pixs (ArrayList Pixel)
     */
    @Override
    public void sortPixs(ArrayList<Pixel_21272789_SaldiviaMonsalve> pixs) {
        Collections.sort(pixs, (Pixel_21272789_SaldiviaMonsalve p, Pixel_21272789_SaldiviaMonsalve p2) -> Integer.valueOf((10*p.getY()) + p.getX()).compareTo((10*p2.getY()) + p2.getX()));
    }
    
    /**
     * Ordena una lista de pixeles por profundidad
     * @param pixs (ArrayList Pixel)
     */
    @Override
    public void sortDepth(ArrayList<Pixel_21272789_SaldiviaMonsalve> pixs){
        Collections.sort(pixs, (Pixel_21272789_SaldiviaMonsalve p, Pixel_21272789_SaldiviaMonsalve p2) -> Integer.valueOf(p.getDepth()).compareTo(p2.getDepth()));
    }
    
}
