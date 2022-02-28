<%-- 
    Document   : infoClientes
    Created on : 24/02/2022, 12:40:14 PM
    Author     : Mr. Machine
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %> 
<div class="container">
    <div class="row">
        <div class="col-md-8">
            <div class="card text-light border" style="background: #353535">
                <h2 class="m-3">Listado de Clientes</h2>
                <div class="card-body">
                    <table class="table table-dark table-striped">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Salario</th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="cliente" items="${clientes}">
                                <tr>
                                    <td>${cliente.idCliente}</td>
                                    <td>${cliente.nombre} ${cliente.apellido}</td>
                                    <fmt:setLocale value="es_CO"/>
                                    <td><fmt:formatNumber type="currency" value="${cliente.salario}"/></td>
                                    <td><a href="ControladorClientes?accion=1&idCliente=${cliente.idCliente}" class="btn btn-secondary"><i class="fa-solid fa-pen-to-square"></i> Editar</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card text-light text-center border" style="background: #353535">
                <div class="card-body">
                    <h2 class="m-3 text-success">Total Clientes </h2>
                    <h1 class="m-3 text-success">${numClientes}</h1>
                </div>
            </div>
            <div class="card text-light text-center border" style="background: #353535">
                <div class="card-body">
                    <h2 class="m-3 text-danger">Saldo Total <i class="fa-solid fa-coins"></i></h2>
                    <h4 class="m-3 text-danger"><fmt:formatNumber type="currency" value="${salarioTotal}" /></h4>
                </div>
            </div>
        </div>
    </div>
</div>
