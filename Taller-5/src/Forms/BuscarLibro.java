package Forms;

import Entities.Libro;
import Entities.Reservas;
import Entities.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class BuscarLibro extends JFrame {
    private JPanel panel;
    private JTextField textField1;
    private JLabel Titulo;
    private JLabel Categoria;
    private JLabel Autor;
    private JLabel nCopias;
    private JButton buscarButton;
    private LinkedList<Libro> books;
    private LinkedList<Reservas> reservas;
    public BuscarLibro(LinkedList<Libro> books, Usuario user, LinkedList<Reservas> reservas){
        this.books = books;

        setContentPane(panel);
        setTitle("Bibliotech");
        setSize(400,400);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField1.getText();
                if (!text.isEmpty()){
                    Libro libro = buscarLibro(text);
                    if (libro != null){
                        Titulo.setText("Titulo: " + libro.getTitulo());
                        Categoria.setText("Categoria: " + libro.getCategoria());
                        Autor.setText("Autor: " + libro.getAutor());
                        nCopias.setText("Numero de copias: " + libro.getCopias());
                    }else {
                        JOptionPane.showMessageDialog(panel,"No existe un libro con el ISBN indicado");
                    }
                }else {
                    JOptionPane.showMessageDialog(panel,"Por favor, complete los campos!");
                }
            }
        });
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
