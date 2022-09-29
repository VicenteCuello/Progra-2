
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
    public DetalleOrden(int c){
       cantidad = c;
       a = new ArrayList <Articulo>();
        
    }
    
    public float calcPrecio(){
        float total1 = 0;
        for(int i=0; i< a.size();i++){
            total1= a.get(i).getPrecio() + total1;
        }
        return total1;
    }
    public float calcPrecioSinIVA(){
        float total3 = 0;
        for(int i=0; i< a.size();i++){
            total3= (a.get(i).getPeso()/100)*19 + total3;
        }
        return total3;
    }
    public float calcIVA(){
        float total4;
        total4 = calcPeso() + calcPrecioSinIVA();
        return total4;
    }
    public float calcPeso(){
        float total2 = 0;
        for(int i=0; i< a.size();i++){
            total2= a.get(i).getPeso() + total2;
        }
        return total2;
    }
}
class OrdenCompra{
    private Date fecha;
    private String estado;
    private DetalleOrden d;
    private DocTributario dt;
    private Pago p;
    
    public OrdenCompra(Date f,String e,DetalleOrden de){
        fecha = f;
        estado = e;
        d = de;
    }
    public float calcPrecioSinIVA(){
        return d.calcPrecioSinIVA();
    }
    public float calcIVA(){
        return d.calcIVA();
    }
    public float calcPrecio(){
        return d.calcPrecio();
    }
    public float calcPeso(){
        return d.calcPeso();
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
    public Boleta(String num, String run, Date f){
        super(num,run,f);
    }
}
class Factura extends DocTributario{
    public Factura(String num, String run, Date f){
        super(num,run,f);
    }
    
}
        
        
public class Tarea {
    
    public static void main(String[] args) {
        
    }
    
}
