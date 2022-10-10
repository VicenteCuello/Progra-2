
package ordencompra1;

import java.util.ArrayList;
import java.util.Date;

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
public class Ordencompra1 {

    
    public static void main(String[] args) {
        
    }
    
}
