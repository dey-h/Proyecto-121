/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parqueo_inteligente.newpackage;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ArchiFactura {

    public void crear(String nomFactura, Cliente cliente, Tarifa tarifa, long horasEstacionado) {
    double total = tarifa.calcularTarifa(horasEstacionado);
    LocalDateTime fecha = LocalDateTime.now();

    String nombreArchivo = nomFactura.replace(" ", "_") + ".txt";

    StringBuilder facturaTexto = new StringBuilder();
    facturaTexto.append("===== FACTURA DE PARQUEO =====\n");
    facturaTexto.append("Fecha: " + fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + "\n");
    facturaTexto.append("Cliente: " + cliente.getNombre() + "\n");
    facturaTexto.append("Vehículo: " + cliente.getVehiculo().getPlaca() + "\n");
    facturaTexto.append("Horas estacionado: " + horasEstacionado + "\n");
    facturaTexto.append("Tarifa por hora: " + tarifa.getTarifaPorHora() + " Bs\n");
    facturaTexto.append("Total a pagar: " + total + " Bs\n");

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
        writer.write(facturaTexto.toString());
    } catch (IOException e) {
        e.printStackTrace();
    }

    System.out.println(facturaTexto.toString());
}


    public void mostrar() {
        File carpeta = new File("."); 
        File[] archivos = carpeta.listFiles((dir, nombre) -> nombre.endsWith(".txt"));

        if (archivos == null || archivos.length == 0) {
            System.out.println("No hay facturas registradas.");
            return;
        }

        for (File archivo : archivos) {
            System.out.println("------ " + archivo.getName() + " ------");
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
            } catch (IOException e) {
                System.out.println("Error leyendo archivo: " + archivo.getName());
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}
