 package Pruebas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Image implements ImageIn{
    private int width;
    private int height;
    private ArrayList<Pixel> pixs;
    private String compressedColor;
    
    public Image(int width, int height, ArrayList<Pixel> pixs) {
        this.width = width;
        this.height = height;
        this.pixs = pixs;
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
    
    @Override
    public boolean isBitmap() {
        for (int i = 0; i < (width * height); i++){
            Pixel pix = pixs.get(i);
            String tipo = pix.getTipo();
            
            if (!tipo.equals("bit"))
                return false;
        }
        
        return true;
    }
    
    @Override
    public boolean isPixmap() {
        for (int i = 0; i < (width * height); i++){
            Pixel pix = pixs.get(i);
            String tipo = pix.getTipo();
            
            if (!tipo.equals("rgb"))
                return false;
        }
        
        return true;
    }
    
    @Override
    public boolean isHexmap() {
        for (int i = 0; i < (width * height); i++){
            Pixel pix = pixs.get(i);
            String tipo = pix.getTipo();
            
            if (!tipo.equals("hex"))
                return false;
        }
        
        return true;
    }
    
    @Override
    public boolean isCompressed() {
        return !compressedColor.equals("-1");
    }
    
    @Override
    public void flipH() {
        if (!isCompressed()) {
            for (int i = 0; i < (width * height); i++){
                Pixel pix = pixs.get(i);
                pix.setY(height - 1 - pix.getY());
            }
        }
    }
    
    @Override
    public void flipV() {
        if (!isCompressed()) {
            for (int i = 0; i < (width * height); i++){
                Pixel pix = pixs.get(i);
                pix.setX(width - 1 - pix.getX());
            }
        }
    }
    
    @Override
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
    
    @Override
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
    
    @Override
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
    
    @Override
    public void rotate90(){
        if (!isCompressed()){
            int aux;

            for (Pixel pix : pixs) {
                aux = pix.getY();
                pix.setY(pix.getX());
                pix.setX(height - 1 - aux);
            }
            aux = width;
            width = height;
            height = aux;
        }
    }
    
    @Override
    public void compress(){
        if (!isCompressed()){
            Histograma histo = histogram();
            ArrayList<Pixel> pixs2 = new ArrayList<>();
            
            if (isBitmap()){
                Pixbit pBit;
                int colorBit = histo.getMasRepetidoBit();
                for (Pixel pix : pixs) {
                    pBit = (Pixbit) pix;
                    if (pBit.getBit() != colorBit){
                        pixs2.add(pBit);
                    }
                }
                setPixs(pixs2);
                setCompressedColor(String.valueOf(colorBit));
            }
            if (isPixmap()){
                Pixrgb pRgb;
                int[] colorRgb = histo.getMasRepetidoRGB();
                for (Pixel pix : pixs) {
                    pRgb = (Pixrgb) pix;
                    if (pRgb.getRgb() != colorRgb){
                        pixs2.add(pRgb);
                    }
                }
                setPixs(pixs2);
                setCompressedColor(String.valueOf(colorRgb[0] + "," + colorRgb[1] + "," + colorRgb[2]));
            }
            if (isHexmap()){
                Pixhex pHex;
                String colorHex = histo.getMasRepetidoHex();
                for (Pixel pix : pixs) {
                    pHex = (Pixhex) pix;
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
    
    @Override
    public void changePixel(Pixel pMod){
        if (!isCompressed()){
            ArrayList<Pixel> pixs2 = new ArrayList<>();
            for (Pixel pix: pixs) {
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
    
    @Override
    public void invertColorBit(){
        if (!isCompressed() && isBitmap()){
            Pixbit pAux;
            for (Pixel pix: pixs) {
                pAux = (Pixbit) pix;
                pAux.setBit(1 - pAux.getBit());
            }
        }
    }
    
    @Override
    public void invertColorRGB(){
        if (!isCompressed() && isPixmap()){
            Pixrgb pAux;
            int[] rgb;
            for (Pixel pix: pixs) {
                pAux = (Pixrgb) pix;
                rgb = pAux.getRgb();
                rgb[0] = 255 - rgb[0];
                rgb[1] = 255 - rgb[1];
                rgb[2] = 255 - rgb[2];
                pAux.setRgb(rgb);
            }
        }
    }
    
    @Override
    public String imgToString(){
        if (!isCompressed()){
            String str = "";
            int cont = 0;
            Pixel pix;
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
    
    @Override
    public ArrayList<Image> depthLayers(){
        if (!isCompressed()){
            ArrayList<Image> imageList = new ArrayList<>();
            ArrayList<Pixel> auxPixs;
            ArrayList<Pixel> auxPixs2 = new ArrayList<>();
            Image auxImg;
            Pixel pix;
            int last, cont;
            
            sortDepth(pixs);
            auxPixs = (ArrayList<Pixel>) pixs.clone();
            
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
                                        auxPixs2.add(new Pixbit(j, i, 1, last));
                                    }
                                }
                                catch(Exception e){
                                    auxPixs2.add(new Pixbit(j, i, 1, last));
                                }
                            }
                        }
                        last = auxPixs.get(0).getDepth();
                        auxImg = new Image(width, height, new ArrayList<>());
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
                            auxPixs2.add(new Pixbit(j, i, 1, last));
                        }
                    }
                }
                auxImg = new Image(width, height, new ArrayList<>());
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
                                        auxPixs2.add(new Pixrgb(j, i, 255, 255, 255, last));
                                    }
                                }
                                catch(Exception e){
                                    auxPixs2.add(new Pixrgb(j, i, 255, 255, 255, last));
                                }
                            }
                        }
                        last = auxPixs.get(0).getDepth();
                        auxImg = new Image(width, height, new ArrayList<>());
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
                            auxPixs2.add(new Pixrgb(j, i, 255, 255, 255, last));
                        }
                    }
                }
                auxImg = new Image(width, height, new ArrayList<>());
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
                                        auxPixs2.add(new Pixhex(j, i, "#FFFFFF", last));
                                    }
                                }
                                catch(Exception e){
                                    auxPixs2.add(new Pixhex(j, i, "#FFFFFF", last));
                                }
                            }
                        }
                        last = auxPixs.get(0).getDepth();
                        auxImg = new Image(width, height, new ArrayList<>());
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
                            auxPixs2.add(new Pixhex(j, i, "#FFFFFF", last));
                        }
                    }
                }
                auxImg = new Image(width, height, new ArrayList<>());
                auxImg.setPixs(auxPixs2);
                imageList.add(auxImg);
            }
           
            return imageList;
        }
        
        return null;
    }
    
    @Override
    public void decompress(){
        if (isCompressed()){
            int cont = 0;
            int bit, rgb[] = new int[3];
            String hex;
            
            sortPixs(pixs);
            Pixel pix;
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
                                pixs.add(new Pixbit(j, i, bit, 10));
                            }
                        } catch(Exception e) {
                            pixs.add(new Pixbit(j, i, bit, 10));
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
                                pixs.add(new Pixrgb(j, i, rgb[0], rgb[1], rgb[2], 10));
                            }
                        } catch(Exception e) {
                            pixs.add(new Pixrgb(j, i, rgb[0], rgb[1], rgb[2], 10));
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
                                pixs.add(new Pixhex(j, i, hex, 10));
                            }
                        } catch(Exception e) {
                            pixs.add(new Pixhex(j, i, hex, 10));
                        }
                    }
                }
                compressedColor = "-1";
            }
        }
    }
    
    @Override
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
    
    @Override
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
    
    @Override
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
    
    @Override
    public void sortPixs(ArrayList<Pixel> pixs) {
        Collections.sort(pixs, (Pixel p, Pixel p2) -> Integer.valueOf((10*p.getY()) + p.getX()).compareTo((10*p2.getY()) + p2.getX()));
    }
    
    @Override
    public void sortDepth(ArrayList<Pixel> pixs){
        Collections.sort(pixs, (Pixel p, Pixel p2) -> Integer.valueOf(p.getDepth()).compareTo(p2.getDepth()));
    }
    
}
