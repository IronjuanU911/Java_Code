/*
Crear un sistema orientado a objetos para gestionar una biblioteca.
El sistema debe manejar libros, usuarios y transacciones de préstamo.
*/

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



class user{
    String name;

}

class administrator extends user{

}

class customer extends user{
    ArrayList<Book> Books_purchased = new ArrayList<Book>();
}


public class Sistema_Biblioteca {
    public static void main (String[] args) {
        //Inicio algoritmo

        //Fin algoritmo
    }
}
