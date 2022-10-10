
package detallaorden1;

import java.util.ArrayList;
import java.util.Date;



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
public class Detallaorden1 {
    
    public static void main(String[] args) {
        
    }
    
}
