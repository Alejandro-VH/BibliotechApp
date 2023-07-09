import Entities.Libro;
import Entities.Reservas;
import Entities.Usuario;
import Forms.Login;
import Utils.LecturaArchivos;

import java.util.LinkedList;

public class SistemaImpl implements Sistema{
    private Login form;
    private LinkedList<Usuario> usuarioList;
    private LinkedList<Libro> libroList;
    private LinkedList<Reservas> reservasList;
    public SistemaImpl() {
        // Se inicializan las listas
        libroList = new LinkedList<>();
        usuarioList = new LinkedList<>();
        reservasList = new LinkedList<>();

        // Se cargan los usuarios y los libros existentes
        usuarioList = LecturaArchivos.leerArchivoUsuarios(usuarioList);
        libroList =  LecturaArchivos.leerArchivoLibros(libroList);
        reservasList = LecturaArchivos.leerArchivoReservas(reservasList);

    }

    /**
     * Subprograma para iniciar la ejecucion del programa
     */
    @Override
    public void iniciarPrograma(){
        this.form = new Login(usuarioList,libroList,reservasList);
    }

}
