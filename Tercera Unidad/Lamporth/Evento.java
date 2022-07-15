/**
 * @author Luis Jumbo
 * @Curso 6to "A"
 * @Fecha 15/07/2022
 */
public class Evento {
    private String nombre;
    private int valor;
    private int peso;
    private String causalidadDesdeEvento;
    private String causalidadHastaEvento;

    Evento() {
    }

    Evento(String nombre, int peso, String causalidadDesdeEvento, String causalidadHastaEvento) {
        this.nombre = nombre;
        this.peso = peso;
        this.causalidadDesdeEvento = causalidadDesdeEvento;
        this.causalidadHastaEvento = causalidadHastaEvento;
    }

    Evento(String nombre, int peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
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
}
