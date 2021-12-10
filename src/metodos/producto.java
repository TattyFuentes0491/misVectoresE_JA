
package metodos;

public class producto {

    int codP;
    String nomP;
    float precioU;

    public producto(int codP, String nomP, float precioU) {
        this.codP = codP;
        this.nomP = nomP;
        this.precioU = precioU;
    }

    public int getCodP() {
        return codP;
    }

    public String getNomP() {
        return nomP;
    }

    public float getPrecioU() {
        return precioU;
    }

    public void setCodP(int codP) {
        this.codP = codP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public void setPrecioU(float precioU) {
        this.precioU = precioU;
    }

}
