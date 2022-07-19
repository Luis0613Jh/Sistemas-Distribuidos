/**
 * @author Luis Jumbo
 * @Curso 6to "A"
 * @Fecha 15/07/2022
 */
public class EventoVectoresDeTiempo {
    private String nombre;
    private int[] valor;
    private int posicion;
    private String causalidadDesdeEvento;
    private String causalidadHastaEvento;

    EventoVectoresDeTiempo() {
    }

    EventoVectoresDeTiempo(String nombre, int posicion, String causalidadDesdeEvento, String causalidadHastaEvento, int cantidadProcesos) {
        this.nombre = nombre;
        this.posicion = posicion - 1;
        this.causalidadDesdeEvento = causalidadDesdeEvento;
        this.causalidadHastaEvento = causalidadHastaEvento;
        this.valor = new int[cantidadProcesos];
    }

    EventoVectoresDeTiempo(String nombre, int posicion, int cantidadProcesos) {
        this.nombre = nombre;
        this.posicion = posicion - 1;
        this.valor = new int[cantidadProcesos];
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
        if (this.valor != null) {
            return "[" + this.valor[0] + ", " + this.valor[1] + ", " + this.valor[2] + "]";
        } else {
            return "Sin valores";
        }
    }
}
