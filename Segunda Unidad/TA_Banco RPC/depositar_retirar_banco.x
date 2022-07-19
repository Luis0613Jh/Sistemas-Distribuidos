struct depositar_argumentos {
    double cantidadTransaccion;
    double cantidadCuenta;
};

struct retirar_argumentos {
    double cantidadTransaccion;
    double cantidadCuenta;
};

program DEPOSITAR_RETIRAR_BANCO {
    version VERSION_DEPOSITAR_RETIRAR_BANCO {
        double depositar(depositar_argumentos) = 1;
        double retirar(retirar_argumentos) = 2;
    } = 1;
} = 0x20000001;
