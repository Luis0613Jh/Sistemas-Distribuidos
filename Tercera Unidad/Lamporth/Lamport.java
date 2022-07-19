
/**
 * @author Luis Jumbo
 * @Curso 6to "A"
 * @Fecha 17/07/2022
 */
public class Lamport {

    public static void main(String[] args) throws Exception {
        int numeroEventos = 8;
        Evento[] proceso1 = new Evento[numeroEventos];
        Evento[] proceso2 = new Evento[numeroEventos];
        Evento[] proceso3 = new Evento[numeroEventos];

        int relojLogicoProceso1 = 0;
        int relojLogicoProceso2 = 0;
        int relojLogicoProceso3 = 0;

        llenarProcesosConEventos(proceso1, proceso2, proceso3);
        System.out.println();
        imprimirProcesoeso(proceso1, 1);
        System.out.println();
        imprimirProcesoeso(proceso2, 2);
        System.out.println();
        imprimirProcesoeso(proceso3, 3);
        System.out.println();
        System.out.println("================================");
        aplicarAlgoritmoLamport(proceso1, proceso2, proceso3, relojLogicoProceso1, relojLogicoProceso2,
                relojLogicoProceso3);
        Evento[] eventosOrdenados = ordenarEventos(proceso1, proceso2, proceso3);
        imprimirEventos(eventosOrdenados);
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
            System.out.println("Proceso 1 [" + i + "]: " + proceso1[i].getNombre());
            System.out.println("Proceso 1 [" + i + "]: " + proceso1[i].getValor());
            System.out.println("Proceso 1 [" + i + "]: " + proceso1[i].getPeso());
            System.out.println("Proceso 1 [" + i + "]: " + proceso1[i].getCausalidadDesdeEvento());
            System.out.println("Proceso 1 [" + i + "]: " + proceso1[i].getCausalidadHastaEvento());
            System.out.println();
            System.out.println("Proceso 2 [" + i + "]: " + proceso2[i].getNombre());
            System.out.println("Proceso 2 [" + i + "]: " + proceso2[i].getValor());
            System.out.println("Proceso 2 [" + i + "]: " + proceso2[i].getPeso());
            System.out.println("Proceso 2 [" + i + "]: " + proceso2[i].getCausalidadDesdeEvento());
            System.out.println("Proceso 2 [" + i + "]: " + proceso2[i].getCausalidadHastaEvento());
            System.out.println();
            System.out.println("Proceso 3 [" + i + "]: " + proceso3[i].getNombre());
            System.out.println("Proceso 3 [" + i + "]: " + proceso3[i].getValor());
            System.out.println("Proceso 3 [" + i + "]: " + proceso3[i].getPeso());
            System.out.println("Proceso 3 [" + i + "]: " + proceso3[i].getCausalidadDesdeEvento());
            System.out.println("Proceso 3 [" + i + "]: " + proceso3[i].getCausalidadHastaEvento());
            System.out.println();
        }
    }

    public static void imprimirProcesoeso(Evento[] proceso, int numeroProceso) {
        System.out.println("================ Proceso " + numeroProceso + " ================");

        for (int i = 0; i < proceso.length; i++) {
            if (proceso[i].getNombre() != null) {
                if (proceso[i].getCausalidadHastaEvento() != null) {
                    System.out.println("✱ " + proceso[i].getNombre() + " ➜ " + proceso[i].getCausalidadHastaEvento());
                } else {
                    System.out.println("✱ " + proceso[i].getNombre());
                }
            }
        }
    }

    public static void aplicarAlgoritmoLamport(Evento[] proceso1, Evento[] proceso2, Evento[] proceso3,
            int relojLogicoProceso1, int relojLogicoProceso2, int relojLogicoProceso3) {
        for (int i = 0; i < proceso1.length; i++) {
            if (proceso1[i].getNombre() != null) {
                relojLogicoProceso1 = determinarRelojLogicoMayor(relojLogicoProceso1, proceso1[i], proceso1,
                        proceso2,
                        proceso3);
            } else if (proceso2[i].getNombre() != null) {
                relojLogicoProceso2 = determinarRelojLogicoMayor(relojLogicoProceso2, proceso2[i], proceso1,
                        proceso2,
                        proceso3);
            } else if (proceso3[i].getNombre() != null) {
                relojLogicoProceso3 = determinarRelojLogicoMayor(relojLogicoProceso3, proceso3[i], proceso1,
                        proceso2,
                        proceso3);
            }
        }
    }

    public static Evento obtenerEventoDeProcesoeso(String nombre, Evento[] proceso1, Evento[] proceso2,
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

    public static int determinarRelojLogicoMayor(int relojLogicoProcesoeso, Evento evento, Evento[] proceso1,
            Evento[] proceso2, Evento[] proceso3) {
        if (evento.getCausalidadDesdeEvento() == null) {
            relojLogicoProcesoeso++;
            evento.setValor(relojLogicoProcesoeso);
        } else {
            Evento causalidadDesdeEvento = obtenerEventoDeProcesoeso(evento.getCausalidadDesdeEvento(), proceso1,
                    proceso2,
                    proceso3);
            if (causalidadDesdeEvento != null) {
                int valorEventoCausalidad = causalidadDesdeEvento.getValor();
                if (relojLogicoProcesoeso > valorEventoCausalidad) {
                    relojLogicoProcesoeso++;
                    evento.setValor(relojLogicoProcesoeso);
                } else {
                    evento.setValor(valorEventoCausalidad + 1);
                    relojLogicoProcesoeso = valorEventoCausalidad + 1;
                }
            } else {
                System.out.println("ERROR");
                return -1;
            }
        }
        return relojLogicoProcesoeso;
    }

    public static Evento[] ordenarEventos(Evento[] proceso1, Evento[] proceso2, Evento[] proceso3) {
        Evento[] eventosOrdenados = new Evento[proceso1.length];
        for (int i = 0; i < eventosOrdenados.length; i++) {
            int auxValor = 9999;
            int auxPeso = 9999;
            String auxNombre = "";
            for (int j = 0; j < proceso1.length; j++) {
                if (proceso1[j].getNombre() != null && proceso1[j].getValor() <= auxValor) {
                    if (proceso1[j].getValor() == auxValor) {
                        if (proceso1[j].getPeso() <= auxPeso) {
                            eventosOrdenados[i] = proceso1[j];
                            auxPeso = proceso1[j].getPeso();
                            auxValor = proceso1[j].getValor();
                            auxNombre = proceso1[j].getNombre();
                        }
                    } else {
                        eventosOrdenados[i] = proceso1[j];
                        auxPeso = proceso1[j].getPeso();
                        auxValor = proceso1[j].getValor();
                        auxNombre = proceso1[j].getNombre();
                    }
                } else if (proceso2[j].getNombre() != null && proceso2[j].getValor() <= auxValor) {
                    if (proceso2[j].getValor() == auxValor) {
                        if (proceso2[j].getPeso() <= auxPeso) {
                            eventosOrdenados[i] = proceso2[j];
                            auxPeso = proceso2[j].getPeso();
                            auxValor = proceso2[j].getValor();
                            auxNombre = proceso2[j].getNombre();
                        }
                    } else {
                        eventosOrdenados[i] = proceso2[j];
                        auxPeso = proceso2[j].getPeso();
                        auxValor = proceso2[j].getValor();
                        auxNombre = proceso2[j].getNombre();
                    }
                } else if (proceso3[j].getNombre() != null && proceso3[j].getValor() <= auxValor) {
                    if (proceso3[j].getValor() == auxValor) {
                        if (proceso3[j].getPeso() <= auxPeso) {
                            eventosOrdenados[i] = proceso3[j];
                            auxPeso = proceso3[j].getPeso();
                            auxValor = proceso3[j].getValor();
                            auxNombre = proceso3[j].getNombre();
                        }
                    } else {
                        eventosOrdenados[i] = proceso3[j];
                        auxPeso = proceso3[j].getPeso();
                        auxValor = proceso3[j].getValor();
                        auxNombre = proceso3[j].getNombre();
                    }
                }
            }
            for (int k = 0; k < proceso1.length; k++) {
                if (proceso1[k].getNombre() != null && proceso1[k].getNombre().equalsIgnoreCase(auxNombre)) {
                    proceso1[k] = new Evento();
                } else if (proceso2[k].getNombre() != null && proceso2[k].getNombre().equalsIgnoreCase(auxNombre)) {
                    proceso2[k] = new Evento();
                } else if (proceso3[k].getNombre() != null && proceso3[k].getNombre().equalsIgnoreCase(auxNombre)) {
                    proceso3[k] = new Evento();
                }
            }
        }
        return eventosOrdenados;
    }

    public static void imprimirEventos(Evento[] eventos) {
        for (int i = 0; i < eventos.length; i++) {
            System.out.println("(" + (i + 1) + ") Evento '" + eventos[i].getNombre() + "': " + eventos[i].getValor()
                    + "." + eventos[i].getPeso());
        }
    }
}
