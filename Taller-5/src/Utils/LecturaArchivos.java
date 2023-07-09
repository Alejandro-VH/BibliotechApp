package Utils;

import Entities.Libro;
import Entities.Usuario;
import Entities.Reservas;

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.LinkedList;

/**
 * @author Marcelo Céspedes.
 */
public class LecturaArchivos {

    /*
        Para la correcta lectura de los archivos, estos deben estan en la carpeta del proyecto, fuera
        de la carpeta "src".
     */

    /**
     * Método encargado de leer el archivo de "libros.txt".
     *
     * @return
     */
    public static LinkedList<Libro> leerArchivoLibros(LinkedList<Libro> books) {
        // Inicializamos la lista
        books = new LinkedList<>();

        // Leer el archivo "libros.txt"
        try (BufferedReader br = new BufferedReader(new FileReader("libros.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] chain = line.split(",");
                String isbn = chain[0];
                String title = chain[1];
                String author = chain[2];
                String category = chain[3];
                int copies = Integer.parseInt(chain[4]);
                int price = Integer.parseInt(chain[5]);

                Libro book = new Libro(isbn,title,author,category,copies,price);
                books.add(book);

            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return books;
    }

    /**
     * Método encargado de leer el archivo de "usuarios.txt".
     *
     * @return
     */
    public static LinkedList<Usuario> leerArchivoUsuarios(LinkedList<Usuario> users) {
        // Inicializamos la lista
        users = new LinkedList<>();
        // Leer el archivo "usuarios.txt"
        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] chain = line.split(",");
                String rut = chain[0];
                String name = chain[1];
                String lastname = chain[2];
                String password = chain[3];

                Usuario user = new Usuario(rut,name,lastname,password);
                users.add(user);
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return users;
    }

    /**
     * Método encargado de leer el archivo de "usuarios.txt".
     *
     * @return
     */
    public static LinkedList<Reservas> leerArchivoReservas(LinkedList<Reservas> reservas) {
        // Inicializamos la lista
        reservas = new LinkedList<>();
        // Leer el archivo "usuarios.txt"
        try (BufferedReader br = new BufferedReader(new FileReader("reservas.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] chain = line.split(",");
                String rut_vendedor = chain[0];
                String nombre = chain[1];
                String apellido = chain[2];
                String isbn_libro = chain[3];
                String nombre_libro = chain[4];
                String tipo_transacción = chain[5];

                Reservas reg = new Reservas(rut_vendedor,nombre,apellido,isbn_libro,nombre_libro,tipo_transacción);
                reservas.add(reg);
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return reservas;
    }

}