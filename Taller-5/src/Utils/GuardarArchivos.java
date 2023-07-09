package Utils;

import Entities.Libro;
import Entities.Reservas;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class GuardarArchivos {


    public static void agregarRegistro(LinkedList<Reservas> lista) throws IOException {
        try {
            FileWriter archivo = new FileWriter("reservas.txt");

            for (Reservas str : lista) {
                archivo.write(str.getRut_vendedor() + "," + str.getNombre_vendedor() + "," + str.getApellido() + "," + str.getIsbn() + "," + str.getNombre_vendedor() + "," + str.getTipo_transacción() + "\n");
            }

            archivo.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static void agregarLibro(LinkedList<Libro> lista){
        try {
            FileWriter archivo = new FileWriter("libros.txt");

            for (Libro libro : lista) {
                archivo.write(libro.getIsbn() + "," + libro.getTitulo() + "," + libro.getAutor() + "," + libro.getCategoria() + "," + libro.getCopias() + "," + libro.getPrecio() + "\n");
            }

            archivo.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

}
