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
public class ConsultaCaja {
    public static void consul(){
        Scanner jm = new Scanner (System.in);

        System.out.println("");
        System.out.println("");
        System.out.println("====RESUMEN ESTADISTICO====");
        System.out.println("Total de productos vendidos  "+  RegistroVenta.productosVendidos);
        System.out.println("Total de ventas realizadas  "+ RegistroVenta.ventasRealizadas);
        System.out.println("Total vendido  Q" + RegistroVenta.totalVendido);
        System.out.println("Ventas en efectivo: "+ RegistroVenta.ventasEfectivo);
        System.out.println("Ventas en tarjeta: "+ RegistroVenta.ventasTarjeta);
        System.out.println("Ventas por transferencia: " + RegistroVenta.ventasTransferencia);
        
    }
}
