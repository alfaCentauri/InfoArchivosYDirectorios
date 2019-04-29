/*
 * InfoArchivosYDirectorios.java
 */
package infoarchivosydirectorios;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Programa para obtener información de un archivo o directorio. Uso de la 
 * libreria java.nio.files.* .
 * @author Ingeniero Ricardo Presilla ricardopresilla@gmail.com.
 * @version 1.0.
 */
public class InfoArchivosYDirectorios {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException Excepción de entrada y salida.
     */
    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escriba el nombre del archivo o directorio:");
        // crear objeto Path con base en la entrada del usuario
        Path ruta = Paths.get(entrada.nextLine());
        if (Files.exists(ruta)){ 
        /* si la ruta existe, mostrar en pantalla información sobre ella */
        // mostrar información de archivo (o directorio)
            System.out.printf("%n%s existe%n", ruta.getFileName());
            System.out.printf("%s un directorio%n",
            Files.isDirectory(ruta) ? "Es" : "No es");
            System.out.printf("%s una ruta absoluta%n",
            ruta.isAbsolute() ? "Es" : "No es");
            System.out.printf("Fecha de ultima modificacion: %s%n",
            Files.getLastModifiedTime(ruta));
            System.out.printf("Tamanio: %s%n", Files.size(ruta));
            System.out.printf("Ruta: %s%n", ruta);
            System.out.printf("Ruta absoluta: %s%n", ruta.toAbsolutePath());
            if (Files.isDirectory(ruta)){ /* Imprime en pantalla el listado del directorio */
                System.out.printf("%nContenido del directorio:%n");
                // objeto para iterar a través del contenido de un directorio
                DirectoryStream<Path> flujoDirectorio = Files.newDirectoryStream(ruta);
                for (Path p : flujoDirectorio)
                    System.out.println(p);
            }
        }
        else{//No es archivo o directorio, imprimir en pantalla mensaje de error
            System.out.printf("%s no existe%n", ruta);
        }
    }
    
}
