package ventanas;

public class Empleado {
    String codigo,nombre, apellidos, puesto, telefono;

    public Empleado(String codigo, String nombre, String apellidos, String puesto, String telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.puesto = puesto;
        this.telefono = telefono;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getPuesto() {
        return puesto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    
}
