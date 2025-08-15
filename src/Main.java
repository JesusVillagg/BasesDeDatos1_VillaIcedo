import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        // Ruta absoluta al archivo CSV donde lo guardo en mi laptop
        String archivoCSV = "C:\\Users\\LEVO\\Downloads\\codigos_postales_hmo.csv";

        String linea;
        String separador = ","; // Separador de columnas del CSV

        // TreeMap para que los códigos postales se mantengan ordenadas automáticamente
        Map<String, Integer> contador = new TreeMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            while ((linea = br.readLine()) != null) {
                // Dividir línea por comas
                String[] datos = linea.split(separador);

                // Verificar que tenga mínimo dos columnas
                if (datos.length >= 2) {
                    String codigoPostal = datos[0].trim(); // Columna 1 = código postal

                    // Sumar 1 al contador de ese código postal
                    contador.put(codigoPostal, contador.getOrDefault(codigoPostal, 0) + 1);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        // Mostrar resultados ordenados
        for (Map.Entry<String, Integer> entrada : contador.entrySet()) {
            System.out.println("Código postal: " + entrada.getKey() +
                    " - Número de asentamientos: " + entrada.getValue());
        }
    }
}
