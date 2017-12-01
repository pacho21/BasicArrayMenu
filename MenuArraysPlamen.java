/*
 * Plamen se ha creado un menu para tratar una array random porque se aburria en su casa.
 * El menu tiene varias opciones y ademas usa metodos y lee por teclado.
 */
package menuarraysplamen;

/**
 *
 * @author Plamen
 */

import java.util.Scanner;

public class MenuArraysPlamen {

    //Variables Globales que utilizaremos en diferentes metodos
    static Scanner sc = new Scanner(System.in);//para leer por teclado
    static boolean salir = true;//para controlar la salida del menu tipo bucle.
    static String mensaje = "";//para introducir mensajes por pantalla (vease metodo leerEntrada)
    static int[] array=new int [0]; //una array de una dimension que se utilizara para ser tratada a lo largo del programa

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opcion;
        do {
            menu();
            mensaje = "Introduce el número de opcion";
            opcion = leerEntero(mensaje);
            tratarMenu(opcion);
        } while (salir);
    }
    
    /**
     * Esto mostrara por pantalla las opciones de mi menu
     */
    public static void menu() {
        System.out.println("Introduce la opción deseada: ");
        System.out.println("1.Crear una array de longitud y numeros que tu desees");
        System.out.println("2.Crear una array de longitud deseada y numeros aleatorios");
        System.out.println("3.Imprimir Array");
        System.out.println("4.Ordenar la array metodo Burbuja Optimizada");
        System.out.println("5.Mostrar los numeros primos de la array");
        System.out.println("6.Ordenacion metodo Plamen");
        System.out.println("7.Busqueda Binaria");
        System.out.println("0.Salir");
    }
    
    /**
     * Metodo que evalua la opcion seleccionada del menu y ejecuta los metodos segun esta opcion. En la busqueda binaria primero se ejecuta la ordenación debido a que es una regla basica de dicha busqueda.
     * @param opcion es la opción del menu que se elige.
     */
    public static void tratarMenu(int opcion){
        int rastreo,numeroBuscado,tamaño;           
        switch (opcion) {
                case 1:
                    mensaje = "Introduce el tamaño de la array";
                    tamaño = leerEntero(mensaje);
                    array = new int[tamaño];
                    asignarValor(array);
                    break;
                case 2:
                    mensaje = "Introduce el tamaño de la array aleatoria";
                    tamaño = leerEntero(mensaje);
                    array = new int[tamaño];
                    arrayAleatoria(array);
                    break;
                case 3:
                    printArray(array);
                case 4:
                    burbujaOptimizada(array);
                    break;
                case 5:
                    System.out.println("Los numeros primos de la array son: ");
                    primoArray(array);
                    System.out.println();

                case 6:
                    ordenacionPlamen(array);
                    break;
                case 7:
                    ordenacionPlamen(array);
                    mensaje = "Introduce el numero a buscar";
                    numeroBuscado = leerEntero(mensaje);
                    rastreo = busquedaBinaria(array, numeroBuscado);
                    if (rastreo != -1) {
                        System.out.println("El numero se encuentra en posicion: " + rastreo);
                    } else {
                        System.out.println("El numero no se encuentra en la array");
                    }
                    break;
                case 0:
                    salir = false;
                    break;
                default:
                    System.out.println("No has introducido una opcion valida");
            }
    }
    
    /**
     * Metodo para asignar valores a una array de una dimension.
     * @param ard es la array a la que se asignaran los valores.
     */
    public static void asignarValor(int[] ard) {
        int posicion;
        for (posicion = 0; posicion < ard.length; posicion++) {
            mensaje = "Introduce el numero que ocupara la posicion: " + posicion;
            ard[posicion] = leerEntero(mensaje);
        }
    }

    /**
     * Método que dada un mensaje introducido
     *
     * @param texto es el texto a mostrar por pantalla
     * @return devuelve el entero que ha escrito el usuario
     */
    public static int leerEntero(String texto) {
        int entero;
        System.out.println(texto);
        entero = sc.nextInt();
        return entero;

    }

    /**
     * Este metodo crea una array aleatoria de la longitud que sea la array
     *
     * @param ard es la array a alternar.
     */
    public static void arrayAleatoria(int[] ard) {
        int posicion, numeroAleatorio;
        for (posicion = 0; posicion < ard.length; posicion++) {
            numeroAleatorio = (int) (Math.random() * 200 - 0);
            ard[posicion] = numeroAleatorio;
        }

    }

    /**
     * Esto es un metodo que nos realiza la busqueda binaria (o dicotomica)
     *
     * @param ar Es la array sobre la que vamos a realizar la busqueda
     * @param numeroBuscado es el numero que estamos buscando
     * @return Este metodo nos devuelve un entero: Si es un valor diferente a -1
     * es la posición donde se encuentra el numero si es "-1" es que no se ha
     * encontrado el valor buscado!
     */
    public static int busquedaBinaria(int ar[], int numeroBuscado) {

        int max; // Ultima posicion del rango que buscamos
        int min; // Es la primera posicion de la array desde la que buscamos (limite max).
        int centro; // centro entre max y min, es con el que comprobamos si el numero esta.
        max = ar.length - 1; //inicializamos que el max sea la ultima posición del array.
        min = 0; //posición inicial 0... todas las arrays empiezan de posición 0...
        centro = (min + max) / 2;
        while (min <= max && numeroBuscado!=centro ) {
            centro = (min + max) / 2;
            if (numeroBuscado == ar[centro]) {
                return centro;
            } else if (numeroBuscado > ar[centro]) {
                min = centro + 1;
            } else {
                max = centro - 1;
            }

        }
        return -1; //si devolvemos -1 es que el numero no se encuentra en la array.
    }

    /**
     * Esto es un metodo de ordenación tipo burbuja y he añadido una opcion para
     * acortar el segundo for. Al acabar de ordenar no devuelve nada porque
     * realmente ordena la array tratada y al volver a usarla se vera que esta
     * ordenada.
     *
     * @param ard Es la array que se va a ordenar.
     */
    public static void ordenacionPlamen(int ard[]) {

        int posicion, recorre, memo;

        for (recorre = 0; recorre < ard.length; recorre++) {
            for (posicion = 0; posicion < (ard.length - 1 - recorre); posicion++) {
                if (ard[posicion] > ard[(posicion + 1)]) {
                    memo = ard[posicion];
                    ard[posicion] = ard[(posicion + 1)];
                    ard[posicion + 1] = memo;
                }
            }
        }

    }

    /**
     * Este metodo es de ordenación tipo "Burbuja" y es la version "Optimizada".
     *
     * @param matriz es la array a ser ordenada.
     */
    public static void burbujaOptimizada(int matriz[]) {
        int buffer;
        int posPrimaria, posSecundaria;
        for (posPrimaria = 0; posPrimaria < matriz.length; posPrimaria++) {
            for (posSecundaria = 0; posSecundaria < posPrimaria; posSecundaria++) {
                if (matriz[posPrimaria] < matriz[posSecundaria]) {
                    buffer = matriz[posSecundaria];
                    matriz[posSecundaria] = matriz[posPrimaria];
                    matriz[posPrimaria] = buffer;
                }
            }
        }
    }

    /**
     * Esto es un metodo simple con un for para imprimir una array
     *
     * @param ard es la array a imprimir.
     */
    public static void printArray(int ard[]) {
        int posicion;
        for (posicion = 0; posicion < ard.length; posicion++) {
            System.out.print(ard[posicion] + " ");
        }
        System.out.println();
    }

    /**
     * Este metodo lo que realizara es mostrar los numeros primos que se
     * encuentran en una array.
     *
     * @param arrayPrime es la array en la que buscaremos los numeros primos.
     */
    public static void primoArray(int arrayPrime[]) {
        int posicion, contador, divisor;
        for (posicion = 0; posicion < arrayPrime.length; posicion++) {
            contador = 0; //cada vez que salimos del bucle de abajo reiniciamos el contador.
            //si el contador es >2 significa que se divide por mas de dos numeros y saldra del bucle
            for (divisor = 1; (divisor <= arrayPrime[posicion]) && (contador != 3); divisor++) {
                //si el numero se divide por otro aumentara el contador
                if (arrayPrime[posicion] % divisor == 0) {
                    contador++;
                }
            }
            if (contador == 2 || contador == 1) {
                System.out.print(" " + arrayPrime[posicion]);
            }

        }
    }

}
