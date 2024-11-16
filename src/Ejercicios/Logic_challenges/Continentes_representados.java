/*
Continentes representados
Escribir una función que recibe como parametro una lista de desarrolladores que se anotaron para asistir
a una meetup. La función debe devolver true si existe al menos una persona de cada continente (Africa,
Americas, Asia, Europe, Oceania).
Nota: Los continentes siempre estarán presentes y escritos correctamente.

Ejemplo:
continentesRepresentados([
  {
    firstName: "Fatima",
    lastName: "A.",
    country: "Algeria",
    continent: "Africa",
    age: 25,
    language: "JavaScript",
  },
  {
    firstName: "Agustín",
    lastName: "M.",
    country: "Chile",
    continent: "Americas",
    age: 37,
    language: "C",
  },
  {
    firstName: "Jing",
    lastName: "X.",
    country: "China",
    continent: "Asia",
    age: 39,
    language: "Ruby",
  },
  {
    firstName: "Laia",
    lastName: "P.",
    country: "Andorra",
    continent: "Europe",
    age: 55,
    language: "Ruby",
  },
  {
    firstName: "Oliver",
    lastName: "Q.",
    country: "Australia",
    continent: "Oceania",
    age: 65,
    language: "PHP",
  },
]); // true

Bonus:

    Hacer otra función para retornar la cantidad de JavaScript developers que vienen de Europa y escribir los tests necesarios
    Hacer otra función que retorne el mismo array pero con una nueva propiedad greeting que contenga el valor Hi < firstName here >, what do you like the most about < language here >? y escribir los tests necesarios
    Hacer otra función que liste los lenguajes representados, sin repetir y escribir los tests necesarios


*/
package Ejercicios.Logic_challenges;

import java.util.ArrayList;
import java.util.Scanner;
import iron_package.F_System;

class developer{
    String firstName;
    String lastName;
    String country;
    String continent;
    String language;
    int age;

    public void Insert_data(
        String firstName,
        String lastName,
        String continent,
        int age
        ){ //Start function
        this.firstName = firstName;
        this.lastName = lastName;
        this.continent = continent;
        this.age = age;

    }
}

public class Continentes_representados {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<developer> developer_list = new ArrayList<developer>();
    public static void main (String[] args) {
        F_System.Output("Hello World!");

        //Fin algoritmo
    }

    public static void add_developer(){
        developer new_developer = new developer();
        F_System.Output("Inserte el nombre del desarrollador");
        String firstName = sc.nextLine();

        F_System.Output("Inserte el apellido del desarrollador");
        String lastName = sc.nextLine();

        F_System.Output("Inserte la edad del desarrollador");
        int age = sc.nextInt();

        String continent;
        String text_warning = "";
        boolean _continue = true;


        while(_continue){
            _continue = false;
            F_System.Output("Inserte el continente que representa segun su indice",
                "[1]Africa         [4]Europe",
                "[2]America        [5]Oceania",
                "[3]Asia",
                text_warning
                );
            switch (sc.nextInt()){
                case 1 -> continent = "Africa";
                case 2 -> continent = "America";
                case 3 -> continent = "Asia";
                case 4 -> continent = "Europe";
                case 5 -> continent = "Oseania";
                default -> {text_warning = "[Inserte un valor dentro del rango]";_continue = true;}
            }
        }



        F_System.Output("Inserte el lenguaje de programacion que domina segun su indice",
            "[1]Python         [4]Ruby",
            "[2]JavaScript     [5]PHP",
            "[3]C/C++          [6]Java",
            ""
        );

    }

}
