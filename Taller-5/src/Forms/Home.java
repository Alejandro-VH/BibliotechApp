package Forms;

import Entities.Libro;
import Entities.Reservas;
import Entities.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Home extends JFrame{

    private JButton buscarLibroButton;
    private JButton devolverLibroButton;
    private JButton agregarNuevoLibroButton;
    private JButton prestarLibroButton;
    private JPanel home;
    private LinkedList<Libro> books;
    private LinkedList<Reservas> reservas;

    public Home(LinkedList<Libro> books, Usuario user, LinkedList<Reservas> reservas) {
        this.books = books;

        setContentPane(home);
        setTitle("Bibliotech");
        setSize(400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        buscarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuscarLibro buscarLibro = new BuscarLibro(books, user, reservas);
            }
        });

        prestarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                PrestarLibro prestarLibro = new PrestarLibro(books, user, reservas);
            }
        });

        agregarNuevoLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AgregarLibro agregarLibro = new AgregarLibro(books, user, reservas);
            }
        });

        devolverLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                DevolverLibro devolverLibro = new DevolverLibro(books, user, reservas);
            }
        });
    }
}
