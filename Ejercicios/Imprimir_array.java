/* Crear un array, imprimir sus posiciones, actualizar sus valores y 
volverlos a imprimir*/
import java.util.Scanner; //Importamos la libreria scanner

public class Imprimir_array {
    public static void main (String[] args) {
        //Inicio
        Scanner sc = new Scanner(System.in); //Creamos el scanner
        
        System.out.print("Inserte la longitud del array a utilizar");
        int longitud_array = sc.nextInt();
        boolean play_while = true;
        
        int[] array = new int[longitud_array]; //Creamos un array con la longitud definida por el usuario
        
        while (play_while){
            for (int i = 0 ; i < array.length; i = i + 1 ){ //Con este ciclo, le pedimos al usuario todos los elementos del array
                int j = i + 1; //Creamos una variable para el print
                System.out.print("Inserte el valor " + j + " del array");
                array[i] = sc.nextInt();
            }
            System.out.print("Los valores del array son [");
            
            for (int i = 0; i < array.length; i = i + 1){//imprimimos los valores del array
                if (!(array.length == (i+1))){
                    System.out.print(array[i] + ", "); //Comprobaciones para que el codigo se vea mejor
                }else{
                    System.out.print(array[i]);
                }
                
            }
            System.out.print("]" + '\n' + '\n' + "Desea reescribir el array?" + '\n' + "Si = true, No = false");
            
            play_while = sc.nextBoolean();
            
        }
        
        //Final
    }
}
