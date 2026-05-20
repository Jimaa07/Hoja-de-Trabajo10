error id: file:///C:/Users/Jair%20Morales/OneDrive%20-%20UVG/Escritorio/Progra2/Hoja-de-Trabajo10/src/Sistema.java:_empty_/Grafo#floydWarshall#
file:///C:/Users/Jair%20Morales/OneDrive%20-%20UVG/Escritorio/Progra2/Hoja-de-Trabajo10/src/Sistema.java
empty definition using pc, found symbol in pc: _empty_/Grafo#floydWarshall#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 278
uri: file:///C:/Users/Jair%20Morales/OneDrive%20-%20UVG/Escritorio/Progra2/Hoja-de-Trabajo10/src/Sistema.java
text:
```scala
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

    int[][] distancias = grafo.floydWar@@shall();

    mostrarDistancias(distancias);

    System.out.println("\nCENTRO DEL GRAFO:");

    System.out.println(grafo.centroGrafo());
};
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
```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/Grafo#floydWarshall#