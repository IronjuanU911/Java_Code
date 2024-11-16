/*
Crea un algoritmo que represente la sucesión Fibonacci
(0, 1, 1, 2, 3, 5, 8, 13, …)
*/

import java.util.Scanner; // Importamos el escaner

public class Fibbonacci {
    public static void main (String[] args) {
        //Inicio algoritmo
        Scanner sc = new Scanner(System.in); //Creamos el objeto Scanner

        long numero_a = 0; //Declaramos las variables
        long numero_b = 1;
        int repeticion_actual = 1;
        boolean printing_a = true;
        boolean can_continue = true;
        int numero_total_repeticiones; //sf

        System.out.print("Inserte la cantidad de numero de la serie Fibonacci que desea:");
        numero_total_repeticiones = sc.nextInt();

        System.out.println("Iniciando");

        while ((repeticion_actual <= numero_total_repeticiones) && can_continue){ //Empezamos el ciclo
            if (printing_a){ //En cada ciclo se imprimira un numero, ya sea a o b, al imprimirse, este numero sera la suma de a y b
                System.out.print(numero_a);
                numero_a = numero_a + numero_b;
            }else{
                System.out.print(numero_b);
                numero_b = numero_a + numero_b;
            }

            if (repeticion_actual < numero_total_repeticiones){
                System.out.print(", "); //Creamos esta separacion para mejorar el output
            }

            printing_a = !printing_a; //Cada que se imprime un numero, despues se imprimira el otro

            if (numero_a < 0 || numero_b < 0){//Si se dan valores negativos, significa que el maximo de memoria se a superado
                can_continue = false;  // lo que significa que de ahora en adelante si el algoritmo continua los datos no correspondran a la serie Fibonacci
                System.out.print('\n' + "No se puede continuar, se a superado el maximo de memoria y los datos serian erroneos" + '\n' +
                "numero de repeticion alcanzado = " + repeticion_actual);
            }

            repeticion_actual += 1; //Aumentamos en uno el contador de repeticiones
        }

        //Fin algoritmo
    }
}
