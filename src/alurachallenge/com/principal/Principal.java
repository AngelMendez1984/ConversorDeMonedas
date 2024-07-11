package alurachallenge.com.principal;

import alurachallenge.com.service.ConsumoAPI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public void saludo() {
        String saludo = """
                ****************************************************
                ***      Bienvenid@ al conversor de monedas      ***
                ***                 Menú                         ***
                """;
        System.out.println(saludo);
    }

    public void muestraElMenu() {
        Scanner teclado = new Scanner(System.in);
        int seleccionMenu = -1;
        ConsumoAPI consumoAPI = new ConsumoAPI();
        var json = consumoAPI.obtenerDatos();
        double usdRate = json.conversion_rates().get("USD");
        double eurRate = json.conversion_rates().get("EUR");
        double gbpRate = json.conversion_rates().get("GBP");

        do {
            System.out.println("""
                1.- Convertir Pesos Mexicanos (MXN) a Dólares Estadounidenses (USD).
                2.- Convertir Dólares Estadounidenses (USD) a Pesos Mexicanos (MXN).
                3.- Convertir Pesos Mexicanos (MXN) a Euros (EUR).
                4.- Convertir Euros (EUR) a Pesos Mexicanos (MXN).
                5.- Convertir Pesos Mexicanos (MXN) a Libras Esterlinas (GBP).
                6.- Convertir Libras Esterlinas (GBP) a Pesos Mexicanos (MXN).
                7.- Salir.

                ************* Por favor seleccione una opción válida *********************
                """);

            try {
                seleccionMenu = teclado.nextInt();

                switch (seleccionMenu) {
                    case 1: {
                        double mxn = obtenerCantidadValida("MXN");
                        System.out.println(String.format("%.2f", mxn) + " Pesos Mexicanos (MXN) equivalen a " + String.format("%.2f", mxn * usdRate) + " Dólares estadounidenses (USD)");
                        break;
                    }
                    case 2: {
                        double usd = obtenerCantidadValida("USD");
                        System.out.println(String.format("%.2f", usd) + " Dólares Estadounidenses (USD) equivalen a " + String.format("%.2f", usd / usdRate) + " Pesos Mexicanos (MXN)");
                        break;
                    }
                    case 3: {
                        double mxn = obtenerCantidadValida("MXN");
                        System.out.println(String.format("%.2f", mxn) + " Pesos Mexicanos (MXN) equivalen a " + String.format("%.2f", mxn * eurRate) + " Euros (EUR)");
                        break;
                    }
                    case 4: {
                        double eur = obtenerCantidadValida("EUR");
                        System.out.println(String.format("%.2f", eur) + " Euros (EUR) equivalen a " + String.format("%.2f", eur / eurRate) + " Pesos Mexicanos (MXN)");
                        break;
                    }
                    case 5: {
                        double mxn = obtenerCantidadValida("MXN");
                        System.out.println(String.format("%.2f", mxn) + " Pesos Mexicanos (MXN) equivalen a " + String.format("%.2f", mxn * gbpRate) + " Libras Esterlinas (GBP)");
                        break;
                    }
                    case 6: {
                        double gbp = obtenerCantidadValida("GBP");
                        System.out.println(String.format("%.2f", gbp) + " Libras Esterlinas (GBP) equivalen a " + String.format("%.2f", gbp / gbpRate) + " Pesos Mexicanos (MXN)");
                        break;
                    }
                    case 7:
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opción incorrecta. Por favor selecciona una opción válida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingresa un número entero válido.");
                teclado.next(); // Descartar la entrada no válida
            }
        } while (seleccionMenu != 7);

        teclado.close();
    }

    private double obtenerCantidadValida(String moneda) {
        Scanner cantidadScanner = new Scanner(System.in);
        double cantidad = -1;

        while (cantidad < 0) {
            System.out.println("Ingresa la cantidad a convertir (" + moneda + "):");
            try {
                cantidad = Double.parseDouble(cantidadScanner.nextLine());
                if (cantidad < 0) {
                    System.out.println("Por favor ingresa un valor positivo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingresa un número válido.");
            }
        }

        return cantidad;
    }
}
