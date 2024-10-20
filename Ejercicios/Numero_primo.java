/*
Escribe un programa que reciba un número y determine si es primo. Luego, 
imprime todos los números primos entre 1 hasta un numero cualquiera.
*/
import java.util.Scanner;

public class Numero_primo {
    static Scanner sc = new Scanner(System.in); //Creamos el objeto Scanner para que permanesca en todas las funciones
    
    public static void main (String[] args) {
        //Inicio algoritmo
        boolean _continue = true;
        
        
        while (_continue){
            System.out.print("[Comprobador de numeros primos]" + '\n' + 
            "- Si desea verificar si un numero es primo presione [1]" + '\n'+
            "- Si desea obtener una lista con numeros primos hasta donde ud desee presione [2]" + '\n' + 
            "- Si desea salir presione cualquier otro numero");
            switch (sc.nextInt()){
                case 1:
                    verificar_numero_usuario();
                    break;
                
                case 2:
                    imprimir_primos();
                    break;
                
                default:
                    _continue = false;
                    break;
            }
            
        }
        //Fin algoritmo
    }
        
        
    public static void imprimir_primos(){
        //Inicio función
        System.out.print("¿Cuantos numeros primos desea?");
        final int cantidad_primos = sc.nextInt();
        int primos_impresos = 0;
        
        System.out.print("[");//Abrimos corchetes
        for (int i = 1; primos_impresos <= cantidad_primos; i++){ //Recorremos todos los numeros del 1 hasta el numero seleccionado
            if (es_primo(i)){ //Si el numero es primo, se mostrara en el output
                System.out.print(i);
                primos_impresos++; //Sumamos en uno la cantidad de primos impresos
                
                if (primos_impresos <= cantidad_primos){//Separacion para mejorar el output
                    System.out.print(", ");
                }
            }
            //Fin for
        }
        System.out.println("]" + '\n');//Cerramos corchetes
        //Fin función
    }
    
    
    public static void verificar_numero_usuario(){
        //Inicio funcion
        int numero_a_comprobar;
        
        System.out.print("¿Que numero desea verificar como un primo?"); 
        numero_a_comprobar = sc.nextInt(); //Le pedimos al usuario el numero a comprobar
        if (es_primo(numero_a_comprobar)){ //Segun la funcion es_primo, nos lo indicara y imprimimos el resultado
            System.out.println("El numero " + numero_a_comprobar + " es primo");
        } else {
            System.out.println("El numero " + numero_a_comprobar + " no es primo");
        }
        System.out.println();
        //Fin funcion
    }
    
    public static boolean es_primo(int numero){ //Creamos una funcion, capaz de definir si un numero es primo o no
        //Inicio función
        final float raiz_numero = (float) Math.sqrt(numero);
        
        if (numero <= 1){ //Miramos si el numero no es menor a 1, porque de ser ese el caso no seria primo
            return false;
        }
        
        for (int i = 2; i <= raiz_numero; i++){//Comprobamos hasta la raiz del numero mismo
            if (numero % i == 0){ //Si el numero es divisible por cualquier numero i
                return false;
            }
        }
        
        return true; //Si supera el ciclo for, significa que el numero es primo
        //Fin función
    }
    
}

