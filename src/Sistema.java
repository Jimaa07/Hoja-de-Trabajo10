package src;

import java.io.File;
import java.util.Scanner;

public class Sistema {

    private Grafo grafo;
    public Sistema(){
        grafo = new Grafo(100);
    }

    public void iniciar(){
        cargarArchivo();
        mostrarMenu();
    }

    private void cargarArchivo(){
        try{

            File archivo = new File("guategrafo.txt");
            Scanner sc = new Scanner(archivo);

            while(sc.hasNext()){

                String origen = sc.next();
                String destino = sc.next();
                int distancia = sc.nextInt();

                grafo.agregarArco(origen, destino, distancia);
            }

            sc.close();

        }catch(Exception e){

            System.out.println("Error al leer archivo");
            System.out.println(e.getMessage());
        }
    }

    private void mostrarMenu(){

        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        while(opcion != 4){

            System.out.println("\n----- MENU -----");
            System.out.println("1. Ruta minima");
            System.out.println("2. Centro del grafo");
            System.out.println("3. Modificar grafo");
            System.out.println("4. Salir");
            System.out.print("Opcion: ");

            opcion = sc.nextInt();

            switch(opcion){

                case 1:
                    consultarRuta(sc);
                    break;

                case 2:
                    mostrarCentro();
                    break;

                case 3:
                    modificarGrafo(sc);
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }
        }
    }

    private void consultarRuta(Scanner sc){

        sc.nextLine();

        System.out.print("Ciudad origen: ");
        String origen = sc.nextLine();

        System.out.print("Ciudad destino: ");
        String destino = sc.nextLine();

        System.out.println("\nRuta minima:");

        System.out.println(
                grafo.obtenerRuta(origen, destino)
        );
    }

    private void mostrarCentro(){

        System.out.println("\nCENTRO DEL GRAFO:");
        System.out.println(grafo.centroGrafo());
    }

    private void modificarGrafo(Scanner sc){

        System.out.println("\n1. Eliminar conexion");
        System.out.println("2. Agregar conexion");

        int opcion = sc.nextInt();

        sc.nextLine();

        if(opcion == 1){

            System.out.print("Origen: ");
            String origen = sc.nextLine();

            System.out.print("Destino: ");
            String destino = sc.nextLine();

            grafo.eliminarArco(origen, destino);
            System.out.println("Conexion eliminada");

        }else if(opcion == 2){

            System.out.print("Origen: ");
            String origen = sc.nextLine();

            System.out.print("Destino: ");
            String destino = sc.nextLine();

            System.out.print("Distancia: ");
            int distancia = sc.nextInt();

            grafo.agregarArco(origen, destino, distancia);
            System.out.println("Conexion agregada");
        }
    }
}