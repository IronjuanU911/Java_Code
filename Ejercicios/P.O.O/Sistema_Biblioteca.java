/*
Crear un sistema orientado a objetos para gestionar una biblioteca.
El sistema debe manejar libros, usuarios y transacciones de préstamo.
*/

import java.io.IOException;
import java.util.ArrayList;

class Book{
    String name;
    int id;

    public void statistics(){
        System.out.println(
            "Nombre del libro : " + name + '\n' +
            "Id del libro : " + id
        );

    }

}


class Transaction{

}



class User{
    String name;

}

class administrator extends user{

}

class customer extends user{
    ArrayList<Book> Books_purchased = new ArrayList<Book>;
}


public class Sistema_Biblioteca {
    public static void main (String[] args) {
        //Inicio algoritmo

        //Fin algoritmo
    }
}

class F_System{ //Clase que contiene funciones que utiliza este sistema pa que se vea mejor
    public static void clean_terminal()  {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); //Borrar consola windows
        } catch (IOException | InterruptedException e) {
            System.out.print("\033[H\033[2J"); //Borrar consola linux
            System.out.flush();
        }
        //Los de mac se pueden joder :D
    }
}
