/*
Clase F_Sistem que contiene funciones personalizadas por mi
*/

package iron_package;

import java.io.IOException;

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

    public static void Output(String text_1){
        Output(text_1,"","", "","");
    }

    public static void Output(String text_1, String text_end){
        Output(text_1,"","", "",text_end);
    }

    public static void Output(String text_1, String text_2, String text_end){
        Output(text_1,text_2,"", "",text_end);
    }

    public static void Output(String text_1, String text_2, String text_3, String text_end){
        Output(text_1,text_2,text_3,"",text_end);
    }

    public static void Output(String text_1, String text_2, String text_3, String text_4, String text_end){
        String text_menu = "[___________________Code_by_Iron___________________]";
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
            + '\n' + "|"
            + '\n' + "|" + text_end
            + '\n' + "|"
            + '\n' + text_menu

        );
    }

}
