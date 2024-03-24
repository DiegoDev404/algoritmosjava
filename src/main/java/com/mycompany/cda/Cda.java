/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.cda;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;

/**
 *
 * @author diego
 */
public class Cda {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("Iniciando aplicación");
        System.out.println("#######################");
        System.out.println("");

        // Determinar si el SOAT está vencido
        System.out.print("¿El SOAT de la motocicleta está vencido? 1.SI / 0.NO: ");
        Integer soatVencido = scanner.nextInt();

        if (soatVencido == 1) {
            System.out.println("");
            System.out.println(
                    "El certificado de técnico mecánina no podra ser generado. Motivo: SOAT vencido");
            System.exit(0);
        }

        //Datos del cleinte
        scanner.nextLine();
        System.out.println("");
        System.out.println("Datos del cliente");
        System.out.println("#######################");
        System.out.print("N° de identificación: ");
        String cliente_dni = scanner.nextLine();
        System.out.print("Nombres: ");
        String cliente_nombres = scanner.nextLine();
        System.out.print("Apellidos: ");
        String cliente_apellidos = scanner.nextLine();
        System.out.print("N° Celular: ");
        String cliente_celular = scanner.nextLine();

        //Datos de la motocicleta
        System.out.println("");
        System.out.println("Datos de la motocicleta");
        System.out.println("#######################");
        System.out.print("Marca: ");
        String moto_marca = scanner.nextLine();
        System.out.print("Linea: ");
        String moto_linea = scanner.nextLine();
        System.out.print("Modelo: ");
        Integer moto_modelo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Placa: ");
        String moto_placa = scanner.nextLine();
        System.out.print("Cilindraje: ");
        Integer moto_cilindraje = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Color: ");
        String moto_color = scanner.nextLine();
        System.out.print("Servicio: ");
        String moto_servicio = scanner.nextLine();
        System.out.print("N° de motor: ");
        String moto_motor = scanner.nextLine();
        System.out.print("N° Chasis: ");
        String moto_chasis = scanner.nextLine();
        System.out.print("Tipo de combustible: ");
        String moto_combustible = scanner.nextLine();

        //Verificar si la técnomecanica esta vencidad o no
        System.out.println("");
        System.out.print("¿El certificado de la técnomecanica está vencido? 1.SI / 0.NO: ");
        Integer estaVencida = scanner.nextInt();
        scanner.nextLine();

        System.out.println("");
        System.out.print("Ingresar la fecha de expedición del certificado (dd/mm/aaaa): ");

        String fechaPago = scanner.nextLine();
        String[] splitFechaPago = fechaPago.split("/");

        int dia = Integer.parseInt(splitFechaPago[0]);
        int mes = Integer.parseInt(splitFechaPago[1]);
        int anio = Integer.parseInt(splitFechaPago[2]);

        LocalDate nuevaFechaPago = LocalDate.of(anio, mes, dia);
        LocalDate fechaExpedicionDate = nuevaFechaPago.plusYears(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaExpedicion = fechaExpedicionDate.format(formatter);

        System.out.println("");
        System.out.print("¿Posee bono promocioal? 1.SI / 0. NO: ");
        Integer tieneBonoPromo = scanner.nextInt();

        double porcentajeBono = 0.0;
        String bonoAplicado = "";

        if (tieneBonoPromo == 1) {
            System.out.println("");
            System.out.println("Escojer bono");
            System.err.println("");
            System.out.println("1. Promo nuevo - 1%");
            System.out.println("2. Promo frecuente - 2%");
            System.out.println("3. Promo fiel - 3.5%");
            System.out.println("");
            System.out.print("Escojer bono: ");
            Integer bono = scanner.nextInt();

            scanner.close();

            switch (bono) {
                case 1:
                    porcentajeBono = 0.01;
                    bonoAplicado = "Promo nuevo";
                    break;
                case 2:
                    porcentajeBono = 0.02;
                    bonoAplicado = "Promo frecuente";
                    break;
                case 3:
                    porcentajeBono = 0.035;
                    bonoAplicado = "Promo fiel";
                    break;
                default:
                    porcentajeBono = 0.0;
            }

        }

        //Calcular valores de la revisión
        double valorRevision = 0;
        if (moto_modelo < 2000 && moto_cilindraje < 100) {
            valorRevision = (estaVencida == 0) ? 70000 : 75000;
        } else if (moto_modelo >= 2001 && moto_modelo <= 2005 && moto_cilindraje < 100) {
            valorRevision = (estaVencida == 0) ? 65000 : 70000;
        } else if (moto_modelo >= 2006 && moto_modelo <= 2010 && moto_cilindraje < 100) {
            valorRevision = (estaVencida == 0) ? 60000 : 65000;
        } else if (moto_modelo > 2011 && moto_cilindraje < 100) {
            valorRevision = (estaVencida == 0) ? 55000 : 60000;
        } else if (moto_modelo < 2000 && moto_cilindraje >= 100 && moto_cilindraje <= 150) {
            valorRevision = (estaVencida == 0) ? 85000 : 90000;
        } else if (moto_modelo >= 2001 && moto_modelo <= 2005 && moto_cilindraje >= 100 && moto_cilindraje <= 150) {
            valorRevision = (estaVencida == 0) ? 80000 : 85000;
        } else if (moto_modelo >= 2006 && moto_modelo <= 2010 && moto_cilindraje >= 100 && moto_cilindraje <= 150) {
            valorRevision = (estaVencida == 0) ? 75000 : 80000;
        } else if (moto_modelo > 2011 && moto_cilindraje >= 100 && moto_cilindraje <= 150) {
            valorRevision = (estaVencida == 0) ? 70000 : 75000;
        } else if (moto_modelo < 2000 && moto_cilindraje > 150) {
            valorRevision = (estaVencida == 0) ? 100000 : 105000;
        } else if (moto_modelo >= 2001 && moto_modelo <= 2005 && moto_cilindraje > 150) {
            valorRevision = (estaVencida == 0) ? 95000 : 100000;
        } else if (moto_modelo >= 2006 && moto_modelo <= 2010 && moto_cilindraje > 150) {
            valorRevision = (estaVencida == 0) ? 90000 : 95000;
        } else if (moto_modelo > 2011 && moto_cilindraje > 150) {
            valorRevision = (estaVencida == 0) ? 85000 : 90000;
        } else {
            valorRevision = 0;
        }

        double descuento = (tieneBonoPromo == 1) ? (valorRevision * porcentajeBono) : 0;

        double subtotal = valorRevision - descuento;

        double iva = subtotal * 0.16;

        double papeleria = subtotal * 0.08;

        double runt = subtotal * 0.03;

        double total = subtotal + iva + papeleria + runt;

        String certificado_vencido = (estaVencida == 1) ? "SI" : "NO";

        //Imprimir 
        System.out.println("");
        System.out.println("CENTRO DE SERVICIO AUTOMOTOR XYZ");
        System.out.println("Fecha de pago: " + fechaPago);
        System.out.println("---------------------------------");
        System.out.println("VIGENCIA DE LA LICENCIA");
        System.out.println("---------------------------------");
        System.out.println("Fecha de expedición: " + fechaPago);
        System.out.println("Fecha de vencimiento: " + fechaExpedicion);
        System.out.println("---------------------------------");
        System.out.println("DATOS DEL CLIENTE");
        System.out.println("---------------------------------");
        System.out.println("Nombre: " + cliente_nombres + " " + cliente_apellidos);
        System.out.println("N°Identificación: " + cliente_dni);
        System.out.println("N°Celular: " + cliente_celular);
        System.out.println("---------------------------------");
        System.out.println("DATOS DE LA MOTOCICLETA");
        System.out.println("-------------------------------");
        System.out.println("Placa: " + moto_placa);
        System.out.println("Marca: " + moto_marca);
        System.out.println("Linea: " + moto_linea);
        System.out.println("Servicio: " + moto_servicio);
        System.out.println("Color: " + moto_color);
        System.out.println("Modelo: " + moto_modelo);
        System.out.println("Cilindraje: " + moto_cilindraje);
        System.out.println("Combustible: " + moto_combustible);
        System.out.println("N° de motor: " + moto_motor);
        System.out.println("Chasis: " + moto_chasis);
        System.out.println("----------------------------------");
        System.out.println("Certificado Anterior Vencido: " + certificado_vencido);
        System.out.println("Costo revisión: " + df.format(valorRevision));
        System.out.println("Bono promocional: " + bonoAplicado);
        System.out.println("Descuento: " + df.format(descuento));
        System.out.println("Subtotal: " + df.format(subtotal));
        System.out.println("IMPUESTOS");
        System.out.println("IVA 16%: " + df.format(iva));
        System.out.println("Papeleria 8%: " + df.format(papeleria));
        System.out.println("Runt 3%: " + df.format(runt));
        System.out.println("COSTO TOTAL: " + df.format(total));
                
        System.out.println("-----------------------------------");
        System.out.println("Gracias por su compra CDA XYZ");

    }
}
