package Forms;

import Entities.Libro;
import Entities.Reservas;
import Entities.Usuario;
import Utils.GuardarArchivos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;

public class AgregarLibro extends JFrame {

    private JPanel panel;
    private JTextField isbnTextField;
    private JTextField precioTextField;
    private JTextField copiasTextField;
    private JTextField categoriaTextField;
    private JTextField nombreTextField;
    private JTextField autorTextField;
    private JButton agregarButton;
    private LinkedList<Libro> books;
    private LinkedList<Reservas> reservas;
    public AgregarLibro(LinkedList<Libro> books, Usuario user, LinkedList<Reservas> reservas){
        this.books = books;

        setContentPane(panel);
        setTitle("Bibliotech");
        setSize(400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String isbn = isbnTextField.getText();
                String precio = precioTextField.getText();
                String copias = copiasTextField.getText();
                String categoria = categoriaTextField.getText();
                String nombre = nombreTextField.getText();
                String autor = autorTextField.getText();

                if (!isbn.isEmpty() || !nombre.isEmpty() || !autor.isEmpty() || !categoria.isEmpty() || !copias.isEmpty() || !precio.isEmpty()){
                    //Se quitan valores no deseados de los valores numericos
                    copias = limpiarString(copias);
                    copias = copias.replaceAll("\\D+","");

                    precio = limpiarString(precio);
                    precio = precio.replaceAll("\\D+","");
                    //Se revisa que no exista un libro con el isbn indicado
                    if (buscarLibro(isbn) != null){
                        JOptionPane.showMessageDialog(panel,"Ya existe un libro con el isbn ingresado!");
                        setVisible(false);
                        Home home = new Home(books,user, reservas);
                    }


                    Libro nuevo = new Libro(isbn,nombre,autor,categoria,Integer.parseInt(copias),Integer.parseInt(precio));
                    books.add(nuevo);
                    try {
                        GuardarArchivos.agregarLibro(books);
                    }catch (Exception err){

                    }
                    setVisible(false);
                    Home home = new Home(books,user, reservas);
                }else {
                    JOptionPane.showMessageDialog(panel,"Por favor, complete los campos!");
                }
            }
        });
    }

    /**
     * Subprograma usado para quitar espacios y letras del campo de texto que deben ser solo numeros
     * @param text a limpiar
     * @return string con solo numeros
     */
    public static String limpiarString(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * Subprogama usado para revisar entre todos los libros existente
     * @param isbn del libro a buscar
     * @return libro
     */
    private Libro buscarLibro(String isbn){
        for (Libro aux: books){
            if (aux.getIsbn().equals(isbn)){
                return aux;
            }
        }
        return null;
    }

}
