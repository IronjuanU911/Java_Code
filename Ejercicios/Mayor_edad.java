//Declara y asigna valores a variables que representen la edad, 
//altura, inicial del nombre, y si una persona es mayor de edad o no.

public class Mayor_edad {
    public static void main (String[] args) {
        //Inicio
        
        char inicial_nombre = 'j'; //Definimos variables
        float altura_metros = 1.75f;
        int edad = 45;
        
        System.out.print( //Escribimos el texto inicial de manera ordenada
            "El hombre, cuya inicial es " + inicial_nombre + 
            ", posee una altura de " + altura_metros + 
            " y tiene " + edad + " años.");
        
        if (edad >= 18) { //Escribimos el texto final, indicando si es mayor de edad o no
            System.out.print(" Haciendolo un mayor de edad");
        } else{
            System.out.print(" Haciendolo un menor de edad");
        }
        
        //Final
    }
}
