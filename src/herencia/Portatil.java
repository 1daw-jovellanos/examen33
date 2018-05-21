
package herencia;

import java.util.Locale;

public class Portatil extends Ordenador {
    double tamanno;

    public Portatil(int memoria, String modeloCpu, double tamanno) {
        super(memoria, modeloCpu);
        this.tamanno = tamanno;
    }

    @Override
    public double getPrecioSeguro() {
        return super.getPrecioSeguro() + tamanno * 0.75; 
    }

    @Override
    public String toString() {
        return String.format(Locale.ROOT, "Portatil. Memoria: %d GB; CPU modelo %s; Tamaño: %.1f pulgadas.",
                getMemoria(), getModeloCpu(), tamanno);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Portatil other = (Portatil) obj;
        if (Math.abs(this.tamanno - other.tamanno) > 0.01 || !this.getModeloCpu().equalsIgnoreCase(other.getModeloCpu()) || this.getMemoria() != other.getMemoria()) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
    
}
