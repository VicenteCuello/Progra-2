
package transferencia.pkg1;

import java.util.Date;

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
public class Transferencia1 {

    
    public static void main(String[] args) {
        
    }
    
}
