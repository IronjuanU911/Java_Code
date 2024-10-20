/*
Escribe una función que reciba 3 números y devuelva el mayor.
*/
import java.util.Scanner; //Importamos la libreria Scanner

public class Numero_mayor_v2 {
    public static void main (String[] args) {
        //Inicio algoritmo
        Scanner sc = new Scanner(System.in); //Creamos el objeto sc pa escanear
        
        
        System.out.print("Este es un algoritmos que compara 3 numeros y nos indica cual es el mayor" + '\n' + 
        "Inserte el primer numero a comparar");
        int a = sc.nextInt();
        
        System.out.print("Inserte el segundo numero a comparar");
        int b = sc.nextInt();
        
        System.out.print("Inserte el tercer numero a comparar");
        int c = sc.nextInt();
        
        System.out.print("El numero mayor es " + detectar_mayor(a,b,c));
        //Fin algoritmo
    }
    
    
    
    public static int detectar_mayor(int num_1, int num_2, int num_3){
        if (num_1 > num_2 && num_1 > num_3){ //Si el numero 1 es mayor al resto, retorne 1
            return num_1;
        } else if (num_2 > num_3){ // Si el numero 2 es mayor, lo retorne
            return num_2;
        } else{ //Si nada se cumple, retorne 3
            return num_3;
        }
        
        //Fin Función
    }
    
    
}

