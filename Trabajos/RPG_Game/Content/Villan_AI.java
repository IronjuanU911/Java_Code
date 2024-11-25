package RPG_Game.Content;

import RPG_Game.RPG_Game;
import java.util.Random;

public class Villan_AI {
    static Random rd = new Random();

    static boolean process_of_healing = false;
    static boolean process_of_attack = true;
    static boolean process_of_special_attack = false;

    public static boolean output_process_of_healing = false;
    public static boolean output_process_of_attack = true;
    public static boolean output_process_of_special_attack = false;

    public static void villan_actions(){
        final int range_to_healing = 35;
        float priority_healing = RPG_Game.villan.healt/RPG_Game.villan.base_healt*100;


        if (!(output_process_of_healing && output_process_of_attack && output_process_of_special_attack)){
            if (priority_healing <= range_to_healing){
                process_of_healing = true; 
            } else {
                switch (rd.nextInt(2)){
                    case 1 -> {
                        process_of_special_attack = true;
                    }

                    default -> {
                        process_of_attack = true;
                    }
                    
                }
            }


        }

        if (RPG_Game.hero.magic >= RPG_Game.MAGIC_TO_SPECIAL_ATTACK){
            process_of_healing = false;
            process_of_attack = false;
            process_of_special_attack = false;
            if (RPG_Game.villan.magic >= RPG_Game.MAGIC_TO_SPECIAL_ATTACK){
                process_of_special_attack = true;
            }
        }

        output_process_of_attack = process_of_attack;
        output_process_of_healing = process_of_healing;
        output_process_of_special_attack = process_of_special_attack;

        //Start villan actions

        if (process_of_healing){
            if (RPG_Game.villan.magic < RPG_Game.MAGIC_TO_HEALING){
                RPG_Game.defend_process[1] = true;
            }else{
                RPG_Game.magic_process[1] = 1;
                process_of_healing = false;
            }

        //End healing
        }

        else if (process_of_attack){
            RPG_Game.attack_process[1] = RPG_Game.villan.force;
            process_of_attack = false;
        //End attack
        }

        else if (process_of_special_attack){
            if (RPG_Game.villan.magic < RPG_Game.MAGIC_TO_SPECIAL_ATTACK){
                RPG_Game.defend_process[1] = true;
            } else {
                RPG_Game.magic_process[1] = 2;
                process_of_special_attack = false;
            }
        //End special attack
        } else {
            RPG_Game.defend_process[1] = true;
        } 

    }



}