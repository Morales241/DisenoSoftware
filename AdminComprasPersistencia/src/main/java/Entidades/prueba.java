/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Entidades;

import DAOs.pProveedorDAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author tacot
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Producto producto1 = new Producto("Jeringa", "132313");
        Producto producto2 = new Producto("Guantes médicos", "132314");
        Producto producto3 = new Producto("Bisturí", "132315");
        Producto producto4 = new Producto("Termómetro", "132316");
        Producto producto5 = new Producto("Estetoscopio", "132317");
        Producto producto6 = new Producto("Tensiómetro", "132318");
        Producto producto7 = new Producto("Vendaje", "132319");
        Producto producto8 = new Producto("Gasas", "132320");
        Producto producto9 = new Producto("Espejo bucal", "132321");
        Producto producto10 = new Producto("Pinzas", "132322");
        Producto producto11 = new Producto("Sonda Foley", "132323");
        Producto producto12 = new Producto("Electrocardiógrafo", "132324");
        Producto producto13 = new Producto("Mascarilla de oxígeno", "132325");
        Producto producto14 = new Producto("Camilla", "132326");
        Producto producto15 = new Producto("Desfibrilador", "132327");
        Producto producto16 = new Producto("Microscopio", "132328");
        Producto producto17 = new Producto("Tubo de ensayo", "132329");
        Producto producto18 = new Producto("Bata de hospital", "132330");
        Producto producto19 = new Producto("Silla de ruedas", "132331");
        Producto producto20 = new Producto("Respirador artificial", "132332");

        Proveedor proveedor1 = new Proveedor("Juan Pérez", "644-456-7890");
        Proveedor proveedor2 = new Proveedor("Ana Sánchez", "644-567-8901");
        Proveedor proveedor3 = new Proveedor("Carlos García", "644-678-9012");
        Proveedor proveedor4 = new Proveedor("María Rodríguez", "644-789-0123");
        Proveedor proveedor5 = new Proveedor("Luis Martínez", "644-890-1234");

        // Crear una lista de todos los productos
        List<Producto> productos = Arrays.asList(producto1, producto2, producto3, producto4, producto5, producto6, producto7, producto8, producto9, producto10, producto11, producto12, producto13, producto14, producto15, producto16, producto17, producto18, producto19, producto20);

        // Crear una lista de todos los proveedores
        List<Proveedor> proveedores = Arrays.asList(proveedor1, proveedor2, proveedor3, proveedor4, proveedor5);

        // Crear una lista para almacenar todas las relaciones producto-proveedor
        List<pProveedor> productoProveedores = new ArrayList<>();

        // Crear un generador de números aleatorios
        Random rand = new Random();

        // Para cada proveedor, asignar 10 productos al azar
        for (Proveedor proveedor : proveedores) {
            // Mezclar la lista de productos
            Collections.shuffle(productos);  
            
            for (int i = 0; i < 10; i++) {
                Producto producto = productos.get(i);
                
                // Generar un precio y una cantidad de stock aleatorios
                // Precio entre 50.00 y 150.00
                String precioP = String.format("%.2f", 50 + (150 - 50) * rand.nextDouble());  
                
                // Stock entre 1 y 100
                int stock = rand.nextInt(100) + 1;  
                
                // Crear una nueva relación producto-proveedor con el precio y el stock generados
                pProveedor productoProveedor = new pProveedor(precioP, stock, producto, proveedor);
                productoProveedores.add(productoProveedor);
            }
        }
        
        pProveedorDAO PP = new pProveedorDAO();
        
        for (pProveedor p : productoProveedores) {
            PP.create(p);
        }
    }

}
