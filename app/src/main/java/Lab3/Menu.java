package Lab3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Clase que representa un menu, se compone de 1 Scanner, 1 boolean, 1 Image,
 * 1 int
 * @author joaquin
 * @version 11.0.17
 */
public class Menu_21272789_SaldiviaMonsalve {
    private Scanner input;
    private boolean on;
    private int opcion;
    private Image_21272789_SaldiviaMonsalve imagen;

    public Menu_21272789_SaldiviaMonsalve() {
        this.input = new Scanner(System.in);
        this.on = true;
        this.opcion = 0;
        this.imagen = new Image_21272789_SaldiviaMonsalve(5, 4, new ArrayList<>());
        this.imagen.crearBitmap();
    }

    /**
     * Pide un input de tipo int
     */
    public void pedirOpcion() {
        int eleccion = input.nextInt();
        this.opcion = eleccion;
    }
    
    /**
     * Mantiene funcionando el menu
     */
    public void iniciador() {
        while(on) {
            inicio();
            switch(opcion) {
                case 1:
                    crearImagen();
                    break;
                case 2:
                    try{
                        imagen.getWidth(); // se verifica existencia de imagen
                        modificadores();
                    } 
                    catch (Exception e){
                        System.out.println("No se ha creado una imagen\n");
                    }
                    break;
                case 3:
                    try{
                        System.out.println(imagen.imgToString());
                    } 
                    catch (Exception e){
                        System.out.println("No se ha creado una imagen\n");
                    }
                    break;
                case 4:
                    on = false;
                    break;
                default:
                    System.out.println("Opcion invalida\n");
                    break;
            }
        }
    }
    
    /**
     * Imprime el inicio
     */
    public void inicio() {
        String inicio = 
                "### Manipulador de imagenes ###\n" +
                "Escoja su opcion:\n" +
                "1. Crear una imagen\n" +
                "2. Operaciones de imagen\n" +
                "3. Visualizar imagen\n" + 
                "4. Terminar programa\n";
        
        System.out.println(inicio);
        System.out.print("INTRODUZCA SU OPCION: ");
        pedirOpcion();
        System.out.println("");
    }
    
    /**
     * Imprime el menu de eleccion de tipo de imagen
     */
    public void crearImagen() {
        String imagenes = 
                "### Manipulador de imagenes ###\n" +
                "Escoja su opcion:\n" +
                "1. Crear una Bitmap\n" +
                "2. Crear una Pixmap\n" +
                "3. Crear una Hexmap\n" + 
                "4. Volver\n";
        
        System.out.println(imagenes);
        System.out.print("INTRODUZCA SU OPCION: ");
        pedirOpcion();
        System.out.println("");
        
        if (opcion != 4) {
            String crear = 
                    "### Manipulador de imagenes ###\n" +
                    "Ingrese las dimensiones:";
            String largo = "Largo: ", ancho = "Ancho: ";
            int w, l;
            
            System.out.println(crear);
            System.out.print(ancho);
            w = input.nextInt();
            System.out.print(largo);
            l = input.nextInt();
            System.out.println("");
            imagen = new Image_21272789_SaldiviaMonsalve(w, l, new ArrayList<>());
        }
        
        switch (opcion) {
            case 1:
                crearBitmap();
                break;
            case 2:
                crearPixmap();
                break;
            case 3:
                crearHexmap();
                break;
            case 4:
                inicio();
                break;
            default:
                System.out.println("Opcion invalida");
                break;
        }
        
    }
    
    /**
     * Imprime mensaje para crear Bitmap
     */
    public void crearBitmap() {
        String pixeles = 
                    "### Manipulador de imagenes ###\n" +
                    "1. Pixeles Manuales\n" + 
                    "2. Pixeles Automaticos\n" + 
                    "3. Volver\n";
        
        System.out.println(pixeles);
        System.out.print("INTRODUZCA SU OPCION: ");
        pedirOpcion();
        System.out.println("");
        
        switch (opcion) {
            case 1:
                ArrayList<Pixel_21272789_SaldiviaMonsalve> pixs = new ArrayList<>();
                Pixel_21272789_SaldiviaMonsalve pix;
                String pixel = "pixbit ";
                String posX = "Ingresar X: ";
                String posY = "Ingresar Y: ";
                String colorBit = "Ingresar Valor Bit: ";
                String depth = "Ingresar Profundidad: ";
                int x, y, bit, d;
                
                for(int i = 0; i < imagen.getWidth() * imagen.getHeight(); i++) {
                        System.out.println(pixel + (1 + i));
                        System.out.print(posX);
                        x = input.nextInt();
                        System.out.print(posY);
                        y = input.nextInt();
                        System.out.print(colorBit);
                        bit = input.nextInt();
                        System.out.print(depth);
                        d = input.nextInt();
                        System.out.println();
                        pix = new Pixbit_21272789_SaldiviaMonsalve(x, y, bit, d);
                        pixs.add(pix);
                }
                
                imagen.setPixs(pixs);
                break;
            case 2:
                imagen.crearBitmap();
                break;
            case 3:
                crearImagen();
                break;
            default:
                System.out.println("Opcion invalida");
                break;
        }
    }
    
    /**
     * Imprime mensaje para crear Pixmap
     */
    public void crearPixmap() {
        String pixeles = 
                    "### Manipulador de imagenes ###\n" +
                    "1. Pixeles Manuales\n" + 
                    "2. Pixeles Automaticos\n" + 
                    "3. Volver\n";
        
        System.out.println(pixeles);
        System.out.print("INTRODUZCA SU OPCION: ");
        pedirOpcion();
        System.out.println("");
        
        switch (opcion) {
            case 1:
                ArrayList<Pixel_21272789_SaldiviaMonsalve> pixs = new ArrayList<>();
                Pixel_21272789_SaldiviaMonsalve pix;
                String pixel = "pixrgb ";
                String posX = "Ingresar X: ";
                String posY = "Ingresar Y: ";
                String colorR = "Ingresar Valor R: ";
                String colorG = "Ingresar Valor G: ";
                String colorB = "Ingresar Valor B: ";
                String depth = "Ingresar Profundidad: ";
                int x, y, r, g, b, d;
                
                for(int i = 0; i < imagen.getWidth() * imagen.getHeight(); i++) {
                        System.out.println(pixel + (1 + i));
                        System.out.print(posX);
                        x = input.nextInt();
                        System.out.print(posY);
                        y = input.nextInt();
                        System.out.print(colorR);
                        r = input.nextInt();
                        System.out.print(colorG);
                        g = input.nextInt();
                        System.out.print(colorB);
                        b = input.nextInt();
                        System.out.print(depth);
                        d = input.nextInt();
                        System.out.println();
                        pix = new Pixrgb_21272789_SaldiviaMonsalve(x, y, r, g, b, d);
                        pixs.add(pix);
                }
                
                imagen.setPixs(pixs);
                break;
            case 2:
                imagen.crearPixmap();
                break;
            case 3:
                crearImagen();
                break;
            default:
                System.out.println("Opcion invalida");
                break;
        }
    }
    
    /**
     * Imprime mensaje para crear Hexmap
     */
    public void crearHexmap() {
        String pixeles = 
                    "### Manipulador de imagenes ###\n" +
                    "1. Pixeles Manuales\n" + 
                    "2. Pixeles Automaticos\n" + 
                    "3. Volver\n";
        
        System.out.println(pixeles);
        System.out.print("INTRODUZCA SU OPCION: ");
        pedirOpcion();
        System.out.println("");
        
        switch (opcion) {
            case 1:
                ArrayList<Pixel_21272789_SaldiviaMonsalve> pixs = new ArrayList<>();
                Pixel_21272789_SaldiviaMonsalve pix;
                String pixel = "pixhex ";
                String posX = "Ingresar X: ";
                String posY = "Ingresar Y: ";
                String colorHex = "Ingresar Valor Hex: ";
                String depth = "Ingresar Profundidad: ";
                int x, y, d;
                String hex;
                
                for(int i = 0; i < imagen.getWidth() * imagen.getHeight(); i++) {
                        System.out.print(pixel + (1 + i));
                        System.out.println(posX);
                        x = input.nextInt();
                        System.out.print(posY);
                        y = input.nextInt();
                        System.out.print(colorHex);
                        hex = input.nextLine();
                        System.out.print(depth);
                        d = input.nextInt();
                        pix = new Pixhex_21272789_SaldiviaMonsalve(x, y, hex, d);
                        pixs.add(pix);
                }
                
                imagen.setPixs(pixs);
                break;
            case 2:
                imagen.crearHexmap();
                break;
            case 3:
                crearImagen();
                break;
            default:
                System.out.println("Opcion invalida");
                break;
        }
    }
    
    /**
     * Imprime mensaje de modificadores de imagen
     */
    public void modificadores() {
        String metodos = 
                "### Manipulador de imagenes ###\n" +
                "Escoja su opcion:\n" +
                "1. Verificar Bitmap\n" +
                "2. Verificar Pixmap\n" +
                "3. Verificar Hexmap\n" +
                "4. Aplicar FlipH\n" +
                "5. Aplicar FlipV\n" +
                "6. Aplicar Crop\n" +
                "7. Ver Histograma\n" +
                "8. Aplicar Rotate90\n" +
                "9. Aplicar Compress\n" +
                "10 Cambiar un Pixel\n" +
                "11 Invertir Color Bit\n" +
                "12 Invertir Color RGB\n" +
                "13 Aplicar DepthLayers\n" +
                "14 Aplicar Decompress\n" +
                "15. Volver\n";
        
        System.out.println(metodos);
        System.out.print("INTRODUZCA SU OPCION: ");
        pedirOpcion();
        System.out.println("");
        
        switch (opcion) {
            case 1:
                System.out.println(imagen.isBitmap() + "\n");
                break;
            case 2:
                System.out.println(imagen.isPixmap() + "\n");
                break;
            case 3:
                System.out.println(imagen.isHexmap() + "\n");
                break;
            case 4:
                imagen.flipH();
                System.out.println("flipH aplicado" + "\n");
                break;
            case 5:
                imagen.flipV();
                System.out.println("flipV aplicado" + "\n");
                break;
            case 6:
                int x1, y1, x2, y2;
                
                System.out.print("INTRODUZCA X1:");
                x1 = input.nextInt();
                
                System.out.print("INTRODUZCA Y1:");
                y1 = input.nextInt();
                
                System.out.print("INTRODUZCA X2:");
                x2 = input.nextInt();
                
                System.out.print("INTRODUZCA Y2:");
                y2 = input.nextInt();
                
                imagen.crop(x1,y1,x2,y2);
                System.out.println("crop aplicado" + "\n");
                break;
            case 7: 
                Histograma_21272789_SaldiviaMonsalve histo = imagen.histogram();
                if(imagen.isBitmap()){
                        System.out.print("El color mas repetido es: " + histo.getMasRepetidoBit());
                        System.out.println(" y se repetite: " + histo.getCont() + " Veces\n");
                }
                if(imagen.isPixmap()){
                        System.out.print("El color mas repetido es: " + Arrays.toString(histo.getMasRepetidoRGB()));
                        System.out.println(" y se repetite: " + histo.getCont() + " Veces\n");
                }
                if(imagen.isHexmap()){
                        System.out.print("El color mas repetido es: " + histo.getMasRepetidoHex());
                        System.out.println(" y se repetite: " + histo.getCont() + " Veces\n");
                }
            case 8: 
                imagen.rotate90();
                System.out.println("rotate90 aplicado" + "\n");
                break;
            case 9:
                imagen.compress();
                System.out.println("compress aplicado" + "\n");
                break;
            case 10:
                int x, y, bit, depth, r, g, b;
                String hex;
                
                System.out.print("Ingrese X: ");
                x = input.nextInt();
                System.out.print("Ingrese Y: ");
                y = input.nextInt();
                if(imagen.isBitmap()){
                        System.out.print("Ingrese Bit: ");
                        bit = input.nextInt();
                        System.out.print("Ingrese Profundidad: ");
                        depth = input.nextInt();
                        imagen.changePixel(new Pixbit_21272789_SaldiviaMonsalve(x, y ,bit, depth));
                }
                if(imagen.isPixmap()){
                    System.out.print("Ingrese R: ");
                    r = input.nextInt();
                    System.out.print("Ingrese G: ");
                    g = input.nextInt();
                    System.out.print("Ingrese B: ");
                    b = input.nextInt();
                    System.out.print("Ingrese Profundidad: ");
                    depth = input.nextInt();
                    imagen.changePixel(new Pixrgb_21272789_SaldiviaMonsalve(x, y , r, g, b, depth));
                }
                if(imagen.isHexmap()){
                    System.out.print("Ingrese Hex: ");
                    hex = input.nextLine();
                    System.out.print("Ingrese Profundidad: ");
                    depth = input.nextInt();
                    imagen.changePixel(new Pixhex_21272789_SaldiviaMonsalve(x, y ,hex, depth));
                }
                System.out.println("changePixel aplicado" + "\n");
                break;
            case 11:
                imagen.invertColorBit();
                System.out.println("inverColorBit aplicado" + "\n");
                break;
            case 12:
                imagen.invertColorRGB();
                System.out.println("inverColorRGB aplicado" + "\n");
                break;
            case 13:
                ArrayList<Image_21272789_SaldiviaMonsalve> imageList = imagen.depthLayers();
                for (Image_21272789_SaldiviaMonsalve imgAux: imageList){
                    System.out.println(imgAux.imgToString());
                }
                System.out.println("\ndepthLayers aplicado" + "\n");
                break;
            case 14:
                imagen.decompress();
                System.out.println("decompress aplicado" + "\n");
                break;
            case 15:
                System.out.println(imagen.isCompressed() + "\n");
                break; 
            case 16:
                inicio();
                break; 
            default:
                System.out.println("Opcion invalida");
                break;
        }
    }
    
}
