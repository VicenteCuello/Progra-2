
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
    public float calcPrecio(){
        float total = 0;
        for(i=0; i< a.size();i++){
            total= a.get(i).getPrecio() + total;
        }
        return total;
    }
    public float calcPeso(){
        float total = 0;
        for(i=0; i< a.size();i++){
            total= a.get(i).getPeso() + total;
        }
        return total;
    }
    public float calcPrecioSinIVA(){
        float total = 0;
        for(i=0; i< a.size();i++){
            total= (a.get(i).getPeso()/100)*19 + total;
        }
        return total;
    }
    public float calcIVA(){
        float total = 0;
        total = calcPeso() + calcPrecioSinIVA();
        return total;
    }
}
class Cliente{
    private String nombre;
    private String rut;
    public Cliente(String name, String run){
        nombre = name;
        run = rut;
    }
    
}
class Direccion{
    private String direccion;
    public Direccion(String dir){
        direccion = dir;
    }
}
class DocTributario{
    private String numero;
    private String rut;
    privte Date fecha;
}

public class Tarea {

    
    public static void main(String[] args) {
        
    }
    
}
