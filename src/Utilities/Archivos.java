package Utilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrador
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;

public class Archivos {

    public static void abrir(File file) {

        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);

            System.out.println("Total file size to read (in bytes) : "
                    + fis.available());

            int content;
            while ((content = fis.read()) != -1) {
                // convert to char and display it
                System.out.print((char) content);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void borrar(String Fichero) {


        File f = new File(Fichero);

        if (!f.exists()) {
            throw new IllegalArgumentException(
                    "Borrar:No existe el archivo o ale directorio: " + Fichero);
        }

        if (!f.canWrite()) {
            throw new IllegalArgumentException("Borrar:No se puede escribir "
                    + Fichero);
        }

        if (f.isDirectory()) {

            String[] files = f.list();

            if (files.length > 0) {
                throw new IllegalArgumentException(
                        "Borrar: el directorio no esta vacio " + Fichero);
            }
        }

        boolean success = f.delete();

        if (!success) {
            throw new IllegalArgumentException("Borrar: fallo al borrar");
        }
    }


    /**
     * Crea el directorio con el nombre especificado en la ruta indicada
     *
     * @param ruta Ruta dÃ³nde se crearÃ¡ el directorio (debe acabar en \o/)
     * @param nombre Nombre del directorio a crear
     */
    public void crearDirectorio(String ruta, String nombre) {
        boolean created = new File(ruta + nombre).mkdir();
        if (!created) {
            // EXCEPTION
            System.err.println("Directorio " + nombre + ", no creado.");
        }
    }

    public String[] obtenerArchivosDirectorio(String directorio, final String filtro) {
        File dir = new File(directorio);
        FilenameFilter filter = new FilenameFilter() {

            @Override
            public boolean accept(File file, String name) {
                String newFilt = filtro;
                File archivo = new File(file.getAbsolutePath() + "/" + name);
                if (newFilt.contains("*")) {
                    newFilt = newFilt.replaceAll("*", "");
                }
                return name.contains(newFilt) && archivo.isFile();
            }
        };
        return dir.list(filter);
    }

    public String[] obtenerDirectorios(String directorio) {
        File dir = new File(directorio);
        FilenameFilter filter = new FilenameFilter() {

            @Override
            public boolean accept(File file, String name) {
                return file.isDirectory();
            }
        };
        return dir.list(filter);
    }



}
