package proyectogrupo1;

import proyectogrupo1.*;

public class Persona {
    
    private final String cedula;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private String correo;

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    Persona(String cedula, String nombre, String apellido, String telefono, String direccion, String correo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }

    public static boolean valida(String cedula){
    int suma=0;
    if(cedula.length()==9){
      System.out.println("Ingrese su cedula de 10 digitos");
      return false;
    }else{
      int a[]=new int [cedula.length()/2];
      int b[]=new int [(cedula.length()/2)];
      int c=0;
      int d=1;
      for (int i = 0; i < cedula.length()/2; i++) {
        a[i]=Integer.parseInt(String.valueOf(cedula.charAt(c)));
        c=c+2;
        if (i < (cedula.length()/2)-1) {
          b[i]=Integer.parseInt(String.valueOf(cedula.charAt(d)));
          d=d+2;
        }
      }
   
      for (int i = 0; i < a.length; i++) {
        a[i]=a[i]*2;
        if (a[i] >9){
          a[i]=a[i]-9;
        }
        suma=suma+a[i]+b[i];
      } 
      int aux=suma/10;
      int dec=(aux+1)*10;
      if ((dec - suma) == Integer.parseInt(String.valueOf(cedula.charAt(cedula.length()-1))))
        return true;
      else
        if(suma%10==0 && cedula.charAt(cedula.length()-1)=='0'){
          return true;
        }else{
          return false;
        }
    
    }
    }
    @Override
    public String toString() {
        return "Cédula: " + cedula + "\n Nombre: " + nombre + "\nApellido: " + apellido + "\nTelefono: " + telefono + "\nDirección: " + direccion + "\nCorreo: " + correo;
    }
    
    
   
    
}
