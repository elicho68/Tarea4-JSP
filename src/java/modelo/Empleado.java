/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.ResultSet;
import java.util.HashMap;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Elicho
 */
public class Empleado extends Persona {
    private String codigo;
    private int id_puesto;
    private Conexion cn;
    
    public Empleado() {
        
    }
    
    public Empleado(String codigo, int id_puesto, int id, String nombres, String apellidos, String direccion, String telefono, String fechaNacimiento) {
        super(id, nombres, apellidos, direccion, telefono, fechaNacimiento);
        this.codigo = codigo;
        this.id_puesto = id_puesto;
    }

    
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
    }

    public HashMap drop_sangre(){
        HashMap<String,String>drop=new HashMap();
        try{
        cn = new Conexion();
        String query="select id_puesto as id, puesto from puestos;";
        cn.abrir_conexion();
        ResultSet consulta = cn.ConexionBD.createStatement().executeQuery(query);
        while (consulta.next()){
        drop.put(consulta.getString("id"),consulta.getString("puesto"));
        }
        cn.cerrar_conexion();
            
        }catch(Exception ex){
        System.out.println(ex.getMessage());
        }
        return drop;
    }
    
    @Override
    public int agregar(){
        int retorno = 0;
    try{
        PreparedStatement parametro;
        cn = new Conexion();
        String query="INSERT INTO empleados (codigo,nombres,apellidos,direccion,telefono,fecha_nacimiento,id_puesto) VALUES (?,?,?,?,?,?,?);";
        cn.abrir_conexion();
        
        parametro=(PreparedStatement)cn.ConexionBD.prepareStatement(query);
        parametro.setString(1, getCodigo());
        parametro.setString(2, getNombres());
        parametro.setString(3, getApellidos());
        parametro.setString(4, getDireccion());        
        parametro.setString(5, getTelefono());        
        parametro.setString(6, getFechaNacimiento());        
        parametro.setInt(7, getId_puesto());        
        
        retorno=parametro.executeUpdate();
        
        cn.cerrar_conexion();
        
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            retorno = 0;
        }
    return retorno;
    }    
    
}
