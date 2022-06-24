/*
 * Nombre: Luis Jumbo
 * Fecha: 23/06/2022
 * Curso: 6to "A"
*/
#include "depositar_retirar_banco.h"


void depositar_retirar_banco_1(char *host)
{
	
	double saldo = 1000;
	int opcion;

	CLIENT *clnt;
	double  *result_1;
	depositar_argumentos  depositar_1_arg;
	double  *result_2;
	retirar_argumentos  retirar_1_arg;

#ifndef	DEBUG
	clnt = clnt_create (host, DEPOSITAR_RETIRAR_BANCO, VERSION_DEPOSITAR_RETIRAR_BANCO, "udp");
	if (clnt == NULL) {
		clnt_pcreateerror (host);
		exit (1);
	}
#endif	/* DEBUG */
	printf ("Bienvenido Usuario");
	do {
	printf ("\n\nActualmente posee [%f] en la cuenta\n", saldo);
	printf ("¿Qué desea hacer?\n");
	printf ("1. Depositar\n");
	printf ("2. Retirar\n");
	printf ("3. Salir\n");
	scanf("%d", &opcion);
		if (opcion == 1) {
			printf ("Ingrese la cantidad a depositar\n");
			scanf("%lf", &depositar_1_arg.cantidadTransaccion);
			
			if (depositar_1_arg.cantidadTransaccion <= 0) {
				printf ("No puede depositar dinero igual o inferior a 0\n");
				depositar_1_arg.cantidadTransaccion = 0;
			} else {
				depositar_1_arg.cantidadCuenta = saldo;
				result_1 = depositar_1(&depositar_1_arg, clnt);
				if (result_1 == (double *) NULL) {
					clnt_perror (clnt, "call failed");
				}
				saldo = *result_1;
			}
		} else if (opcion == 2) {
			printf ("Ingrese la cantidad a retirar\n");
			scanf("%lf", &retirar_1_arg.cantidadTransaccion);

			if (retirar_1_arg.cantidadTransaccion > saldo || retirar_1_arg.cantidadTransaccion <= 0) {
				printf ("No puede retirar dinero igual o inferior a 0, ni superior al que posee en la cuenta\n");
				retirar_1_arg.cantidadTransaccion = 0;
			} else {
				retirar_1_arg.cantidadCuenta = saldo;
				result_2 = retirar_1(&retirar_1_arg, clnt);
				if (result_2 == (double *) NULL) {
					clnt_perror (clnt, "call failed");
				}
				saldo = *result_2;
			}
		} else if (opcion == 3) {
			break;
		} else {
			printf ("Opción Inválida\n");
		}
	} while (opcion != 3);

#ifndef	DEBUG
	clnt_destroy (clnt);
#endif	 /* DEBUG */
}


int
main (int argc, char *argv[])
{
	char *host;

	if (argc < 2) {
		printf ("usage: %s server_host\n", argv[0]);
		exit (1);
	}
	host = argv[1];
	depositar_retirar_banco_1 (host);
exit (0);
}
