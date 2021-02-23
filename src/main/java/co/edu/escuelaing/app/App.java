package co.edu.escuelaing.app;
import java.io.IOException;

import co.edu.escuelaing.app.HttpServer.HttpServer;
/**
 * Clase principal encargada de llevar a cabo la ejecucion de todo el programa.
 * @author  Alejandro Toro Daza
 * @version 1.0.  (4 de Febrero del 2021) 
 */
public class App {
	/**
     * Metodo principal main que se encarga del funcionamiento de toda la clase App.
     * @param args Parametro que indica la lista de los elementos a evaluar.
     */
    public static void main( String[] args ) {
       
        HttpServer server = new HttpServer();
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
