/*
String termina con

Hacer una función que reciba 2 strings (siempre los va a recibir),
y devuelva si el primero termina con el segundo. Ejemplos:

func("abc", "bc"); // returns true
func("abc", "d"); // returns false
*/
package Logic_challenges;

import iron_package.F_System;
import java.util.Scanner;

public class String_termina_con{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        F_System.clean_terminal();
        System.out.println("Inserte el primer string a testear");
        String text_a = sc.nextLine();
        F_System.clean_terminal();
        System.out.println("Inserte el segundo string para verificar si termina con el primero");
        String text_b = sc.nextLine();

        F_System.clean_terminal();
        System.out.print("El texto " + text_a);
        if (A_termina_con_B(text_a,text_b)){
            System.out.print(" si ");
        } else {System.out.print(" no ");}
        System.out.println("termina con " + text_b);

        sc.close();
        //Fin algoritmo
    }

    public static boolean A_termina_con_B (String text_a,String text_b){
        boolean condition_is_true = true;
        char[] Array_text_a = text_a.toCharArray();
        char[] Array_text_b = text_b.toCharArray();
        int text_a_lenght = Array_text_a.length;
        int text_b_lenght = Array_text_b.length;

        /*
        La idea en este algoritmo es recorrer el string b solamente, y comprobar si el mismo elemento
        se encuentra en el string a respectivamente.
        */
        int j = text_a_lenght - 1;

        if (text_b.isEmpty()){ //Si el segundo texto a comparar esta vacio, que retorne false
            return false;
        }

        for (int i = text_b_lenght - 1 ; i > 0 ; i--){ //Se hace un recorrido inverso del array b
            if (Array_text_b[i] != Array_text_a[j]){
                condition_is_true = false;
                break;
            }
            j--; /* Si la comprobacion es valida, se resta uno al indice del array a y continua el ciclo hasta acabar
                    con los elementos del array b */
        }


        return condition_is_true;
    }

}
