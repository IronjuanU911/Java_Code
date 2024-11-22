/*
Clase F_Sistem que contiene funciones personalizadas por mi
*/

package iron_package;

import iron_package.F_Input;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class F_System { //Clase que contiene funciones que utiliza este sistema pa que se vea mejor
    public static void clean_terminal() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); //Borrar consola windows
        } catch (IOException | InterruptedException e) {
            System.out.print("\033[H\033[2J"); //Borrar consola linux
            System.out.flush();
        }
        //Los de mac se pueden joder :D
    }

    public static void Output(String text_1, int mode){
        Output(text_1,"","", "","","",mode);
    }

    public static void Output(String text_1, String text_end, int mode){
        Output(text_1,"","", "","",text_end,mode);
    }

    public static void Output(String text_1, String text_2, String text_end, int mode){
        Output(text_1,text_2,"", "","",text_end,mode);
    }

    public static void Output(String text_1, String text_2, String text_3, String text_end, int mode){
        Output(text_1,text_2,text_3,"","",text_end,mode);
    }

    public static void Output(String text_1, String text_2, String text_3, String text_4, String text_end, int mode){
        Output(text_1,text_2,text_3,text_4,"",text_end,mode);
    }

    public static void Output(String text_1, String text_2, String text_3, String text_4, String text_5, String text_end, int mode){
        
        String text_menu = "";

        switch(mode){
            case 1 -> text_menu = "[Left : a][Right: d]_____________________________________[Exit: x]";
            case 2 -> text_menu = "[Right: d]_______________________________________________[Exit: x]";
            case 3 -> text_menu = "[Left: a]________________________________________________[Exit: x]";
            case 4 -> text_menu = "[________________________________________________________[Exit: x]";
            case 9 -> text_menu = "[__________________Presiona enter para continuar_________________]";
            default -> text_menu = "[__________________________Code_by_Iron__________________________]";
        }
        
        
        clean_terminal();
        System.out.println(
                     "|" + text_1
            + '\n' + "|"
            + '\n' + "|" + text_2
            + '\n' + "|"
            + '\n' + "|" + text_3
            + '\n' + "|"
            + '\n' + "|" + text_4
            + '\n' + "|"
            + '\n' + "|" + text_5
            + '\n' + "|" + text_end
            + '\n' + "|"
            + '\n' + text_menu

        );
    
        if (mode == 9){ //Hacemos que el usuario presione enter a continuar :D
            F_Input.String_mode();
        }
    
    }

    public static ArrayList<String> Array_to_ArrayList(String[] Input_array){
        ArrayList<String> Output_Array = new ArrayList<String>();

        for (String Element : Input_array){
            Output_Array.add(Element);
        }

        return Output_Array;
    }

    public static String Iterador_ArrayList(ArrayList Input_array){
        Iterator iterador_array = Input_array.iterator(); //Se crea el iterador
        String Output_text = "[";

        while (iterador_array.hasNext()){ //Si existe un elemento siguiente en el array, se guarda en el output
            Output_text = Output_text + iterador_array.next();
            if (iterador_array.hasNext()){ //Si en el siguiente siclo se va a imprimir un elemento, se pone una ,
                Output_text = Output_text + ", ";
            }
        }
        Output_text = Output_text + "]";

        return Output_text;
    }

}

