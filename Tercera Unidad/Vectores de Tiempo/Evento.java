/**
 * @author Luis Jumbo
 * @Curso 6to "A"
 * @Fecha 15/07/2022
 */
public class Evento {
    private String nombre;
    private int[] valor = new int[3];
    private int posicion;
    private String causalidadDesdeEvento;
    private String causalidadHastaEvento;

    Evento() {
    }

    Evento(String nombre, int posicion, String causalidadDesdeEvento, String causalidadHastaEvento) {
        this.nombre = nombre;
        this.posicion = posicion - 1;
        this.causalidadDesdeEvento = causalidadDesdeEvento;
        this.causalidadHastaEvento = causalidadHastaEvento;
    }

    Evento(String nombre, int posicion) {
        this.nombre = nombre;
        this.posicion = posicion - 1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int[] getValor() {
        return valor;
    }

    public void setValor(int[] valor) {
        this.valor = valor;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPeso(int posicion) {
        this.posicion = posicion;
    }

    public String getCausalidadDesdeEvento() {
        return causalidadDesdeEvento;
    }

    public void setCausalidadDesdeEvento(String causalidadDesdeEvento) {
        this.causalidadDesdeEvento = causalidadDesdeEvento;
    }

    public String getCausalidadHastaEvento() {
        return causalidadHastaEvento;
    }

    public void setCausalidadHastaEvento(String causalidadHastaEvento) {
        this.causalidadHastaEvento = causalidadHastaEvento;
    }

    @Override
    public String toString() {
        return "[" + this.valor[0] + ", " + this.valor[1] + ", " + this.valor[2] + "]";
    }
}
