<%-- 
    Document   : EditarCliente
    Created on : 26/02/2022, 03:37:58 PM
    Author     : Mr. Machine
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/1689727545.js" crossorigin="anonymous"></script>
        <title>Control Clientes</title>

    </head>
    <body style="background: #353535" >

        <%-- Cabecero --%>
        <jsp:include page="/WEB-INF/recursosIndex/cabecero.jsp"/>

        <div class="container text-light">
            <div class="row">
                <form class="was-validated" method="post" action="ControladorClientes">
                    <a href="index.jsp" class="btn btn-outline-warning mb-3  mt-3"><i class="fa-solid fa-house"></i> Ir al inicio</a>
                    <button type="submit" class="btn btn-outline-warning mb-3 mt-3" >Actualizar Cliente</button>
                    <a href="ControladorClientes?accion=2&idCliente=${editarCliente.idCliente}" class="btn btn-outline-warning mb-3  mt-3"><i class="fa-solid fa-trash-can"></i> Eliminar Cliente</a>
                    
                    <input id="" name="accion" type="hidden" value="2">
                    <input id="" name="idCliente" type="hidden" value="${editarCliente.idCliente}">
                    <div class="form-group mt-2">
                        <label for="nombre">Nombre</label>
                        <input type="text"  class="form-control " name="nombre"  placeholder="Introduce el nombre" value="${editarCliente.nombre}" required>
                    </div>
                    <div class="form-group mt-2">
                        <label for="apellido">Apellido</label>
                        <input type="text" class="form-control " name="apellido" placeholder="Introduce el apellido"  value="${editarCliente.apellido}" required>
                    </div>
                    <div class="form-group mt-2">
                        <label for="email">Email</label>
                        <input type="email" class="form-control " name="email" placeholder="Introduce el email"  value="${editarCliente.email}" required>
                    </div>
                    <div class="form-group mt-2">
                        <label for="telefono">Teléfono</label>
                        <input type="tel" class="form-control " name="telefono" placeholder="Introduce el teléfono"  value="${editarCliente.telefono}" required>
                    </div>
                    <div class="form-group mt-2">
                        <label for="salario">Salario</label>
                        <input type="number" step="any" class="form-control " name="salario" placeholder="Introduce el salario"  value="${editarCliente.salario}" required>
                    </div>
                </form>
            </div>
        </div>


        <%-- Pie Pag --%>
        <jsp:include page="/WEB-INF/recursosIndex/piePagina.jsp"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    </body>
</html>
