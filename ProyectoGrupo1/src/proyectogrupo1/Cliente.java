package proyectogrupo1;

public class Cliente extends Persona{
    
   private int idCliente;

    Cliente(long cedula, String nombre, String apellido, long telefono, String direccion, String correo) {
        super(cedula, nombre, apellido, telefono, direccion, correo);
        //this.idCliente = (int) Math.random(); Crear metodo para obtener id de la base de datos
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + "nombre" + super.getNombre() + '}';
    }

    
    
}
