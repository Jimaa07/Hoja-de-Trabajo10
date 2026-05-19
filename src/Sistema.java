package src;

import java.io.File;
import java.util.Scanner;

public class Sistema {

    private Grafo grafo;
    public Sistema() {
        grafo = new Grafo(30);
    }

    public void iniciar() {
        cargarArchivo();
        System.out.println("GRAFO CARGADO:\n");
        grafo.mostrarMatriz();
    }

    private void cargarArchivo() {
        try {
            File archivo = new File("guategrafo.txt");
            Scanner sc = new Scanner(archivo);
            while (sc.hasNext()) {
                String origen = sc.next();
                String destino = sc.next();
                int distancia = sc.nextInt();
                grafo.agregarArco(origen,
                                  destino,
                                  distancia);
            }

            sc.close();

        } catch (Exception e) {
            System.out.println("Error al leer archivo");
            System.out.println(e.getMessage());
        }
    }
}