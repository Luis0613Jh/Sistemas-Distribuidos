/*
 * Nombre: Luis Jumbo
 * Fecha: 23/06/2022
 * Curso: 6to "A"
*/
#include "depositar_retirar_banco.h"

double *depositar_1_svc(depositar_argumentos *argp, struct svc_req *rqstp)
{
	static double  result;
	result = argp->cantidadCuenta + argp->cantidadTransaccion;
	return &result;
}

double *retirar_1_svc(retirar_argumentos *argp, struct svc_req *rqstp)
{
	static double  result;
	result = argp->cantidadCuenta - argp->cantidadTransaccion;
	return &result;
}
