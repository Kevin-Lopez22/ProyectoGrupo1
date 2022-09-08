package proyectogrupo1;

public class Cliente extends Persona{
    
   private final int idCliente;
   private boolean isSuspendido;

    Cliente(int idCliente, String cedula, String nombre, String apellido, String telefono, String direccion, String correo, boolean isSuspendido) {
        super(cedula, nombre, apellido, telefono, direccion, correo);
        this.idCliente = idCliente;
        this.isSuspendido = isSuspendido;
        //this.idCliente = (int) Math.random(); Crear metodo para obtener id de la base de datos
    }

   
    Cliente(int idCliente, String cedula, String nombre, String apellido, String telefono, String direccion, String correo) {
        this(idCliente,cedula,nombre,apellido,telefono,direccion,correo,false);
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setSuspendido(boolean isSuspendido) {
        this.isSuspendido = isSuspendido;
    }
    
    public boolean isSuspendido() {
        return isSuspendido;
    }
                   
    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente +",isSuspendido="+ String.valueOf(isSuspendido) + ", "+super.toString()+'}';
    }


    

    
    
}
