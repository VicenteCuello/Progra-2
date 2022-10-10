
package doctri.pkg1;
import java.util.ArrayList;
import java.util.Date;

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
public class Doctri1 {

    
    public static void main(String[] args) {
        
    }
    
}
