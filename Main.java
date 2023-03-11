import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    static Integer valorReal = 0;

    public static void main(String[] args) throws IOException {
        String respuesta = "";
        System.out.println("Dese 1- sumar o 2- multiplicar:");
        respuesta = metodoTipeoString();
        switch (respuesta) {
            case "1":
                System.out.println("La suma es: " + metodoSuma());
                break;
            case "2":
                System.out.println("El producto es: " + metodoProducto());
                break;
            default:
                System.out.println("Opción incorrecta");
                break;
        }
    }

    private static String metodoTipeoString() {
        String texto = "";
        Scanner tipeo = new Scanner(System.in);
        texto = tipeo.next();
        return texto;
    }

    private static String capturaArchivo() throws IOException {
        String texto = "";
        String archivo = "C:\\Users\\VHS 4\\Dropbox\\UTN ARGENTINA PROGRAMA\\CARPETA PARA ARCHIVOS\\NUMEROS.txt";
        System.out.println(archivo);
        for (String linea : Files.readAllLines(Paths.get(archivo))) {
            texto += linea;
        }
        return texto;
    }

    private static Integer metodoSuma() throws IOException {
        for (String numero : capturaArchivo().split(" ")) {
            valorReal += Integer.parseInt(numero);
        }
        return valorReal;
    }

    private static Integer metodoProducto() throws IOException {
        valorReal = 1;
        for (String numero : capturaArchivo().split(" ")) {
            valorReal *= Integer.parseInt(numero);
        }
        return valorReal;
    }

}