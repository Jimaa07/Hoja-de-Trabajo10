package src;

import java.util.*;

public class Grafo {

    private final int INF = 999999;

    private int[][] matriz;
    private int[][] siguiente;
    private Map<String, Integer> indices;
    private List<String> ciudades;
    private int cantidad;

    public Grafo(int maxCiudades){

        matriz = new int[maxCiudades][maxCiudades];
        siguiente = new int[maxCiudades][maxCiudades];
        indices = new HashMap<>();
        ciudades = new ArrayList<>();
        cantidad = 0;

        for(int i = 0; i < maxCiudades; i++){

            for(int j = 0; j < maxCiudades; j++){

                if(i == j){
                    matriz[i][j] = 0;
                    siguiente[i][j] = j;
                }else{
                    matriz[i][j] = INF;
                    siguiente[i][j] = -1;
                }
            }
        }
    }

    public void agregarCiudad(String ciudad){

        if(!indices.containsKey(ciudad)){

            indices.put(ciudad, cantidad);
            ciudades.add(ciudad);
            cantidad++;
        }
    }

    public void agregarArco(String origen, String destino, int distancia){

        agregarCiudad(origen);
        agregarCiudad(destino);

        int i = indices.get(origen);
        int j = indices.get(destino);

        matriz[i][j] = distancia;
        siguiente[i][j] = j;
    }

    public void eliminarArco(String origen, String destino){

        if(indices.containsKey(origen) &&
           indices.containsKey(destino)){

            int i = indices.get(origen);
            int j = indices.get(destino);

            matriz[i][j] = INF;
        }
    }

    public void mostrarMatriz(){

        System.out.print("\t");

        for(String ciudad : ciudades){
            System.out.print(ciudad + "\t");
        }

        System.out.println();
        for(int i = 0; i < cantidad; i++){
            System.out.print(ciudades.get(i) + "\t");
            for(int j = 0; j < cantidad; j++){
                if(matriz[i][j] == INF){
                    System.out.print("INF\t");
                }else{
                    System.out.print(matriz[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    public int[][] floydWarshall(){
        int[][] distancias = new int[cantidad][cantidad];
        for(int i = 0; i < cantidad; i++){
            for(int j = 0; j < cantidad; j++){
                distancias[i][j] = matriz[i][j];
            }
        }

        for(int k = 0; k < cantidad; k++){

            for(int i = 0; i < cantidad; i++){

                for(int j = 0; j < cantidad; j++){

                    if(distancias[i][k] != INF &&
                       distancias[k][j] != INF){

                        if(distancias[i][k] +
                           distancias[k][j]
                           < distancias[i][j]){

                            distancias[i][j] =
                                    distancias[i][k]
                                    + distancias[k][j];
                                    siguiente[i][j] = siguiente[i][k];
                        }
                    }
                }
            }
        }
        return distancias;
    }

    public String centroGrafo(){
        if(cantidad == 0){
            return "No hay ciudades en el grafo";
        }

        int[][] distancias = floydWarshall();
        int menorExcentricidad = INF;
        int indiceCentro = -1;
        for(int i = 0; i < cantidad; i++){
            int excentricidad = 0;
            for(int j = 0; j < cantidad; j++){
                if(distancias[i][j] != INF &&
                   distancias[i][j] > excentricidad){
                    excentricidad = distancias[i][j];
                }
            }

            if(excentricidad < menorExcentricidad){
                menorExcentricidad = excentricidad;
                indiceCentro = i;
            }
        }
        return ciudades.get(indiceCentro);
    }

    public String obtenerRuta(String origen, String destino){

        if(!indices.containsKey(origen) ||
           !indices.containsKey(destino)){

            return "Ciudad no existente";
        }

        int i = indices.get(origen);

        int j = indices.get(destino);

        if(siguiente[i][j] == -1){
            return "No existe ruta";
        }

        String ruta = origen;

        while(i != j){

            i = siguiente[i][j];

            ruta += " -> " + ciudades.get(i);
        }

        return ruta;
    }
}
