/*
Crea una función que calcule el área de un polígono. Los polígonos que deben ser soportados son Triángulo, 
Cuadrado y Rectángulo. La función debe recibir el polígono y sus dimensiones como parámetros, y 
retornar el área correspondiente.
*/
import java.util.Scanner; //Importamos la libreria Scanner

public class Area_de_un_poligono {
    static Scanner sc = new Scanner(System.in); //Creamos el objeto sc para poder resivir datos de los usuarios
    
    public static void main (String[] args) {
        //Inicio algoritmo
        boolean _continue = true;
        float base_local;
        float altura_local;
        float lado_local;
        
        while (_continue){
            System.out.print("[Algoritmo para calcular el area de un poligono]" + '\n' + 
            "- Para calcular el area de un triangulo presione [1]" + '\n' + 
            "- Para calcular el area de un cuadrado presione [2]" + '\n' + 
            "- Para calcular el area de un rectangulo presione [3]" + '\n' + 
            "- Si desea salir, presione cualquier otro numero");
            
            switch (sc.nextInt()){
                case 1: // Area triangulo
                    System.out.print("Inserte el valor de la base del triangulo");
                    base_local = sc.nextFloat();
                    
                    System.out.print("Inserte el valor de la altura del triangulo");
                    altura_local = sc.nextFloat();
                    
                    System.out.println("El area del triangulo es [" + 
                    area_triangulo(base_local,altura_local) + "]");
                    break;
                
                case 2: //Area cuadrado
                    System.out.print("Inserte el lado del cuadrado");
                    lado_local = sc.nextFloat();
                    
                    System.out.println("El area del cuadrado es [" + 
                    area_cuadrado(lado_local) + "]");
                    break;
                
                case 3: //Area rectangulo
                    System.out.print("Inserte el valor de la base del rectangulo");
                    base_local = sc.nextFloat();
                    
                    System.out.print("Inserte el valor de la altura del rectangulo");
                    altura_local = sc.nextFloat();
                    
                    System.out.println("El area del rectangulo es [" + 
                    area_rectangulo(base_local,altura_local) + "]");
                    break;
                
                default: //Salir
                    _continue = false;
                
                //Fin switch
            }
            
            System.out.println();
            
            //Fin while
        }
        
        //Fin algoritmo
    }
    
    public static float area_triangulo(float base, float altura){
        return ( (base*altura)/2.0f );
        
        //Fin función
    }
    
    public static float area_cuadrado(float lado){
        return ( (float) Math.pow(lado,2.0f) );
        
        //Fin función
    }
    
    public static float area_rectangulo(float base, float altura){
        return ( base*altura );
        
        //Fin función
    }
    
}

