<%-- 
    Document   : agregarEmpleado
    Created on : 02-nov-2019, 16:33:13
    Author     : denis
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <style> 
         body{            
             margin:40px;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Empleado</title>
    </head>
    <body>
        <h2 style="text-align: center">AgregarEmpleado</h2>
        <form method="GET" action="EmpleadoControl" enctype="multipart/form-data">
         <input type="hidden" name="Comando" value="GUARDARE"/>
            <div class="row">
                <div class="form-group col-md-6">                    
                    <label for="Nombre">Nombre</label>
                    <input type="text" class="form-control" name="txtNombre" placeholder="Nombre">                    

                </div>
                <div class="form-group col-md-6">
                    <label for="Email">Apellido</label>
                    <input type="Apellido" class="form-control" name="txtApellido" placeholder="Apellido">
                </div>


            </div>
            <div class="row">
                <div class="form-group col-md-6">                    
                    <label for="DNI">DNI</label>
                    <input type="text" class="form-control" name="txtDNI" placeholder="DNI">
                </div>
                <div class="form-group col-md-6">
                    <label for="Email">Email</label>
                    <input type="text" class="form-control" name="txtEmail" placeholder="Email">
                </div>
            </div>
        </div>
        <div class='row'>
            <div class="col-md-6">
                <label for="direccion">Direccion</label>
                <input type="text" class="form-control" name="txtDireccion" placeholder="Los valles colorados 232 9'c'">
            </div>
            <div class="col-md-6">
                <label for="telefono">Telefono</label>
                <input type="text" class="form-control" name="txtTelefono" placeholder="Los valles colorados 232 9'c'">
            </div>
        </div>

        <div class="row">
            <div class="col-md-6">
                <label for="TipoEmpleado">Tipo de Empleado</label>          
                    <select name="idTipoE" class="form-control">
                    <option value="99">Elije Opcion</option>                     
                    <c:forEach items="${ListaTiposE}" var="lstTE">                            
                        <option value='${lstTE.id}'>
                            ${lstTE.descripcion}</option>                    
                    </c:forEach>
                        
                </select>
            </div >
            <div class="col-md-6 ">                    
                <label for="FechaN"> Fecha de Nacimiento</label> <br>                   
                <input type="date" name="txtfecha" min="1800-03-25"
                       max="2018-05-25" step="2">                    
            </div>
        </div>
        
        <div class="row">
               <div class="col-md-6">
            <label foto=>Foto</label>
            <input class="form-control-file" name="fotoIngreso" type="file">
               </div>
        </div>
        <br>
        <button type="submit" class="btn btn-primary">Agregar</button>
        <p><a href="EmpleadoControl">Volver A Lista</a></p>
    </form>
</body>
</html>
