
package tarea;
import java.util.ArrayList;

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
}
class DetalleOrden{
    private ArrayList <Articulo> a;
    private int cantidad;
    private int i;
    public DetalleOrden(){
        a = new ArrayList <Articulo>();
    }
    public void addArticulo(Articulo r){
        a.add(r);
        
    }
    public Articulo calcPrecio(){
        float total = 0;
        for(i=0; i< a.size();i++){
            total= a.get(i).getPrecio() + total;
        }
    }
        
 }

public class Tarea {

    
    public static void main(String[] args) {
        
    }
    
}
