
/**
 * @author Luis Jumbo
 * @Curso 6to "A"
 * @Fecha 15/07/2022
 */
public class VectoresDeTiempo {

    public static void main(String[] args) throws Exception {
        int numeroEventos = 8;
        EventoVectoresDeTiempo[] proceso1 = new EventoVectoresDeTiempo[numeroEventos];
        EventoVectoresDeTiempo[] proceso2 = new EventoVectoresDeTiempo[numeroEventos];
        EventoVectoresDeTiempo[] proceso3 = new EventoVectoresDeTiempo[numeroEventos];

        int cantidadProcesos = 3;
        int[] relojLogicoProceso1 = { 0, 0, 0 };
        int[] relojLogicoProceso2 = { 0, 0, 0 };
        int[] relojLogicoProceso3 = { 0, 0, 0 };

        llenarProcesosConEventos(proceso1, proceso2, proceso3, cantidadProcesos);
        System.out.println();
        imprimirProceso(proceso1, 1);
        System.out.println();
        imprimirProceso(proceso2, 2);
        System.out.println();
        imprimirProceso(proceso3, 3);
        System.out.println();
        aplicarAlgoritmoLamport(proceso1, proceso2, proceso3, relojLogicoProceso1, relojLogicoProceso2,
        relojLogicoProceso3);
        System.out.println(
            "============================== RESULTADO ==============================");
            System.out.println();
            
        imprimirProcesoConVectoresDeTiempo(proceso1, 1);
        imprimirProcesoConVectoresDeTiempo(proceso2, 2);
        imprimirProcesoConVectoresDeTiempo(proceso3, 3);
        System.out.println();
    }

    public static void llenarProcesosConEventos(EventoVectoresDeTiempo[] proceso1, EventoVectoresDeTiempo[] proceso2,
            EventoVectoresDeTiempo[] proceso3, int cantidadProcesos) {
        proceso1[0] = new EventoVectoresDeTiempo("A", 1, cantidadProcesos);
        proceso2[0] = new EventoVectoresDeTiempo();
        proceso3[0] = new EventoVectoresDeTiempo();

        proceso1[1] = new EventoVectoresDeTiempo("B", 1, null, "D", cantidadProcesos);
        proceso2[1] = new EventoVectoresDeTiempo();
        proceso3[1] = new EventoVectoresDeTiempo();

        proceso1[2] = new EventoVectoresDeTiempo();
        proceso2[2] = new EventoVectoresDeTiempo();
        proceso3[2] = new EventoVectoresDeTiempo("C", 3, null, "F", cantidadProcesos);

        proceso1[3] = new EventoVectoresDeTiempo();
        proceso2[3] = new EventoVectoresDeTiempo("D", 2, "B", null, cantidadProcesos);
        proceso3[3] = new EventoVectoresDeTiempo();

        proceso1[4] = new EventoVectoresDeTiempo();
        proceso2[4] = new EventoVectoresDeTiempo("E", 2, null, "G", cantidadProcesos);
        proceso3[4] = new EventoVectoresDeTiempo();

        proceso1[5] = new EventoVectoresDeTiempo("F", 1, "C", null, cantidadProcesos);
        proceso2[5] = new EventoVectoresDeTiempo();
        proceso3[5] = new EventoVectoresDeTiempo();

        proceso1[6] = new EventoVectoresDeTiempo();
        proceso2[6] = new EventoVectoresDeTiempo();
        proceso3[6] = new EventoVectoresDeTiempo("G", 3, "E", null, cantidadProcesos);

        proceso1[7] = new EventoVectoresDeTiempo();
        proceso2[7] = new EventoVectoresDeTiempo();
        proceso3[7] = new EventoVectoresDeTiempo("H", 3, "B", null, cantidadProcesos);
    }

    public static void imprimirProcesos(EventoVectoresDeTiempo[] proceso1, EventoVectoresDeTiempo[] proceso2,
            EventoVectoresDeTiempo[] proceso3) {
        for (int i = 0; i < proceso1.length; i++) {
            System.out.println("Proceso 1 [" + i + "]: " + proceso1[i].getNombre());
            System.out.println("Proceso 1 [" + i + "]: " + proceso1[i].toString());
            System.out.println("Proceso 1 [" + i + "]: " + proceso1[i].getPosicion());
            System.out.println("Proceso 1 [" + i + "]: " + proceso1[i].getCausalidadDesdeEvento());
            System.out.println("Proceso 1 [" + i + "]: " + proceso1[i].getCausalidadHastaEvento());
            System.out.println();
            System.out.println("Proceso 2 [" + i + "]: " + proceso2[i].getNombre());
            System.out.println("Proceso 2 [" + i + "]: " + proceso2[i].toString());
            System.out.println("Proceso 2 [" + i + "]: " + proceso2[i].getPosicion());
            System.out.println("Proceso 2 [" + i + "]: " + proceso2[i].getCausalidadDesdeEvento());
            System.out.println("Proceso 2 [" + i + "]: " + proceso2[i].getCausalidadHastaEvento());
            System.out.println();
            System.out.println("Proceso 3 [" + i + "]: " + proceso3[i].getNombre());
            System.out.println("Proceso 3 [" + i + "]: " + proceso3[i].toString());
            System.out.println("Proceso 3 [" + i + "]: " + proceso3[i].getPosicion());
            System.out.println("Proceso 3 [" + i + "]: " + proceso3[i].getCausalidadDesdeEvento());
            System.out.println("Proceso 3 [" + i + "]: " + proceso3[i].getCausalidadHastaEvento());
            System.out.println();
        }
    }

    public static void imprimirProceso(EventoVectoresDeTiempo[] proceso, int numeroProceso) {
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

    public static void imprimirProcesoConVectoresDeTiempo(EventoVectoresDeTiempo[] proceso, int numeroProceso) {
        System.out.println("================ Proceso " + numeroProceso + " ================");

        for (int i = 0; i < proceso.length; i++) {
            if (proceso[i].getNombre() != null) {
                System.out.println("✱ " + proceso[i].getNombre() + ": " + proceso[i].toString());
            }
        }
    }

    public static void aplicarAlgoritmoLamport(EventoVectoresDeTiempo[] proceso1, EventoVectoresDeTiempo[] proceso2,
            EventoVectoresDeTiempo[] proceso3,
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

    public static EventoVectoresDeTiempo obtenerEventoDeProceso(String nombre, EventoVectoresDeTiempo[] proceso1,
            EventoVectoresDeTiempo[] proceso2,
            EventoVectoresDeTiempo[] proceso3) {
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

    public static int[] determinarRelojLogicoMayor(int[] relojLogicoProceso, EventoVectoresDeTiempo evento,
            EventoVectoresDeTiempo[] proceso1,
            EventoVectoresDeTiempo[] proceso2, EventoVectoresDeTiempo[] proceso3) {
        int[] auxVectorValores = new int[evento.getValor().length];
        if (evento.getCausalidadDesdeEvento() == null) {
            System.arraycopy(relojLogicoProceso, 0, auxVectorValores, 0, relojLogicoProceso.length);
            auxVectorValores[evento.getPosicion()] = relojLogicoProceso[evento.getPosicion()] + 1;
            evento.setValor(auxVectorValores);
        } else {
            EventoVectoresDeTiempo causalidadDesdeEvento = obtenerEventoDeProceso(evento.getCausalidadDesdeEvento(),
                    proceso1, proceso2,
                    proceso3);
            if (causalidadDesdeEvento != null) {
                int[] valoresEventoCausalidad = causalidadDesdeEvento.getValor();
                for (int i = 0; i < relojLogicoProceso.length; i++) {
                    if (evento.getPosicion() == i) {
                        if (relojLogicoProceso[evento.getPosicion()] > valoresEventoCausalidad[evento.getPosicion()]) {
                            auxVectorValores[evento.getPosicion()] = relojLogicoProceso[evento.getPosicion()] + 1;
                        } else {
                            auxVectorValores[evento.getPosicion()] = valoresEventoCausalidad[evento.getPosicion()] + 1;
                        }
                    } else {
                        if (relojLogicoProceso[i] > valoresEventoCausalidad[i]) {
                            auxVectorValores[i] = relojLogicoProceso[i];
                        } else {
                            auxVectorValores[i] = valoresEventoCausalidad[i];
                        }
                    }
                }
                evento.setValor(auxVectorValores);
            } else {
                System.out.println("ERROR");
                return new int[3];
            }
        }
        relojLogicoProceso = auxVectorValores;
        return relojLogicoProceso;
    }

    public static void imprimirEventos(EventoVectoresDeTiempo[] eventos) {
        for (int i = 0; i < eventos.length; i++) {
            System.out.println("(" + i + ") Evento '" + eventos[i].getNombre() + "': " + eventos[i].getValor() + "."
                    + eventos[i].getPosicion());
        }
    }

    public static void imprimirArreglo(int[] arreglo) {
        boolean bandera = false;
        System.out.print("[");
        for (int i = 0; i < arreglo.length; i++) {
            if ((i + 1) == arreglo.length) {
                bandera = true;
            }
            if (bandera) {
                System.out.print(arreglo[i]);
            } else {
                System.out.print(arreglo[i] + ", ");
            }
        }
        System.out.print("]\n");
    }
}
