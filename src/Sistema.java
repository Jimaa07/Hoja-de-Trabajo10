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
        int[][] distancias = grafo.floydWarshall();
        mostrarDistancias(distancias);
    }

    private void cargarArchivo() {
        try {
            File archivo = new File("guategrafo.txt");
            Scanner sc = new Scanner(archivo);
            while (sc.hasNext()) {
                String origen = sc.next();
                String destino = sc.next();
                int distancia = sc.nextInt();
                grafo.agregarArco(origen, destino,distancia);
            }

            sc.close();

        } catch (Exception e) {
            System.out.println("Error al leer archivo");
            System.out.println(e.getMessage());
        }
    }
    
    private void mostrarDistancias(int[][] distancias) {
    System.out.println("MATRIZ DE DISTANCIAS MINIMAS:\n");
    for (int i = 0; i < distancias.length; i++) {
        for (int j = 0; j < distancias.length; j++) {
            if (distancias[i][j] == 999999) {
                System.out.print("INF\t");
            } else {
                System.out.print(distancias[i][j] + "\t");
            }
        }
        System.out.println();
    }
}
}