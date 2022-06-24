struct sumandos {
    int sumando1;
    int sumando2;
};

program FUNCIONESBASICAS {
    version VERSION_SUMA {
        int suma (sumandos) = 1;
    } = 1;
} = 0x20000001;
