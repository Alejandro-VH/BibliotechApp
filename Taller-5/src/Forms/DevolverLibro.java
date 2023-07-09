package Forms;

import Entities.Libro;
import Entities.Reservas;
import Entities.Usuario;
import Utils.GuardarArchivos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class DevolverLibro extends JFrame {
    private JPanel panel;
    private JTextField textField1;
    private JButton buscarButton;
    private LinkedList<Libro> books;
    private LinkedList<Reservas> reservas;
    public DevolverLibro(LinkedList<Libro> books, Usuario user, LinkedList<Reservas> reservas){
        this.books = books;

        setContentPane(panel);
        setTitle("Bibliotech");
        setSize(400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField1.getText();
                if (!text.isEmpty()){
                    Libro libro = buscarLibro(text);
                    for (Libro aux : books){
                        if (aux.getIsbn().equals(text)){
                            aux.addCopia();
                            setVisible(false);
                            try {
                                Reservas reg = new Reservas(user.getRut(), user.getNombre(), user.getApellido(), aux.getIsbn(),aux.getTitulo(),"devolucion");
                                reservas.add(reg);
                                GuardarArchivos.agregarRegistro(reservas);
                                GuardarArchivos.agregarLibro(books);
                            }catch (Exception err){

                            }
                            Home home = new Home(books, user, reservas);
                            JOptionPane.showMessageDialog(panel,"Se agrego una copia al libro indicado");
                            break;
                        }
                    }
                    JOptionPane.showMessageDialog(panel,"No existe un libro con el ISBN indicado");
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
