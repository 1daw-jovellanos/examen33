
package herencia;

import java.util.*;
public class ExamenH {

    public void arrobaArroba(Collection<CharSequence> coleccion) {
        for (CharSequence s : coleccion) {
            if (s.toString().equals("fin")) {
                break;
            }
            if (s instanceof StringBuilder) {
                ((StringBuilder) s).append("@@");
            }
            
        }
        
    }



    public void run() {
        // tus código de prueba aquí.
        
    }
    public static void main(String[] args) {
        new ExamenH().run();
    }
    
}
