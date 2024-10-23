/*
Un juego RPG
*/

import java.util.Scanner;

class Warrior{
    String name;

    float base_healt;
    float base_resistance;
    float base_force;

    float healt = 200;
    float resistance = 10;
    float force = 10;
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
    static short difficulty;
    static final float difficulty_index = 0.2f;
    static float index_villan_upgrade;

    public static void main (String[] args) {
        //Inicio algoritmo
        
        while (true){
            start();

            game();



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

            difficulty = sc.nextShort();

            if (difficulty > 0 && difficulty < 4){
                set_index_villan_difficulty();
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

    }

    public static void output(String text_1, String text_2, String text_3){
        clean_terminal();

        System.out.println(
                   "|" + text_1 + 
            '\n' + "|" + 
            '\n' + "|" + text_2 +
            '\n' + "|" + 
            '\n' + "|" + text_3 + 
            '\n' + "|" + 
            '\n' + "|" + 
            '\n' + "|" + 
            '\n' + "|" + 
            '\n' + "|" + 
            '\n' + "|" + 
            '\n' + "|" + 
            '\n' + "[Ataque : 1][Defensa : 2][Estadisticas : 3][Magia : 4]"
        );
    }


    public static void game(){
        output("Esto iniciara","","");
        sc.nextLine();

    }

// Funciones del fuego

    public static void load_warriors(){
        //Load_hero
        hero.base_healt = hero.healt;
        hero.base_resistance = hero.resistance;
        hero.base_force = hero.force;


        //Load_villan

        villan.name = "Cronos";

        
        villan.base_healt = villan.healt*index_villan_upgrade;
        villan.base_resistance = villan.resistance*index_villan_upgrade;
        villan.base_force = villan.force*index_villan_upgrade;

        villan.healt = villan.base_healt;
        villan.resistance = villan.base_resistance;
        villan.force = villan.base_force;

    }

    public static void set_index_villan_difficulty(){
        switch (difficulty){
            case 1:
                index_villan_upgrade = (float)(1 - difficulty_index);
                break;

            case 2:
                index_villan_upgrade = (1.0f);
                break;

            case 3:
            index_villan_upgrade = (float)(1 + difficulty_index);
        }
                
    }


    public static void enter_to_continue(boolean reset_Scanner){
        if (reset_Scanner){
            sc.nextLine();
        }
        System.out.println("[Presiona enter para continuar]");
        sc.nextLine();
        //Fin función
    }


// Funciones del sistema

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
