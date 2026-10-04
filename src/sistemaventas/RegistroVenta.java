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
public class RegistroVenta {
    public static int ventasRealizadas = 0;
    public static int productosVendidos = 0;   // total de unidades vendidas
    public static double totalVendido = 0;
    public static int ventasEfectivo = 0;
    public static int ventasTarjeta = 0;
    public static int ventasTransferencia = 0;
    public static double ventaMayor = 0;
    public static double ventaMenor = 0;

    

    public static void RegisVenta(){
    Scanner jm = new Scanner (System.in);
 
        System.out.println("=== REGISTRAR VENTA ===");
 
        // Cantidad de productos (se valida con while)
        System.out.print("Cuantos productos tendra la compra? ");
        int cantidadProductos = jm.nextInt();
        
        while (cantidadProductos <= 0) {
            System.out.print("Debe ser mayor que cero. Ingrese de nuevo: ");
            cantidadProductos = jm.nextInt();
        }
 
        double subtotal = 0; // acumulador del subtotal de la venta
        int unidades = 0;    // acumulador de unidades de la venta
 
        // Ingreso de productos con ciclo for
        for (int i = 1; i <= cantidadProductos; i++) {
            System.out.println();
            
            //Muestra un resumen de los productos ingresados y cuantos son en total 
            System.out.println("--- Producto " + i + " de " + cantidadProductos + " ---");
 
            jm.nextLine(); // limpia el Enter que quedo de la lectura anterior
            System.out.print("Codigo: ");
            String codigo = jm.nextLine();
            System.out.print("Nombre: ");
            String nombre = jm.nextLine();
 
            System.out.print("Precio (Q): ");
            double precio = jm.nextDouble();
            
            //Evalua si el precio es menor o igual a 0 para preguntarle de nuevo
            while (precio <= 0) {
                System.out.print("El precio debe ser mayor que cero. Ingrese de nuevo: ");
                precio = jm.nextDouble();
            }
 
            System.out.print("Cantidad: ");
            int cantidad = jm.nextInt();
            while (cantidad <= 0) {
                System.out.print("La cantidad debe ser mayor que cero. Ingrese de nuevo: ");
                cantidad = jm.nextInt();
            }
 
            // Subtotal del producto = precio x cantidad (redondeado a 2 decimales)
            double subtotalProducto = (int) (precio * cantidad * 100 + 0.5) / 100.0;
            System.out.println("Agregado: [" + codigo + "] " + nombre + " -> Subtotal del producto: Q" + subtotalProducto);
 
            subtotal = subtotal + subtotalProducto;
            unidades = unidades + cantidad;
        }
 
        // Descuento segun el subtotal
        double porcentaje;
        if (subtotal >= 1000) {
            porcentaje = 0.10;
        } else if (subtotal >= 500) {
            porcentaje = 0.8;
        } else if (subtotal >= 200) {
            porcentaje = 0.5;
        } else {
            porcentaje = 0;
        }
 
        double descuento = (subtotal * porcentaje);
        double montoConDescuento = (int) (subtotal - descuento);
        double iva = (int) (montoConDescuento * 0.12);
        double total = (int) (montoConDescuento + iva);
 
        System.out.println();
        System.out.println("Total a pagar: Q" + total);
 
        // Forma de pago
        System.out.println();
        System.out.println("Forma de pago:");
        System.out.println("1) Efectivo");
        System.out.println("2) Tarjeta");
        System.out.println("3) Transferencia");
        System.out.print("Seleccione: ");
        
        
        int pago = jm.nextInt();
        while (pago < 1 || pago > 3) {
            System.out.print("Opcion invalida. Ingrese 1, 2 o 3: ");
            pago = jm.nextInt();
        }
 
        String formaPago = "";
        double recibido = 0;
        double cambio = 0;
 
        if (pago == 1) {
            formaPago = "Efectivo";
            ventasEfectivo++;
            System.out.print("Efectivo recibido (Q): ");
            recibido = jm.nextDouble();
            
            //Bucle mientras el usuario de un billete menos al total a pagar 
            //Va a esta va de pedir hasta que de un mayor 
            while (recibido < total) {
                System.out.println("Efectivo insuficiente. El total es Q" + total);
                System.out.print("Ingrese el efectivo recibido de nuevo (Q): ");
                recibido = jm.nextDouble();
            }
            cambio = (int) (recibido - total);
            
            
        } else if (pago == 2) {
            formaPago = "Tarjeta";
            ventasTarjeta++;
        } else {
            formaPago = "Transferencia";
            ventasTransferencia++;
        }
 
        // Resumen final
        System.out.println();
        System.out.println("=== RESUMEN DE LA VENTA ===");
        System.out.println("Cantidad de productos: " + cantidadProductos);
        System.out.println("Unidades vendidas: " + unidades);
        System.out.println("Subtotal: Q" + subtotal);
        System.out.println("Descuento (" + porcentaje + "%): Q" + descuento);
        System.out.println("Monto con descuento: Q" + montoConDescuento);
        System.out.println("IVA (12%): Q" + iva);
        System.out.println("TOTAL: Q" + total);
        System.out.println("Forma de pago: " + formaPago);
        
        //Lo muestra por si pago en efectivo para mostrar el vuelto
        if (pago == 1) {
            System.out.println("Efectivo recibido: Q" + recibido);
            System.out.println("Cambio: Q" + cambio);
        }
 
        // Actualizar contadores y acumuladores
        ventasRealizadas++;
        productosVendidos = productosVendidos + unidades;
        totalVendido = totalVendido + total;
 
        
        //Evalua la primera venta la pone min y max 
        if (ventasRealizadas == 1) {
            // En la primera venta, esa venta es la mayor y la menor a la vez
            ventaMayor = total;
            ventaMenor = total;
        } else { 
            //Venta es > al total es la mayor
            if (total > ventaMayor) {
                ventaMayor = total;
            }
            //Venta es < al total esa va a ser la menor 
            if (total < ventaMenor) {
                ventaMenor = total;
            }
        }
    }
        
}
