/*
Dada una lista de elementos (array), crear una funcion que retorne una nueva
lista con solo los elementos que aparecen una cantidad n veces repetidos sean pares.

["A","B","A","C","C","C","C"] // -> ["A","C"]
[1,2,3,1,2] // -> [1,2]
*/

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ElementosPares {

    public static void main(final String[] args) {
        F_System.clean_terminal();

        final Scanner sc = new Scanner(System.in); //Creamos el objeto Scanner
        final ArrayList<String> Input_Array = new ArrayList<String>();

        System.out.println("Cuantos elementos desea añadir al array?");
        final int Elementos_a_añadir = sc.nextInt();

        sc.nextLine(); //Que mamon que me daba error por no tener esto :'v

        for (int i = 0; Elementos_a_añadir > i; i++) {
            F_System.clean_terminal();

            final int i_add = i + 1;

            System.out.print("Estado actual del array : "); //Mostramos al usuario el estado actual del array
            iterador_ArrayList(Input_Array);

            System.out.println(
                "Inserte el elemento numero " +
                i_add +
                " de " +
                Elementos_a_añadir
            ); //Le pedimos al usuario el siguiente elemento del array
            Input_Array.add(sc.nextLine());
        } //Fin ciclo

        final ArrayList<String> Output_Array = Elementos_pares_repetidos(
            Input_Array
        );

        F_System.clean_terminal();

        System.out.print("Array ingresada por el usuario : ");
        iterador_ArrayList(Input_Array);

        System.out.println("Array solo con los elementos pares : ");
        iterador_ArrayList(Output_Array);

        sc.close();
    } //Fin algoritmo

    public static ArrayList<String> Elementos_pares_repetidos(
        final ArrayList<String> Array_to_test
    ) {
        final ArrayList<String> Elementos_pares = new ArrayList<String>(); //Creamos arrays para almacenar si un elemento se encuentra de manera par o impar
        final ArrayList<String> Elementos_inpares = new ArrayList<String>();

        for (final String Elemento : Array_to_test) {
            if (Elementos_pares.contains(Elemento)) { //Comprobamos si se encuentra el elemento en pares, para eliminarlo
                Elementos_pares.remove(Elemento);
                Elementos_inpares.add(Elemento); //Y luego añadirlo a los impares
            } else if (Elementos_inpares.contains(Elemento)) { //Comprobamos si se encuentra el elemento en inpares, para eliminarlo
                Elementos_inpares.remove(Elemento);
                Elementos_pares.add(Elemento); //Y luego añadirlo a los pares
            } else {
                Elementos_inpares.add(Elemento); //Si ambos arrays no poseen el elemento, quiere desir que es la primera ves que lo encuentra, por lo tanto es un elemento impar por el momento
            }
            //Finaliza ciclo
        }

        return Elementos_pares;
    }

    public static void iterador_ArrayList(final ArrayList<String> Array) {
        final Iterator<String> Iterador_array = Array.iterator();
        System.out.print("[");
        for (; Iterador_array.hasNext();) { //Verificamos si existe un elemento siguiente por iterar
            System.out.print(Iterador_array.next()); //Si es el caso se imprime

            if (Iterador_array.hasNext()) { //Si quedan elementos por imprimir, se pone una coma
                System.out.print(", ");
            }
        } //Fin bucle

        System.out.println("]");
    } //Fin funcion
}

class F_System { //Clase que contiene funciones que utiliza este sistema pa que se vea mejor
    public static void clean_terminal() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); //Borrar consola windows
        } catch (IOException | InterruptedException e) {
            System.out.print("\033[H\033[2J"); //Borrar consola linux
            System.out.flush();
        }
        //Los de mac se pueden joder :D
    }
}
