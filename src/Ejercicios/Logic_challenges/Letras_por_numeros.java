/*
Letras por números

Reemplazar las letras de un string por su index en el alfabeto (e.g. A = 1 , B = 2 , C = 3 ...)
Consideraciones Adicionales:
    Ignorar espacios.
    Hacer clean up del string antes de comenzar el swap (para eliminar acentos y caracteres especiales, se sugiere meter en este proceso de clean up el ignorado de espacios).

Ejemplo:
func("abc def"); // returns '1 2 3 4 5 6';
*/

import java.util.Scanner;

public class Letras_por_numeros {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        F_System.clean_terminal();
        System.out.println("Inserte el texto");

        System.out.println( Letras_a_numero( Clean_String(sc.nextLine()) ) );
        sc.close();
        //Fin algoritmo
    }

    public static String Letras_a_numero(String text){
        char[] alphabet = {' ','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] Array_text = text.toCharArray();
        int Array_text_lenght = Array_text.length;
        int alphabet_lenght = alphabet.length;
        String Output_text = "";

        for (int i = 0; Array_text_lenght > i;i++){//Ciclo para los elementos del array
            for (int j = 0; alphabet_lenght > j;j++){//Ciclo para los elementos del alfabeto
                if (Array_text[i] == alphabet[j]){ //Si encuentra una letra en el alfabeto igual a la del texto, escribe su indice :D
                    Output_text = Output_text + j + " ";
                    break;
                }
            }
        }

        return Output_text;
    }

    public static String Clean_String(String text) {
        char[] Array_text = text.toLowerCase().toCharArray();
        int Array_text_lenght = Array_text.length;
        String Output_text = "";

        for (int i = 0; Array_text_lenght > i; i++) {
            switch (Array_text[i]) {
                case 'á' -> Output_text = Output_text + 'a';
                case 'é' -> Output_text = Output_text + 'e';
                case 'í' -> Output_text = Output_text + 'i';
                case 'ó' -> Output_text = Output_text + 'o';
                case 'ú', 'ü' -> Output_text = Output_text + 'u';
                case ' ' -> {}
                default -> Output_text = Output_text + Array_text[i];
            }
        }

        return Output_text;
    }
}
