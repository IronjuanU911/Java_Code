/*Crea un programa en Java que solicite al usuario tres números y determine 
si el primero es mayor que el segundo y menor que el tercero. El programa 
debe utilizar tanto operadores de comparación como operadores lógicos*/
import java.util.Scanner;

public class Numero_mayor_o_menor_al_resto {
    public static void main (String[] args) {
        //Inicio
        Scanner sc = new Scanner(System.in); //Creamos el objeto scanerr
        
        System.out.printf("Inserte el primer numero"); //Numeros a comparar
        int num_1 = sc.nextInt(); 
        System.out.printf("Inserte el segundo numero");
        int num_2 = sc.nextInt();
        System.out.printf("Inserte el tercer numero");
        int num_3 = sc.nextInt();
        
        System.out.print("El primer numero (" + num_1 + ")");
        
        if (num_1 > num_2 && num_1 > num_3){ //Comprobacion si ambas condiciones son verdaderas
            System.out.print(" es mayor a los otros 2 numeros (" + num_2 + ") y (" + num_3 + ")");
        } else{
            if (num_1 > num_2){ //Comprobacion si el primer numero el mayor al numero 2
                System.out.print(" es mayor al segundo numero (" + num_2 + ") y tambien");
            } else {
                System.out.print(" es menor al segundo numero (" + num_2 + ") y tambien");
            }
            
            if (num_1 > num_3){ //Comprobacion si el primer numero es mayor al numero 3
                System.out.print(" es mayor al tercer numero (" + num_3 + ")");
            } else {
                System.out.print(" es menor al tercer numero (" + num_3 + ")");
            }
            
        }
        
        //Final
    }
}
