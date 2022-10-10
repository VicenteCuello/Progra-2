
package articulo1;
import java.util.ArrayList;
import java.util.Date;

class Articulo{
    private float peso;
    private String nombre;
    private String descripcion;
    private float precio;
    public Articulo(float p,String n,String d,float pr){
        peso = p;
        nombre = n;
        descripcion=d;
        precio =  pr;
    }
    public float getPeso(){
        return peso;
    }
    public float getPrecio(){
        return precio;
    }
    public String toString(){
        return "Nombre:"+nombre+"\nDescripcion:"+descripcion+"\nPeso:"+peso+"\nPrecio:"+precio+"\n";
    }
}
public class Articulo1 {

    
    public static void main(String[] args) {
        
    }
    
}
