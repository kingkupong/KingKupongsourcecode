/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.imgscalr.Scalr;

/**
 *
 * @author Mushi
 */
public class Imagen {

    final static int ANCHO = 100;
    final static int ALTO = 100;

    private static BufferedImage cargar(String url) throws IOException {
        return (ImageIO.read(new File(url)));

    }

    public static String guardarPNG(String url) throws IOException {
        BufferedImage image = cargar(url);
        BufferedImage newBufferedImage = new BufferedImage(image.getWidth(),
                image.getHeight(), BufferedImage.TYPE_INT_RGB);
        newBufferedImage.createGraphics().drawImage(image, 0, 0, Color.WHITE, null);
        // Escribir en png
        System.out.println(url);
        String[] split=url.split("\\.");
        url = split[0] + ".png";
        ImageIO.write(newBufferedImage, "png", new File(url));
        return url;
    }

    public static String guardarJPG(String url) throws IOException {
        BufferedImage image=cargar(url);
        BufferedImage newBufferedImage = new BufferedImage(image.getWidth(),
                image.getHeight(), BufferedImage.TYPE_INT_RGB);
        newBufferedImage.createGraphics().drawImage(image, 0, 0, Color.WHITE, null);
        // write to jpeg file
        url = url.split("\\.")[0] + ".jpg";
        ImageIO.write(newBufferedImage, "jpg", new File(url));
        return url;
    }

    public static String resizeImage(String url) throws IOException {
        String extension;
        BufferedImage image =cargar(url);
        BufferedImage thumbnail = Scalr.resize(image, Scalr.Method.SPEED, Scalr.Mode.FIT_TO_WIDTH,
                ANCHO, ALTO, Scalr.OP_ANTIALIAS);
        extension = url.split("\\.")[1];
        url = url.split("\\.")[0] + "thumb." + extension;
        ImageIO.write(thumbnail, extension, new File(url));
        return url;
    }
}
