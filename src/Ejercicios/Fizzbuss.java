/*
Escribe un programa que muestre por consola los números del 1 al 100 (ambos incluidos) con un salto de línea entre cada número, pero sustituyendo los siguientes:
- Los múltiplos de 3 por la palabra "fizz".
- Los múltiplos de 5 por la palabra "buzz".
- Los múltiplos de 3 y de 5 por la palabra "fizzbuzz".
*/

import java.util.Scanner; //Invocamos la libreria Scanner

public class Fizzbuss {
    public static void main (String[] args) {
        //Inicio codigo
        Scanner sc = new Scanner(System.in); //Creamos el objeto sc
        
        final int multiplo_a = 3;
        final int multiplo_b = 5;
        final int residuo_esperado = 0;
        
        System.out.println("Inserte la cantidad de repeticiones para el algoritmo fizzbuzz");
        final int repeticiones_maximas = sc.nextInt();
        
        for (int num = 0; num < repeticiones_maximas; num = num + 1 ){ //Realizamos el for, para comprobar todos los numeros que indique el usuario
            if ((num % multiplo_a == residuo_esperado) || (num % multiplo_b == residuo_esperado)){ //Comprobamos si un numero es multiplo de tanto a como b
                
                if (num % multiplo_a == residuo_esperado){ //Comprobamos respectivamente si el numero es multiplo de a o de b, y imprimimos fizz y buzz respectivamente
                    System.out.print("fizz");
                }
                if (num % multiplo_b == residuo_esperado){
                    System.out.print("buzz");
                }
                
                System.out.println(); //hacemos un salto de linea al final
                
            }else{ //En caso contrario, escribimos el numero sin mas
                System.out.println(num);
            }
        }
        
        sc.close();
        //Fin codigo
    }
}