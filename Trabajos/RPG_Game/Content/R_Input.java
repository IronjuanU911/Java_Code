package RPG_Game.Content;

import RPG_Game.Content.R_System;
import java.util.InputMismatchException;
import java.util.Scanner;


class Input_exit{
    public static void check_exit(String text) { //Excepcion personalizada para salir del programa
        if (text.equals("exit")){
            R_System.clean_terminal();
            System.exit(0);
        }
    }

}

public class R_Input {
    final static short number_error_return = 32767;
    static boolean primitive_is_read = false;
    static Scanner sc = new Scanner(System.in);

    public static short Short_mode(){
        short short_to_return = 0;
        primitive_is_read = true;

        try {
            short_to_return = sc.nextShort(); //Le pedimos un short al usuario
        } catch (InputMismatchException e) {
            Input_exit.check_exit(sc.nextLine()); //Limpiamos consola y verificamos si se quiere salir
            
            short_to_return = number_error_return; // Si le da por poner un string, mandamos number_error_return
        }

        return short_to_return;
    }



    public static int Int_mode(){
        int int_to_return = 0;
        primitive_is_read = true;

        try {
            int_to_return = sc.nextInt(); //Le pedimos un entero al usuario
        } catch (InputMismatchException e) {
            Input_exit.check_exit(sc.nextLine()); //Limpiamos consola y verificamos si se quiere salir
            int_to_return = (int) number_error_return; // Si le da por poner un string, mandamos number_error_return
        }

        return int_to_return;
    }

    public static String String_mode(){ 
        String string_to_return;
        if (primitive_is_read){
            primitive_is_read = false;
            sc.nextLine();
        }
        string_to_return = sc.nextLine();

        Input_exit.check_exit(string_to_return);


        return string_to_return;
    }
}