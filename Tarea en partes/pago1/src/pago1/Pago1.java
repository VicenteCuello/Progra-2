
package pago1;

import java.util.Date;

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
public class Pago1 {

   
    public static void main(String[] args) {
        
    }
    
}
