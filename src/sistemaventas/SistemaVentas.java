/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemaventas;
import java.util.Scanner;
/**
 *
 * @author Josue Morales
 */
public class SistemaVentas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner jm = new Scanner (System.in);
 
    int opcion;   
    do {
    System.out.println();
    System.out.println("=================================");
    System.out.println("  SISTEMA DE VENTAS Y FACTURACION");
    System.out.println("=================================");
    System.out.println("1. Registrar una venta");
    System.out.println("2. Consultar caja");
    System.out.println("3. Mostrar estadisticas");
    System.out.println("4. Salir");
    System.out.print("Seleccione una opcion: ");
    opcion = jm.nextInt();

    switch (opcion) {
        case 1:
            RegistroVenta.RegisVenta();
            break;
        case 2:
            
            break;
        case 3:
           
            break;
        case 4:
            System.out.println("Saliendo del programa...");
            break;
    } 
    
        } while (opcion >= 1 && opcion <= 3); 
        }
}

    
