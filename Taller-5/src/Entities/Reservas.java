package Entities;

public class Reservas {

    String rut_vendedor;
    String nombre_vendedor;
    String apellido;
    String isbn;
    String nombre_libro;
    String tipo_transacción;

    public Reservas(String rut_vendedor, String nombre_vendedor, String apellido, String isbn, String nombre_libro, String tipo_transacción) {
        this.rut_vendedor = rut_vendedor;
        this.nombre_vendedor = nombre_vendedor;
        this.apellido = apellido;
        this.isbn = isbn;
        this.nombre_libro = nombre_libro;
        this.tipo_transacción = tipo_transacción;
    }

    public String getRut_vendedor() {
        return rut_vendedor;
    }

    public String getNombre_vendedor() {
        return nombre_vendedor;
    }

    public String getApellido() {
        return apellido;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getNombre_libro() {
        return nombre_libro;
    }

    public String getTipo_transacción() {
        return tipo_transacción;
    }
}
