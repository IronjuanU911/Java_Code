/*
Un juego RPG
*/

package RPG_Game;

import RPG_Game.Content.*;

public class RPG_Game {
    
    public static Warrior hero = new Warrior();
    public static Warrior villan = new Warrior();
    
    static short difficulty;

    public static int[] magic_process = new int[2];
    public static boolean[] defend_process = new boolean[2];
    public static float[] attack_process = new float[2];


    public static final int MAGIC_TO_HEALING = 30; //magic_to_healin
    public static final int MAGIC_TO_SPECIAL_ATTACK = 90; //magic_to_special_attack

    public static void main (String[] args) {
        //Inicio algoritmo
        
        
        start();

        game();


        //Fin algoritmo
    }

    public static void start(){
        String hero_name = "";
        R_System.clean_terminal();

        R_System.output("Inserta tu nombre","","","",8);
        hero_name = R_Input.String_mode();
            
        String warning_ = "";

        while (true){
            R_System.output("Inserta el nivel de dificultad ","Facil [1]","Medio [2]","Dificil [3]",warning_,8);

            difficulty = R_Input.Short_mode();

            if (difficulty > 0 && difficulty < 4){
                break;
            } else {
                warning_ = "[Inserte un valor dentro del rango]";
            }
        }

        hero.load(hero_name, 2, villan, hero);
        villan.load("Cronos", difficulty, hero, villan);

        R_System.output("Cargando...",9);
        R_System.await(1000);
        R_System.output("Es un dia muy oscuro, de seguro estas muy confundido",9);
        R_System.await(2500);
        R_System.output(hero.name + ", has sido traido aqui para acabar con " + villan.name,0);

    }



    public static void game(){

        while (true){
            Villan_AI.villan_actions();

            menu();

            if (process_actions()){
                break;
            }

            R_System.clean_terminal();

        }


    }

// Funciones in_game

    public static void menu(){
        String warning = "";
        String text_menu;
        boolean _continue = true;

        if (Villan_AI.output_process_of_attack){
            text_menu = villan.name + " esta preparado";
        } else if (Villan_AI.output_process_of_special_attack){
            text_menu = villan.name + " parece tramar algo";
        } else if (Villan_AI.output_process_of_healing){
            text_menu = villan.name + " se ve herido";
        } else{
            text_menu = villan.name + " se ve precavido";
        }

        while (_continue) { 
            R_System.output(text_menu,"","",warning,1);
            switch (R_Input.Short_mode()){
                case 1 ->
                    _continue = attack_select();

                case 2 ->
                    _continue = defense_select();

                case 3 ->
                    _continue = magic_select();

                case 4 ->
                    _continue = statistics();

                default ->{
                    warning = "ADVERTENCIA:[Ingrese un valor valido]";
                    _continue = true;
                }
        }

        }


    }


    public static boolean attack_select(){
        String warning = "";
        boolean _continue = true;
        boolean _return = true;

        while (_continue) {
            _continue = false;
            R_System.output("Ataque basico hacia tu enemigo","","",warning,2);

            switch (R_Input.Short_mode()){
                case 1 -> {
                    attack_process[0] = hero.force;
                    _return = false;
                }
                case 0 -> {
                    _return = true;
                }
                default -> {
                warning = "ADVERTENCIA:[Ingrese un valor valido]";
                _continue = true;
                }

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
            R_System.output("Defenderte te hara mas resistente ante los ataques",
                "Tambien al descansar, recuperaras magia","",warning,2);

            switch (R_Input.Short_mode()){
                case 1 ->{
                    defend_process[0] = true;
                    _return = false;
                }
                case 0 ->
                    _return = true;

                default ->{
                warning = "ADVERTENCIA:[Ingrese un valor valido]";
                _continue = true;
                }

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
            R_System.output("Curarse : [Healt +" + hero.healt_recovered + "][Magia - " + MAGIC_TO_HEALING + "]",
                "Ataque especial: [Attack with Force*" + hero.special_attack_multipliquer + "][Magia - " + MAGIC_TO_SPECIAL_ATTACK + "]","",warning,"Magic = " + hero.magic,3);

            switch (R_Input.Short_mode()){
                case 1 -> {
                    if (hero.magic >= MAGIC_TO_HEALING){
                        magic_process[0] = 1;
                        _return = false;
                    } else {
                        warning = "[Magia insuficiente]";
                        _continue = true;
                    }
                }
                case 2 -> {
                    if (hero.magic >= MAGIC_TO_SPECIAL_ATTACK){
                        magic_process[0] = 2;
                        _return = false;
                    } else {
                        warning = "[Magia insuficiente]";
                        _continue = true; 
                    }
                }

                case 0 -> _return = true;

                default -> {
                    warning = "ADVERTENCIA:[Ingrese un valor valido]";
                    _continue = true;
                }

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
            R_System.output(
            "Healt = " + hero.healt + "/" + hero.base_healt + "       " + 
            "Magic = " + hero.magic + "/" + hero.base_magic,
            "Resistance = " + hero.resistance,
            "Force = " + hero.force,warning,4);

            switch (R_Input.Short_mode()){
                case 1 -> {
                    R_System.output("Analizando a " + villan.name,"","","",9);
                    R_System.await(1000);
                    R_System.output(
                        "Healt = " + villan.healt + "/" + villan.base_healt + "       " + 
                        "Magic = " + villan.magic + "/" + villan.base_magic,
                        "Resistance = " + villan.resistance,
                        "Force = " + villan.force,"",0);

                    _return = false; //false no pasa turno al ver estadisticas enemigo
                }

                case 0 -> {
                    _return = true;
                }

                default -> {
                warning = "ADVERTENCIA:[Ingrese un valor valido]";
                _continue = true;
                }

            }


        }

        return _return;

    }

// Funciones de iniciacion del juego

    public static boolean process_actions(){
        int i = -1;
        boolean end_game;

        hero.start();
        villan.start();

        for (boolean is_defend : defend_process){
            i++;
            if (is_defend){
                switch (i){
                    case 0 -> {
                        hero.defend();
                        defend_process[i] = false;
                    }
                    case 1 -> {
                        villan.defend();
                        defend_process[i] = false;
                    }
                }
            }


        }

        i = -1;
        
        for (int type_magic : magic_process){
            i++;
            if (type_magic != 0){
                switch (i){
                    case 0 -> {
                        hero.magic(type_magic);
                        magic_process[i] = 0;
                    }
                    case 1 -> {
                        villan.magic(type_magic);
                        magic_process[i] = 0;
                    }
                }
            }
        }

        i = -1;



        for (float damage : attack_process){
            i++;
            if (damage != 0){
                switch (i){
                    case 0 -> {
                        hero.attack(damage);
                        attack_process[i] = 0.0f;
                    }
                    case 1 -> {
                        villan.attack(damage);
                        attack_process[i] = 0.0f;
                    }
                }

            }


        }


    if (hero.healt <= 0 && villan.healt <= 0){
        R_System.output(hero.name + " a fallecido junto a " + villan.name,"A pesar del sacrificio, el mundo encontrara la paz","","",0);
        end_game = true;
    } else if (hero.healt <= 0){
        R_System.output(hero.name + " a fallecido","El mundo se estremecera ante el terror de " + villan.name,"","",0);
        end_game = true;
    } else if (villan.healt <= 0){
        R_System.output(villan.name + " a fallecido","lo haz hecho muy bien " + hero.name,"","",0);
        end_game = true;
    } else{
        end_game = false;
    }

    return end_game;

    }

}
