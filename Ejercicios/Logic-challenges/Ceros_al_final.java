/*
Mover los ceros al final
Escribir una función que tome un array de valores y retorne el mismo array pero moviendo los ceros al final.

Ejemplo:
moverCeros([false, 1, 0, 1, 2, 0, 1, 3, "a"]); // [false,1,1,2,1,3,"a",0,0]

Bonus: Implementar la función sin usar una variable de contador
*/

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ceros_al_final {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> Array = new ArrayList<String>();
        F_System.clean_terminal();
        System.out.println("Este es un algoritmo donde ingresas los elementos de un array y ponemos los 0 al final," +
            '\n' + "Inserte la cantidad de elementos que desea añadir al array");
        int Elements_array = sc.nextInt();
        F_System.clean_terminal();
        sc.nextLine();

        for (int i = 1;Elements_array >= i;i++){
            F_System.clean_terminal();
            System.out.print("El estado actual del array es: "); Iterador_Array(Array);
            System.out.println("Inserte el elemento numero " + i + " al array");
            Array.add(sc.nextLine());
        }

        F_System.clean_terminal();
        System.out.print("Array ingresado por el usuario: "); Iterador_Array(Array);
        System.out.print("Array con los 0 al final: "); Iterador_Array(CerosAlFinal(Array));

        sc.close();
        //Fin algoritmo
    }

    public static ArrayList<String> CerosAlFinal(ArrayList<String> Input_array){
        ArrayList<String> Output_Array = new ArrayList<String>();
        final String Elemento_a_excluir = "0";
        int Zero_counter = 0; //Contador de ceros que posee el imput array

        for (String Elemento : Input_array){
            if (!(Elemento.equals(Elemento_a_excluir))){ //Si el elemento en el array no es un 0, se añade al Output
                Output_Array.add(Elemento);
            } else {
                Zero_counter ++; //Si si lo es, lo añadimos al contador
            }
        }
        /*
        No se remueven directamente del imput array, al poner los elementos en otro array
        Se obtiene un mayor control de los elementos que se iteran pues dicha iteracion
        seria afectada si se añaden elementos en el proceso
        */

        while (Zero_counter > 0){ //Se añaden los elementos excluidos al final
            Output_Array.add(Elemento_a_excluir);
            Zero_counter--;
        }

        return Output_Array;
    }

    public static void Iterador_Array(ArrayList<String> Input_array){
        Iterator<String> iterador_array = Input_array.iterator(); //Se crea el iterador

        System.out.print("[");
        while (iterador_array.hasNext()){ //Si existe un elemento siguiente en el array, se imprime
            System.out.print (iterador_array.next());
            if (iterador_array.hasNext()){ //Si en el siguiente siclo se va a imprimir un elemento, se pone una ,
                System.out.print(", ");
            }
        }
        System.out.println("]");

    }

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
