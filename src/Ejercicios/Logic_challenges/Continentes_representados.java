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

import iron_package.*;
import java.util.ArrayList;


class developer{
    String firstName;
    String lastName;
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
    static ArrayList<developer> developer_list = new ArrayList<developer>();
    final static String[] all_continents = {"","Africa", "America","Asia","Europe","Oceania"};
    final static String[] all_languages = {"","Python","JavaScript","C/C++","Ruby","PHP","Java"};

    public static void main (String[] args) {
      start_menu();

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

      for (int i = 1; remaining_continents_length > i ; i++){
        for (developer select_developer : developer_list){
          if (select_developer.continent.equals(remaining_continents[i])){
            remaining_continents[i] = ""; //Volverlo vacio. 
          }
        }
      }


      for (String null_text : remaining_continents){ //Comprobamos si todos los elementos en remain_contientes son vacios
        if (!(null_text.equals(""))){
          is_true = false;
          break;
        }
      }

      return is_true;

    }

    public static void start_menu(){
      boolean _continue = true;
      String warning = "";
      while (_continue){
        _continue = false;
        F_System.Output(
        "[1]Añadir desarrollador",
        "[2]Ver lista de desarrolladores",
        "[0]Salir",

        warning,0);

        switch(F_Input.Int_mode()){
          case 1 -> add_developer();
          case 2 -> developers_menu(0);
          case 0 -> {}
          default -> {
            _continue = true;
            warning = "Inserte un valor valido";
          }
        }

      }

    }

    public static void developers_menu(int index_developer){
      int developer_list_lenght = developer_list.size();

      final boolean cant_left = index_developer == 0;
      final boolean cant_right = index_developer == developer_list_lenght -1;

      developer developer_selected = developer_list.get(index_developer);

      int output_mode;

      if (cant_left && cant_right){ //Seleccionamos el modo del output que se mostrara
        output_mode = 4;
      } else if (cant_left){
        output_mode = 2;
      } else if (cant_right){
        output_mode = 3;
      } else {
        output_mode = 1;
      }


      boolean _continue = true;
      String warning = "";

      while(_continue){
        _continue = false;
        F_System.Output("Nombre: " + developer_selected.firstName + " " + developer_selected.lastName,
          "Edad: " + developer_selected.age,
          "Continente: " + developer_selected.continent,
          "Lenguaje: " + developer_selected.language,

          warning,
          output_mode); // Las opciones a elegir, son las que se muestran en la funcion Output



        switch (F_Input.String_mode()){ //Dependiendo del valor que se ingrese, se ingresara a su respectivo menu
          case "x" -> {
            start_menu();
          }
          case "a" -> {
            if(!cant_left){
              developers_menu(index_developer - 1);
            } else {
              _continue = true;
            }
          }
          case "d" -> {
            if (!cant_right){
              developers_menu(index_developer + 1);
            } else {
              _continue = true;
            }
          }
          default -> {
            _continue = true;
          }
        }

        warning = "Inserte un valor dentro del rango";

      }

    

    }


    public static void add_developer(){
        developer new_developer = new developer();
        F_System.Output("Inserte el nombre del desarrollador",0);
        String firstName = F_Input.String_mode();

        F_System.Output("Inserte el apellido del desarrollador",0);
        String lastName = F_Input.String_mode();

        F_System.Output("Inserte la edad del desarrollador",0);
        int age = F_Input.Int_mode();

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
                ,0);
            switch (F_Input.Int_mode()){
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
              ,0);

          switch(F_Input.Int_mode()){
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

        start_menu();
    }

}
