package Forms;

import Entities.Libro;
import Entities.Usuario;
import Entities.Reservas;
import Utils.GuardarArchivos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class PrestarLibro extends JFrame {
    private JPanel panel;
    private JTextField textField1;
    private JButton buscarButton;
    private LinkedList<Libro> books;
    private LinkedList<Reservas> reservas;

    public PrestarLibro(LinkedList<Libro> books, Usuario user, LinkedList<Reservas> registro){
        this.books = books;
        this.reservas = registro;

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
                    if (text != null){
                        for (Libro aux : books){
                            if (aux.getIsbn().equals(text)){
                                if (aux.prestarCopia()){
                                    try {
                                        Reservas reg = new Reservas(user.getRut(), user.getNombre(), user.getApellido(), aux.getIsbn(),aux.getTitulo(),"prestamo");
                                        reservas.add(reg);
                                        GuardarArchivos.agregarRegistro(reservas);
                                        GuardarArchivos.agregarLibro(books);
                                    }catch (Exception err){

                                    }
                                    JOptionPane.showMessageDialog(panel,"Se presto una copia del libro indicado!");
                                }else {
                                    JOptionPane.showMessageDialog(panel,"No quedan copias del libro indicado!");
                                }

                                setVisible(false);
                                Home home = new Home(books, user, reservas);
                                break;
                            }
                        }
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
