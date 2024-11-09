/*
Crear un sistema orientado a objetos para gestionar una biblioteca. 
El sistema debe manejar libros, usuarios y transacciones de préstamo.
*/

import java.io.IOException;
import java.util.ArrayList

public class Book{
    String name;
    int id;

    public void statistics(){
        System.out.println(
            "Nombre del libro : " + name + '\n' +
            "Id del libro : " + id
        );

    }

}


public class Transaction{
    
}



public class User{
    String name;

}

public class administrator extends user{
    
}

public class customer extends user{
    ArrayList<Book> Books_purchased = new ArrayList<Book>;
}


public class Sistema_Biblioteca {
    public static void main (String[] args) {
        //Inicio algoritmo
        
        //Fin algoritmo
    }
}

public class F_System{ //Clase que contiene funciones que utiliza este sistema pa que se vea mejor
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