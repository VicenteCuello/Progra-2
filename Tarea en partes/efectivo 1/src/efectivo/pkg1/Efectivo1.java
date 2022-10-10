
package efectivo.pkg1;

import java.util.Date;

class Efectivo extends Pago{
    public Efectivo(float m,Date f){
        super(m,f,1);
    }
    public String toStringPago(){
        return "Pago con Efectivo: "+super.getPago()+"\nFecha: "+super.getFecha()+"\n";
    }
    
}
public class Efectivo1 {

    
    public static void main(String[] args) {
        
    }
    
}
