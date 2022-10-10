
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
    public String toString(){
        return "Nombre:"+nombre+"\nDescripcion:"+descripcion+"\nPeso:"+peso+"\nPrecio:"+precio+"\n";
    }
}
class DetalleOrden{
    private Articulo art;
    private int cantidad;
    private float totala;
    private float totalb;
    private float totalc;
    private float totald;
    public DetalleOrden(int c, Articulo objeto){
       cantidad = c;
       art = objeto;
    }
    private ArrayList <Articulo> a;
    public DetalleOrden(){
       a = new ArrayList <Articulo>();
        
    }
     public void addArticulo(Articulo x){
        a.add(x);
    }
    public float calcPrecio(){
        float total1 = 0;
        for(int i=0; i< a.size();i++){
            total1+= a.get(i).getPrecio() + a.get(i).getPrecio()*0.19;
        }
        totala = total1;
        return total1;
    }
    public float calcPrecioSinIVA(){
        float total3 = 0;
        for(int i=0; i< a.size();i++){
            total3+= a.get(i).getPrecio() ;
        }
        totalb = total3;
        return total3;
    }
    public float calcIVA(){
        float total4 = 0;
        for(int i = 0; i<a.size(); i++){
            total4 += a.get(i).getPrecio()*0.19 ;
        }
        totalc = total4;
        return total4;
    }
    public float calcPeso(){
        float total2 = 0;
        for(int i=0; i< a.size();i++){
            total2= a.get(i).getPeso() + total2;
        }
        totald= total2;
        return total2;
    }
    public String toString(){
        String detalle = "";
        for(int i = 0; i<a.size(); i++){
            detalle += a.get(i).toString()+"\n";
        }
        detalle += "Precio (Sin IVA):"+totalb+"\nIva:"+totalc+"\nPeso Total:"+totald+"\nPrecio final:"+totala+"\n";
        return detalle;
    }
    
}
class OrdenCompra{
    private Date fecha;
    private String estado;
    private ArrayList <DetalleOrden> detord;
    private DocTributario dt;
    private ArrayList <Pago> p;
    private Cliente usuario;
    private Direccion dir;
    private Boleta bol;
    private Factura fact;
    private float total;
    private float deuda;
    private int cant;
    private float totala;
    private float totalb;
    private float totalc;
    private float totald;
    private float pag = 0;
    private float vue = 0;
    public OrdenCompra(Date f,Cliente c,DocTributario d,Direccion di){
        detord = new ArrayList<>();
        p = new ArrayList<>();
        fecha = f;
        usuario = c;
        dt = d;
        dir = di;
        estado = "En proceso";
        pag = (float)0;
    }
    public void addDetalleOrden(DetalleOrden n){
        detord.add(n);
    }
    public void addPago(Pago x){
        if(pag < totala){
            p.add(x);
            pag =x.getPago()+pag;
        }if(pag >= totala){
            if(x.getTipoPago()==1){
                vue = x.calcDevolucion(pag,totala);
            }
            else{
              pag = totala;  
            }
            estado = "Pagado";
           
        }
    }
    public float calcPrecio(){
        float total1 = 0;
        for(int i=0; i< detord.size();i++){
            total1+= detord.get(i).calcPrecio() + detord.get(i).calcPrecio()*0.19;
        }
        totala = total1;
        return total1;
    }
    public float calcPrecioSinIVA(){
        float total3 = 0;
        for(int i=0; i< detord.size();i++){
            total3+= detord.get(i).calcPrecio() ;
        }
        totalb= total3;
        return total3;
    }
    public float calcIVA(){
        float total4 = 0;
        for(int i = 0; i<detord.size(); i++){
            total4 += detord.get(i).calcPrecio()*0.19 ;
        }
        totalc= total4;
        return total4;
    }
    public float calcPeso(){
        float total2 = 0;
        for(int i=0; i< detord.size();i++){
            total2= detord.get(i).calcPeso() + total2;
        }
        totald= total2;
        return total2;
    }
    public String toStringOrdenCompra(){
        String n = "";
        n += usuario.toString()+"\n";
        n += dir.toString()+"\n";
        n += dt.toString();
        n += "Estado: "+estado+"\n";
        n += "Fecha: "+fecha+"\n";
        n += "Lista de Pagos: \n";
        for(int i = 0; i < p.size(); i++){
            n += p.get(i).toStringPago()+"\n";
        }
        for(int i = 0; i < detord.size(); i++){
            n += "Detalle de Orden numero " + (i+1)+"\n";
            n += detord.get(i).toString()+"\n";
        }
        n += "Precio total: " + totala+"\nPagado:"+pag+"\nVuelto: "+vue+"\nTotal (Sin IVA): "+totalb+"\nIVA total pagado: "+totalc+"\nPeso Total: "+totald+"\n";
        return n;
    }
}
class Cliente{
    private String nombre;
    private String rut;
    public Cliente(String name, String run){
        nombre = name;
        rut = run;
    }
    public String getNombre(){
        return nombre;
    }
    public String getRut(){
        return rut;
    }
    public String toString(){
        return "Nombre: "+nombre+",\nRut: "+rut+"\n";
    }
    
}
class Direccion{
    private String direccion;
    public Direccion(String dir){
        direccion = dir;
    }
    public String toString(){
        return "Direccion:"+direccion+"\n";
    }
}
class DocTributario{
    private String numero;
    private String rut;
    private Date fecha;
    private int tdoc;
    public DocTributario(String num, String run, Date f,int t){
        numero = num;
        rut = run;
        fecha = f;
        tdoc = t;
    }  
    public String getNumero(){
        return numero;
    }
    public String getRut(){
        return rut;
    }
    public Date getFecha(){
        return fecha;
    }
    public String toString(){
        if(tdoc==1){
          return "Boleta\nNumero:"+numero+"\nRUT:"+rut+"\nFecha: "+fecha+"\n";    
        }
        if(tdoc==2){
          return "Factura\nNumero:"+numero+"\nRUT:"+rut+"\nFecha: "+fecha+"\n";    
        }
        return "";
    }
    
    
}
abstract class Pago{
    private float monto;
    private Date fecha;
    private int tipa;
    public Pago(float m, Date f,int tp){
        monto = m;
        fecha = f;
        tipa = tp;
    }
    public float getPago(){
        return monto;
    }
    public Date getFecha(){
        return fecha;
    }
    public int getTipoPago(){
        return tipa;
    }
    public float calcDevolucion(float d,float p){
        if(p<d){
            return d-p;
            
        }
        else{
            return 0;
        }
        
    }
    abstract public String toStringPago();
}
class Efectivo extends Pago{
    public Efectivo(float m,Date f){
        super(m,f,1);
    }
    public String toStringPago(){
        return "Pago con Efectivo: "+super.getPago()+"\nFecha: "+super.getFecha()+"\n";
    }
    
}
class Transferencia extends Pago{
    private String banco;
    private String numCuenta;
    public Transferencia(float m,Date f, String b,String nc){
        super(m,f,2);
        banco = b;
        numCuenta = nc;
    }
    public String toStringPago(){
        return "Pago por Transferencia: "+super.getPago()+"\nFecha: "+super.getFecha()+"\nBanco:"+banco+"Numero de Cuenta:"+numCuenta+"\n";
    }
    
}
class Tarjeta extends Pago{
    private String tipo;
    private String numTransaccion;
    public Tarjeta(float m,Date f, String b,String nc){
        super(m,f,3);
        tipo = b;
        numTransaccion = nc;
    }
    public String toStringPago(){
        return "Pago con Tarjeta"+super.getPago()+"\nFecha:"+super.getFecha()+"\nTipo de tarjeta:"+tipo+"\nNumero de Transaccion:"+numTransaccion+"\n";
    }
}
class Boleta extends DocTributario{
    public Boleta(String num, String run, Date f){
        super(num,run,f,1);
    }
}
class Factura extends DocTributario{
    public Factura(String num, String run, Date f){
        super(num,run,f,2);
    }
    
}
        
        
public class Tarea {
    
    public static void main(String[] args) {
        Articulo a1 = new Articulo(5, "Juguete", "Juguete para niños", 19990);
        Articulo a2 = new Articulo(1, "Polera", "Polera Nike", 9990);
        Articulo a3 = new Articulo(1, "Chocolate", "Cholate de 350g", 1990);
        Articulo a4 = new Articulo(6, "Sabanas", "Sabanas para cama de dos plazas", 24990);
        Articulo a5 = new Articulo(2, "Autito", "Autito de juguete coleccionable", 4990);
        Cliente c1 = new Cliente("Alexis Sanchez", "16.927.586-6");
        Cliente c2 = new Cliente("Arturo Vidal", "16.713.130-1");
        Boleta b = new Boleta("0002","16.927.586-6", new Date());
        Factura f = new Factura("0003","16.713.130-1", new Date());
        Direccion d1 = new Direccion("Marseilla");
        Direccion d2 = new Direccion("Sao Paulo");
        DetalleOrden do1 = new DetalleOrden();
        do1.addArticulo(a1);
        do1.addArticulo(a2);
        do1.addArticulo(a3);
        do1.addArticulo(a4);
        do1.addArticulo(a5);
        do1.calcPrecio();
        do1.calcPrecioSinIVA();
        do1.calcIVA();
        do1.calcPeso();
        DetalleOrden do2 = new DetalleOrden();
        do2.addArticulo(a1);
        do2.addArticulo(a1);
        do2.addArticulo(a3);
        do2.addArticulo(a3);
        do2.addArticulo(a5);
        do2.calcPrecio();
        do2.calcPrecioSinIVA();
        do2.calcIVA();
        do2.calcPeso();
        DetalleOrden do3 = new DetalleOrden();
        do3.addArticulo(a2);
        do3.addArticulo(a2);
        do3.addArticulo(a4);
        do3.addArticulo(a4);
        do3.addArticulo(a1);
        do3.calcPrecio();
        do3.calcPrecioSinIVA();
        do3.calcIVA();
        do3.calcPeso();
        OrdenCompra o1 = new OrdenCompra(new Date(), c1, b, d1);
        o1.addDetalleOrden(do1);
        o1.addDetalleOrden(do2);
        o1.calcPrecio();
        o1.calcPrecioSinIVA();
        o1.calcIVA();
        o1.calcPeso();
        OrdenCompra o2 = new OrdenCompra(new Date(), c2, f, d2);
        o2.addDetalleOrden(do3);
        o2.calcPrecio();
        o2.calcPrecioSinIVA();
        o2.calcIVA();
        o2.calcPeso();
        Tarjeta t1 = new Tarjeta(100000, new Date(),"Debito", "2353253253523");
        Tarjeta t2 = new Tarjeta(100000, new Date(),"Debito", "2353253253524");
        Tarjeta t3 = new Tarjeta(100000, new Date(),"Debito", "2353253253525");
        Tarjeta t4 = new Tarjeta(100000, new Date(),"Debito", "2353253253526");
        Tarjeta t5 = new Tarjeta(100000, new Date(),"Debito", "2353253253527");
        Tarjeta t6 = new Tarjeta(100000, new Date(),"Debito", "2353253253528");
        o1.addPago(t1);
        o1.addPago(t2);
        o1.addPago(t3);
        o1.addPago(t4);
        o1.addPago(t5);
        o1.addPago(t6);
        Efectivo e = new Efectivo(500000, new Date());
        o2.addPago(e);
        o2.addPago(e);
        o2.addPago(e);
        o2.addPago(e);
        System.out.println(o1.toStringOrdenCompra()+"\n"+o2.toStringOrdenCompra());
    }
    
}
