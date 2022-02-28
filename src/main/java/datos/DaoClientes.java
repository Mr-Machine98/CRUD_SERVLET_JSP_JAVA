
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mr. Machine
 */
public class DaoClientes {

    private static final String SELECT = "SELECT id_cliente, nombre, apellido, email, telefono, salario FROM clientes";
    private static final String SELECT_BY_ID = "SELECT id_cliente, nombre, apellido, email, telefono, salario FROM clientes WHERE id_cliente = ?";
    private static final String INSERT = "INSERT INTO clientes(nombre, apellido, email, telefono, salario) VALUES(?,?,?,?,?)";
    private static final String UPDATE = "UPDATE clientes SET nombre = ?, apellido = ?, email = ?, telefono = ?, salario = ? WHERE id_cliente = ?";
    private static final String DELETE = "DELETE FROM clientes WHERE id_cliente = ?";
    
    public static List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getString("telefono"),
                        rs.getFloat("salario")
                );
                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            System.out.println("Error al listar los clientes...");
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return clientes;
    }

    public static int insertar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int insertados = 0;

        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(INSERT);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setFloat(5, cliente.getSalario());
            insertados = stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error al insertar datos...");
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return insertados;
    }

    public static Cliente ClienteById(String id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = new Cliente();

        try {

            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SELECT_BY_ID);
            stmt.setString(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setSalario(rs.getFloat("salario"));
            } else { System.out.println("No está el cliente..."); }
            
        } catch (SQLException ex) {
            System.out.println("Error al seleccionar el cliente...");
            ex.printStackTrace(System.out);
        } finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cliente;
    }
    
    public static int actualizar(Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        int actualizados = 0;

        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(UPDATE);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setFloat(5, cliente.getSalario());
            stmt.setInt(6, cliente.getIdCliente());
            
            actualizados = stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error al actualizar datos...");
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return actualizados;
    }
    
    public static int eliminar(String idCliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        int eliminados = 0;

        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(DELETE);
            stmt.setInt(1, Integer.parseInt( idCliente ));
            
            eliminados = stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error al actualizar datos...");
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return eliminados;
    }

}
