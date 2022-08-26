package proyectogrupo1;

public class Cliente extends Persona{
    
   private final int idCliente;

    Cliente(int idCliente, long cedula, String nombre, String apellido, long telefono, String direccion, String correo) {
        super(cedula, nombre, apellido, telefono, direccion, correo);
        this.idCliente = idCliente;
        //this.idCliente = (int) Math.random(); Crear metodo para obtener id de la base de datos
    }

    public int getIdCliente() {
        return idCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente +","+super.toString()+'}';
    }


    

    
    
}