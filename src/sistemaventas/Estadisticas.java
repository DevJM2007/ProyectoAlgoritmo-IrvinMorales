/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaventas;
import java.util.Scanner;
/**
 *
 * @author Josue Morales
 */
public class Estadisticas {
    public static void estadi(){
       Scanner jm = new Scanner(System.in);


            System.out.println();
            System.out.println("=== ESTADISTICAS ===");

            
            if (RegistroVenta.ventasRealizadas == 0) {
                System.out.println("No existen ventas registradas.");
            } else {
                
                //Calcula el promedio de dinero vendido
                double promedio = RegistroVenta.totalVendido / RegistroVenta.ventasRealizadas;

                System.out.println("Numero total de ventas: " + RegistroVenta.ventasRealizadas);
                System.out.println("Cantidad total de productos vendidos: " + RegistroVenta.productosVendidos);
                System.out.println("Total de dinero vendido: Q" + RegistroVenta.totalVendido);
                System.out.println("Promedio de dinero por venta: Q" + promedio);
                System.out.println("Ventas en efectivo: " + RegistroVenta.ventasEfectivo);
                System.out.println("Ventas en tarjeta: " + RegistroVenta.ventasTarjeta);
                System.out.println("Ventas por transferencia: " + RegistroVenta.ventasTransferencia);
                System.out.println("Venta de mayor valor: Q" + RegistroVenta.ventaMayor);
                System.out.println("Venta de menor valor: Q" + RegistroVenta.ventaMenor);
            }
        }
}
