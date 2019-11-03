<%-- 
    Document   : agregarPaciente
    Created on : 03-nov-2019, 17:23:18
    Author     : denis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style> 
            body{            
                margin:40px;
            }
        </style>
        <title>AgregarPaciente</title>
    </head>
    <body>
        <h1 style="text-align: center">Agregar Paciente</h1>
        <form method="GET" action="PacienteControl">
            <input type="hidden" name="Comando" value="AGREGAR"/>
            <div class="row">
                <div class="col-md-6">
                    <label>Nombre</label>
                    <input type="text" name="txtNombre" class="form-control" placeholder="Nombre">
                </div>
                <div class="col-md-6">
                    <label>Apellido</label>
                    <input type="text" name="txtApellido"class="form-control" placeholder="Apellido">
                </div>
            </div>
             <div class="row">
                <div class="col-md-6">
                    <label>DNI</label>
                     <input type="text" name="txtDNI"class="form-control" >
                </div>
                <div class="col-md-6">
                    <label>FechaNacimiento</label>
                    <br>
                    <input class="datepicker" type="date" name="txtFechaNac">
                </div>
            </div>                
            <div class="row">
                <div class="col-md-6">
                    <label>Direccion</label>
                     <input type="text" name="txtDireccion"class="form-control" placeholder="Los Pepillos 323">
                </div>
                <div class="col-md-6">
                    <label>Email</label>
                     <input type="text" name="txtCorreo"class="form-control">
                </div>
            </div>
            <div clas="row">
                <div class="col-md-6">
                    <label>Telefono</label>
                    <input type="text" name="txtTelefono" class="form-control">
                </div>
            </div>
           
            <br>
            <input class="btn btn-primary" type="submit" value="Guardar">
        </form>          
        <p><a href="PacienteControl">Volver A Lista</a></p>
    </body>
</html>
