
package herencia;

public class Ordenador {
    private int memoria; // Memoria principal, en GB
    private String modeloCpu; // Modelo de CPU

    public Ordenador(int memoria, String modeloCpu) {
        this.memoria = memoria;
        this.modeloCpu = modeloCpu;
    }

    public String getModeloCpu() {
        return modeloCpu;
    }

    public void setModeloCpu(String modeloCpu) {
        this.modeloCpu = modeloCpu;
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }
    
    /**
     * Devuelve el precio de la prima del seguro contra roturas por dos años
     * que ofrece la tienda
     * @return precio del seguro en euros.
     */
    
    public double getPrecioSeguro() {
        return 40 + memoria * 2;
    }
}
