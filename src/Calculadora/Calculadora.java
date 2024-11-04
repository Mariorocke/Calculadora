package Calculadora;

public class Calculadora {

    public double sumar(double a, double b) {

        return a + b;
    }

    public double restar(double a, double b) {

        return a - b;
    }

    public double multiplicar(double a, double b) {

        return a * b;
    }

    public double dividir(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("*** No se puede dividir por cero. ***");
        }
        return a / b;
    }

    public double potencia(double base, double exponente) {

        return Math.pow(base, exponente);
    }

    public double raizCuadrada(double a) throws ArithmeticException {
        if (a < 0) {
            throw new ArithmeticException("*** No se puede realizar esta operación con números negativos. ***");
        }
        return Math.sqrt(a);
    }
}