/*
Clase F_Sistem que contiene funciones personalizadas por mi
*/
import java.io.IOException;

class F_System { //Clase que contiene funciones que utiliza este sistema pa que se vea mejor
    public static void clean_terminal() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); //Borrar consola windows
        } catch (IOException | InterruptedException e) {
            System.out.print("\033[H\033[2J"); //Borrar consola linux
            System.out.flush();
        }
        //Los de mac se pueden joder :D
    }
}
