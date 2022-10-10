
package cliente.pkg1;
import java.util.ArrayList;
import java.util.Date;

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
public class Cliente1 {

    
    public static void main(String[] args) {
        
    }
    
}
