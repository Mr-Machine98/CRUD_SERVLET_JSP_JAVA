/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import datos.DaoClientes;
import dominio.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mr. Machine
 */
@WebServlet(value = "/ControladorClientes")
public class ControladorClientes extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String accion = req.getParameter("accion");
        String idCliente = req.getParameter("idCliente");

        if (accion != null) {

            switch (accion) {

                case "1": //Añadir cliente
                    addCliente(req, resp);
                    break;

                case "2"://Actualizar Cliente
                    actualizarCliente(req, resp, idCliente);
                    break;

                default:
                    listarClientes(req, resp);
            }

        } else {
            listarClientes(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String accion = req.getParameter("accion");
        String idCliente = req.getParameter("idCliente");

        if (accion != null) {
            switch (accion) {
                case "1": // 1 es igual a botón editar cliente
                    req.setAttribute("editarCliente", seleccionarCliente(idCliente));
                    String path = "/WEB-INF/VistaAccionesCliente/EditarCliente.jsp";
                    req.getRequestDispatcher(path).forward(req, resp);
                    break;
                case "2"://2 es igual a eliminar cliente
                    System.out.println("Número de clientes eliminados: " +DaoClientes.eliminar(idCliente));
                    listarClientes(req, resp);
                    break;
                default:
                    listarClientes(req, resp);
            }
        } else {
            listarClientes(req, resp);
        }

    }

    public void addCliente(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String email = req.getParameter("email");
        String telefono = req.getParameter("telefono");
        float salario = Float.parseFloat(req.getParameter("salario"));
        Cliente cliente = new Cliente(nombre, apellido, email, telefono, salario);
        System.out.println("Número de clientes añadidos: " + DaoClientes.insertar(cliente));
        listarClientes(req, resp);
    }

    public void listarClientes(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        List<Cliente> clientes = DaoClientes.listar();
        session.setAttribute("clientes", clientes);
        session.setAttribute("numClientes", clientes.size());
        session.setAttribute("salarioTotal", salarioTotal(clientes));
        resp.sendRedirect("clientes.jsp");
    }

    public float salarioTotal(List<Cliente> clientes) {
        float salario = 0;
        for (Cliente cliente : clientes) {
            salario = cliente.getSalario() + salario;
        }
        return salario;
    }

    public Cliente seleccionarCliente(String id) {
        return DaoClientes.ClienteById(id);
    }

    private void actualizarCliente(HttpServletRequest req, HttpServletResponse resp, String idCliente) throws IOException {
        int id = Integer.parseInt(idCliente);
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String email = req.getParameter("email");
        String telefono = req.getParameter("telefono");
        float salario = Float.parseFloat(req.getParameter("salario"));
        Cliente cliente = new Cliente(id, nombre, apellido, email, telefono, salario);
        System.out.println("Número de clientes actualizados: " + DaoClientes.actualizar(cliente));
        listarClientes(req, resp);
    }
}
