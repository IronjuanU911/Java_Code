/*
Un isograma es una palabra que no tiene letras repetidas.

Consideraciones Adicionales:

    Un string vacío es un isograma.
    La función tiene que ser case insensitive e ignorar acentos.
    Si el string tiene mas de una palabra retornar false.
    Se tiene que hacer clean up del string antes de comparar.

*/
package Ejercicios.Logic_challenges;

import iron_package.F_System;
import java.util.Scanner;

public class Isograma {

    public static void main(String[] args) {
        //Inicio algoritmo
        Scanner sc = new Scanner(System.in);
        F_System.clean_terminal();
        System.out.println("Inserte el texto a verificar como isograma");
        String Input_text = sc.nextLine(); //Le pedimos al usuario ingresar el string a verificar

        Boolean texto_es_isograma = Es_isograma(
            Eliminar_acentos(Input_text.toLowerCase())
        );
        /*Convertimos el texto en minusculas (Requisito mencionado anteriormente),
        Le quitamos los asentos al texto para luego verificar si es isorama*/

        F_System.clean_terminal(); //Reseteamos terminal para mostrar resultado
        System.out.print("El texto " + Input_text);

        if (texto_es_isograma) {
            System.out.println(" es un isograma.");
        } else {
            System.out.println(" no es un isograma.");
        }

        sc.close();
        //Fin algoritmo
    }

    public static boolean Es_isograma(String Text) {
        char[] Array_text = Text.toCharArray(); //Convertimos el texto de entrada en un array de chars
        boolean texto_es_isograma = true;
        int text_length = Array_text.length; //Establecemos el tamaño del array fuera del ciclo

        for (int i = 0; text_length > i; i++) { //i es el numero que se revisara si no es igual al resto
            if (Array_text[i] == ' ') { //Si se detecta un espacio significa que hay 2 palabras, entonces no es isograma
                texto_es_isograma = false;
                break;
            }
            for (int j = 0; text_length > j; j++) { //j es el resto de numeros en cada ciclo
                if (i != j && Array_text[i] == Array_text[j]) { //Quiere decir que, aunque la letra se encuentre en
                    texto_es_isograma = false; //posicion diferente, si son iguales significa que es isograma
                    break;
                }
            }
        }

        return texto_es_isograma;
    }

    public static String Eliminar_acentos(String Text) {
        char[] Array_text = Text.toCharArray(); //Convertimos el texto de entrada en un array de chars
        String Output_text = "";

        int text_length = Array_text.length; //Establecemos el tamaño del array fuera del ciclo

        for (int i = 0; text_length > i; i++) {
            switch (Array_text[i]) { //Si se encuentra cualquiera de estos asentos, se cambiara por su letra respectiva
                case 'á' -> Output_text = Output_text + 'a';
                case 'é' -> Output_text = Output_text + 'e';
                case 'í' -> Output_text = Output_text + 'i';
                case 'ó' -> Output_text = Output_text + 'o';
                case 'ú', 'ü' -> Output_text = Output_text + 'u';
                default -> Output_text = Output_text + Array_text[i]; //En caso de que no se encuentre, se pondra la letra sin mas
            }
        }

        return Output_text;
    }
}
