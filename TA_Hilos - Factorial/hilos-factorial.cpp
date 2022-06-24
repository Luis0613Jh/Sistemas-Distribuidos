/*
    Desarrollado por: Luis Jumbo
    Curso: "A"
    Fecha: 20/06/2022
*/
#include <pthread.h>
#include <stdio.h>
#include <vector>

using std::vector;
#define MAX_THREADS 8

pthread_mutex_t mutex;
int suma = 0;

pthread_t inc_x_thread[MAX_THREADS];

void *factorial(void *numero);
void join ();

int main()
{
    vector<int> array {3, 4, 5, 6, 7, 8, 9, 10};

    for (size_t i = 0; i < array.size(); i++)
    {
        pthread_create(&inc_x_thread[i], NULL, factorial, &array[i]);
    }
    join();
    printf("\n\n");
    printf("Suma: %d\n", suma);
    printf("======================================\n");
    printf("| > Desarrollado por: Luis Jumbo     |\n");
    printf("======================================\n");
    return 0;
}

void *factorial(void *numero_void)
{
    int i;
    int fact = 1;
    int *numero = (int *)numero_void;
    if (*numero < 0)
    {
        fact = 0;
    }
    else if (*numero == 0)
    {
        fact = 1;
    }
    else
    {
        for (i = 1; i <= *numero; i++)
        {
            fact = fact * i;
        }
    }
    printf("\n\n");
    printf("\t\tEl Factorial de %d es: %d\n", *numero, fact);
    pthread_mutex_lock(&mutex);
	suma = suma + fact;
	pthread_mutex_unlock(&mutex);
    return NULL;
}

void join () {
    for (size_t i = 0; i < MAX_THREADS; i++)
    {
        pthread_join(inc_x_thread[i], NULL);
    }
}