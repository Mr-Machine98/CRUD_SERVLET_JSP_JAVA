<%-- 
    Document   : modalAddCliente
    Created on : 25/02/2022, 03:08:18 PM
    Author     : Mr. Machine
--%>
<div class="modal fade " id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog ">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Añade un nuevo cliente</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form class="was-validated" method="post" action="ControladorClientes">
                    <input id="" name="accion" type="hidden" value="1">
                    <div class="form-group mt-2">
                        <label for="nombre">Nombre</label>
                        <input type="text"  class="form-control " name="nombre"  placeholder="Introduce el nombre" required>
                    </div>
                    <div class="form-group mt-2">
                        <label for="apellido">Apellido</label>
                        <input type="text" class="form-control " name="apellido" placeholder="Introduce el apellido" required>
                    </div>
                    <div class="form-group mt-2">
                        <label for="email">Email</label>
                        <input type="email" class="form-control " name="email" placeholder="Introduce el email" required>
                    </div>
                    <div class="form-group mt-2">
                        <label for="telefono">Teléfono</label>
                        <input type="tel" class="form-control " name="telefono" placeholder="Introduce el teléfono" required>
                    </div>
                    <div class="form-group mt-2">
                        <label for="salario">Salario</label>
                        <input type="number" step="any" class="form-control " name="salario" placeholder="Introduce el salario" required>
                    </div>
                    <button type="submit" class="btn btn-primary mt-4">Agregar Cliente</button>
                </form> 
            </div>
        </div>
    </div>
</div>
