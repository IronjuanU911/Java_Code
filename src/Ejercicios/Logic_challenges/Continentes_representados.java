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
package Logic_challenges;

import iron_package.F_System;
import java.util.ArrayList;
import java.util.Scanner;

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
        String language,
        int age
        ){ //Start function
        this.firstName = firstName;
        this.lastName = lastName;
        this.continent = continent;
        this.language = language;
        this.age = age;

    }
}

public class Continentes_representados {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<developer> developer_list = new ArrayList<developer>();
    final static String[] all_continents = {"","Africa", "America","Asia","Europe","Oceania"};
    final static String[] all_languages = {"","Python","JavaScript","C/C++","Ruby","PHP","Java"};
    public static void main (String[] args) {
        add_developer();

        //Fin algoritmo
    }

    public static boolean all_continents_developer_presented(){
      boolean is_true = true; //Variable que indica si se presenta un desarrollador por cada continente :D
      String[] remaining_continents = all_continents;
      int remaining_continents_length = remaining_continents.length;

      /* 
      La idea en la siguiente iteracion es hacer un for de cada uno de los continentes que quedan por comprobar, y si 
      se encuentra que uno se los desarrolladores se encuentra en la lista de continentes que aun no se an comprobado
      dicho continente se elimina de la lista volviendolo vacio, si al final de comprobar todos los desarroladores
      quedan continentes restantes, devolvera false. 
      */

      for (int i = 1; remaining_continents_length >= i ; i++){
        for (developer select_developer : developer_list){
          if (select_developer.continent.equals(remaining_continents[i])){
            remaining_continents[i] = ""; //Volverlo vacio. 
          }
        }
      }

      return is_true;

    }


    public static void add_developer(){
        developer new_developer = new developer();
        F_System.Output("Inserte el nombre del desarrollador");
        String firstName = sc.nextLine();

        F_System.Output("Inserte el apellido del desarrollador");
        String lastName = sc.nextLine();

        F_System.Output("Inserte la edad del desarrollador");
        int age = sc.nextInt();

        String continent = "";
        String language = "";
        String text_warning = "";
        boolean _continue = true;


        while(_continue){
            _continue = false;
            F_System.Output("Inserte el continente que representa segun su indice", //all_continents
                "[1]" + all_continents[1] + "         [4]" + all_continents[4], 
                "[2]" + all_continents[2] + "        [5]" + all_continents[5],
                "[3]" + all_continents[3],
                text_warning
                );
            switch (sc.nextInt()){
                case 1 -> continent = all_continents[1];
                case 2 -> continent = all_continents[2];
                case 3 -> continent = all_continents[3];
                case 4 -> continent = all_continents[4];
                case 5 -> continent = all_continents[5];
                default -> {text_warning = "[Inserte un valor dentro del rango]";_continue = true;}
            }
        }

        text_warning = ""; //Resiclamos variables para el siguiente ciclo
        _continue = true;

        while (_continue){
          _continue = false;
          
          F_System.Output("Inserte el lenguaje de programacion que domina segun su indice", //all_languages
              "[1]" + all_languages[1] + "         [4]" + all_languages[4],
              "[2]" + all_languages[2] + "     [5]" + all_languages[5],
              "[3]" + all_languages[3] + "          [6]" + all_languages[6],
              text_warning
              );

          switch(sc.nextInt()){
            case 1 -> language = all_languages[1];
            case 2 -> language = all_languages[2];
            case 3 -> language = all_languages[3];
            case 4 -> language = all_languages[4];
            case 5 -> language = all_languages[5];
            case 6 -> language = all_languages[6];
            default -> {text_warning = "[Inserte un valor dentro del rango]";_continue = true;}

          }

        }

        /*
        Creamos un nuevp desarrollador, Pedimos al usuario de manera ordenada los datos del desarrollador,
        para luego agregarle los datos con la funcion Insert data y luego al desarrollador lo agregamos
        a la lista de desarrolladores 
        */

        new_developer.Insert_data(firstName, lastName, continent, language, age);

        developer_list.add(new_developer);

    }

}
