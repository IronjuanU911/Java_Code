/*
Un juego RPG
*/

import java.util.Scanner;
import java.util.Random;

class Warrior{
    String name = "";

    final float healt_recovered = 30f;
    final float magic_recovered_to_defend = 30.0f;
    final float special_attack_multipliquer = 7.0f;

    float base_healt;
    float base_resistance;
    float base_force;
    float base_magic;
    float base_defence;
    float active_defence = 0.5f;

    float healt = 200.0f;
    float resistance = 10.0f;
    float force = 30.0f;
    float magic = 100.0f;
    float defence = 1.0f;

    Warrior focused;
    Warrior me;

    public void start(){
        defence = base_defence;
    }

    public void is_attacked(float damage, Warrior attacker){
        float damage_received;
        if (damage*defence - resistance/2.0 <= 0){
            damage_received = 1.0f;
        } else {
            damage_received = (float) (damage*defence - resistance/2.0);
        }

        healt = healt - damage_received;

        RPG_Game.output(attacker.name + " a atacado a " + name ,
            "Daño recibido = " + damage_received,"","",9);

    }

    public void attack(float damage){
        
        focused.is_attacked(damage, me);
        magic = magic + 10;
        RPG_Game.await(1500);
    }

    public void defend(){
        defence = active_defence;
        if (magic + magic_recovered_to_defend > base_magic){
            magic = base_magic;
        } else {
            magic = magic + magic_recovered_to_defend;
        }
        
        RPG_Game.output(name + " se a defendido","","","",9);
        RPG_Game.await(1500);
    }

    public void magic(int type_magic){
        switch (type_magic){
            case 1://Curarse
                healt = healt + healt_recovered;
                magic = magic - RPG_Game.magic_to_healing;
                RPG_Game.output(name + " se a curado","","","",9);
                RPG_Game.await(1500);
                break;
            case 2://Ataque especial
                attack(force*special_attack_multipliquer);
                magic = magic - RPG_Game.magic_to_special_attack;
                break;
        }
        
        
    }


}


public class RPG_Game {
    static Scanner sc = new Scanner(System.in);
    static Random rd = new Random();

    static Warrior hero = new Warrior();
    static Warrior villan = new Warrior();
    static short difficulty;
    static final float difficulty_index = 0.2f;
    static float index_villan_upgrade;

    static int[] magic_process = new int[2];
    static boolean[] defend_process = new boolean[2];
    static float[] attack_process = new float[2];


    static final int magic_to_healing = 30;
    static final int magic_to_special_attack = 90;

    public static void main (String[] args) {
        //Inicio algoritmo
        
        
        start();

        game();



        

        //Fin algoritmo
    }

    public static void start(){
        clean_terminal();

        output("Inserta tu nombre","","","",8);
        hero.name = sc.nextLine();
            

        while (true){
            String warning_ = "";

            output("Inserta el nivel de dificultad ","Facil [1]","Medio [2]","Dificil [3]",warning_,8);

            difficulty = sc.nextShort();

            if (difficulty > 0 && difficulty < 4){
                set_index_villan_difficulty();
                break;
            } else {
                warning_ = "[Inserte un valor dentro del rango]";
            }
        }


        load_warriors();

        output("Cargando...",9);
        await(1000);
        output("Es un dia muy oscuro, de seguro estas muy confundido",9);
        await(2500);
        output(hero.name + ", has sido traido aqui para acabar con " + villan.name,0);

    }
    public static void output(String text_1,int state){ //Sobrecarga
        output(text_1,"","","","",state);
    }

    public static void output(String text_1,String text_warning,int state){
        output(text_1,"","","",text_warning,state);
    }

    public static void output(String text_1,String text_2,String text_warning,int state){
        output(text_1,text_2,"","",text_warning,state);
    }

    public static void output(String text_1, String text_2, String text_3, String text_warning, int state){
        output(text_1,text_2,text_3,"",text_warning,state);
    }

    public static void output(String text_1, String text_2, String text_3, String text_4,String text_warning, int state){
        clean_terminal();

        String input_text = "";

        switch (state){
            case 1:
                input_text = "[Ataque : 1][Defensa : 2][Magia : 3][Estadisticas : 4]";
                break;
            case 2:
                input_text = "[Select : 1]________________________________[back : 0]";
                break;
            case 3:
                input_text = "[Curarse : 1][Ataque especial : 2]__________[back : 0]";
                break;
            case 4:
                input_text = "[Analizar a " + villan.name + " : 1]_____________________[back : 0]";
                break;
            case 8:
                input_text = "[____________________________________________________]";
                break;
            case 9:
                input_text = "[__________________Espere por favor__________________]";
                break;
            case 0:
                input_text = "[____________Presiona enter para continuar___________]";
                break;

        }

        System.out.println(
                   "|" + text_1 + 
            '\n' + "|" + 
            '\n' + "|" + text_2 +
            '\n' + "|" + 
            '\n' + "|" + text_3 + 
            '\n' + "|" + 
            '\n' + "|" + text_4 +
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
            villan_actions();

            menu();

            if (process_actions()){
                break;
            }


        }


    }

// Funciones in_game

    public static void menu(){
        String warning = "";
        String text_menu = "";
        boolean _continue = true;

        if (output_process_of_attack){
            text_menu = villan.name + " esta preparado";
        } else if (output_process_of_special_attack){
            text_menu = villan.name + " parece tramar algo";
        } else if (output_process_of_healing){
            text_menu = villan.name + " se ve herido";
        } else{
            text_menu = villan.name + " se ve precavido";
        }

        while (_continue) {
            _continue = false;
            output(text_menu,"","",warning,1);
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
            output("Ataque basico hacia tu enemigo","","",warning,2);

            switch (sc.nextShort()){
                case 1:
                    attack_process[0] = hero.force;
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
            output("Defenderte te hara mas resistente ante los ataques",
                "Tambien al descansar, recuperaras magia","",warning,2);

            switch (sc.nextShort()){
                case 1:
                    defend_process[0] = true;
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
            output("Curarse : [Healt +" + hero.healt_recovered + "][Magia - " + magic_to_healing + "]",
                "Ataque especial: [Attack with Force*" + hero.special_attack_multipliquer + "][Magia - " + magic_to_special_attack + "]","",warning,3);

            switch (sc.nextShort()){
                case 1:
                    if (hero.magic >= magic_to_healing){
                        magic_process[0] = 1;
                        _return = false;
                    } else {
                        warning = "[Magia insuficiente]";
                        _continue = true;
                    }

                    

                    break;
                case 2:
                    if (hero.magic >= magic_to_special_attack){
                        magic_process[0] = 2;
                        _return = false;
                    } else {
                        warning = "[Magia insuficiente]";
                        _continue = true; 
                    }
                    
                    break;

                case 0:
                    _return = true;
                    break;
                default:
                    warning = "ADVERTENCIA:[Ingrese un valor valido]";
                    _continue = true;
                    break;

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
            "Healt = " + hero.healt + "/" + hero.base_healt + "       " + 
            "Magic = " + hero.magic + "/" + hero.base_magic,
            "Resistance = " + hero.resistance,
            "Force = " + hero.force,warning,4);

            switch (sc.nextShort()){
                case 1:
                    output("Analizando a " + villan.name,"","","",9);
                    await(1000);
                    output(
                        "Healt = " + villan.healt + "/" + villan.base_healt + "       " + 
                        "Magic = " + villan.magic + "/" + villan.base_magic,
                        "Resistance = " + villan.resistance,
                        "Force = " + villan.force,"",0);

                    _return = false; //No pasa turno al ver estadisticas enemigo
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

    static boolean process_of_healing = false;
    static boolean process_of_attack = true;
    static boolean process_of_special_attack = false;

    static boolean output_process_of_healing = false;
    static boolean output_process_of_attack = true;
    static boolean output_process_of_special_attack = false;

    public static void villan_actions(){
        final int range_to_healing = 35;
        float priority_healing = (float) villan.healt/villan.base_healt*100;


        if (!(output_process_of_healing && output_process_of_attack && output_process_of_special_attack)){
            if (priority_healing <= range_to_healing){
                process_of_healing = true; 
            } else {
                switch (rd.nextInt(2)){
                    case 1:
                        process_of_special_attack = true;
                        break;
                    default:
                        process_of_attack = true;
                        break;
                }
            }


        }

        if (hero.magic >= magic_to_special_attack){
            process_of_healing = false;
            process_of_attack = false;
            process_of_special_attack = false;
            if (villan.magic >= magic_to_special_attack){
                process_of_special_attack = true;
            }
        }

        output_process_of_attack = process_of_attack;
        output_process_of_healing = process_of_healing;
        output_process_of_special_attack = process_of_special_attack;

        //Start villan actions

        if (process_of_healing){
            if (villan.magic < magic_to_healing){
                defend_process[1] = true;
            }else{
                magic_process[1] = 1;
                process_of_healing = false;
            }

        //End healing
        }

        else if (process_of_attack){
            attack_process[1] = villan.force;
            process_of_attack = false;
        //End attack
        }

        else if (process_of_special_attack){
            if (villan.magic < magic_to_special_attack){
                defend_process[1] = true;
            } else {
                magic_process[1] = 2;
                process_of_special_attack = false;
            }
        //End special attack
        } else {
            defend_process[1] = true;
        } 

    }


    public static boolean process_actions(){
        int i = -1;
        boolean end_game = false;

        hero.start();
        villan.start();

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


    if (hero.healt <= 0 && villan.healt <= 0){
        output(hero.name + " a fallecido junto a " + villan.name,"A pesar del sacrificio, el mundo encontrara la paz","","",0);
        end_game = true;
    } else if (hero.healt <= 0){
        output(hero.name + " a fallecido","El mundo se estremecera ante el terror de " + villan.name,"","",0);
        end_game = true;
    } else if (villan.healt <= 0){
        output(villan.name + " a fallecido","lo haz hecho muy bien " + hero.name,"","",0);
        end_game = true;
    } else{
        end_game = false;
    }

    return end_game;

    }




    public static void load_warriors(){
        //Load_hero
        hero.base_healt = hero.healt;
        hero.base_resistance = hero.resistance;
        hero.base_force = hero.force;
        hero.base_magic = hero.magic;
        hero.base_defence = hero.defence;

        hero.focused = villan;
        hero.me = hero;

        hero.magic = 0;


        //Load_villan

        villan.name = "Cronos";

        
        villan.base_healt = villan.healt*index_villan_upgrade;
        villan.base_resistance = villan.resistance*index_villan_upgrade;
        villan.base_force = villan.force*index_villan_upgrade;
        villan.base_magic = villan.magic;
        villan.base_defence = villan.defence;

        villan.healt = villan.base_healt;
        villan.resistance = villan.base_resistance;
        villan.force = villan.base_force;

        villan.magic = 0;

        villan.focused = hero;
        villan.me = villan;


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
            index_villan_upgrade = (float)(1 + difficulty_index*2);
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
