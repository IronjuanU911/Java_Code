package RPG_Game.Content;

import RPG_Game.Content.R_Input;
import java.io.IOException;

public class R_System {
    
    public static void output(String text_1,int state){ //Sobrecarga (Una misma funcion resive diferentes parametros)
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
            case 1 ->
                input_text = "[Ataque : 1][Defensa : 2][Magia : 3][Estadisticas : 4]";

            case 2 ->
                input_text = "[Select : 1]________________________________[back : 0]";

            case 3 ->
                input_text = "[Curarse : 1][Ataque especial : 2]__________[back : 0]";

            case 4 ->
                input_text = "[Analizar enemigo : 1]______________________[back : 0]";

            case 8 ->
                input_text = "[____________________________________________________]";

            case 9 ->
                input_text = "[__________________Espere por favor__________________]";

            case 0 ->
                input_text = "[____________Presiona enter para continuar___________]";


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
            R_Input.String_mode();
        }
    }

    public static void clean_terminal()  {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); //Borrar consola windows
        } catch (IOException | InterruptedException e) {
            System.out.print("\033[H\033[2J"); //Borrar consola linux
            System.out.flush(); 
        }
        //Los de mac se pueden joder :D
    }

    public static void await(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {}
        //Fin función
    }

}