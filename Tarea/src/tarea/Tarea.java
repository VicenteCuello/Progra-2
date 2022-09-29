
package tarea;
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
        rut = run;
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
    private Date fecha;
    
    public DocTributario(String num, String run, Date f){
        numero = num;
        rut = run;
        fecha = f;
    }
}
class Pago{
    private float monto;
    private Date fecha;
    
    public Pago(float m, Date f){
        monto = m;
        fecha = f;
    }
    public float getPago(){
        return monto;
    }
    
}
class Efectivo extends Pago{
    public Efectivo(float m,Date f){
        super(m,f);
    }
    public float calcDevolucion(float p){
        if(getPago() <= p){
            p = p - getPago();
            
        }
        else if(p < getPago()){
            p = 0;
        }
        return p;
    }
}
class Transferencia extends Pago{
    private String banco;
    private String numCuenta;
    public Transferencia(float m,Date f, String b,String nc){
        super(m,f);
        banco = b;
        numCuenta = nc;
    }
    
}
class Tarjeta extends Pago{
    private String tipo;
    private String numTransaccion;
    public Tarjeta(float m,Date f, String b,String nc){
        super(m,f);
        tipo = b;
        numTransaccion = nc;
    }
}
class Boleta extends DocTributario{
    
}
class Factura extends DocTributario{
    
}
        
        
public class Tarea {

    
    public static void main(String[] args) {
        
    }
    
}
