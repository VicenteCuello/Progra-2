
package tarjeta1;

import java.util.Date;

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
public class Tarjeta1 {

    
    public static void main(String[] args) {
        
    }
    
}
