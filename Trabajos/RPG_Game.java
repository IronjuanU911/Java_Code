/*
Un juego RPG
*/

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Warrior{
    String name;
    float healt;
    float resistance;
    float force;
    boolean is_alive = true;

}


public class RPG_Game {
    static Scanner sc = new Scanner(System.in);
    static Timer timer = new Timer();

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

        System.out.println("Inserta tu nombre");
        hero.name = sc.nextLine();
            
    
        limpiar_consola();
        System.out.println("Inserta el nivel de dificultad " + '\n' + 
        "Facil [1]" + '\n' + 
        "Medio [2]" + '\n' + 
        "Dificil [3]" + '\n');

        dificulty = sc.nextShort();

        System.out.println("Cargando...");
        await(1000);
        limpiar_consola();
        System.out.println("Es un dia muy oscuro, de seguro estas muy confundido");
        await(2500);
        System.out.println(hero.name + ", has sido traido aqui para acabar con Falcon");
        await(2500);
        enter_to_continue();

        game();
        sc.nextLine();
    }

    public static void game(){
        limpiar_consola();

        System.out.println(
                   "//" + 
            '\n' + "//" + 
            '\n' + "//" + 
            '\n' + "//" + 
            '\n' + "//" + 
            '\n' + "//" + 
            '\n' + "//" + 
            '\n' + "//" + 
            '\n' + "//" + 
            '\n' + "//" + 
            '\n' + "//" + 
            '\n' + "//" + 
            '\n' + "[Ataque : 1][Defensa : 2][Estadisticas : 3][Piedad : 4]"
        );
    }
    


    public static void enter_to_continue(){
        Scanner sc_temp = new Scanner(System.in);
        System.out.println("[Presiona enter para continuar]");
        sc_temp.nextLine();
        //Fin función
    }

    public static void limpiar_consola()  {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            /*No hacer nada*/
        }
        //Fin función
    }

    public static void await(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Fin función
    }


}
