package co.edu.escuelaing.app.PicoSpark;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import co.edu.escuelaing.app.HttpServer.HttpServer;
/**Esta clase permite simular un framework muy pequeño y guardar sus funciones lambda
 * @author Jonathan Paez
 * @version 1.0.  
 */
public class PicoSpark {
    private static Map<String, String> functions = new HashMap<>();
    /**
     * Este metodo se encarga de consultar y devolver las funciones lambda
     * @param key .
     * @return Retorna todos los lambda.
     */
    public static String get(String key){
        if(functions.containsKey(key)){
            return functions.get(key);
        }
        return null;
    }
    /**
     * Metodo post que se de asignar los valores al hash.
     * @param value metodo que retorna el valor.
     * @param key valor del get.
     */
    public static void post(String key, String value){
        functions.put(key,value);
    }
    /**
     * Metodo post que se encargar de establecer una comunicacion con el servidor.
     */
	public void startServer()
	{
		HttpServer.startServer();
	}
}
