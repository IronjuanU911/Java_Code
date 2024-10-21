/*
Un juego RPG
*/

import java.util.Scanner;

class Gerrero{
    float salud;
    float resistencia;
    float fuerza;
    boolean esta_vivo = true;

}


public class RPG_Game {
    static Scanner sc = new Scanner(System.in);

    public static void main (String[] args) {
        //Inicio algoritmo
        int text;
        System.out.println("¿Desea borrar la consola?");
        text = sc.nextInt();
        limpiar_consola();
        System.out.println("Consola borrada");
        text = sc.nextInt();


        //Fin algoritmo
    }


    public static void limpiar_consola()  {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            /*No hacer nada*/
        }
        //Fin función
    }
}
