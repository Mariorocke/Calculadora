package Calculadora;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfazUsuario {
    private Calculadora calculadora;
    private Scanner scanner;

    public InterfazUsuario() {
        calculadora = new Calculadora();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        boolean continuar = true;
        int contadorErrores = 0;

        while (continuar) {
            mostrarMenu();
            try {
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        realizarOperacion("suma");
                        break;
                    case 2:
                        realizarOperacion("resta");
                        break;
                    case 3:
                        realizarOperacion("multiplicación");
                        break;
                    case 4:
                        realizarOperacion("división");
                        break;
                    case 5:
                        realizarOperacion("potencia");
                        break;
                    case 6:
                        realizarRaizCuadrada();
                        break;
                    case 0:
                        continuar = false;
                        System.out.println("¡Gracias por usar la calculadora!");
                        break;
                    default:
                        System.out.println("Opción no válida, intenta de nuevo.");
                }
            } catch (InputMismatchException e) {
                contadorErrores++;

                if (contadorErrores >= 10) {
                    System.out.println("Número de entradas no válidas: " + contadorErrores);
                    System.out.println("Demasiados errores. El programa se cerrará.");
                    continuar = false; // Detiene el bucle
                } else {
                    System.out.println("Por favor, ingrese solamente una de las opciones mostradas");
                    scanner.next();
                }
            }
        }
        scanner.close();
    }

    private void mostrarMenu() {
        System.out.println("\nSeleccione una operación:");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.println("5. Potencia");
        System.out.println("6. Raíz Cuadrada");
        System.out.println("0. Salir");
        System.out.print("\nElige una opción: ");
    }

    private void realizarOperacion(String operacion) {
        try {
            if(operacion=="potencia") {
                System.out.print("Ingrese la base: ");
            }else
                System.out.print("Ingrese el primer número: ");
            Numero num1 = new Numero(scanner.nextDouble());
            if(operacion=="potencia") {
                System.out.print("Ingrese la potencia: ");
            }else
                System.out.print("Ingrese el segundo número: ");
            Numero num2 = new Numero(scanner.nextDouble());

            double resultado = 0;

            switch (operacion) {
                case "suma":
                    resultado = calculadora.sumar(num1.getValor(), num2.getValor());
                    break;
                case "resta":
                    resultado = calculadora.restar(num1.getValor(), num2.getValor());
                    break;
                case "multiplicación":
                    resultado = calculadora.multiplicar(num1.getValor(), num2.getValor());
                    break;
                case "división":
                    try {
                        resultado = calculadora.dividir(num1.getValor(), num2.getValor());
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                        return;
                    }
                    break;
                case "potencia":
                    resultado = calculadora.potencia(num1.getValor(), num2.getValor());
                    break;
            }
            System.out.println("El resultado es: " + resultado);
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingrese solamente números");
            scanner.next();
        }
    }

    private void realizarRaizCuadrada() {
        try {
            System.out.print("Ingrese el número: ");
            Numero num = new Numero(scanner.nextDouble());
            double resultado = calculadora.raizCuadrada(num.getValor());
            System.out.println("El resultado es: " + resultado);
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingrese solamente números.");
            scanner.next();
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}