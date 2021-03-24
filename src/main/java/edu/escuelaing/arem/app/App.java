package edu.escuelaing.arem.app;

import org.primefaces.json.JSONObject;
import spark.Request;
import spark.Response;

import java.net.MalformedURLException;
import java.net.URL;
import static spark.Spark.*;
import com.google.gson.Gson;
/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )  {
        port(getPort());
        Gson gson = new Gson();
        calculadora calculadora = new calculadora();
        get("/sin",(req,res) -> {
            double value = Double.parseDouble(req.queryParams("value"));
           double conexion = calculadora.seno(value);
            JSONObject obj=new JSONObject();
            obj.put("output",conexion);
            obj.put("input",value);
            obj.put("operation","sin");
            return obj;
        });

        get("/tan",(req,res) -> {
            double value = Double.parseDouble(req.queryParams("value"));
            double conexion = calculadora.tan(value);
            JSONObject obj=new JSONObject();
            obj.put("output",conexion);
            obj.put("input",value);
            obj.put("operation","tan");
            return obj;
        });

    }




    /**
     * metodo que nos retorna un puerto
     * @return entero que indica el puerto
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
