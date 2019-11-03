<%-- 
    Document   : listaPacientes
    Created on : 03-nov-2019, 17:00:35
    Author     : denis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <title>Pacientes</title>
    </head>
    <body>

        <h1 style="text-align: center">Lista de pacientes</h1>        
        
       <input class="btn-primary" type="button" value="AgregarPaciente" onclick="window.location.href = 'agregarPaciente.jsp'; return false;" >

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
                    <th scope="col">Fecha Nac</th>

                </tr>
            </thead>
            <tbody>

                <c:forEach items="${ListaP}" var ="p"> 
                    <c:url var="cargaLink" value="PacienteControl">                        
                        <c:param name="Comando" value="CARGAR" />
                        <c:param name="idPaciente" value="${p.id}" />
                    </c:url>

                    <c:url var="deleteLink" value="PacienteControl">
                        <c:param name="Comando" value="BORRAR" />
                        <c:param name="idPaciente" value="${p.id}" />
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
                        <td>

                            <a href="${cargaLink}">Actualizar</a>
                            <a href="${deleteLink}" onclick="if (!(confirm('Esta seguro que quiere borrar a esta persona?')))
                                        return false">Borrar </a>                        </td>
                    </tr>


                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
