
package compiladorfinal;

/**
 *
 * @author Yeudi
 */
public class Token {
    
    String tipo, nombre, vslorString;
    int valorEntero;
    float valorFlotante;
    Boolean valorBool;

    public Token() {
        
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVslorString() {
        return vslorString;
    }

    public void setVslorString(String vslorString) {
        this.vslorString = vslorString;
    }

    public int getValorEntero() {
        return valorEntero;
    }

    public void setValorEntero(int valorEntero) {
        this.valorEntero = valorEntero;
    }

    public float getValorFlotante() {
        return valorFlotante;
    }

    public void setValorFlotante(float valorFlotante) {
        this.valorFlotante = valorFlotante;
    }

    public Boolean getValorBool() {
        return valorBool;
    }

    public void setValorBool(Boolean valorBool) {
        this.valorBool = valorBool;
    }
    
    
    
    
    
}
