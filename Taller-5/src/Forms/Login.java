package Forms;

import Entities.Libro;
import Entities.Reservas;
import Entities.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Login extends JFrame {
    private JButton iniciarSesionButton;
    private JPanel login;
    private JTextField rutTextField;
    private JPasswordField passwordField1;
    private LinkedList<Usuario> users;
    private LinkedList<Libro> books;
    private LinkedList<Reservas> reservas;

    public Login(LinkedList<Usuario> users, LinkedList<Libro> books, LinkedList<Reservas> reservas){
        this.users = users;
        this.books = books;
        this.reservas = reservas;

        setContentPane(login);
        setTitle("Inicio de Sesión");
        setSize(400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);


        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String rut = rutTextField.getText();
                    String pass = passwordField1.getText();

                    if (!rut.isEmpty() || !pass.isEmpty()){
                        for (Usuario aux: users){
                            if (aux.getRut().equals(rut) && aux.getContrasenia().equals(pass)){
                                setTitle("Bibliotech");
                                Home home = new Home(books, aux, reservas);
                                setVisible(false);
                                return;
                            }
                        }
                        throw new Exception();
                    }else {
                        JOptionPane.showMessageDialog(login,"Por favor, complete los campos!");
                    }

                }catch (Exception er){
                    JOptionPane.showMessageDialog(login, "Credenciales invalidas");
                }
            }
        });
    }


}

