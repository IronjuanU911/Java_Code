//Una tienda de ropa está ofreciendo una promoción en la que se aplica un descuento del 15% 
//sobre el precio original de cada prenda. Si una camiseta cuesta $25 y un pantalón cuesta 
//$30, ¿Cuál será el precio total de ambas prendas después de aplicar el descuento? Además, 
//si se compra una segunda camiseta, se aplica un descuento adicional del 5% sobre el precio 
//ya descuento de la primera camiseta.
import java.util.Scanner;

public class Descuentos_tienda_de_ropa{
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in); //Creamos el objeto Scanner
    
    final int precio_camisa = 30; //Definicion de constantes que se utilizaran
    final int precio_pantalon = 25;
    final float descuento_general = 0.15f;
    final float descuento_segunda_compra = 0.05f;
    
    float descuento_total_camiseta = 0f; //Definicion de variables que se utilizaran
    float descuento_total_pantalon = 0f;
    float descuento_total = 0f;
    
    float precio_total_pantalon = 0f;
    float precio_total_camiseta = 0f;
    float precio_total = 0f;
    
    System.out.print("Cuantas camisetas va a llevar?"); //Pedimos la cantidad de camisas y pantalones
    int cantidad_de_camisas = sc.nextInt();
    
    System.out.print("Cuantos pantalones va a llevar?");
    int cantidad_de_pantalones = sc.nextInt();
    
    if (cantidad_de_camisas >= 1){ //Calculamos el descuento por todas las camisetas, y luego lo aplicamos
        descuento_total_camiseta = (float) (cantidad_de_camisas - 1)*(precio_camisa)*(descuento_general+descuento_segunda_compra) + (descuento_general)*(precio_camisa);
        precio_total_camiseta = (float) (cantidad_de_camisas*precio_camisa) - (descuento_total_camiseta);
        
        System.out.println("El valor de las " + cantidad_de_camisas + " camisetas es " + precio_total_camiseta + ", con un descuento aplicado de " + descuento_total_camiseta);
    } else{
        System.out.println("No se an pedido camisetas");
        cantidad_de_camisas = 0;
    }
    
    if (cantidad_de_pantalones >= 1){ //Calculamos el descuento de todos los pantalones, y luego lo aplicamos
        descuento_total_pantalon = (float) (cantidad_de_pantalones - 1)*(precio_pantalon)*(descuento_general+descuento_segunda_compra) + (descuento_general)*(precio_pantalon);
        precio_total_pantalon = (float) (cantidad_de_pantalones*precio_pantalon) - (descuento_total_pantalon);
        
        System.out.println("El valor de los " + cantidad_de_pantalones + " pantalones es " + precio_total_pantalon + ", con un descuento aplicado de " + descuento_total_pantalon);
    } else { 
        System.out.println("No se an pedido pantalones");
        cantidad_de_pantalones = 0;
    }
    
    precio_total = (precio_total_pantalon + precio_total_camiseta); //Calculamos el precio total
    descuento_total = (descuento_total_pantalon + descuento_total_camiseta); //Calculamos el descuento total aplicado
    
    System.out.println(); //Imprimimos la salida final mientras hacemos un salto de linea
    
    if (precio_total != 0){ //Comprobamos si si se a comprado algun producto, de no ser el caso lo informa al usuario
        System.out.println("El valor por todos los productos es " + precio_total + ", con un descuento aplicado de " + descuento_total);
    } else {
        System.out.println("No se a comprado ningun producto.");
    }
    
    sc.close();
    //Fin algoritmo
    }
}
