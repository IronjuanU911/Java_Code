/*
Un juego RPG
*/

import java.util.Scanner;

class Warrior{
    String name = "";

    float base_healt;
    float base_resistance;
    float base_force;
    float base_magic;

    float healt = 200;
    float resistance = 10;
    float force = 10;
    float magic = 100;
    boolean is_alive = true;

    Warrior focused;

    public void is_attacked(float damage){
        healt = healt - damage;
    }

    public void attack(float damage){
        //output(name + "A atacado a " + focused.name ,"","","",0);
        focused.is_attacked(damage);
    }

    public void defend(){
        resistance++;
        //output(name + "Se a defendido","","","",0);
    }

    public void magic(int type_magic){
        healt = healt + 10;
        //output(name + "Se a curado","","","",0);
    }

}


public class RPG_Game {
    static Scanner sc = new Scanner(System.in);

    static Warrior hero = new Warrior();
    static Warrior villan = new Warrior();
    static short difficulty;
    static final float difficulty_index = 0.2f;
    static float index_villan_upgrade;

    static int[] magic_process = new int[2];
    static boolean[] defend_process = new boolean[2];
    static float[] attack_process = new float[2];

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


        load_warriors();


        System.out.println("Cargando...");
        await(1000);
        clean_terminal();
        System.out.println("Es un dia muy oscuro, de seguro estas muy confundido");
        await(2500);
        System.out.println(hero.name + ", has sido traido aqui para acabar con " + villan.name);
        await(2500);
        enter_to_continue(true,true);

    }

    public static void output(String text_1, String text_2, String text_3, String text_warning, int state){
        clean_terminal();

        String input_text = "";

        switch (state){
            case 1:
                input_text = "[Ataque : 1][Defensa : 2][Magia : 3][Estadisticas : 4]";
                break;
            case 2:
                input_text = "[Select : 1]________________________________[back : 0]";
                break;
            case 4:
                input_text = "[Analizar a " + villan.name + " : 1]_____________________[back : 0]";
                break;
            case 0:
                input_text = "[____________Presiona enter para continuar___________]";

        }

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
            '\n' + "|" + text_warning + 
            '\n' + "|" + 
            '\n' + input_text
        );

        if (state == 0){
            enter_to_continue(true,false);
        }
    }


    public static void game(){

        while (true){
            menu();

            process_actions();

            output("Nuevo ciclo","","","",0);

        }


    }

// Funciones in_game

    public static void menu(){
        String warning = "";
        boolean _continue = true;

        while (_continue) {
            _continue = false;
            output("Menu","","",warning,1);
            switch (sc.nextShort()){
                case 1:
                    _continue = attack_select();
                    break;
                case 2:
                    _continue = defense_select();
                    break;
                case 3:
                    _continue = magic_select();
                    break;
                case 4:
                    _continue = statistics();
                    break;
                default:
                    warning = "ADVERTENCIA:[Ingrese un valor valido]";
                    _continue = true;
                    break;
        }



        }


    }




    public static boolean attack_select(){
        String warning = "";
        boolean _continue = true;
        boolean _return = true;

        while (_continue) {
            _continue = false;
            output("Attack","","",warning,2);

            switch (sc.nextShort()){
                case 1:
                    output("Attacking","","","",2);
                    attack_process[0] = hero.force;
                    await(1000);
                    _return = false;
                    break;
                case 0:
                    _return = true;
                    break;
                default:
                warning = "ADVERTENCIA:[Ingrese un valor valido]";
                _continue = true;

            }


        }

        return _return;

    }   

    public static boolean defense_select(){
        String warning = "";
        boolean _continue = true;
        boolean _return = true;

        while (_continue) {
            _continue = false;
            output("Defense","","",warning,2);

            switch (sc.nextShort()){
                case 1:
                    output("Defending","","","",2);
                    defend_process[0] = true;
                    await(1000);
                    _return = false;
                    break;
                case 0:
                    _return = true;
                    break;
                default:
                warning = "ADVERTENCIA:[Ingrese un valor valido]";
                _continue = true;

            }


        }

        return _return;

    }

    public static boolean magic_select(){
        String warning = "";
        boolean _continue = true;
        boolean _return = true;

        while (_continue) {
            _continue = false;
            output("Magic","","",warning,2);

            switch (sc.nextShort()){
                case 1:
                    output("Healing","","","",2);
                    magic_process[0] = 1;
                    await(1000);
                    _return = false;
                    break;
                case 0:
                    _return = true;
                    break;
                default:
                warning = "ADVERTENCIA:[Ingrese un valor valido]";
                _continue = true;

            }


        }

        return _return;

    }

    public static boolean statistics(){
        String warning = "";
        boolean _continue = true;
        boolean _return = true;

        while (_continue) {
            _continue = false;
            output(
            "Healt = " + hero.healt + "/" + hero.base_healt,
            "Resistance = " + hero.resistance,
            "Force = " + hero.force,warning,4);

            switch (sc.nextShort()){
                case 1:
                    output("Analizando a " + villan.name,"","","",4);
                    await(1000);
                    output(
                        "Healt = " + villan.healt + "/" + villan.base_healt,
                        "Resistance = " + villan.resistance,
                        "Force = " + villan.force,"",0);

                    _return = false;
                    break;
                case 0:
                    _return = true;
                    break;
                default:
                warning = "ADVERTENCIA:[Ingrese un valor valido]";
                _continue = true;

            }


        }

        return _return;

    }

// Funciones de iniciacion del juego


    public static void process_actions(){
        int i = -1;

        for (int type_magic : magic_process){
            i++;
            if (type_magic != 0){
                switch (i){
                    case 0:
                        hero.magic(type_magic);
                        magic_process[i] = 0;
                        break;
                    case 1:
                        villan.magic(type_magic);
                        magic_process[i] = 0;
                        break;
                }
            }
        }

        i = -1;

        for (boolean is_defend : defend_process){
            i++;
            if (is_defend){
                switch (i){
                    case 0:
                        hero.defend();
                        defend_process[i] = false;
                        break;
                    case 1:
                        villan.defend();
                        defend_process[i] = false;
                        break;
                }
            }


        }

        i = -1;

        for (float damage : attack_process){
            i++;
            if (damage != 0){
                switch (i){
                    case 0:
                        hero.attack(damage);
                        attack_process[i] = 0.0f;
                        break;
                    case 1:
                        villan.attack(damage);
                        attack_process[i] = 0.0f;
                        break;
                }

            }


        }


    }




    public static void load_warriors(){
        //Load_hero
        hero.base_healt = hero.healt;
        hero.base_resistance = hero.resistance;
        hero.base_force = hero.force;
        hero.base_magic = hero.magic;

        hero.focused = villan;


        //Load_villan

        villan.name = "Cronos";

        
        villan.base_healt = villan.healt*index_villan_upgrade;
        villan.base_resistance = villan.resistance*index_villan_upgrade;
        villan.base_force = villan.force*index_villan_upgrade;
        villan.base_magic = villan.magic*index_villan_upgrade;

        villan.healt = villan.base_healt;
        villan.resistance = villan.base_resistance;
        villan.force = villan.base_force;
        villan.magic = villan.base_magic;

        villan.focused = hero;


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
                break;
        }
                
    }


    public static void enter_to_continue(boolean reset_Scanner,boolean visible_text){
        if (reset_Scanner){
            sc.nextLine();
        }
        if (visible_text){
            System.out.println("[Presiona enter para continuar]");
        }
        
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
