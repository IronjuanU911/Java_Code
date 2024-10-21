/*
Un juego RPG
*/

import java.util.InputMismatchException;
import java.util.Scanner;

class Warrior{
    String name;
    float healt;
    float resistance;
    float force;
    boolean is_alive = true;

}


public class RPG_Game {
    static Scanner sc = new Scanner(System.in);
    static Warrior hero = new Warrior();
    static Warrior villan = new Warrior();
    static short dificulty;

    public static void main (String[] args) {
        //Inicio algoritmo
        
        while (true){
            start();
        }

        //Fin algoritmo
    }

    public static void start(){
        limpiar_consola();

        try {
            System.out.println("Inserta tu nombre");
            hero.name = sc.nextLine();
            
        } catch (InputMismatchException ex){}
        
        try {
            limpiar_consola();
            System.out.println("Inserta el nivel de dificultad " + '\n' + 
            "Facil [1]" + '\n' + 
            "Medio [2]" + '\n' + 
            "Difisil [3]" + '\n');

            dificulty = sc.nextShort();

        } catch (InputMismatchException ex){
            System.out.println("Inserte un valor esperado");
            enter_to_continue(false);
        }

        System.out.println(hero.name + ", as sido traido aqui para acabar con Falcon");
        enter_to_continue(true);
    }


    public static void enter_to_continue(boolean is_visible_text){
        if (is_visible_text){
            System.out.print("[Presiona enter para continuar]");
        }
        String x = sc.nextLine();
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
