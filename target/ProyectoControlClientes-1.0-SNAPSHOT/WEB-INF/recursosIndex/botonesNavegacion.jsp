<%-- 
    Document   : botonesNavegacion
    Created on : 24/02/2022, 03:49:42 PM
    Author     : Mr. Machine
--%>
<div class="container">
    <button type="button" class="btn btn-outline-warning mb-3"  data-bs-toggle="modal" data-bs-target="#exampleModal"><i class="fa-solid fa-plus"></i> Agregar Cliente</button>
    <button onclick="refresh()" id="refresh" type="button" class="btn btn-outline-warning mb-3"><i class="fa-solid fa-arrows-rotate"></i></button>
    <script type="text/javascript">
        function refresh(){
            window.location.href="<%=request.getContextPath()%>";
        }
    </script>
</div>
<jsp:include page="/WEB-INF/modales/modalAddCliente.jsp" />
