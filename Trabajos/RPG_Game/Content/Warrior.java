package RPG_Game.Content;

import RPG_Game.*;
import RPG_Game.Content.*;

public class Warrior{
    public String name = "";

    public final float healt_recovered = 30f;
    public final float magic_recovered_to_defend = 30.0f;
    public final float special_attack_multipliquer = 7.0f;
    

    public float base_healt;
    public float base_resistance;
    public float base_force;
    public float base_magic;
    public float base_defence;

    public float active_defence = 0.5f;

    public float healt = 200.0f;
    public float resistance = 10.0f;
    public float force = 30.0f;
    public float magic = 100.0f;
    public float defence = 1.0f;

    public Warrior focused;
    public Warrior me;

    public float set_index_difficulty(int _difficulty){
        final float difficulty_index = 0.2f;

        float index = 0.0f;
        switch (_difficulty){
            case 1 ->{
                index = (1 - difficulty_index);
            }

            case 2 ->{
                index = (1.0f);
            }

            case 3 ->{
                index = (1 + difficulty_index*2);
            }

        }
        return index;
                
    }

    public void load(String name_warrior, int _difficulty, Warrior focused, Warrior me){
        name = name_warrior;
        
        base_healt = healt*set_index_difficulty(_difficulty);
        base_resistance = resistance*set_index_difficulty(_difficulty);
        base_force = force*set_index_difficulty(_difficulty);
        base_magic = magic;
        base_defence = defence;

        healt = base_healt;
        resistance = base_resistance;
        force = base_force;

        magic = 0;

        this.focused = focused;
        this.me = me;

    }


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

        R_System.output(attacker.name + " a atacado a " + name ,
            "Daño recibido = " + damage_received,"","",9);

    }

    public void attack(float damage){
        
        focused.is_attacked(damage, me); // Paso por valor (Damage) y paso por referencia (me)
        magic = magic + 10;
        R_System.await(1500);
    }

    public void defend(){
        defence = active_defence;
        if (magic + magic_recovered_to_defend > base_magic){
            magic = base_magic;
        } else {
            magic = magic + magic_recovered_to_defend;
        }
        
        R_System.output(name + " se a defendido","","","",9);
        R_System.await(1500);
    }

    public void magic(int type_magic){
        switch (type_magic){
            case 1 -> {
                //Curarse
                healt = healt + healt_recovered;
                magic = magic - RPG_Game.MAGIC_TO_HEALING;
                R_System.output(name + " se a curado","","","",9);
                R_System.await(1500);
            }
            case 2 -> {
                //Ataque especial
                attack(force*special_attack_multipliquer);
                magic = magic - RPG_Game.MAGIC_TO_SPECIAL_ATTACK;
            }
        }
        
        
    }


} // End Warrior