//Realice un algoritmo para determinar el sueldo semanal de un trabajador con base 
//en las horas trabajadas y el pago por hora, considerando que después de las 40 
//horas cada hora se considera como excedente y se paga el doble.

import java.util.Scanner; //Importamos la libreria scanner

public class Sueldo_semanal {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in); //Creamos el objeto scanner
        
        System.out.println("Inserte el pago por hora del trabajador"); //Pedimos al usuario el pago por hora y las horas trabajadas
        int pago_por_hora = sc.nextInt();
        
        System.out.println("Inserte la cantidad de horas trabajadas");
        int horas_trabajadas = sc.nextInt();
        
        int horas_extras = 0;
        
        
        if (pago_por_hora < 0){ //Comprobamos que el usuario no se endeuda trabajando
            System.out.println("A poco te pagan con deudas?");
        } else if (horas_trabajadas < 0){ //Comprobamos que el usuario no trabaje horas negativas
            System.out.println("Como es que trabajas horas negativas?");
        } else {
            System.out.println("La persona en cuestion trabajo " + horas_trabajadas + 
            " horas y le pagan " + pago_por_hora + " pesos la hora.");
            
            if (horas_trabajadas >= 40) {
                horas_extras = (horas_trabajadas - 40); //Calculamos las horas extras
            }
            int paga_total = (horas_trabajadas - horas_extras)*pago_por_hora + horas_extras*pago_por_hora*2; //Definimos el valor paga_total
            
            System.out.println("El usuario merese una paga de " + paga_total + " pesos."); //Salida
        }
        sc.close();
    }
}
