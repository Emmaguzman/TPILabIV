<%-- 
    Document   : listaEmpleados
    Created on : 02-nov-2019, 12:59:51
    Author     : denis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Empleados</title>
    </head>
    <body>        
        <table class="table table-dark">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Apellido</th>
                    <th scope="col">Direccion</th>
                    <th scope="col">Correo</th>
                    <th scope="col">Telefono</th>
                    <th scope="col">DNI</th>
                    <th scope="col">F-Nacimiento</th>
                    <th scope="col">TipoEmpleado</th>
                    <th scope="col">Foto</th>                 

                </tr>
            </thead>
            <tbody>                
                <c:forEach items="${List}" var ="p">
                    <c:url var="actualizaELink" value="EmpleadoControl"> 
                        <c:param name="Comando" value="ACTUALIZAE"/>
                        <c:param name="idEmpleado" value="${p.id}"/>
                    </c:url>
                     <c:url var="eliminaELink" value="EmpleadoControl">
                        <c:param name="Comando" value="ELIMINARE" />
                        <c:param name="idEmpelado" value="${p.id}" />
                    </c:url>
                    <tr>
                        <td>${p.id}</td>
                        <td>${p.nombre}</td>                        
                        <td>${p.apellido}</td>
                        <td>${p.direccion}</td>
                        <td>${p.correo}</td>
                        <td>${p.telefono}</td>
                        <td>${p.dni}</td>
                        <td>${p.fechaNac}</td>
                        <td>${p.idTipoEmpleado}</td>
                        <td><img src="EmpleadoControlImg?id=${p.id}" width="100" height="100"></td>
                        <td><a href="${actualizaELink}">Actualizar</a>
                <a href="${eliminaELink}"onclick="if (!(confirm('Esta seguro que quiere eliminar a este empleado?')))return false">Eliminar</a> </td>
                    </tr>
                
                </c:forEach>
            </tbody>

        </table>

    </body>
</html>
