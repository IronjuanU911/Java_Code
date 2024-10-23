/*
Un juego RPG
*/

import java.util.Scanner;

class Warrior{
    String name;
    float healt;
    float resistance;
    float force;
    boolean is_alive = true;

    Warrior focused;

    public void is_attacked(){

    }

    public void attack(){
        focused.is_attacked();
    }

    public void defend(){

    }

    public void to_heal(){

    }

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
        clean_terminal();

        System.out.println("Inserta tu nombre");
        hero.name = sc.nextLine();
            
        clean_terminal();

        while (true){
            
            System.out.println("Inserta el nivel de dificultad " + '\n' + 
            "Facil [1]" + '\n' + 
            "Medio [2]" + '\n' + 
            "Dificil [3]" + '\n');

            dificulty = sc.nextShort();

            if (dificulty > 0 && dificulty < 4){
                break;
            } else {
                clean_terminal();
                System.out.println("ADVERTENCIA:[Inserte un valor dentro del rango]");
            }
        }


        


        System.out.println("Cargando...");
        await(1000);
        clean_terminal();
        System.out.println("Es un dia muy oscuro, de seguro estas muy confundido");
        await(2500);
        System.out.println(hero.name + ", has sido traido aqui para acabar con Falcon");
        await(2500);
        enter_to_continue(true);

        game("Prueba","Del motor","De texto");
        sc.nextLine();
    }

    public static void game(String text_1, String text_2, String text_3){
        clean_terminal();

        System.out.println(
                   "//" + text_1 + 
            '\n' + "//" + 
            '\n' + "//" + text_2 +
            '\n' + "//" + 
            '\n' + "//" + text_3 + 
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
    


    public static void enter_to_continue(boolean reset_Scanner){
        if (reset_Scanner){
            sc.nextLine();
        }
        System.out.println("[Presiona enter para continuar]");
        sc.nextLine();
        //Fin función
    }

    public static void clean_terminal()  {
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
