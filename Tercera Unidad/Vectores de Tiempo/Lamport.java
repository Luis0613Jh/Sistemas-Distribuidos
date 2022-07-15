
/**
 * @author Luis Jumbo
 * @Curso 6to "A"
 * @Fecha 15/07/2022
 */
public class Lamport {

    public static void main(String[] args) throws Exception {
        int numeroEventos = 8;
        Evento[] proceso1 = new Evento[numeroEventos];
        Evento[] proceso2 = new Evento[numeroEventos];
        Evento[] proceso3 = new Evento[numeroEventos];

        int[] relojLogicoProceso1 = {0, 0, 0};
        int[] relojLogicoProceso2 = {0, 0, 0};
        int[] relojLogicoProceso3 = {0, 0, 0};

        llenarProcesosConEventos(proceso1, proceso2, proceso3);
        imprimirProcesos(proceso1, proceso2, proceso3);
        System.out.println("================================================================================================");
        aplicarAlgoritmoLamport(proceso1, proceso2, proceso3, relojLogicoProceso1, relojLogicoProceso2, relojLogicoProceso3);
        imprimirProcesos(proceso1, proceso2, proceso3);
    }

    public static void llenarProcesosConEventos(Evento[] proceso1, Evento[] proceso2, Evento[] proceso3) {
        proceso1[0] = new Evento("A", 1);
        proceso2[0] = new Evento();
        proceso3[0] = new Evento();

        proceso1[1] = new Evento("B", 1, null, "D");
        proceso2[1] = new Evento();
        proceso3[1] = new Evento();

        proceso1[2] = new Evento();
        proceso2[2] = new Evento();
        proceso3[2] = new Evento("C", 3, null, "F");

        proceso1[3] = new Evento();
        proceso2[3] = new Evento("D", 2, "B", null);
        proceso3[3] = new Evento();

        proceso1[4] = new Evento();
        proceso2[4] = new Evento("E", 2, null, "G");
        proceso3[4] = new Evento();

        proceso1[5] = new Evento("F", 1, "C", null);
        proceso2[5] = new Evento();
        proceso3[5] = new Evento();

        proceso1[6] = new Evento();
        proceso2[6] = new Evento();
        proceso3[6] = new Evento("G", 3, "E", null);

        proceso1[7] = new Evento();
        proceso2[7] = new Evento();
        proceso3[7] = new Evento("H", 3, "B", null);
    }

    public static void imprimirProcesos(Evento[] proceso1, Evento[] proceso2, Evento[] proceso3) {
        for (int i = 0; i < proceso1.length; i++) {
            System.out.println("Proc 1 [" + i + "]: " + proceso1[i].getNombre());
            System.out.println("Proc 1 [" + i + "]: " + proceso1[i].toString());
            System.out.println("Proc 1 [" + i + "]: " + proceso1[i].getPosicion());
            System.out.println("Proc 1 [" + i + "]: " + proceso1[i].getCausalidadDesdeEvento());
            System.out.println("Proc 1 [" + i + "]: " + proceso1[i].getCausalidadHastaEvento());
            System.out.println();
            System.out.println("Proc 2 [" + i + "]: " + proceso2[i].getNombre());
            System.out.println("Proc 2 [" + i + "]: " + proceso2[i].toString());
            System.out.println("Proc 2 [" + i + "]: " + proceso2[i].getPosicion());
            System.out.println("Proc 2 [" + i + "]: " + proceso2[i].getCausalidadDesdeEvento());
            System.out.println("Proc 2 [" + i + "]: " + proceso2[i].getCausalidadHastaEvento());
            System.out.println();
            System.out.println("Proc 3 [" + i + "]: " + proceso3[i].getNombre());
            System.out.println("Proc 3 [" + i + "]: " + proceso3[i].toString());
            System.out.println("Proc 3 [" + i + "]: " + proceso3[i].getPosicion());
            System.out.println("Proc 3 [" + i + "]: " + proceso3[i].getCausalidadDesdeEvento());
            System.out.println("Proc 3 [" + i + "]: " + proceso3[i].getCausalidadHastaEvento());
            System.out.println();
        }
    }

    public static void aplicarAlgoritmoLamport(Evento[] proceso1, Evento[] proceso2, Evento[] proceso3,
            int[] relojLogicoProceso1, int[] relojLogicoProceso2, int[] relojLogicoProceso3) {
        for (int i = 0; i < proceso1.length; i++) {
            if (proceso1[i].getNombre() != null) {
                relojLogicoProceso1 = determinarRelojLogicoMayor(relojLogicoProceso1, proceso1[i], proceso1, proceso2,
                        proceso3);
            } else if (proceso2[i].getNombre() != null) {
                relojLogicoProceso2 = determinarRelojLogicoMayor(relojLogicoProceso2, proceso2[i], proceso1, proceso2,
                        proceso3);
            } else if (proceso3[i].getNombre() != null) {
                relojLogicoProceso3 = determinarRelojLogicoMayor(relojLogicoProceso3, proceso3[i], proceso1, proceso2,
                        proceso3);
            }
        }
    }

    public static Evento obtenerEventoDeProceso(String nombre, Evento[] proceso1, Evento[] proceso2,
            Evento[] proceso3) {
        for (int i = 0; i < proceso1.length; i++) {
            if (proceso1[i].getNombre() != null && proceso1[i].getNombre().equalsIgnoreCase(nombre)) {
                return proceso1[i];
            } else if (proceso2[i].getNombre() != null && proceso2[i].getNombre().equalsIgnoreCase(nombre)) {
                return proceso2[i];
            } else if (proceso3[i].getNombre() != null && proceso3[i].getNombre().equalsIgnoreCase(nombre)) {
                return proceso3[i];
            }
        }
        return null;
    }

    public static int[] determinarRelojLogicoMayor(int[] relojLogicoProceso, Evento evento, Evento[] proceso1,
            Evento[] proceso2, Evento[] proceso3) {
        if (evento.getCausalidadDesdeEvento() == null) {
            relojLogicoProceso[evento.getPosicion()] = relojLogicoProceso[evento.getPosicion()] + 1;
            evento.setValor(relojLogicoProceso);
        } else {
            Evento causalidadDesdeEvento = obtenerEventoDeProceso(evento.getCausalidadDesdeEvento(), proceso1, proceso2,
                    proceso3);
            if (causalidadDesdeEvento != null) {
                int[] valorEventoCausalidad = causalidadDesdeEvento.getValor();
                if (relojLogicoProceso[evento.getPosicion()] > valorEventoCausalidad[evento.getPosicion()]) {
                    relojLogicoProceso[evento.getPosicion()] = relojLogicoProceso[evento.getPosicion()] + 1;
                    evento.setValor(relojLogicoProceso);
                } else {
                    valorEventoCausalidad[evento.getPosicion()] = valorEventoCausalidad[evento.getPosicion()] + 1;
                    relojLogicoProceso[evento.getPosicion()] = valorEventoCausalidad[evento.getPosicion()];
                    evento.setValor(valorEventoCausalidad);
                }
            } else {
                System.out.println("ERROR");
                return new int[3];
            }
        }
        return relojLogicoProceso;
    }

    public static void imprimirEventos(Evento[] eventos) {
        for (int i = 0; i < eventos.length; i++) {
            System.out.println("(" + i + ") Evento '" + eventos[i].getNombre() + "': " + eventos[i].getValor() + "." + eventos[i].getPosicion());
        }
    }
}
